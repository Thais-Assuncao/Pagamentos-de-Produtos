package com.projetofinal.dto.response;

import com.projetofinal.entity.Product;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductResponse {

	public ProductResponse(Product product) {
		this.setId(product.getId());
		this.setName(product.getName());
		this.setPrice(product.getPrice());
				
		CategoryResponse categoryResponse = new CategoryResponse(product.getCategory());
		this.setCategory(categoryResponse);
				
//		this.setDetails(product.getDetails());
	}

	private Long id;
		
	private String name;

	private CategoryResponse category;
	
	private Double price;
	
//	private List<String> details;
	
}
