package com.pro.cat.productosCategorias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewUserDTO {
	
	private String username;
	private String password;
	private String role = "USER";
	
	public NewUserDTO(String username, String password) {
		
		this.username = username;
		this.password = password;
	}
}
