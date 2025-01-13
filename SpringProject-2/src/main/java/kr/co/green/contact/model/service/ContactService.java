package kr.co.green.contact.model.service;

import java.util.Map;

import kr.co.green.board.model.dto.SearchDTO;
import kr.co.green.board.util.Pagination;
import kr.co.green.contact.model.dto.ContactAskDTO;
import kr.co.green.contact.model.dto.WriterInfoDTO;

public interface ContactService {

	public int contactEnroll(WriterInfoDTO writerInfoDTO);
	
	public Map<String,Object> contactListFrom(Pagination pageNation,
													int currentPage, int postCount,
													int pageLimit, int boardLimit,
													SearchDTO searchDTO); 
	
	public int getContactCount(SearchDTO searchDTO);
	
	public WriterInfoDTO contactDetail(int no);
	
	
}
