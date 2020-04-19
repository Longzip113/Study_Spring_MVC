package com.longnguyen.controller.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.longnguyen.dto.NewDTO;
import com.longnguyen.service.INewService;

@RestController(value = "newAPIOfAdmin")
public class NewAPI {
	
	@Autowired
	private INewService newService;
	
	@PostMapping("/api/new") // định nghĩa đây là hàm post
	public NewDTO createNew(@RequestBody NewDTO newDTO) {
		
		return newService.save(newDTO);
	}
	
	@PutMapping("/api/new") // định nghĩa đây là hàm put
	public NewDTO updataNew(@RequestBody NewDTO updataNew) {
		
		return newService.save(updataNew);
	}

	@DeleteMapping("/api/new") // định nghĩa đây là hàm delete
	public void deleteNew(@RequestBody Long []ids) {
		newService.delete(ids);
	}
	
	//hàm lấy data lên controller đảm nhiệm
}
