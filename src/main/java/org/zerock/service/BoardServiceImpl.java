package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

	private BoardMapper mapper;

	@Override
	public void register(BoardVO boardVO) {
		log.info("BoardServiceImpl.register 메서드 실행");
		mapper.insertSelectKey(boardVO);

	}

	@Override
	public BoardVO get(Long bno) {
		log.info("BoardServiceImpl.get 메서드 실행");

		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO boardVO) {
		log.info("BoardServiceImpl.modify 메서드 실행");
		
		return mapper.update(boardVO) == 1;
	}

	@Override
	public boolean remove(Long bno) {
		log.info("BoardServiceImpl.remove메서드 실행");
		return mapper.delete(bno) == 1;
	}

	@Override
	public List<BoardVO> getList() {
		log.info("BoardServiceImpl.getList 메서드 실행");
		
		return mapper.getList();
	}

}
