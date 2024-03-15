package com.example.demo.configuration.jackson.codecs.authorcodecs;

import com.example.demo.model.author.YearsOld;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class YearsOldCodecs {
    public static class Serializer extends JsonSerializer<YearsOld> {
        @Override
        public void serialize(YearsOld value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString(value.toString());
        }
    }

    public static class Deserializer extends JsonDeserializer<YearsOld> {
        @Override
        public YearsOld deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
            return new YearsOld(p.getIntValue());
        }
    }
}
