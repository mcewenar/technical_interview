package com.example.demo.configuration.jackson.codecs.bookcodecs;

import com.example.demo.model.book.Name;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class NameCodecs {
    public static class Serializer extends JsonSerializer<Name> {
        @Override
        public void serialize(Name value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString(value.toString());
        }
    }

    public static class Deserializer extends JsonDeserializer<Name> {
        @Override
        public Name deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
            return new Name(p.getValueAsString());
        }
    }
}
