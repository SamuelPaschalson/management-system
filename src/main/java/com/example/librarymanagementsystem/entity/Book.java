// src/main/java/com/example/librarymanagementsystem/entity/Book.java
package com.example.librarymanagementsystem.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is mandatory")
    @Size(max = 100, message = "Title cannot be longer than 100 characters")
    private String title;

    @NotBlank(message = "Author is mandatory")
    @Size(max = 100, message = "Author cannot be longer than 100 characters")
    private String author;

    private int publicationYear;

    @NotBlank(message = "ISBN is mandatory")
    @Size(max = 13, message = "ISBN cannot be longer than 13 characters")
    private String isbn;
}