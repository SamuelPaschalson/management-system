// src/test/java/com/example/librarymanagementsystem/service/BorrowingRecordServiceTests.java
package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.entity.BorrowingRecord;
import com.example.librarymanagementsystem.repository.BorrowingRecordRepository;
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
public class BorrowingRecordServiceTests {

    @Autowired
    private BorrowingRecordService borrowingRecordService;

    @MockBean
    private BorrowingRecordRepository borrowingRecordRepository;

    @Test
    void testSaveBorrowingRecord() {
        BorrowingRecord borrowingRecord = new BorrowingRecord();
        borrowingRecord.setBorrowingDate(LocalDate.now());

        Mockito.when(borrowingRecordRepository.save(any(BorrowingRecord.class))).thenReturn(borrowingRecord);

        BorrowingRecord savedRecord = borrowingRecordService.save(borrowingRecord);

        assertEquals(borrowingRecord.getBorrowingDate(), savedRecord.getBorrowingDate());
    }

    @Test
    void testFindBorrowingRecordById() {
        BorrowingRecord borrowingRecord = new BorrowingRecord();
        borrowingRecord.setId(1L);

        Mockito.when(borrowingRecordRepository.findById(anyLong())).thenReturn(Optional.of(borrowingRecord));

        Optional<BorrowingRecord> foundRecord = borrowingRecordService.findById(1L);

        assertTrue(foundRecord.isPresent());
        assertEquals(borrowingRecord.getId(), foundRecord.get().getId());
    }
}