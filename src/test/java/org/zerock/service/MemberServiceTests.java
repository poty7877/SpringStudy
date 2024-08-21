package org.zerock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.MemberVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class)
@Log4j2
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MemberServiceTests {

	@Setter(onMethod_ = @Autowired)
	private MemberService service;
	
	@Test
	public void testGetList() {
		service.getList().forEach(memberVO -> log.info(memberVO));
	}
	
	@Test
	public void testGet() {
		
		log.info(service.get(3L));
	}
	
	@Test
	public void testJoin() {
		MemberVO memberVO = new MemberVO();
		memberVO.setName("서비스 이름");
		memberVO.setEmail("서비스 이메일");
		memberVO.setId("서비스 아이디");
		memberVO.setPw("서비스 비밀번호");
		service.join(memberVO);
		
		log.info(memberVO);
	}
	
	@Test
	public void testModify() {
		MemberVO memberVO = new MemberVO();
		memberVO.setMno(1L);
		memberVO.setName("서비스 수정");
		memberVO.setEmail("서비스 수정메일");
		memberVO.setId("서비스 수정아이디");
		memberVO.setPw("서비수 수정비번");
		service.update(memberVO);
		
		log.info(memberVO);
	}
	
	@Test
	public void testDelete() {
		service.delete(5L);
	}
	
	
}
