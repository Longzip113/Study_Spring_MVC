package com.longnguyen.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.longnguyen.converter.NewConverter;
import com.longnguyen.dto.NewDTO;
import com.longnguyen.entity.CategoryEntity;
import com.longnguyen.entity.NewEntity;
import com.longnguyen.repository.ICategoryRepository;
import com.longnguyen.repository.INewRepository;
import com.longnguyen.service.INewService;

@Service
public class NewService implements INewService {

//	@Autowired
//	private INewDAO newDAO;
	
	@Autowired
	private INewRepository newRepository;
	
	@Autowired
	private NewConverter newConverter;
	
	@Autowired
	private ICategoryRepository categoryRepository;

	@Override
	public List<NewDTO> findAll(Pageable pageable) {
		List<NewEntity> NewEntity = newRepository.findAll(pageable).getContent();
		List<NewDTO> models = new ArrayList<NewDTO>();
		for (NewEntity item : NewEntity) {
			NewDTO model = newConverter.toDTO(item);
			models.add(model);
		}
		return models;
	}

	@Override
	public int getTotalItem() {
		return (int)newRepository.count();
	}

	@Override
	public NewDTO findById(Long id) {
		NewEntity entity = newRepository.findOne(id);
		
		return newConverter.toDTO(entity);
	}
	
	@Override
	@Transactional // Commit rollback spring làm
	public NewDTO save(NewDTO dto) {
		CategoryEntity category = categoryRepository.findOneByCode(dto.getCategoryCode());
		NewEntity newEntity = new NewEntity();
		if(dto.getId() != null) { // updata
			NewEntity oldNew = newRepository.findOne(dto.getId());
			oldNew.setCategoryEntity(category);
			newEntity = newConverter.toEntity(oldNew, dto);
		} else { // save new
			newEntity = newConverter.toEntity(dto);
			newEntity.setCategoryEntity(category);
		}
			
		return newConverter.toDTO(newRepository.save(newEntity));
	}

	@Override
	@Transactional // Commit rollback spring làm
	public void delete(Long []ids) {
		for (Long id : ids) {
			newRepository.delete(id);
		}
	}
	
	
}
