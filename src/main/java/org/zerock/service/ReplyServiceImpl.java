package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;
import org.zerock.mapper.ReplyMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ReplyServiceImpl implements ReplyService {
	
	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;
	
	@Override
	public int register(ReplyVO vo) {
		
		return mapper.insert(vo);
	}

	@Override
	public ReplyVO get(Long rno) {
		// TODO Auto-generated method stub
		return mapper.select(rno);
	}

	@Override
	public int modify(ReplyVO vo) {
		// TODO Auto-generated method stub
		return mapper.update(vo);
	}

	@Override
	public int remove(Long rno) {
		// TODO Auto-generated method stub
		return mapper.delete(rno);
	}

	@Override
	public List<ReplyVO> getList(Criteria cri, Long bno) {
		// TODO Auto-generated method stub
		return mapper.getListWithPaging(cri, bno);
	}

}
