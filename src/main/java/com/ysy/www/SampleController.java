package com.ysy.www;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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

	@GetMapping("/ex04") // http://localhost:80/sample/ex04?name=kkw&age=30&page=3
	public String ex04(SampleDTO sampleDTO, @ModelAttribute("page") int page) {
		log.info("dto : " + sampleDTO);
		log.info("page : " + page);

		return "/sample/ex04";
	}

	@GetMapping("/ex05") // http://localhost:80/sample/ex05
	public void ex05() {
		log.info("/ex05 메서드 실행");
	}

	@GetMapping("/ex06") // http://localhost:80/sample/ex06
	public @ResponseBody SampleDTO ex06() {
		log.info("/ex06 매서드 실행"); //{"name":"용상엽","age":30}
		SampleDTO sampleDTO = new SampleDTO();
		sampleDTO.setAge(30);
		sampleDTO.setName("용상엽");

		return sampleDTO;

	}

	@GetMapping("/ex07") // http://localhost:80/sample/ex07
	public ResponseEntity<String> ex07() {
		log.info("/ex07 메서드 실행");
		String msg = "{\"name\":\"용상엽\",\"age\":30}";

		HttpHeaders header = new HttpHeaders();
		header.add("Content-type", "application/json;charset=UTF-8");

		return new ResponseEntity<String>(msg, header, HttpStatus.OK);
	}
	
	@GetMapping("/exUpload") // http://localhost:80/sample/exUpload
	public void exUpload() {
		log.info("/exUpload 메서드 실행");
	}
	
	@PostMapping("/exUploadPost") // http://localhost:80/sample/exUploadPost
	public void exUploadPost(ArrayList<MultipartFile> files) {
		
		files.forEach( file -> {
			log.info("-------------------");
			log.info("name : " + file.getOriginalFilename()); // 파일 원본이름
			log.info("size : " + file.getSize()); // 파일용량크기
			log.info("toString : " + file.toString()); // toString 메서드
		}
				
				
				
				);
		
		
		
	}
}
