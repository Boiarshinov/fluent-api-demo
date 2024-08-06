package dev.boiarshinov.fluentapi.core.step3;

public class ProxyConfiguration {

    static RecipientsConfigurator configure() {
        return new ProxyFluentConfigurator();
    }

    interface RecipientsConfigurator {
        LoadBalancingConfigurator recipients(String... recipients);
    }

    interface LoadBalancingConfigurator {
        OptionalConfigurator lbByRoundRobin();
        OptionalConfigurator lbByRandom();
        OptionalConfigurator lbByHash();
        OptionalConfigurator lbByLeastConnections();
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

        @Override
        public ProxyFluentConfigurator acl(String... ips) {
            return this;
        }

        @Override
        public OptionalConfigurator lbByRoundRobin() {
            return this;
        }

        @Override
        public OptionalConfigurator lbByLeastConnections() {
            return this;
        }

        @Override
        public OptionalConfigurator lbByRandom() {
            return this;
        }

        @Override
        public OptionalConfigurator lbByHash() {
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
