package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;

public interface BoardService {

	public void register(BoardVO boardVO);
	
	public BoardVO get(Long bno); // 객체 읽기
	
	public boolean modify(BoardVO boardVO); // 수정
	
	public boolean remove(Long bno); // 삭제
	
	public List<BoardVO> getList(); // 전체 읽기
}
