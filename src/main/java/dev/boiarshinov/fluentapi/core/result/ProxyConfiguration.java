package dev.boiarshinov.fluentapi.core.result;

class ProxyConfiguration {

    static ProxyFluentConfigurator configure() {
        return new ProxyConfigurer();
    }


    static class ProxyConfigurer implements ProxyFluentConfigurator {

        @Override
        public ProxyFluentConfigurator recipients(String... recipients) {
            return null;
        }

        @Override
        public BalancerConfigurer balancer() {
            return null;
        }

        @Override
        public ProxyConfiguration build() {
            return null;
        }
    }

    interface ProxyFluentConfigurator {
        ProxyFluentConfigurator recipients(String ... recipients);
        BalancerConfigurer balancer();
        ProxyConfiguration build();
    }

    interface BalancerConfigurer {
        ProxyFluentConfigurator roundRobin();
        ProxyFluentConfigurator random();
        ProxyFluentConfigurator byHash();
        ProxyFluentConfigurator leastConnections();
    }
}
