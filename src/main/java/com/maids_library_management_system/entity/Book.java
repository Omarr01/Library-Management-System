package com.maids_library_management_system.entity;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "\"book\"")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "title", length = 100, nullable = false)
	private String title;

	@Column(name = "author", length = 50, nullable = false)
	private String author;

	@Column(name = "publication_year", nullable = false)
	private int publicationYear;

	@Column(name = "isbn", length = 26, unique = true, nullable = false)
	private String isbn;
}
