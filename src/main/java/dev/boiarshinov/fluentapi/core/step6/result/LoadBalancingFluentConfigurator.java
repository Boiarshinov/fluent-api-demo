package dev.boiarshinov.fluentapi.core.step6.result;

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


    static abstract class AbstractLoadBalancerConfigurator<T extends AbstractLoadBalancerConfigurator<T>> {
        T healthcheckEnabled(boolean enabled) {
            return (T) this;
        }
    }

    static class HashLbConfigurator extends AbstractLoadBalancerConfigurator<HashLbConfigurator> {
        HashLbConfigurator md5() { return this; }
        HashLbConfigurator murmur3() { return this; }
        HashLbConfigurator sha256() { return this; }
    }

    static class RoundRobinFluentConfigurator extends AbstractLoadBalancerConfigurator<RoundRobinFluentConfigurator> {
        //много специфичных методов настройки
    }

    static class RandomLbConfigurator extends AbstractLoadBalancerConfigurator<RandomLbConfigurator> {
        //много специфичных методов настройки
    }

    static class LeastConnectionsConfigurator extends AbstractLoadBalancerConfigurator<LeastConnectionsConfigurator> {
        //много специфичных методов настройки
    }
}
