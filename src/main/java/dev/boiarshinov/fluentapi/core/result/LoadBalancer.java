package dev.boiarshinov.fluentapi.core.result;

import java.util.List;
import java.util.function.BiFunction;

public class LoadBalancer {

    private final List<String> recipients;
    private final BiFunction<byte[], List<String>, String> recipientResolver;

    public LoadBalancer(List<String> recipients, BiFunction<byte[], List<String>, String> recipientResolver) {
        this.recipients = recipients;
        this.recipientResolver = recipientResolver;
    }

    public String getNextRecipient(byte[] request) {
        return recipientResolver.apply(request, recipients);
    }
}
