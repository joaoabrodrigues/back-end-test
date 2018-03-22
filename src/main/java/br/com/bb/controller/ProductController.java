package br.com.bb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.bb.model.Product;
import br.com.bb.model.dto.ProductDTO;
import br.com.bb.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> createProduct(@RequestBody ProductDTO product) {
		productService.saveProduct(product);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> updateProduct(@PathVariable("id") Long id, @RequestBody ProductDTO product) {
		productService.updateProduct(product, id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id) {
		productService.deleteProduct(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(path = "/listAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Product> listAll() {
		return productService.getAllCategories();
	}
	
	@RequestMapping(path = "/listByCategory/{categoryId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Product> getAllProductsByCategory(@PathVariable("categoryId") Long categoryId) {
		return productService.getAllProductsByCategory(categoryId);
	}

}
