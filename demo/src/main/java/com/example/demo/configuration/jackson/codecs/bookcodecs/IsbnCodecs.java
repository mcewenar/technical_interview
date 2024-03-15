package com.example.demo.configuration.jackson.codecs.bookcodecs;

import com.example.demo.model.book.Isbn;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class IsbnCodecs {
    public static class Serializer extends JsonSerializer<Isbn> {
        @Override
        public void serialize(Isbn value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString(value.toString());
        }
    }

    public static class Deserializer extends JsonDeserializer<Isbn> {
        @Override
        public Isbn deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
            return new Isbn(p.getValueAsString());
        }
    }
}
