package org.zerock.mapper;

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
public class BoardMapperTests {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;

	@Test
	public void testGetList() {
		mapper.getList().forEach(boardVO -> log.info(boardVO));
	}

	@Test
	public void testInsert() {
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("매퍼로 만든 제목");
		boardVO.setContent("매퍼로 만든 내용");
		boardVO.setWriter("매퍼 사용자");
		mapper.insert(boardVO);

		log.info(boardVO);
	}

	@Test
	public void testInsertSelectKey() {
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("셀렉트 키 제목");
		boardVO.setContent("셀렉트 키 내용");
		boardVO.setWriter("셀렉트 키");
		mapper.insertSelectKey(boardVO);

		log.info(boardVO);
	}

	@Test
	public void testRead() {
		BoardVO boardVO = mapper.read(5L);

		log.info(boardVO);
	}
	
	@Test
	public void testUpdate() {
		BoardVO boardVO = new BoardVO();
		boardVO.setBno(3L);
		boardVO.setTitle("수정된 제목");
		boardVO.setContent("수정된 내용");
		boardVO.setWriter("수정한 사람");
		
		mapper.update(boardVO);
		
		log.info(boardVO);
	}
	
	@Test
	public void testDelete() {
		
		
		log.info("삭제된 객체 수  : " + mapper.delete(4L));
	}

}
