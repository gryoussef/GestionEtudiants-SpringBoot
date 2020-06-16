package com.ensas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data @AllArgsConstructor
public class AuthentificationResponseDTO {
	private final String jwt;
}
