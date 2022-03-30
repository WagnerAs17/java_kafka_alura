package br.com.alura.ecommerce;

import com.google.gson.*;

import java.lang.reflect.Type;

public class MessageAdapter implements JsonSerializer<Message> , JsonDeserializer<Message> {
    @Override
    public JsonElement serialize(Message message, Type type, JsonSerializationContext context) {
        var obj = new JsonObject();
        obj.add("correlationId", context.serialize(message.getId()));
        obj.add("data", context.serialize(message.getPayload()));
        obj.addProperty("type", message.getPayload().getClass().getName());

        return obj;
    }

    @Override
    public Message deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {

        var obj = jsonElement.getAsJsonObject();
        var payloadType = obj.get("type").getAsString();
        var correlationId = (CorrelationId) context.deserialize(obj.get("correlationId"), CorrelationId.class);

        try {
            var data = context.deserialize(obj.get("data"), Class.forName(payloadType));
            return new Message(correlationId, data);
        } catch (ClassNotFoundException e) {
            System.out.println("Class is not found!!");
           throw new JsonParseException(e);
        }
    }
}
