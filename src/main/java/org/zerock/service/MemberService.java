package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.MemberVO;


public interface MemberService {

	// 멤버 등록
	public void join(MemberVO memberVO);
	
	// 멤버 조회
	public MemberVO get(Long mno);
	
	// 멤버 리스트
	public List<MemberVO> getList();
	
	// 멤버 수정
	public boolean update(MemberVO memberVO);
	
	// 멤버 삭제
	public boolean delete(Long mno);

	
	
	
}
