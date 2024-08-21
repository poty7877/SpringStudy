package org.zerock.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j2
public class BoardServiceTests {

	@Setter(onMethod_ = @Autowired)
	private BoardService service;

	@Test
	public void testExist() {
		log.info(service);
		assertNotNull(service);

	}

	@Test
	public void testRegister() {
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("service 제목");
		boardVO.setContent("service 내용");
		boardVO.setWriter("서비스");

		service.register(boardVO);

		log.info(boardVO);
	}
	@Test
	public void testGet() {
		service.get(1L);
	}
	@Test
	public void testGetList() {
		service.getList().forEach(boardVO -> log.info(boardVO));
	}
	@Test
	public void testModify() {
		BoardVO boardVO = service.get(5L);
		
		if(boardVO == null) {
			return;
		}
		
		boardVO.setTitle("수정된 제목");
		boardVO.setContent("수정된 내용");
		boardVO.setWriter("수정된 작성자");
		
		service.modify(boardVO);
		
		log.info(boardVO);
	}
	
	@Test
	public void testRemove() {
		
		service.remove(2L);
	}

}
