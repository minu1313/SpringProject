package kr.co.green.contact.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.green.board.model.dto.PageInfoDTO;
import kr.co.green.board.model.dto.SearchDTO;
import kr.co.green.board.util.Pagination;
import kr.co.green.contact.model.dto.ContactAskDTO;
import kr.co.green.contact.model.dto.WriterInfoDTO;
import kr.co.green.contact.model.service.ContactService;

@Controller
@RequestMapping("/contact")
public class ContactController {
	
	private final ContactService contactService;
	private final Pagination pageNation;
	
	public ContactController(ContactService contactService, Pagination pageNation) {
		this.contactService = contactService;
		this.pageNation = pageNation;
	}
	
	
	
	
	
	

	@GetMapping("/contactListForm")
	public String contactListForm(@RequestParam(value="current",defaultValue="1") int currentPage,
									@ModelAttribute PageInfoDTO pi,
									@ModelAttribute ArrayList<WriterInfoDTO> posts,
									@ModelAttribute SearchDTO searchDTO,
									Model model) {
		int postCount = contactService.getContactCount(searchDTO);
		int pageLimit = 5;
		int boardLimit = 7;
		
		Map<String, Object> result = contactService.contactListFrom(pageNation, currentPage,
																		postCount,
																		pageLimit,
																		boardLimit,
																		searchDTO);
		pi = (PageInfoDTO) result.get("pi");
		posts = (ArrayList<WriterInfoDTO>) result.get("posts");
		
		model.addAttribute("posts", posts);
	    model.addAttribute("pi", pi);
		
		
		return "contact/list";
	}
	
	@GetMapping("/contactEnrollForm")
	public String contactEnrollForm() {
		return "contact/enroll";
	}
	
	
	
	@PostMapping("/contactEnroll")
	public String contactEnroll(WriterInfoDTO writerInfoDTO) {
		
		
		int result = contactService.contactEnroll(writerInfoDTO);
		System.out.println(result);
		
		
		
		
		return "contact/list";
	}
	
	
	
	@GetMapping("/contactDetail")
	public String contactDetail(@RequestParam(value="askNo") int no,
						 Model model) {
		// 선택한 게시글에 대한 정보를 불러와야 함
		// 제목, 내용, 작성자, 작성일, 조회수
		System.out.println("bbbbbbbbbbb" + no);
		WriterInfoDTO result = contactService.contactDetail(no);
		
		System.out.println("aaaaaaaaaa" + result.getWriterName());
		model.addAttribute("posts", result);
		return "contact/detail";
	}
	
	
	
	
	
	
	
	
	
	
}
