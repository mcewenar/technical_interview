package com.example.demo.configuration.jackson.codecs.bookcodecs;

import com.example.demo.model.book.PageNumber;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class PageNumberCodecs {
    public static class Serializer extends JsonSerializer<PageNumber> {
        @Override
        public void serialize(PageNumber value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeNumber(value.toString());
        }
    }

    public static class Deserializer extends JsonDeserializer<PageNumber> {
        @Override
        public PageNumber deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
            return new PageNumber(p.getIntValue());
        }
    }

}
