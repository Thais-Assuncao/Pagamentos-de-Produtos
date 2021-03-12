package com.projetofinal.dto.request;

import java.util.ArrayList;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import lombok.Data;

@Data
public class ProductRequest {

	@Size(min = 2, max = 255)
	@NotBlank
	private String name;
	
	@NotNull
	@Positive	
	private Long idCategory;
	
	@NotNull
	@Positive
	private Double price;
	
	@NotNull
	private ArrayList<String> details;
	
}
