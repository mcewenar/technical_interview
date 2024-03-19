package com.example.demo.configuration.jackson.codecs.authorcodecs;

import com.example.demo.model.author.AuthorCc;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class AuthorCcCodecs {
    public static class Serializer extends JsonSerializer<AuthorCc> {
        @Override
        public void serialize(AuthorCc value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeNumber(value.toString());
        }
    }

    public static class Deserializer extends JsonDeserializer<AuthorCc> {
        @Override
        public AuthorCc deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
            return new AuthorCc(p.getLongValue());
        }
    }
}
