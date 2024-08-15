package dev.boiarshinov.fluentapi.core.step6.initial;

public class LoadBalancingFluentConfigurator {
    public RoundRobinFluentConfigurator roundRobin() {
        return new RoundRobinFluentConfigurator();
    }

    public RandomLbConfigurator random() {
        return new RandomLbConfigurator();
    }

    public HashLbConfigurator hash() {
        return new HashLbConfigurator();
    }

    public LeastConnectionsConfigurator leastConnections() {
        return new LeastConnectionsConfigurator();
    }



    static class HashLbConfigurator {
        HashLbConfigurator md5() { return this; }
        HashLbConfigurator murmur3() { return this; }
        HashLbConfigurator sha256() { return this; }
    }

    static class RoundRobinFluentConfigurator {
        //много специфичных методов настройки
    }

    static class RandomLbConfigurator {
        //много специфичных методов настройки
    }

    static class LeastConnectionsConfigurator {
        //много специфичных методов настройки
    }
}
