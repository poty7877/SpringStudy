package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.MemberVO;
import org.zerock.mapper.MemberMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {

	private MemberMapper mapper;
	
	@Override
	public void join(MemberVO memberVO) {
		log.info("MemberServiceImpl.join() 실행");
		mapper.insert(memberVO);
	}

	@Override
	public MemberVO get(Long mno) {
		log.info("MemberServiceImpl.get() 실행");
		
		return mapper.get(mno);
	}

	@Override
	public List<MemberVO> getList() {
		log.info("MemberServiceImpl.getList() 실행");
		return mapper.getList();
	}

	@Override
	public boolean update(MemberVO memberVO) {
		log.info("MemberServiceImpl.update() 실행");
		return mapper.update(memberVO) == 1;
	}

	@Override
	public boolean delete(Long mno) {
		log.info("MemberServiceImpl.delete() 실행");
		return mapper.delete(mno) == 1;
	}

}
