package br.com.alura.ecommerce;

import java.util.UUID;

public class Message<T> {

    private final String id;
    private final T payload;

    public Message( T payload) {
        this.id = UUID.randomUUID().toString();
        this.payload = payload;
    }

    public T getPayload() {
        return payload;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                ", payload=" + payload +
                '}';
    }
}
