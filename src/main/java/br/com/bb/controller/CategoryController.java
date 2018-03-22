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

import br.com.bb.model.Category;
import br.com.bb.model.dto.CategoryDTO;
import br.com.bb.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> createCategory(@RequestBody CategoryDTO category) {
		categoryService.saveCategory(category);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> updateCategory(@PathVariable("id") Long id, @RequestBody CategoryDTO category) {
		categoryService.updateCategory(category, id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteCategory(@PathVariable("id") Long id) {
		categoryService.deleteCategory(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(path = "/listAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Category> getCategories() {
		return categoryService.getAllCategories();
	}
	
	@RequestMapping(path = "/listAll/{letter}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Category getCategoryWithMostCharOccurrence(@PathVariable("letter") String letter) {
		return categoryService.getCategoryWithMostCharOccurrence(letter);
	}

}
