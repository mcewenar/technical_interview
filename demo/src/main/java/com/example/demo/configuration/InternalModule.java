package com.example.demo.configuration;

import com.example.demo.configuration.jackson.codecs.authorcodecs.AuthorCcCodecs;
import com.example.demo.configuration.jackson.codecs.authorcodecs.AuthorNameCodecs;
import com.example.demo.configuration.jackson.codecs.authorcodecs.BirthDateCodecs;
import com.example.demo.configuration.jackson.codecs.authorcodecs.YearsOldCodecs;
import com.example.demo.configuration.jackson.codecs.bookcodecs.IsbnCodecs;
import com.example.demo.configuration.jackson.codecs.bookcodecs.NameCodecs;
import com.example.demo.configuration.jackson.codecs.bookcodecs.PageNumberCodecs;
import com.example.demo.configuration.jackson.codecs.bookcodecs.TypeCodecs;
import com.example.demo.model.author.AuthorCc;
import com.example.demo.model.author.AuthorName;
import com.example.demo.model.author.BirthDate;
import com.example.demo.model.author.YearsOld;
import com.example.demo.model.book.Isbn;
import com.example.demo.model.book.Name;
import com.example.demo.model.book.PageNumber;
import com.example.demo.model.book.Type;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class InternalModule extends SimpleModule {
    private static final String NAME = "InternalModule";

    public InternalModule() {
        super(NAME, Version.unknownVersion());

        //Book:
        addSerializer(Isbn.class, new IsbnCodecs.Serializer());
        addDeserializer(Isbn.class, new IsbnCodecs.Deserializer());

        addSerializer(Name.class, new NameCodecs.Serializer());
        addDeserializer(Name.class, new NameCodecs.Deserializer());

        addSerializer(PageNumber.class, new PageNumberCodecs.Serializer());
        addDeserializer(PageNumber.class, new PageNumberCodecs.Deserializer());

        addSerializer(Type.class, new TypeCodecs.Serializer());
        addDeserializer(Type.class, new TypeCodecs.Deserializer());


        //Author:
        addSerializer(AuthorCc.class, new AuthorCcCodecs.Serializer());
        addDeserializer(AuthorCc.class, new AuthorCcCodecs.Deserializer());

        addSerializer(AuthorName.class, new AuthorNameCodecs.Serializer());
        addDeserializer(AuthorName.class, new AuthorNameCodecs.Deserializer());

        addSerializer(BirthDate.class, new BirthDateCodecs.Serializer());
        addDeserializer(BirthDate.class, new BirthDateCodecs.Deserializer());

        addSerializer(YearsOld.class, new YearsOldCodecs.Serializer());
        addDeserializer(YearsOld.class, new YearsOldCodecs.Deserializer());
    }
}
