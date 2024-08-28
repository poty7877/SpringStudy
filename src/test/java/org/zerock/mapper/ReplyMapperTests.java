package org.zerock.mapper;

import java.util.List;

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
		// INFO org.zerock.mapper.ReplyMapperTests(testMapper30) -
		// org.apache.ibatis.binding.MapperProxy@148c7c4b
	}

	@Test
	public void testCreate() {
		ReplyVO replyVO = new ReplyVO();
		replyVO.setBno(11L);
		replyVO.setReply("매퍼 댓글 테스트");
		replyVO.setReplyer("매퍼 kkw");
		log.info(mapper.insert(replyVO) + "개 댓글 작성 완료");
	}

	@Test
	public void testRead() {
		Long targetRno = 10L;
		ReplyVO replyVO = mapper.read(targetRno);
		log.info(replyVO);
	}

	@Test
	public void testUpdate() {
		Long targetRno = 10L;
		ReplyVO replyVO = mapper.read(targetRno);
		replyVO.setReply("매퍼로 수정 테스트");
		int count = mapper.update(replyVO);
		log.info(count + "개의 댓글 수정 완료");
		log.info(replyVO);
	}

	@Test
	public void testDelete() {
		Long targetRno = 11L;
		log.info(mapper.delete(targetRno) + "개의 댓글 삭제 완료");
	}

	@Test
	public void testGetList() {

		mapper.getList().forEach(replyVO -> log.info(replyVO));
	}

	@Test
	public void testGetListWithPaging() {
		Long targetBno = 10L;
		Criteria cri = new Criteria();
		log.info("Criteria : " + cri);

		List<ReplyVO> replies = mapper.getListWithPaging(cri, targetBno);
		
		replies.forEach(replyVO -> log.info(replyVO));
	}

}
