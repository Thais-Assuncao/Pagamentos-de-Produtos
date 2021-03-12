package com.projetofinal.dto.response;

import com.projetofinal.entity.Category;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryResponse {
	
	public CategoryResponse(Category category) {
		this.setId(category.getId());
		this.setName(category.getName());
		this.setCode(category.getCode() + String.format("%02d", category.getId()));
	}

	private Long id;

	private String name;

	private String code;

}
