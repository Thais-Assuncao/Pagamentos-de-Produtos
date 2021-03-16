package com.projetofinal.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.projetofinal.dto.request.ProductRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(of = { "id" })
@NoArgsConstructor
@Entity
public class Product {
	
	public Product(ProductRequest productRequest, Category category) {
		this.fillFromDto(productRequest);
		this.setCategory(category);
	}
	
	public void fillFromDto(ProductRequest productRequest) {
		this.setName(productRequest.getName());
		this.setPrice(productRequest.getPrice());
		this.setDetails(productRequest.getDetails());
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id", referencedColumnName = "id")
	private Category category;
	
	@Column(nullable = false)
	private Double price;
	
	@ElementCollection
	private List<String> details = new ArrayList<String>();

}
