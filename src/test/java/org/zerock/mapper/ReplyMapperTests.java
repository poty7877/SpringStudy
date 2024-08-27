package org.zerock.mapper;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
// Java Config
// @ContextConfiguration(classes = {org.zerock.config.RootConfig.class} )
@Log4j2
public class ReplyMapperTests {

	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;

	@Test
	public void testMapper() {

		log.info(mapper);
	}

	@Test
	public void testInsert() {

		ReplyVO vo = new ReplyVO();

		vo.setBno(11L);
		vo.setReply("댓글 테스트");
		vo.setReplyer("댓글 테스트");
		mapper.insert(vo);

		log.info(vo);
	}

	@Test
	public void testSelect() {
		Long targetRno = 20L;
		ReplyVO vo = mapper.select(targetRno);
		log.info(vo);
	}

	@Test
	public void testDelete() {
		Long targetRno = 20L;
		mapper.delete(targetRno);
	}

	@Test
	public void testUpdate() {
		ReplyVO vo = mapper.select(21L);
		vo.setReply("매퍼 수정 테스트");
		mapper.update(vo);

	}

	@Test
	public void testList() {
		Criteria cri = new Criteria();
		
		mapper.getListWithPaging(cri, 11L).forEach(vo -> log.info(vo));
	}
	
	

}
