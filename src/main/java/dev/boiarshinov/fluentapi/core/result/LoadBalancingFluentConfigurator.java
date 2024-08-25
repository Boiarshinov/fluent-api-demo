package dev.boiarshinov.fluentapi.core.result;

import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;

public class LoadBalancingFluentConfigurator {

    private final List<String> recipients;
    private AbstractLoadBalancerConfigurator<?> implementation;

    public LoadBalancingFluentConfigurator(List<String> recipients) {
        this.recipients = recipients;
    }

    public RoundRobinFluentConfigurator roundRobin() {
        var configurator = new RoundRobinFluentConfigurator();
        implementation = configurator;
        return configurator;
    }

    public RandomLbConfigurator random() {
        var configurator = new RandomLbConfigurator();
        implementation = configurator;
        return configurator;
    }

    public HashLbConfigurator hash() {
        var configurator = new HashLbConfigurator();
        implementation = configurator;
        return configurator;
    }

    LoadBalancer build() {
        return new LoadBalancer(recipients, implementation.recipientResolver());
    }

    static abstract class AbstractLoadBalancerConfigurator<T extends AbstractLoadBalancerConfigurator<T>> {
        protected boolean healthcheckEnabled = false;

        T healthcheckEnabled(boolean enabled) {
            healthcheckEnabled = enabled;
            return (T) this;
        }

        abstract BiFunction<byte[], List<String>, String> recipientResolver();
    }

    public static class HashLbConfigurator extends AbstractLoadBalancerConfigurator<HashLbConfigurator> {
        private HashAlgorithm algorithm;

        HashLbConfigurator md5() {
            algorithm = HashAlgorithm.MD5;
            return this;
        }
        HashLbConfigurator murmur3() {
            algorithm = HashAlgorithm.MURMUR3;
            return this;
        }
        HashLbConfigurator sha256() {
            algorithm = HashAlgorithm.SHA256;
            return this;
        }

        @Override
        BiFunction<byte[], List<String>, String> recipientResolver() {
            return (input, recipients) -> {
                int hash = input.hashCode(); //считать хэш по выбранному алгоритму
                return recipients.get(hash % recipients.size());
            };
        }

        private enum HashAlgorithm {
            MD5, MURMUR3, SHA256
        }
    }

    public static class RoundRobinFluentConfigurator extends AbstractLoadBalancerConfigurator<RoundRobinFluentConfigurator> {
        //много специфичных методов настройки

        @Override
        BiFunction<byte[], List<String>, String> recipientResolver() {
            //Здесь нужно прикапывать итератор. Лень писать
            return (input, recipients) -> recipients.get(0);
        }
    }

    public static class RandomLbConfigurator extends AbstractLoadBalancerConfigurator<RandomLbConfigurator> {
        //много специфичных методов настройки
        private final Random random = new Random();

        @Override
        BiFunction<byte[], List<String>, String> recipientResolver() {
            return (input, recipients) -> {
                int index = random.nextInt(recipients.size());
                return recipients.get(index);
            };
        }
    }
}
