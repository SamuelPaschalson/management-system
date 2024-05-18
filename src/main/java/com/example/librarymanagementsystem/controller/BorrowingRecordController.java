// src/main/java/com/example/librarymanagementsystem/controller/BorrowingRecordController.java
package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.entity.BorrowingRecord;
import com.example.librarymanagementsystem.exception.ResourceNotFoundException;
import com.example.librarymanagementsystem.service.BorrowingRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/borrowing-records")
public class BorrowingRecordController {
    @Autowired
    private BorrowingRecordService borrowingRecordService;

    @GetMapping
    public List<BorrowingRecord> getAllBorrowingRecords() {
        return borrowingRecordService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BorrowingRecord> getBorrowingRecordById(@PathVariable Long id) {
        return borrowingRecordService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Borrowing record not found with id " + id));
    }

    @PostMapping
    public BorrowingRecord createBorrowingRecord(@Valid @RequestBody BorrowingRecord borrowingRecord) {
        borrowingRecord.setBorrowingDate(LocalDate.now());
        return borrowingRecordService.save(borrowingRecord);
    }

    @PutMapping("/{id}/return")
    public ResponseEntity<BorrowingRecord> returnBook(@PathVariable Long id, @RequestBody LocalDate returnDate) {
        return borrowingRecordService.findById(id)
                .map(record -> {
                    record.setReturnDate(returnDate);
                    return ResponseEntity.ok(borrowingRecordService.save(record));
                })
                .orElseThrow(() -> new ResourceNotFoundException("Borrowing record not found with id " + id));
    }
}