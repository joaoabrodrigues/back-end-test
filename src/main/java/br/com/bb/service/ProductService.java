package br.com.bb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bb.model.Product;
import br.com.bb.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getAll() {
		return productRepository.findAll();
	}

	public List<Product> getAllProductsByCategory(Long categoryId) {
		return productRepository.findByCategoryId(categoryId);
	}
}
