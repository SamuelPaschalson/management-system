// src/main/java/com/example/librarymanagementsystem/entity/Patron.java
package com.example.librarymanagementsystem.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Patron {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Size(max = 100, message = "Name cannot be longer than 100 characters")
    private String name;

    @NotBlank(message = "Contact Info is mandatory")
    @Size(max = 100, message = "Contact Info cannot be longer than 100 characters")
    private String contactInfo;
}