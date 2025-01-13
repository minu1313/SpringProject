package kr.co.green.test.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import kr.co.green.test.dto.ListDTO;
import kr.co.green.test.dto.ListPageInfoDTO;
import kr.co.green.test.dto.ListSearchDTO;
import kr.co.green.test.mapper.ListMapper;
import kr.co.green.test.util.PageNation;

@Service
public class ListServiceImpl implements ListService{

	
	private final ListMapper listMapper;

	
	public ListServiceImpl(ListMapper listMapper) {
		this.listMapper = listMapper;
		
	}
	
	@Override
	public Map<String, Object> getAllPosts(PageNation pageNation, int currentPage,int postCount,
																  int pageLimit, int boardLimit,
																  ListSearchDTO searchDTO) {
		// 페이징 처리
		ListPageInfoDTO pi = pageNation.getListPageInfo(postCount, currentPage,
													pageLimit,  boardLimit);
		
		// 페이지에 따라서 필요한 게시글들만 SELECT
		List<ListDTO> posts = listMapper.getAllPosts(pi, searchDTO);
		
		Map<String, Object> result = new HashMap<>();
		result.put("pi", pi);
		result.put("posts", posts);
		
		return result;
	}
	
	@Override
	public int getTotalCount(ListSearchDTO searchDTO) {
		return listMapper.getTotalCount(searchDTO);
	}
}
