package com.longnguyen.converter;

import org.springframework.stereotype.Component;

import com.longnguyen.dto.CategoryDTO;
import com.longnguyen.entity.CategoryEntity;

@Component
public class CategoryConverter {

	public CategoryDTO toDTO(CategoryEntity entity) {
		CategoryDTO result = new CategoryDTO();
		result.setCode(entity.getCode());
		result.setName(entity.getName());
		return result;
	}
	
	public CategoryEntity toEntity(CategoryDTO entity) {
		CategoryEntity result = new CategoryEntity();
		result.setCode(entity.getCode());
		result.setName(entity.getName());
		return result;
	}
}
