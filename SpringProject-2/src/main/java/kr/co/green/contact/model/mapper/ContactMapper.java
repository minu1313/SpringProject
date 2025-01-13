package kr.co.green.contact.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.co.green.board.model.dto.PageInfoDTO;
import kr.co.green.board.model.dto.SearchDTO;
import kr.co.green.contact.model.dto.ContactAskDTO;
import kr.co.green.contact.model.dto.WriterInfoDTO;

@Mapper
public interface ContactMapper {

	int contactEnroll(WriterInfoDTO writerInfoDTO);
	int contactAskEnroll(WriterInfoDTO writerInfoDTO);
	
	List<WriterInfoDTO> contactListForm(@Param("pi")PageInfoDTO pi,
            									@Param("searchDTO") SearchDTO searchDTO);
	int getContactCount(@Param("searchDTO") SearchDTO searchDTO);
	
	WriterInfoDTO contactDetail(int no);
	
	
	
}
