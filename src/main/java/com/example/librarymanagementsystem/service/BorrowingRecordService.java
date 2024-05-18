// src/main/java/com/example/librarymanagementsystem/service/BorrowingRecordService.java
package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.entity.BorrowingRecord;
import com.example.librarymanagementsystem.repository.BorrowingRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BorrowingRecordService {
    @Autowired
    private BorrowingRecordRepository borrowingRecordRepository;

    public List<BorrowingRecord> findAll() {
        return borrowingRecordRepository.findAll();
    }

    public Optional<BorrowingRecord> findById(Long id) {
        return borrowingRecordRepository.findById(id);
    }

    public BorrowingRecord save(BorrowingRecord borrowingRecord) {
        return borrowingRecordRepository.save(borrowingRecord);
    }

    public void deleteById(Long id) {
        borrowingRecordRepository.deleteById(id);
    }

    @Transactional
    public BorrowingRecord borrowBook(BorrowingRecord record) {
        return borrowingRecordRepository.save(record);
    }

    @Transactional
    public BorrowingRecord returnBook(Long id, LocalDate returnDate) {
        BorrowingRecord record = borrowingRecordRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("BorrowingRecord", "id", id));
        record.setReturnDate(returnDate);
        return borrowingRecordRepository.save(record);
    }
}