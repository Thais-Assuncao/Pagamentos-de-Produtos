package com.projetofinal.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.projetofinal.dto.request.CategoryRequest;
import com.projetofinal.dto.response.CategoryResponse;
import com.projetofinal.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired 
	private CategoryService categoryService;
	
	@PostMapping(consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public CategoryResponse post(@Valid @RequestBody CategoryRequest categoryRequest) {
		return this.categoryService.create(categoryRequest);
	}
	
	@GetMapping(produces = "application/json")
	public List<CategoryResponse> get() {
		return this.categoryService.getAll();
	}

//	@GetMapping(path = "/{id}", produces = "application/json")
//	public CategoryResponse get(@PathVariable Long id) {
//		return this.categoryService.get(id);
//	}
}
