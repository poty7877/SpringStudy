package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller // 스프링이 컨트롤러 역할을 제공
@Log4j2
@RequestMapping("/board/*") // http://localhost:80/board/
@AllArgsConstructor // 모든 필드를 사용하는 생성자 만듬
public class BoardController {

	// 필드
	private BoardService service;
	// public BoardController(BoardService){}

	@GetMapping("/list") // http://localhost:80/board/list
	public void list(Model model) { // 스프링이 관리하는 메모리

		log.info("BoardController.list() 실행");
		model.addAttribute("list", service.getList()); // name : list, Ojbect : List<BoardVO>

	}

	@GetMapping("/register") // http://localhost:80/board/register
	public void register() {
		log.info("BoardController.register().get메서드 실행");

		// 리턴이 void -> url과 같은 jsp를 찾음 http://localhost:80/board/register.jsp

	}

	@PostMapping("/register") // http://localhost:80/board/register
	public String register(BoardVO boardVO, RedirectAttributes rttr) {
		// RedirectAttributes rttr -> 일회성의 값을 제공 (addFlashAtrribute("name", value));
		log.info("BoardController.register().post메서드 실행");
		service.register(boardVO); // 프론트에서 form 값이 객체로 넘어옴
		rttr.addFlashAttribute("result", boardVO.getBno()); // 객체에 있는 bno 값을 1회성으로 가지고있음(model영역)

		return "redirect:/board/list"; // = response.sendRedirect()
		// 등록후에는 리스트 페이지로보냄 http://localhost:80/board/list
	}

	@GetMapping({"/get", "/modify"}) // 이중화 작업 
	// http://localhost:80/board/get -> board/get.jsp
	// http://localhost:80/board/modify -> board/modify.jsp
	public void get(@RequestParam("bno") Long bno, Model model) {
		log.info("BoardController.get() 실행");
		model.addAttribute("board", service.get(bno));
		// 서비스 계층에 get메서드에 bno 값을 넣어주면 객체 (Sql처리후)가 나옴
	}

	@PostMapping("/modify") // http://localhost:80/board/modify
	public String modify(BoardVO boardVO, RedirectAttributes rttr) {
		log.info("BoardController.modify() 실행");

		if (service.modify(boardVO)) { // service.modify(boardVO)의 리턴타입이 boolean,
			rttr.addFlashAttribute("result", "success"); // 수정 성공시 success 메세지를 보냄
		} else {
			rttr.addFlashAttribute("result", "fail"); // 수정 실패시 fail 메세지를 보냄
		}

		return "redirect:/board/list"; // http://localhost:80/board/list로 이동

	}

	@PostMapping("/remove") // http://localhost:80/board/remove
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) { // 번호를 받아 delete 쿼리를 실행
		log.info("BoardController.remove() 실행");
		if (service.remove(bno)) { // service.modify(boardVO)의 리턴타입이 boolean,
			rttr.addFlashAttribute("result", "success"); // 수정 성공시 success 메세지를 보냄
		} else {
			rttr.addFlashAttribute("result", "fail"); // 수정 실패시 fail 메세지를 보냄
		}

		return "redirect:/board/list";
	}
}
