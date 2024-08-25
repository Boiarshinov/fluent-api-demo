package dev.boiarshinov.fluentapi.core.step5;

public class App {

    //@Bean
    public ProxyConfiguration proxyConfig() {
        return ProxyConfiguration.configure()
            .recipients("host1:port", "host2:port")
            .loadBalancer(lb ->
                lb.roundRobin()
            )
            .declineOnContent("Тинькофф")
            .replaceResponse("Тинькофф банк", "Т-Банк")
            .replaceResponse("Олег", "Александр Поломодов")
            .build();
    }
}
