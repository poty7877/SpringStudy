package com.ysy.www;

import java.text.SimpleDateFormat;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ysy.domain.TodoDTO;

import lombok.extern.log4j.Log4j2;

@RequestMapping("/todo/*")
@Log4j2
@Controller
public class TodoController { 
	
	
	/*
	 * @InitBinder public void initBinder(WebDataBinder binder) { SimpleDateFormat
	 * simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
	 * binder.registerCustomEditor(java.util.Date.class, new
	 * CustomDateEditor(simpleDateFormat, false)); }
	 */
	
	@GetMapping("/ex03") // http://localhost:80/todo/ex03?title=test&dueDate=2024/08/15
	public String ex03(TodoDTO todoDTO) {
		
		log.info("todo : " + todoDTO);
		
		return "ex03";
	}

}
