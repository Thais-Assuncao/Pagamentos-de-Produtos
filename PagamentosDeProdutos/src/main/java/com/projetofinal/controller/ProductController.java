package com.projetofinal.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.projetofinal.dto.request.ProductRequest;
import com.projetofinal.dto.response.ProductResponse;
import com.projetofinal.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping(consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public ProductResponse post(@Valid @RequestBody ProductRequest productRequest) {
		return this.productService.create(productRequest);
	}
	
	@GetMapping(produces = "application/json")
	public List<ProductResponse> get() {
		return this.productService.getAll();
	}
	
	@PutMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
	public ProductResponse put(@Valid @RequestBody ProductRequest productRequest, @PathVariable Long id) {
		return this.productService.update(productRequest, id);
	}
	
	@DeleteMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		this.productService.delete(id);
	}
}
