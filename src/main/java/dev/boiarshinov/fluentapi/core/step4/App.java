package dev.boiarshinov.fluentapi.core.step4;

public class App {

    //@Bean
    public ProxyConfiguration proxyConfig() {
        return ProxyConfiguration.configure()
            .recipients("host1:port", "host2:port")
            .loadBalancer()
                .roundRobin()
            .declineOnContent("СПб")
            .replaceResponse("СПб", "СБП")
            .build();
    }
}
