package com.ysy.www;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ysy.domain.SampleDTO;
import com.ysy.domain.SampleDTOList;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/sample/")
@Log4j2
public class SampleController {

	@RequestMapping("") // http://localhost:80/sample/
	public void basic() {
		log.info("SampleController.basic() 실행");
	}

	@GetMapping("/basicOnlyGet") // http://localhost:80/sample/basicOnlyGet
	public void basicGet2() {

		log.info("SampleController.basicOnlyGet() 실행");
	}

	@GetMapping("/ex01") // http://localhost:80/sample/ex01?name=kkw&age=30
	public String ex01(SampleDTO sampleDTO) {

		log.info(sampleDTO);

		return "ex01";
	}

	@GetMapping("/ex02") // http://localhost:80/sample/ex02?id=ysy&age=29
	public String ex02(@RequestParam("id") String name, @RequestParam("age") int age) {

		log.info("name : " + name);
		log.info("age : " + age);
		return "ex02";
	}

	@GetMapping("/ex02List") // http://localhost:80/sample/ex02List?ids=111&ids=222&ids=333
	public String ex02List(@RequestParam("ids") ArrayList<String> ids) {

		log.info("ids : " + ids);

		return "ex02List";
	}
	
	@GetMapping("/ex02Array") // http://localhost:80/sample/ex02Array?ids=111&ids=222&ids=333
	public String ex02Array(@RequestParam("ids") String[] ids) {
		
		log.info("array ids : " + Arrays.toString(ids));
		return "ex02Array";
	}
	
	@GetMapping("/ex02Bean") // http://localhost:80/sample/ex02Bean?list%5B0%5D.name%3Dkkw%26list%5B0%5D.age%3D30
	public String ex02Bean(SampleDTOList list) {
		
		log.info("list dtos : " + list);
		return "ex02Bean";
	}
}
