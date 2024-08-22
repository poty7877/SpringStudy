package org.zerock.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml", // mybatis, service 담당
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" }) // Controller 담당 프론트영역 테스트용
@Log4j2
// ------------------------------------------------ 위 3개는 테스트 공용필수

@WebAppConfiguration // 프론트영역 테스트용
public class BoardControllerTests {

	@Setter(onMethod_ = @Autowired)
	private WebApplicationContext ctx; // 톰캣 대타

	private MockMvc mockMvc; // 크롬 대타

	@Before // import org.junit.Before; 구동전에 선행 해야되는 코드 작성
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}

	@Test // url, 결과를 처리해주는 테스트
	public void testList() throws Exception {

		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/list")) // url
//				Mapped "{[/board/list],methods=[GET]}" onto public void org.zerock.controller.BoardController.list(org.springframework.ui.Model)
				.andReturn() // 결과
				.getModelAndView() // model에서 view까지 (스프링에서 관리하는 model영역 , 프론트에서 관리하는 View 영역)
				.getModelMap()); // 표형식
	}

	@Test
	public void testRegister() throws Exception {
		
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
				.param("title", "컨트롤러 테스트 제목")
				.param("content", "컨트롤러 테스트 내용")
				.param("writer", "컨트롤러 테스터"))
				.andReturn()
				.getModelAndView()
				.getViewName(); // return 값을 받아서 String으로 처리
		log.info("결과 url : " + resultPage);
				
	}
	
	@Test // bno가 넘어가면 돌아오는 값은 객체
	public void testGet() throws Exception {
		
		// http://localhost:80/board/get?bno=4
		log.info("결과 : " +  // 결과 : {board=BoardVO(bno=4, title=test 제목3, content=test 내용3, writer=user03, regdate=Tue Aug 20 17:31:08 KST 2024, updateDate=Tue Aug 20 17:31:08 KST 2024)
				mockMvc.perform(MockMvcRequestBuilders.get("/board/get")
				.param("bno", "4"))
				.andReturn()
				.getModelAndView()
				.getModelMap()); // select의 결과는 getModelMap
								 // int, boolean, string의 결과는 getViewName
	
	}
	
	@Test //
	public void testModify() throws Exception {
	String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
			.param("bno", "6")
			.param("title", "컨트롤러 수정 테스트 제목")
			.param("content", "컨트롤러 수정 테스트 내용")
			.param("writer", "컨트롤러 수정 사용자"))
			.andReturn()
			.getModelAndView()
			.getViewName();
	}
	
	@Test
	public void testRemove() throws Exception {
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/remove")
				.param("bno", "42"))
				.andReturn()
				.getModelAndView()
				.getViewName();
		
		log.info("결과 url : " + resultPage);
		
		
	}
}
