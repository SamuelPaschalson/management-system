// src/main/java/com/example/librarymanagementsystem/controller/PatronController.java
package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.entity.Patron;
import com.example.librarymanagementsystem.exception.ResourceNotFoundException;
import com.example.librarymanagementsystem.service.PatronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/patrons")
public class PatronController {
    @Autowired
    private PatronService patronService;

    @GetMapping
    public List<Patron> getAllPatrons() {
        return patronService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patron> getPatronById(@PathVariable Long id) {
        return patronService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Patron not found with id " + id));
    }

    @PostMapping
    public Patron createPatron(@Valid @RequestBody Patron patron) {
        return patronService.save(patron);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patron> updatePatron(@PathVariable Long id, @Valid @RequestBody Patron patronDetails) {
        return patronService.findById(id)
                .map(patron -> {
                    patron.setName(patronDetails.getName());
                    patron.setContactInfo(patronDetails.getContactInfo());
                    return ResponseEntity.ok(patronService.save(patron));
                })
                .orElseThrow(() -> new ResourceNotFoundException("Patron not found with id " + id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatron(@PathVariable Long id) {
        return patronService.findById(id)
                .map(patron -> {
                    patronService.deleteById(id);
                    return ResponseEntity.noContent().build();
                })
                .orElseThrow(() -> new ResourceNotFoundException("Patron not found with id " + id));
    }
}