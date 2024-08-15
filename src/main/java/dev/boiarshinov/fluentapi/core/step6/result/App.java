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
            .acl("192.168.0.1", "192.168.0.2")
            .declineOnContent("Тинькофф")
            .replaceResponse("Тинькофф банк", "Т-Банк")
            .replaceResponse("Олег", "Александр Поломодов")
            .build();
    }
}
