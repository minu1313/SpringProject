package kr.co.green.test.service;

import java.util.Map;

import kr.co.green.test.dto.ListSearchDTO;
import kr.co.green.test.util.PageNation;

public interface ListService {
	

		
	public Map<String, Object> getAllPosts(PageNation pageNation,int currentPage,int postCount,
					int pageLimit, int boardLimit, ListSearchDTO searchDTO);
		
	public int getTotalCount(ListSearchDTO searchDTO);
	
}
