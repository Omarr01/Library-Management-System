package com.maids_library_management_system.service;

import com.maids_library_management_system.entity.BorrowingRecord;

public interface BorrowingRecordService {
	public BorrowingRecord addBorrowingRecord(Long bookId, Long patronId);
	
	public BorrowingRecord addReturnDate(Long bookId, Long patronId);
}
