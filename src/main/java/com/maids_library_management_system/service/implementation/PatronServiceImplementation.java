package com.maids_library_management_system.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maids_library_management_system.dto.PatronDto;
import com.maids_library_management_system.entity.Patron;
import com.maids_library_management_system.repository.PatronRepository;
import com.maids_library_management_system.service.PatronService;

@Service
public class PatronServiceImplementation implements PatronService {
	@Autowired
	private final PatronRepository patronRepository;

	public PatronServiceImplementation(PatronRepository patronRepository) {
		this.patronRepository = patronRepository;
	}

	@Override
	public List<Patron> getAllPatrons() {
		return patronRepository.findAll();
	}

	@Override
	public Optional<Patron> getPatronById(Long id) {
		return patronRepository.findById(id);
	}

	@Override
	public Patron addPatron(PatronDto patronDto) {
		Patron patron = new Patron();
		BeanUtils.copyProperties(patronDto, patron);
		return patronRepository.save(patron);
	}

	@Override
	public Patron updatePatron(Long id, PatronDto patronDetails) {
		return patronRepository.findById(id).map(patron -> {
			patron.setName(patronDetails.getName());
			patron.setEmail(patronDetails.getEmail());
			patron.setPhoneNumber(patronDetails.getPhoneNumber());
			return patronRepository.save(patron);
		}).orElseThrow(() -> new RuntimeException("Patron not found with id " + id));
	}

	@Override
	public void deletePatron(Long id) {
		patronRepository.deleteById(id);
	}

}
