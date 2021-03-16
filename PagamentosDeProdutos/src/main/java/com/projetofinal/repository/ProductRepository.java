package com.projetofinal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetofinal.entity.Category;
import com.projetofinal.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

    List<Product> findByCategory(Category category);
	
	List<Product> findByOrderByPriceAsc();
	
	List<Product> findByOrderByPriceDesc();
	
	List<Product> findProductByIdIn(List<Long> productIds);
}
