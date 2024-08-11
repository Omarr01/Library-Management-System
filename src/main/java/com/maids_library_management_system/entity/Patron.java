package com.maids_library_management_system.entity;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Patron {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", length = 50, nullable = false)
	private String name;

	@Column(name = "email", length = 50, unique = true, nullable = false)
	private String email;

	@Column(name = "phone_number", length = 30, unique = true, nullable = false)
	private String phoneNumber;
}
