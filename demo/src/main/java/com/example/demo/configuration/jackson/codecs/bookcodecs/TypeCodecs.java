package com.example.demo.configuration.jackson.codecs.bookcodecs;

import com.example.demo.model.book.Type;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class TypeCodecs {
    public static class Serializer extends JsonSerializer<Type> {
        @Override
        public void serialize(Type value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString(value.toString());
        }
    }

    public static class Deserializer extends JsonDeserializer<Type> {
        @Override
        public Type deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
            return new Type(p.getValueAsString());
        }
    }
}
