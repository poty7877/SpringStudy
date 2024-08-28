package org.zerock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyPageDTO;
import org.zerock.domain.ReplyVO;
import org.zerock.service.BoardService;
import org.zerock.service.ReplyService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController // Rest방식으로 응답 함 -> view 대신 json, xml로 나옴
@Log4j2
@AllArgsConstructor // new ReplyController(ReplyService, BoardService);
@RequestMapping("/replies/*") // http://localhost:80/replies
public class ReplyController { // REST 방식의 컨트롤러로 구현 + ajax 처리함

	// private BoardService bService;
	private ReplyService service;

	// http://localhost:80/replies/new (json으로 입력 되면 객체로 저장됨)
	@PostMapping(value = "/new", consumes = "application/json", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> create(@RequestBody ReplyVO replyVO) {
		// 리턴은 200 이나 500 으로 처리됨
		log.info("ReplyVO 객체 json 입력 값 : " + replyVO); // 파라미터로 입력값 처리

		int insertCount = service.register(replyVO); // sql 처리후 결과값이 1 또는 0으로 나옴

		log.info("Service + Mapper 처리 결과 : " + insertCount);

		return insertCount == 1 ? new ResponseEntity<>("success", HttpStatus.OK)// 200 정상
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // 500 서버오류
		// 삼항 연산자나 if 로 리턴을 할때 정상 처리인지 오류 값인지를 전달 해야 한다.
		// 삼항 연산자 x == y ?(조건) a(참) : b(거짓)
	}

	// http://localhost:80/replies/pages/11/1 -> xml
	// http://localhost:80/replies/pages/11/1.json -> json
	@GetMapping(value = "/pages/{bno}/{page}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<ReplyPageDTO> getList(@PathVariable("page") int page, @PathVariable("bno") Long bno) {
		log.info("ReplyController.getList() 메서드 실행");
		log.info("페이지 번호 : " + page);
		log.info("찾을 번호 : " + bno);
		Criteria cri = new Criteria(page, 10); // 현재 페이지와 리스트 개수를 전달
		log.info("Criteria : " + cri);

		return new ResponseEntity<>(service.getListPage(cri, bno), HttpStatus.OK); // 200 정상
		// [{"rno":1,"bno":11,"reply":"댓글11","replyer":"kkw","replyDate":1724723544000,"updateDate":1724723544000},
		// {"rno":7,"bno":11,"reply":"댓글11","replyer":"kkw","replyDate":1724723558000,"updateDate":1724723558000},
		// {"rno":10,"bno":11,"reply":"매퍼로 수정
		// 테스트","replyer":"kkw","replyDate":1724723568000,"updateDate":1724728040000},
		// {"rno":13,"bno":11,"reply":"댓글11","replyer":"kkw","replyDate":1724723575000,"updateDate":1724723575000},
		// {"rno":22,"bno":11,"reply":"매퍼 댓글 테스트","replyer":"매퍼
		// kkw","replyDate":1724724692000,"updateDate":1724724692000}]
	}

	// http://localhost:80/replies/4
	@GetMapping(value = "/{rno}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<ReplyVO> get(@PathVariable("rno") Long rno) {
		log.info("ReplyController.get() 메서드 실행\t\n" + "찾을 rno : " + rno);

		return new ResponseEntity<ReplyVO>(service.get(rno), HttpStatus.OK);
	}

	@DeleteMapping(value = "/{rno}", produces = MediaType.TEXT_PLAIN_VALUE) // json으로 나올 필요 없음
	public ResponseEntity<String> remove(@PathVariable("rno") Long rno) {
		log.info("ReplyController.get() 메서드 실행\t\n" + "삭제할 rno : " + rno);
		return service.remove(rno) == 1 ? new ResponseEntity<>("success", HttpStatus.OK) // 200 정상
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // 500 서버 오류
	}

	// RequestMethod.PUT -> @PutMapping : 객체 전체 필드를 수정. 값을 입력하지않으면 null 값으로 저장
	// RequestMethod.PATCH -> @PatchMapping : 객체 일부필드(부분) 수정한다.
	@RequestMapping(method = { RequestMethod.PUT,
			RequestMethod.PATCH }, value = "/{rno}", consumes = "application/json", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> modify(@RequestBody ReplyVO replyVO, @PathVariable("rno") Long rno) {
		// 이미 프론트(폼) 에 있는 값 수정할 번호
		replyVO.setRno(rno); // 이미 가지고있는 객체에 rno값을 넣음

		log.info("ReplyController.get() 메서드 실행\n" + "\t수정할 rno : " + rno);

		log.info("수정할 객체 : " + replyVO);

		return service.modify(replyVO) == 1 ? new ResponseEntity<>("success", HttpStatus.OK) // 200 정상
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // 500 서버 오류
	}
	
	
}
