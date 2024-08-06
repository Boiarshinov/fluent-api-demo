package dev.boiarshinov.fluentapi.core.step4;

public class ProxyConfiguration {

    static RecipientsConfigurator configure() {
        return new ProxyFluentConfigurator();
    }

    interface LoadBalancingConfigurator {
        LoadBalancingImplConfigurator loadBalancer();
    }

    interface RecipientsConfigurator {
        LoadBalancingConfigurator recipients(String... recipients);
    }

    interface LoadBalancingImplConfigurator {
        OptionalConfigurator roundRobin();
        OptionalConfigurator random();
        OptionalConfigurator hash();
        OptionalConfigurator leastConnections();
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
        public LoadBalancingImplConfigurator loadBalancer() {
            return new LoadBalancingFluentConfigurator(this);
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

    static class LoadBalancingFluentConfigurator implements LoadBalancingImplConfigurator {

        private final ProxyFluentConfigurator proxyFluentConfigurator;

        LoadBalancingFluentConfigurator(ProxyFluentConfigurator proxyFluentConfigurator) {
            this.proxyFluentConfigurator = proxyFluentConfigurator;
        }

        @Override
        public OptionalConfigurator roundRobin() {
            return proxyFluentConfigurator;
        }

        @Override
        public OptionalConfigurator random() {
            return proxyFluentConfigurator;
        }

        @Override
        public OptionalConfigurator hash() {
            return proxyFluentConfigurator;
        }

        @Override
        public OptionalConfigurator leastConnections() {
            return proxyFluentConfigurator;
        }
    }
}
