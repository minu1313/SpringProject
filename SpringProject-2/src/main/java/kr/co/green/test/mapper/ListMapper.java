package kr.co.green.test.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.co.green.board.model.dto.SearchDTO;
import kr.co.green.test.dto.ListDTO;
import kr.co.green.test.dto.ListPageInfoDTO;
import kr.co.green.test.dto.ListSearchDTO;

@Mapper
public interface ListMapper {

	
	List<ListDTO> getAllPosts(@Param("pi") ListPageInfoDTO pi,@Param("searchDTO") ListSearchDTO searchDTO);
	int getTotalCount( @Param("searchDTO") ListSearchDTO searchDTO);
	
}
