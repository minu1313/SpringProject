package kr.co.green.contact.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import kr.co.green.board.model.dto.PageInfoDTO;
import kr.co.green.board.model.dto.SearchDTO;
import kr.co.green.board.util.Pagination;
import kr.co.green.contact.model.dto.WriterInfoDTO;
import kr.co.green.contact.model.mapper.ContactMapper;

@Service
public class ContactServiceImpl implements ContactService {
	
	private final ContactMapper contactMapper;
	
	public ContactServiceImpl(ContactMapper contactMapper) {
		this.contactMapper=contactMapper;
	}
	
	@Override
	public int contactEnroll(WriterInfoDTO writerInfoDTO) {
		int result = contactMapper.contactEnroll(writerInfoDTO);
		contactMapper.contactAskEnroll(writerInfoDTO);
		
		
		
		return result;
	}
	
	@Override
	public Map<String,Object> contactListFrom(Pagination pageNation,
												int currentPage, int postCount,
												int pageLimit, int boardLimit,
												SearchDTO searchDTO){
		
		
		PageInfoDTO pi = pageNation.getPageInfo(postCount, currentPage, pageLimit, boardLimit);
		
		List<WriterInfoDTO> posts = contactMapper.contactListForm(pi, searchDTO);
		
		Map<String, Object> result = new HashMap<>();
		result.put("pi", pi);
		result.put("posts", posts);
		
		return result;
	}
	
	@Override
	public int getContactCount(SearchDTO searchDTO) {
		return contactMapper.getContactCount(searchDTO);
	}
	
	@Override
	public WriterInfoDTO contactDetail(int no) {
		WriterInfoDTO result;
		result = contactMapper.contactDetail(no);
		
		return result;
	}
}
