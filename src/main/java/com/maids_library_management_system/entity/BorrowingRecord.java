package com.maids_library_management_system.entity;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

import jakarta.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class BorrowingRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book;

	@ManyToOne
	@JoinColumn(name = "patron_id")
	private Patron patron;

	@Column(name = "borrow_date", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date borrowDate;

	@Column(name = "return_date")
	@Temporal(TemporalType.DATE)
	private Date returnDate;
}
