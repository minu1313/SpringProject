package kr.co.green.test.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.green.test.dto.ListDTO;
import kr.co.green.test.dto.ListPageInfoDTO;
import kr.co.green.test.dto.ListSearchDTO;
import kr.co.green.test.service.ListServiceImpl;
import kr.co.green.test.util.PageNation;

@Controller
@RequestMapping("/test")
public class ListController {

	
	
	private final ListServiceImpl listService;
	private final PageNation pageNation;
	
	public ListController(ListServiceImpl listService,
								   PageNation pageNation) {
		this.listService = listService;
		this.pageNation = pageNation;
	}
	
	@GetMapping("/list")
	public String list(@RequestParam(value="currentPage",defaultValue="1") int currentPage,
						@ModelAttribute ListPageInfoDTO pi,
						@ModelAttribute ArrayList<ListDTO> posts,
						@ModelAttribute(value="searchDTO") ListSearchDTO searchDTO,
						Model model) {
		
		// 전체 게시글 수
		int postCount = listService.getTotalCount(searchDTO);
		
		// 보여질 페이지 수
		int pageLimit = 5;
		
		// 한 페이지에 들어갈 게시글 수
		int boardLimit = 10;
		
		
		// 1. pageInfoDTO 대신 currentPage, postCount, pageLimit, boardLimit 다 인자로 작성
		// 2. 배열로 만들어서 넣어주는 방법
		Map<String, Object> result = listService.getAllPosts(pageNation, currentPage,
																			  postCount,
																			  pageLimit,
																			  boardLimit,
																				searchDTO);
		pi = (ListPageInfoDTO) result.get("pi");
		posts = (ArrayList<ListDTO>) result.get("posts");
		
		
	    model.addAttribute("posts", posts);
	    model.addAttribute("pi", pi);
		
		return "test/list";
	}
	

}
