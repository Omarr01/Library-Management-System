package com.maids_library_management_system.service;

import java.util.List;
import java.util.Optional;

import com.maids_library_management_system.dto.PatronDto;
import com.maids_library_management_system.entity.Patron;

public interface PatronService {
	public List<Patron> getAllPatrons();

	public Optional<Patron> getPatronById(Long id);

	public Patron addPatron(PatronDto patronDto);
	
	public Optional<Patron> updatePatron(Long id, PatronDto patronDto);

	public Optional<Patron> deletePatron(Long id);
}
