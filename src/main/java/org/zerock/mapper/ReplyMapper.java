package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

public interface ReplyMapper {
	// xml와 연동해서 sql 처리
	public List<ReplyVO> list();
	
	public int insert(ReplyVO vo);
	
	public ReplyVO select(Long rno);
	
	public int update(ReplyVO vo);
	
	public int delete(Long rno);
	
	public List<ReplyVO> getListWithPaging(@Param("cri") Criteria cri, @Param("bno") Long bno);
}
