package com.longnguyen.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.longnguyen.dao.INewDAO;
import com.longnguyen.mapper.NewMapper;
import com.longnguyen.model.NewModel;

@Repository
public class NewDAO extends AbsTractDAO<NewModel> implements INewDAO {

	
	@Override
	public List<NewModel> findAll() {
		// String sql = "SELECT * FROM news LIMIT ?, ?";
		StringBuilder sql = new StringBuilder("SELECT * FROM news");
		
		return Query(sql.toString(), new NewMapper());
	}


}
