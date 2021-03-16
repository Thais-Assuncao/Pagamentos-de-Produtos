package com.projetofinal.dto.request;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class ClientRequest {

	@Email
	@NotBlank
	private String email;
	
	@Size(min = 2, max = 255)
	@NotBlank
	private String address;
	
	private List<Long> ordersIds;
}
