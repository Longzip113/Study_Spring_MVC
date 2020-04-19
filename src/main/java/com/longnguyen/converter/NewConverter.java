package com.longnguyen.converter;

import org.springframework.stereotype.Component;

import com.longnguyen.dto.NewDTO;
import com.longnguyen.entity.NewEntity;

@Component
public class NewConverter {

	public NewDTO toDTO(NewEntity entity) {
		NewDTO result = new NewDTO();
		result.setId(entity.getId());
		result.setTitle(entity.getTitle());
		result.setContent(entity.getContent());
		result.setThumbnail(entity.getThumbnail());
		result.setShortDescripTion(entity.getShortDescripTion());
		result.setCategoryId(entity.getCategoryEntity().getId());
		return result;
	}
	
	public NewEntity toEntity(NewDTO dto) {
		NewEntity result = new NewEntity();
		result.setTitle(dto.getTitle());
		result.setContent(dto.getContent());
		result.setThumbnail(dto.getThumbnail());
		result.setShortDescripTion(dto.getShortDescripTion());
		return result;
	}
	
	public NewEntity toEntity( NewEntity entity, NewDTO dto) {
		entity.setTitle(dto.getTitle());
		entity.setContent(dto.getContent());
		entity.setThumbnail(dto.getThumbnail());
		entity.setShortDescripTion(dto.getShortDescripTion());
		return entity;
	}
}
