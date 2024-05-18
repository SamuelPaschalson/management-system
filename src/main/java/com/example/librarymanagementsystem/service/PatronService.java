// src/main/java/com/example/librarymanagementsystem/service/PatronService.java
package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.entity.Patron;
import com.example.librarymanagementsystem.repository.PatronRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatronService {
    @Autowired
    private PatronRepository patronRepository;

    public List<Patron> findAll() {
        return patronRepository.findAll();
    }

    public Optional<Patron> findById(Long id) {
        return patronRepository.findById(id);
    }

    public Patron save(Patron patron) {
        return patronRepository.save(patron);
    }

    public void deleteById(Long id) {
        patronRepository.deleteById(id);
    }
}