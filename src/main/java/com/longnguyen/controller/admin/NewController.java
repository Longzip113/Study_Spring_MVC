package com.longnguyen.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.longnguyen.dto.NewDTO;
import com.longnguyen.service.ICategoryService;
import com.longnguyen.service.INewService;
import com.longnguyen.util.MessageUtil;

@Controller(value = "newControllerOfAdmin")
public class NewController {
	@Autowired
	private INewService newService;
	
	@Autowired
	private ICategoryService categoryService;
	
	@Autowired
	private MessageUtil messageUtil;
	

	@RequestMapping(value = "/quan-tri/bai-viet/danh-sach", method = RequestMethod.GET)
	public ModelAndView showList(@RequestParam("page") int page, @RequestParam("limit") int limit, HttpServletRequest req) {
		NewDTO model = new NewDTO();
		model.setPage(page);
		model.setLimit(limit);
		Pageable pageable = new PageRequest(page - 1, limit);
		ModelAndView mav = new ModelAndView("admin/new/list");
		if(req.getParameter("message") != null) {
//			if(req.getParameter("message").equals("updata_success")) {
//				mav.addObject("message", "Updata success");
//				mav.addObject("alert", "success");
//			}else if (req.getParameter("message").equals("insert_success")) {
//				mav.addObject("message", "Insert success");
//				mav.addObject("alert", "success");
//			}else if (req.getParameter("message").equals("error_system")) {
//				mav.addObject("message", "Error success");
//				mav.addObject("alert", "danger");
//			}
			Map<String, String> message = messageUtil.getMessage(req.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		model.setListResult(newService.findAll(pageable));

		model.setTotalItem(newService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));

		mav.addObject("model", model);
		return mav;
	}

	@RequestMapping(value = "/quan-tri/bai-viet/chinh-sua", method = RequestMethod.GET)
	//Thêm  required = false khi có parm id thì lấy không có thì không lấy nếu không có sẽ lỗi exceptionNULL
	public ModelAndView editNew(@RequestParam( value = "id", required = false) Long id, HttpServletRequest req) {
		ModelAndView mav = new ModelAndView("admin/new/edit");
		NewDTO model = new NewDTO();
		if (id != null) {
			model = newService.findById(id);
		}
		if(req.getParameter("message") != null) {
//			if(req.getParameter("message").equals("updata_success")) {
//				mav.addObject("message", "Updata success");
//				mav.addObject("alert", "success");
//			}else if (req.getParameter("message").equals("insert_success")) {
//				mav.addObject("message", "Insert success");
//				mav.addObject("alert", "success");
//			}else if (req.getParameter("message").equals("error_system")) {
//				mav.addObject("message", "Error success");
//				mav.addObject("alert", "danger");
//			}
			Map<String, String> message = messageUtil.getMessage(req.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("categoryModel", categoryService.findAll());
		mav.addObject("model", model);
		return mav;
	}
}
