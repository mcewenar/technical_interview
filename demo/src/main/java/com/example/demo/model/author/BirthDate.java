package com.example.demo.model.author;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Objects;
/*@Data
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class BirthDate {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    //@JsonSerialize( using = LocalDateSerializer.class )
    //@JsonDeserialize( using = LocalDateDeserializer.class )
    private LocalDate birthDateAuthor;

    public BirthDate(LocalDate birthDateAuthor) {
        Objects.requireNonNull(birthDateAuthor, "BirthDate can not be null");
        this.birthDateAuthor = birthDateAuthor;
    }

}

 */
