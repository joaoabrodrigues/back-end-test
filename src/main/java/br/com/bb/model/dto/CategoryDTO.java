package br.com.bb.model.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

public class CategoryDTO implements Serializable {
	
	private static final long serialVersionUID = 6196033656380058573L;

	@NotBlank
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
