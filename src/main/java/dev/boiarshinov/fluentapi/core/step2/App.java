package dev.boiarshinov.fluentapi.core.step2;

public class App {

    //@Bean
    public ProxyConfiguration proxyConfig() {
        return ProxyConfiguration.configure()
            .recipients("host1:port", "host2:port")
            .lbByRoundRobin()
            .declineOnContent("Желтофф")
            .replaceResponse("Желтофф банк", "Ж-Банк")
            .build();
    }
}
