package br.com.alura.ecommerce;

import org.apache.kafka.common.serialization.Deserializer;

public class GsonDeserializer<T> extends BaseSerializer implements Deserializer<Message> {

    @Override
    public Message deserialize(String s, byte[] bytes) {
        return gson.fromJson(new String(bytes), Message.class);
    }
}
