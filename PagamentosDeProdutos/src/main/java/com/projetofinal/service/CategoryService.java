package com.projetofinal.service;

import java.util.List;
import java.util.stream.Collectors;

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
	
//	private Category findById(Long id) {
//		Optional<Category> categoryOptional = this.categoryRepository.findById(id);
//		Category category = categoryOptional.orElseThrow();
//		return category;
//	}
	
	public CategoryResponse create(CategoryRequest categoryRequest) {
		
		Category newCategory = new Category(categoryRequest);
		this.categoryRepository.save(newCategory);
		return new CategoryResponse(newCategory);
	}
	
	public List<CategoryResponse> getAll() {
		return this.categoryRepository.findAll().stream().map(CategoryResponse::new).collect(Collectors.toList());
	}
	
//	public CategoryResponse get(Long id) {
//		Category category = this.findById(id);
//		return new CategoryResponse(category);
//	}
}
