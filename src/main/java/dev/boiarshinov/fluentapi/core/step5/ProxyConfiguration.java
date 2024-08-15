package dev.boiarshinov.fluentapi.core.step5;

import java.util.function.Consumer;

public class ProxyConfiguration {

    static RecipientsStep configure() {
        return new ProxyFluentConfigurator();
    }

    interface RecipientsStep {
        LoadBalancerStep recipients(String... recipients);
    }

    interface LoadBalancerStep {
        OptionalSteps loadBalancer(Consumer<LoadBalancingFluentConfigurator> lbConfigurator);
    }

    interface OptionalSteps {
        OptionalSteps acl(String... ips);
        OptionalSteps declineOnContent(String substring);
        OptionalSteps replaceResponse(String toReplace, String replacement);
        ProxyConfiguration build();
    }

    static class ProxyFluentConfigurator implements RecipientsStep, LoadBalancerStep, OptionalSteps {

        @Override
        public ProxyFluentConfigurator recipients(String... recipients) {
            //как обрабатывать входные аргументы здесь и далее не важно для темы Fluent API
            return this;
        }

        public ProxyFluentConfigurator acl(String... ips) {
            return this;
        }

        @Override
        public OptionalSteps loadBalancer(Consumer<LoadBalancingFluentConfigurator> lbConfigurator) {
            //прикапываем конфигурацию loadBalancer
            return this;
        }

        @Override
        public OptionalSteps declineOnContent(String substring) {
            return this;
        }

        @Override
        public OptionalSteps replaceResponse(String toReplace, String replacement) {
            return this;
        }

        @Override
        public ProxyConfiguration build() {
            return new ProxyConfiguration();
        }
    }

    static class LoadBalancingFluentConfigurator {
        public void roundRobin() {}
        public void random() {}
        public void hash() {}
        public void leastConnections() {}
    }
}
