// src/test/java/com/example/librarymanagementsystem/controller/BorrowingRecordControllerTests.java
package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.entity.BorrowingRecord;
import com.example.librarymanagementsystem.entity.Book;
import com.example.librarymanagementsystem.entity.Patron;
import com.example.librarymanagementsystem.repository.BookRepository;
import com.example.librarymanagementsystem.repository.PatronRepository;
import com.example.librarymanagementsystem.repository.BorrowingRecordRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class BorrowingRecordControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PatronRepository patronRepository;

    @Autowired
    private BorrowingRecordRepository borrowingRecordRepository;

    private Book book;
    private Patron patron;

    @BeforeEach
    void setup() {
        bookRepository.deleteAll();
        patronRepository.deleteAll();
        borrowingRecordRepository.deleteAll();

        book = new Book("Test Book", "Test Author", 2000, "1234567890123");
        bookRepository.save(book);

        patron = new Patron("John Doe", "john@example.com");
        patronRepository.save(patron);
    }

    @Test
    void testGetAllBorrowingRecords() throws Exception {
        BorrowingRecord record = new BorrowingRecord();
        record.setBook(book);
        record.setPatron(patron);
        record.setBorrowingDate(LocalDate.now());
        borrowingRecordRepository.save(record);

        mockMvc.perform(get("/api/borrowing-records"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    void testCreateBorrowingRecord() throws Exception {
        String borrowingRecordJson = String.format(
                "{\"bookId\": %d, \"patronId\": %d, \"borrowingDate\": \"%s\"}",
                book.getId(), patron.getId(), LocalDate.now().toString()
        );

        mockMvc.perform(post("/api/borrowing-records")
                .contentType(MediaType.APPLICATION_JSON)
                .content(borrowingRecordJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.book.id").value(book.getId()));
    }
}