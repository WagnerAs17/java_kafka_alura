package br.com.alura.ecommerce;

import org.apache.kafka.common.serialization.Serializer;

public class GsonSerializer<T> extends BaseSerializer implements Serializer<T> {

    @Override
    public byte[] serialize(String s, T object) {
        return gson.toJson(object).getBytes();
    }
}
