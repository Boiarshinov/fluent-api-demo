package dev.boiarshinov.fluentapi.core.step1;

public class App {

    //@Bean
    public ProxyConfiguration proxyConfig() {
        return ProxyConfiguration.configure()
            //конфигурация
            .build();
    }
}
