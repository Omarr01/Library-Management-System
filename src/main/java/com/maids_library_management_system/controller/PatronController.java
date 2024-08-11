package com.maids_library_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.maids_library_management_system.dto.PatronDto;
import com.maids_library_management_system.entity.Patron;
import com.maids_library_management_system.exception.PatronNotFoundException;
import com.maids_library_management_system.service.implementation.PatronServiceImplementation;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/patrons")
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@Slf4j
public class PatronController {
	@Autowired
	private final PatronServiceImplementation patronServiceImplementation;

	public PatronController(PatronServiceImplementation patronServiceImplementation) {
		this.patronServiceImplementation = patronServiceImplementation;
	}

	@GetMapping
	public List<Patron> getAllPatrons() {
		return patronServiceImplementation.getAllPatrons();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Patron> getPatronById(@PathVariable Long id) {
		return patronServiceImplementation.getPatronById(id).map(ResponseEntity::ok)
				.orElseThrow(() -> new PatronNotFoundException("Patron not found with id " + id));
	}

	@PostMapping
	public Patron addPatron(@Valid @RequestBody PatronDto patronDto) {
		return patronServiceImplementation.addPatron(patronDto);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Patron> updatePatron(@PathVariable Long id, @Valid @RequestBody PatronDto patronDetails) {
        return patronServiceImplementation.updatePatron(id, patronDetails)
            .map(ResponseEntity::ok)
            .orElseThrow(() -> new PatronNotFoundException("Patron not found with id " + id));
    }

	@DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatron(@PathVariable Long id) {
        patronServiceImplementation.deletePatron(id)
            .orElseThrow(() -> new PatronNotFoundException("Patron not found with id " + id));
        return ResponseEntity.noContent().build();
    }
}
