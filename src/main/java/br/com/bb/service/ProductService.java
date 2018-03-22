package br.com.bb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bb.model.Product;
import br.com.bb.model.dto.ProductDTO;
import br.com.bb.repository.CategoryRepository;
import br.com.bb.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public void saveProduct(ProductDTO product) {
		productRepository.save(new Product(product, categoryRepository.findOne(product.getCategory())));
	}
	
	public void updateProduct(ProductDTO productDTO, Long id) {
		Product product = new Product(productDTO, categoryRepository.findOne(productDTO.getCategory()));
		product.setId(id);
		productRepository.save(product);
	}
	
	public List<Product> getAllCategories() {
		return productRepository.findAll();
	}
	
	public void deleteProduct(Long id) {
		productRepository.delete(id);
	}

	public List<Product> getAllProductsByCategory(Long categoryId) {
		return productRepository.findByCategoryId(categoryId);
	}
}
