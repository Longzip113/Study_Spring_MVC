package com.longnguyen.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.longnguyen.entity.CategoryEntity;
import com.longnguyen.repository.ICategoryRepository;
import com.longnguyen.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService{
	
	@Autowired
	private ICategoryRepository categoryRepository;


	@Override
	public Map<String,String> findAll() {
		Map<String,String> result = new HashMap<String, String>();
		List<CategoryEntity> entities = categoryRepository.findAll();
		for (CategoryEntity item : entities) {
			result.put(item.getCode(), item.getName());
		}
		return result;
	}

}
