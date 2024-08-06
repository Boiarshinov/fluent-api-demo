package dev.boiarshinov.fluentapi.core.step1;

class ProxyConfiguration {

    static ProxyFluentConfigurator configure() {
        return new ProxyFluentConfigurator();
    }

    static class ProxyFluentConfigurator {
        ProxyConfiguration build() {
            return new ProxyConfiguration();
        }
    }
}
