package br.com.alura.ecommerce;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class MessageAdapter implements JsonSerializer<Message> {
    @Override
    public JsonElement serialize(Message message, Type type, JsonSerializationContext context) {
        var obj = new JsonObject();
        obj.add("correlationId", context.serialize(message.getId()));
        obj.add("data", context.serialize(message.getPayload()));
        obj.addProperty("type", message.getPayload().getClass().getName());

        return obj;
    }
}
