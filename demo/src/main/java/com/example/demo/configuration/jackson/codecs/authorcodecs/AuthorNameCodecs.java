package com.example.demo.configuration.jackson.codecs.authorcodecs;

import com.example.demo.model.author.AuthorName;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class AuthorNameCodecs {
    public static class Serializer extends JsonSerializer<AuthorName> {
        @Override
        public void serialize(AuthorName value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString(value.toString());
        }
    }

    public static class Deserializer extends JsonDeserializer<AuthorName> {
        @Override
        public AuthorName deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
            return new AuthorName(p.getValueAsString());
        }
    }
}
