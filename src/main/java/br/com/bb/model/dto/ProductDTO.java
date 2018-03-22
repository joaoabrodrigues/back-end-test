package br.com.bb.model.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

public class ProductDTO implements Serializable {
	
	private static final long serialVersionUID = -6466186865124976390L;

	@NotBlank
	private String name;
	
	private Long category;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCategory() {
		return category;
	}

	public void setCategory(Long category) {
		this.category = category;
	}
}
