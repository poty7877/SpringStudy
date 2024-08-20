package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2 // 로그 출력용
@AllArgsConstructor // 모든 매개값을 이영해서 자동으로기본 생성자
@Service // 스프링에 서비스를 담당한다. / 비즈니스 로직 영역을 담당
			// root-context.xml에 context항목 추가
public class BoardServiceImpl implements BoardService {

	private BoardMapper mapper; // 필드 생성

	@Override
	public void register(BoardVO boardVO) {
		// board 객체가 넘어온 값을 db에 insert 처리함
		log.info("BoardServiceImpl.register 메서드 실행");
		mapper.insertSelectKey(boardVO); // 자동번호를 먼저 생성하고 insert 처리함
	}

	@Override
	public BoardVO get(Long bno) {
		// bno를 이용해서 mapper에 select 조건으로 검색한다.
		log.info("BoardServiceImpl.get 메서드 실행");

		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO boardVO) {
		// 게시물 수정을 담당한다.
		log.info("BoardServiceImpl.modify 메서드 실행");
		return mapper.update(boardVO) == 1;
	}

	@Override
	public boolean remove(Long bno) {
		// bno를 이용해서 삭제한다.
		log.info("BoardServiceImpl.remove 메서드 실행");

		return mapper.delete(bno) == 1;
	}

	@Override
	public List<BoardVO> getList() {
		// Board테이블의 모든 값을 리스트로 출력
		log.info("BoardServiceImpl.getList() 메서드 실행");

		return mapper.getList();
	}

}
