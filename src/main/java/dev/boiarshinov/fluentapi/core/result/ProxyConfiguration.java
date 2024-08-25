package dev.boiarshinov.fluentapi.core.result;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class ProxyConfiguration {

    private final List<String> recipients;
    private final LoadBalancer loadBalancer;
    private final List<String> rejections;
    private final Map<String, String> replacements;

    private ProxyConfiguration(
        List<String> recipients,
        LoadBalancer loadBalancer,
        List<String> rejections,
        Map<String, String> replacements
    ) {
        this.recipients = recipients;
        this.loadBalancer = loadBalancer;
        this.rejections = rejections;
        this.replacements = replacements;
    }

    static RecipientsStep configure() {
        return new ProxyFluentConfigurator();
    }

    interface LoadBalancerStep {
        OptionalSteps loadBalancer(Consumer<LoadBalancingFluentConfigurator> lbConfigurator);
    }

    interface RecipientsStep {
        LoadBalancerStep recipients(String... recipients);
    }

    interface OptionalSteps {
        OptionalSteps declineOnContent(String substring);
        OptionalSteps replaceResponse(String toReplace, String replacement);
        ProxyConfiguration build();
    }

    static class ProxyFluentConfigurator implements RecipientsStep, LoadBalancerStep, OptionalSteps {

        private final List<String> recipients = new ArrayList<>();
        private final List<String> rejections = new ArrayList<>();
        private final Map<String, String> replacements = new HashMap<>();
        private LoadBalancer loadBalancer;


        @Override
        public ProxyFluentConfigurator recipients(String... recipients) {
            this.recipients.addAll(Arrays.asList(recipients));
            return this;
        }

        @Override
        public OptionalSteps loadBalancer(Consumer<LoadBalancingFluentConfigurator> lbConfigurator) {
            var lbConfig = new LoadBalancingFluentConfigurator(recipients);
            lbConfigurator.accept(lbConfig);
            this.loadBalancer = lbConfig.build();
            return this;
        }

        @Override
        public OptionalSteps declineOnContent(String substring) {
            rejections.add(substring);
            return this;
        }

        @Override
        public OptionalSteps replaceResponse(String toReplace, String replacement) {
            replacements.put(toReplace, replacement);
            return this;
        }

        @Override
        public ProxyConfiguration build() {
            return new ProxyConfiguration(
                recipients,
                loadBalancer,
                rejections,
                replacements
            );
        }
    }
}
