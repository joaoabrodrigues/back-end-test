package br.com.bb.service;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import br.com.bb.model.Category;
import br.com.bb.model.dto.CategoryDTO;
import br.com.bb.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public void saveCategory(CategoryDTO category) {
		categoryRepository.save(new Category(category));
	}
	
	public void updateCategory(CategoryDTO categoryDTO, Long id) {
		Category categoryToUpdate = categoryRepository.findOne(id);
		if (Objects.nonNull(categoryToUpdate)) {
			Category category = new Category(categoryDTO);
			category.setId(id);
			categoryRepository.save(category);
		}
	}
	
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}
	
	public Category getCategoryWithMostCharOccurrence(String letter) {
		return getAllCategories().stream()
						  .sorted(Comparator.comparing(Category::getName, (c1, c2) -> {
							  return Integer.compare(StringUtils.countOccurrencesOf(c2.toUpperCase(), letter.toUpperCase()),
									  StringUtils.countOccurrencesOf(c1.toUpperCase(), letter.toUpperCase()));
						  })).findFirst().get();
	}
	
	public void deleteCategory(Long id) {
		categoryRepository.delete(id);
	}
}
