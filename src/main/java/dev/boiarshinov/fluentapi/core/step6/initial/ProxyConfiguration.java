package dev.boiarshinov.fluentapi.core.step6.initial;

import java.util.function.Consumer;

public class ProxyConfiguration {

    static RecipientsConfigurator configure() {
        return new ProxyFluentConfigurator();
    }

    interface LoadBalancingConfigurator {
        OptionalConfigurator loadBalancer(Consumer<LoadBalancingFluentConfigurator> lbConfigurator);
    }

    interface RecipientsConfigurator {
        LoadBalancingConfigurator recipients(String... recipients);
    }

    interface OptionalConfigurator {
        OptionalConfigurator acl(String... ips);
        OptionalConfigurator declineOnContent(String substring);
        OptionalConfigurator replaceResponse(String toReplace, String replacement);
        ProxyConfiguration build();
    }

    static class ProxyFluentConfigurator implements RecipientsConfigurator, LoadBalancingConfigurator, OptionalConfigurator {

        @Override
        public ProxyFluentConfigurator recipients(String... recipients) {
            //как обрабатывать входные аргументы здесь и далее не важно, для темы Fluent API
            return this;
        }

        public ProxyFluentConfigurator acl(String... ips) {
            return this;
        }

        @Override
        public OptionalConfigurator loadBalancer(Consumer<LoadBalancingFluentConfigurator> lbConfigurator) {
            //прикапываем конфигурацию loadBalancer
            return this;
        }

        @Override
        public OptionalConfigurator declineOnContent(String substring) {
            return this;
        }

        @Override
        public OptionalConfigurator replaceResponse(String toReplace, String replacement) {
            return this;
        }

        @Override
        public ProxyConfiguration build() {
            return new ProxyConfiguration();
        }
    }

}
