package com.projetofinal.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetofinal.dto.request.ProductRequest;
import com.projetofinal.dto.response.ProductResponse;
import com.projetofinal.entity.Category;
import com.projetofinal.entity.Product;
import com.projetofinal.repository.CategoryRepository;
import com.projetofinal.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	private Product findById(Long id) {
		Optional<Product> contatoOptional = this.productRepository.findById(id);
		Product product = contatoOptional.orElseThrow();
		return product;
	}
	
	public ProductResponse create(ProductRequest productRequest) {
		Category category = categoryRepository.findById(productRequest.getIdCategory()).orElseThrow();		
		Product newProduct = new Product(productRequest, category);
		Product product = this.productRepository.save(newProduct);
		return new ProductResponse(product);
	}	
	
	public List<ProductResponse> getAll() {
		return this.productRepository.findAll().stream().map(ProductResponse::new).collect(Collectors.toList());
	}
	
	public ProductResponse update(ProductRequest productRequest, Long id) {
		Product product = this.findById(id);
		product.fillFromDto(productRequest);
		this.productRepository.save(product);
		return new ProductResponse(product);
	}
	
	public void delete(Long id) {
		Product product = this.findById(id);
		this.productRepository.delete(product);
	}
	
	
	

}
