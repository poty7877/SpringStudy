package org.zerock.mapper;

import java.util.List;


import org.zerock.domain.BoardVO;

public interface BoardMapper {
	public List<BoardVO> getList();
	
	// 객체 삽입
	public void insert(BoardVO boardVO);
	
	// 번호를 미리 만들고 객체 삽입.
	public void insertSelectKey(BoardVO boardVO);
	
	// 번호를 이용해서 객체 불러오기
	public BoardVO read(Long bno);
	
	// 객체 수정하기
	public int update(BoardVO boardVO);
	
	// 객체 삭제하기
	public int delete(Long bno);
	
	
}
