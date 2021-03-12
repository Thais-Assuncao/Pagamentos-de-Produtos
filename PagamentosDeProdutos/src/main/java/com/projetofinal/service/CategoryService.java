package com.projetofinal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetofinal.dto.request.CategoryRequest;
import com.projetofinal.dto.response.CategoryResponse;
import com.projetofinal.entity.Category;
import com.projetofinal.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	
	public CategoryResponse create(CategoryRequest categoryRequest) {
		
		Category newCategory = new Category(categoryRequest);
		this.categoryRepository.save(newCategory);
		return new CategoryResponse(newCategory);
	}
}
