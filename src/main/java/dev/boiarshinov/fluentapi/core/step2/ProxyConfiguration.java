package dev.boiarshinov.fluentapi.core.step2;

class ProxyConfiguration {

    static ProxyConfiguration.ProxyFluentConfigurator configure() {
        return new ProxyConfiguration.ProxyFluentConfigurator();
    }

    static class ProxyFluentConfigurator {

        ProxyFluentConfigurator recipients(String... recipients) {
            //как обрабатывать входные аргументы здесь и далее не важно для темы Fluent API
            return this;
        }

        ProxyFluentConfigurator acl(String... ips) {
            return this;
        }

        ProxyFluentConfigurator lbByRoundRobin() {
            return this;
        }

        ProxyFluentConfigurator lbByLeastConnections() {
            return this;
        }

        ProxyFluentConfigurator declineOnContent(String substring) {
            return this;
        }

        ProxyFluentConfigurator replaceResponse(String toReplace, String replacement) {
            return this;
        }

        ProxyConfiguration build() {
            return new ProxyConfiguration();
        }
    }
}
