package com.longnguyen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.longnguyen.dao.INewDAO;
import com.longnguyen.model.NewModel;
import com.longnguyen.service.INewService;

@Service
public class NewService implements INewService {

	@Autowired
	private INewDAO newDAO;

	@Override
	public List<NewModel> findAll() {
		return newDAO.findAll();
	}
}
