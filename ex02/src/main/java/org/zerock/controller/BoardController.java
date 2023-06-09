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
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {

	private BoardService service;
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("list");
		model.addAttribute("list", service.getList());
	}
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		
		log.info("register : " + board);
		
		service.register(board);
		// flash 속성에 객체를 저장할 수 있음
		// 이는 요청 매개 변수(requestparameters)로 값을 전달하지 않고, 객체로 값을 그대로 전달하게 된다. 그리고 adllFlashAttribute는 일회성으로 한번 사용하면 Redirect후 값이 소멸이 된다.
		rttr.addFlashAttribute("result", board.getBno());
		
		return "redirect:/board/list";
	}
	
	// get, post는 배열로 처리할 수 있고, 하나의 메서드로 여러 URL을 처리할 수 있따.
	@GetMapping({"/get", "/modify"})
	// @RequestParam = HttpServletRequest의 request.getParameter의 기능과 동일하다.
	// jsp에서 보낸 request값을 효율적으로 받기 위해 사용험.
	public void get(@RequestParam("bno") Long bno, Model model) {
		
		log.info("/get or modify");
		// 뷰로 해당 번호의 게시물을 전달해야하므로 Model을 파라미터로 지정함.
		model.addAttribute("board", service.get(bno));
	}
	
	
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		log.info("modify : " + board);
		
		// service.modify()는 수정 여부를 boolean으로 처리하므로 이를 이용해서 성공한 경우에만 RedirectAttributes에 추가함.
		if(service.modify(board)) {
			rttr.addFlashAttribute("result" + "success");
		}
		return "redirect:/board/list";
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
		
		log.info("remove : " + bno);
		if(service.remove(bno)) {
			
			rttr.addFlashAttribute("result", "success");
		}
		// 삭제 후 이동이 필요하므 redirect를 이용해서 삭제 처리 후에 목록 페이지로 이동함.
		return "redirect:/board/list";
	}
	
	@GetMapping("/register")
	public void register() {
		
	}
}
