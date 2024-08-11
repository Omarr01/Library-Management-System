package com.maids_library_management_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatronDto {
	private String name;
	private String email;
	private String phoneNumber;
}
