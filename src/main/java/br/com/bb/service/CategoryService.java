package br.com.bb.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import br.com.bb.model.Category;
import br.com.bb.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> getAll() {
		return categoryRepository.findAll();
	}
	
	public Category getCategoryWithMostCharOccurrence(String letter) {
		return getAll().stream()
						  .sorted(Comparator.comparing(Category::getName, (name1, name2) -> {
							  return Integer.compare(StringUtils.countOccurrencesOf(name2.toUpperCase(), letter.toUpperCase()),
									  StringUtils.countOccurrencesOf(name1.toUpperCase(), letter.toUpperCase()));
						  })).findFirst().get();
	}
}
