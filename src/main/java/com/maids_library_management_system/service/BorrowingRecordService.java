package com.maids_library_management_system.service;

import java.util.Optional;

import com.maids_library_management_system.entity.BorrowingRecord;

public interface BorrowingRecordService {
	public Optional<BorrowingRecord> addBorrowingRecord(Long bookId, Long patronId);
	
	public Optional<BorrowingRecord> addReturnDate(Long bookId, Long patronId);
}
