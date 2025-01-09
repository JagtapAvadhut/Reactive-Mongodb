package com.spring.reactive.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
//import org.springframework.data.cassandra.core.mapping.PrimaryKey;
//import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("books")
//@Table("users")
public class Book {

    @Id
//    @PrimaryKey
    private String id;

//    @NotBlank(message = "Title cannot be blank")
    private String title;

//    @NotBlank(message = "Author cannot be blank")
    private String author;

//    @NotNull(message = "Price cannot be null")
    private Double price;
}
