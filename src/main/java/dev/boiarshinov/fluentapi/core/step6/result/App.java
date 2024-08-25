package dev.boiarshinov.fluentapi.core.step6.result;

public class App {

    //@Bean
    public ProxyConfiguration proxyConfig() {
        return ProxyConfiguration.configure()
            .recipients("host1:port", "host2:port")
            .loadBalancer(lb -> lb
                .hash()
                .healthcheckEnabled(false)
                .murmur3()
            )
            .declineOnContent("Тинькофф")
            .replaceResponse("Тинькофф банк", "Т-Банк")
            .build();
    }
}
