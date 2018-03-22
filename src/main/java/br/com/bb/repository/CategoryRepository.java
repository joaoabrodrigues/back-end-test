package br.com.bb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bb.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
