package dev.boiarshinov.fluentapi.core.step2;

class ProxyConfiguration {

    static ProxyConfiguration.ProxyFluentConfigurator configure() {
        return new ProxyConfiguration.ProxyFluentConfigurator();
    }

    static class ProxyFluentConfigurator {

        public ProxyFluentConfigurator recipients(String... recipients) {
            //как обрабатывать входные аргументы здесь и далее не важно для темы Fluent API
            return this;
        }

        public ProxyFluentConfigurator lbByRoundRobin() {
            return this;
        }

        public ProxyFluentConfigurator lbByLeastConnections() {
            return this;
        }

        public ProxyFluentConfigurator declineOnContent(String substring) {
            return this;
        }

        public ProxyFluentConfigurator replaceResponse(String toReplace, String replacement) {
            return this;
        }

        public ProxyConfiguration build() {
            return new ProxyConfiguration();
        }
    }
}
