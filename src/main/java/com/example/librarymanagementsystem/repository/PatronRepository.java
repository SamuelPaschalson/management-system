// src/main/java/com/example/librarymanagementsystem/repository/PatronRepository.java
package com.example.librarymanagementsystem.repository;

import com.example.librarymanagementsystem.entity.Patron;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatronRepository extends JpaRepository<Patron, Long> {
}