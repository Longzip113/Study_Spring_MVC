package com.longnguyen.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.longnguyen.dto.NewDTO;

public interface INewService {
	List<NewDTO> findAll(Pageable pageable);
	int getTotalItem();
	NewDTO findById(Long id);
	NewDTO save(NewDTO dto);
	void delete(Long []ids);
}
