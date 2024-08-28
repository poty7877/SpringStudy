package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyPageDTO;
import org.zerock.domain.ReplyVO;
import org.zerock.mapper.ReplyMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service // Spring에서 서비스 담당을 찾아줌
public class ReplyServiceImpl implements ReplyService { // ReplyService의 구현 클래스
	
	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;

	@Override
	public int register(ReplyVO replyVO) {
		log.info("ReplyServiceImpl.register() 메서드 실행" + replyVO);
		return mapper.insert(replyVO);
	}

	@Override
	public ReplyVO get(Long rno) {
		log.info("ReplyServiceImpl.get() 메서드 실행" + rno);
		return mapper.read(rno);
	}

	@Override
	public int modify(ReplyVO replyVO) {
		log.info("ReplyServiceImpl.modify() 메서드 실행" + replyVO);
		return mapper.update(replyVO);
	}

	@Override
	public int remove(Long rno) {
		log.info("ReplyServiceImpl.delete() 메서드 실행" + rno);
		return mapper.delete(rno);
	}

	@Override
	public List<ReplyVO> getList(Criteria cri, Long bno) {
		log.info("ReplyServiceImpl.getList() 메서드 실행" + cri + bno);
		return mapper.getListWithPaging(cri, bno);
	}

	@Override
	public ReplyPageDTO getListPage(Criteria cri, Long bno) {
		// TODO Auto-generated method stub
		return new ReplyPageDTO(mapper.getCountByBno(bno), mapper.getListWithPaging(cri, bno));
	}

}
