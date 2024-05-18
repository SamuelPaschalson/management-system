// src/test/java/com/example/librarymanagementsystem/service/PatronServiceTests.java
package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.entity.Patron;
import com.example.librarymanagementsystem.repository.PatronRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

@SpringBootTest
public class PatronServiceTests {

    @Autowired
    private PatronService patronService;

    @MockBean
    private PatronRepository patronRepository;

    @Test
    void testSavePatron() {
        Patron patron = new Patron();
        patron.setName("Test Patron");

        Mockito.when(patronRepository.save(any(Patron.class))).thenReturn(patron);

        Patron savedPatron = patronService.save(patron);

        assertEquals(patron.getName(), savedPatron.getName());
    }

    @Test
    void testFindPatronById() {
        Patron patron = new Patron();
        patron.setId(1L);
        patron.setName("Test Patron");

        Mockito.when(patronRepository.findById(anyLong())).thenReturn(Optional.of(patron));

        Optional<Patron> foundPatron = patronService.findById(1L);

        assertTrue(foundPatron.isPresent());
        assertEquals(patron.getName(), foundPatron.get().getName());
    }
}