package org.zerock.mapper;

import java.util.List;import org.zerock.domain.BoardVO;
import org.zerock.domain.MemberVO;

public interface MemberMapper {
	
	public List<MemberVO> getList(); // 멤버 전체 리스트 출력
	
	public void insert(MemberVO memberVO); // 멤버 삽입
	
	public void insertSelectKey(MemberVO memberVO); // 번호 만들고 멤버 삽입
	
	public MemberVO get(Long mno); // 멤버 1개 출력
	
	public int update(MemberVO memberVO); // 멤버 정보 수정
	
	public int delete(Long mno); // 멤버 삭제

}
