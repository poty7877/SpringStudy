package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.MemberVO;
import org.zerock.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@AllArgsConstructor
@Controller
@RequestMapping("/member/*")
public class MemberController {

	private MemberService service;

	@GetMapping("/list")
	public void list(Model model) {
		model.addAttribute("list", service.getList());
	}

	@PostMapping("/join")
	public String join(MemberVO memberVO, RedirectAttributes rttr) {
		service.join(memberVO);
		rttr.addFlashAttribute("result", memberVO.getMno());
		return "redirect:/member/list";
	}

	@GetMapping("/get")
	public void get(@RequestParam("mno") Long mno, Model model) {
		model.addAttribute("member", service.get(mno));
	}

	@PostMapping("/modify")
	public String modify(MemberVO memberVO, RedirectAttributes rttr) {
		if (service.update(memberVO)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/member/modify";
	}

	@PostMapping("/remove")
	public String remove(@RequestParam("mno") Long mno, RedirectAttributes rttr) {
		if (service.delete(mno)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/member/modify";
	}
}
