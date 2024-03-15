package com.example.demo.configuration.jackson.codecs.authorcodecs;

import com.example.demo.model.author.BirthDate;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDate;

public class BirthDateCodecs {
    public static class Serializer extends JsonSerializer<BirthDate> {
        @Override
        public void serialize(BirthDate value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString(value.toString());
        }
    }

    public static class Deserializer extends JsonDeserializer<BirthDate> {
        @Override
        public BirthDate deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
            return new BirthDate(LocalDate.parse(p.getValueAsString()));
        }
    }
}
