package org.zerock.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyPageDTO;
import org.zerock.domain.ReplyVO;

public interface ReplyService {

	public int register(ReplyVO replyVO); // 댓글 등록용 || return = int

	public ReplyVO get(Long rno); // 댓글 상세보기용 || return = ReplyVO

	public int modify(ReplyVO replyVO); // 댓글 수정용 || return = int

	public int remove(Long rno); // 댓글 삭제용 || return = int

	// 댓글 전체리스트 : 페이징처리 + bno(pk+fk)
	public List<ReplyVO> getList(Criteria cri, Long bno);
							  // 페이징 처리 기준점, 게시물 번호 pk+fk
	public ReplyPageDTO getListPage(Criteria cri, Long bno);

}
