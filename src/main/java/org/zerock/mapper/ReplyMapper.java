package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

public interface ReplyMapper {
	// xml와 연동해서 sql 처리
	// 추상 메서드가 필요하다

	public int insert(ReplyVO replyVO); // 외부에서 폼으로 VO객체가 넘어옴, 리턴은 int

	public ReplyVO read(Long rno); // 댓글의 번호를 가지고 댓글(객체)을 가져옴, 리턴은 ReplyVO 객체

	public int update(ReplyVO replyVO); // 객체가 넘어가서 수정됨, 리턴은 int

	public int delete(Long rno); // 댓글의 번호를 가지고 댓글을 삭제, 리턴은 int

	public List<ReplyVO> getList(); // 댓글 전체리스트

	// 댓글 전체리스트 : 페이징처리 + bno(pk+fk)
	// 여러개의 파라미터인 경우 @Param()을 사용한다
	public List<ReplyVO> getListWithPaging(@Param("cri") Criteria cri, @Param("bno") Long bno);
											//페이징 처리 기준점,				게시물 번호 pk+fk
	public int getCountByBno(Long bno);
	
}
