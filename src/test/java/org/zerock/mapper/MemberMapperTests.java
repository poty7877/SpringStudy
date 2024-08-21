package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.MemberVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j2
public class MemberMapperTests {

	@Setter(onMethod_ = @Autowired)
	private MemberMapper mapper;

	@Test
	public void testGetList() {
		mapper.getList().forEach(memberVO -> log.info(memberVO));
	}

	@Test
	public void testGet() {
		mapper.get(3L);
	}

	@Test
	public void testInsert() {
		MemberVO memberVO = new MemberVO();
		memberVO.setName("매퍼 이름");
		memberVO.setEmail("매퍼 이메일");
		memberVO.setId("매퍼 아이디");
		memberVO.setPw("매퍼 비밀번호");
		mapper.insert(memberVO);

	}

	@Test
	public void testInsertSelectKey() {
		MemberVO memberVO = new MemberVO();
		memberVO.setName("매퍼 이름2");
		memberVO.setEmail("매퍼 이메일2");
		memberVO.setId("매퍼 아이디2");
		memberVO.setPw("매퍼 비밀번호2");
		mapper.insertSelectKey(memberVO);

		log.info(memberVO);
	}

	@Test
	public void testUpdate() {
		MemberVO memberVO = new MemberVO();
		memberVO.setMno(3L);
		memberVO.setName("수정 이름");
		memberVO.setEmail("수정 이메일");
		memberVO.setId("수정 아이디");
		memberVO.setPw("수정 비밀번호");
		log.info(memberVO);
		mapper.update(memberVO);

	}
	@Test
	public void testDelete() {
		
		log.info("삭제된 객체 수 : " + mapper.delete(4L));
	}

}
