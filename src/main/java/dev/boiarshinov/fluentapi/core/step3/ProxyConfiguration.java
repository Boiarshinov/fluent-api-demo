package dev.boiarshinov.fluentapi.core.step3;

public class ProxyConfiguration {

    static RecipientsStep configure() {
        return new ProxyFluentConfigurator();
    }

    interface RecipientsStep {
        LoadBalancerStep recipients(String... recipients);
    }

    interface LoadBalancerStep {
        OptionalSteps lbByRoundRobin();
        OptionalSteps lbByRandom();
        OptionalSteps lbByHash();
        OptionalSteps lbByLeastConnections();
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
            //как обрабатывать входные аргументы здесь и далее не важно, для темы Fluent API
            return this;
        }

        @Override
        public ProxyFluentConfigurator acl(String... ips) {
            return this;
        }

        @Override
        public OptionalSteps lbByRoundRobin() {
            return this;
        }

        @Override
        public OptionalSteps lbByLeastConnections() {
            return this;
        }

        @Override
        public OptionalSteps lbByRandom() {
            return this;
        }

        @Override
        public OptionalSteps lbByHash() {
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
}
