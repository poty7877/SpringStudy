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
	private BoardService service; // setService(BoardService)

	@Test
	public void testExist() {
		// 객체 생성 유무 판단용 테스트
		log.info(service);
		// 인터페이스를 필드로 생성 하고, 서비스를 객체를 실행하면 impl이 붙은 class가 실행이 된다.
		assertNotNull(service); // service가 null 값이어도 그냥 진행
	}

	@Test
	public void testRegister() {
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("서비스로 만든 제목");
		boardVO.setContent("서비스로 만든 내용");
		boardVO.setWriter("서비스 작성자");

		service.register(boardVO);

		log.info("등록된 게시물의 번호 : " + boardVO.getBno());
	}

	@Test
	public void testGet() {
		log.info(service.get(3L));
	}

	@Test
	public void testGetList() {
		service.getList().forEach(boardVO -> log.info(boardVO));
	}

	@Test
	public void testModify() {
		BoardVO boardVO = service.get(1L);
		if (boardVO == null) {
			log.info("찾는 객체가 없습니다.");
			return;
		}
		boardVO.setTitle("서비스에서 수정한 제목");
		log.info("서비스에서 수정메서드 결과  : " + service.modify(boardVO)); // boolean
	}

	@Test
	public void testDelete() {

		log.info("삭제된결과 : " + service.remove(3L));
	}

}
