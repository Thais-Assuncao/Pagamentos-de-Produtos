package com.projetofinal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.projetofinal.dto.request.CategoryRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(of = { "id" })
@NoArgsConstructor
@Entity
public class Category {
	
	public Category(CategoryRequest categoryRequest) {
		
		this.fillFromDto(categoryRequest);		
	}
	
	public void fillFromDto(CategoryRequest categoryRequest) {
		this.setCode(categoryRequest.getCode());
		this.setName(categoryRequest.getName());
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String code;
	
}
