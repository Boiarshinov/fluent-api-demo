package dev.boiarshinov.fluentapi.core.step4;

public class ProxyConfiguration {

    static RecipientsStep configure() {
        return new ProxyFluentConfigurator();
    }

    interface LoadBalancerStep {
        LoadBalancingFluentConfigurator loadBalancer();
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

        @Override
        public ProxyFluentConfigurator recipients(String... recipients) {
            //как обрабатывать входные аргументы здесь и далее не важно для темы Fluent API
            return this;
        }

        @Override
        public LoadBalancingFluentConfigurator loadBalancer() {
            return new LoadBalancingFluentConfigurator(this);
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

        private final ProxyFluentConfigurator proxyFluentConfigurator;

        LoadBalancingFluentConfigurator(ProxyFluentConfigurator proxyFluentConfigurator) {
            this.proxyFluentConfigurator = proxyFluentConfigurator;
        }

        public OptionalSteps roundRobin() {
            return proxyFluentConfigurator;
        }

        public OptionalSteps random() {
            return proxyFluentConfigurator;
        }

        public OptionalSteps hash() {
            return proxyFluentConfigurator;
        }

        public OptionalSteps leastConnections() {
            return proxyFluentConfigurator;
        }
    }
}
