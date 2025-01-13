package kr.co.green.board.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.co.green.board.model.dto.BoardDTO;
import kr.co.green.board.model.dto.FileDTO;
import kr.co.green.board.model.dto.PageInfoDTO;
import kr.co.green.board.model.dto.SearchDTO;

@Mapper
public interface BoardMapper {

	List<BoardDTO> getAllPosts(@Param("pi") PageInfoDTO pi,
								   @Param("searchDTO") SearchDTO searchDTO);

	int getTotalCount( @Param("searchDTO") SearchDTO searchDTO);

	int enroll(BoardDTO boardDTO);

	BoardDTO detail(int no);
	BoardDTO detailFile(BoardDTO boardDTO);

	int addViewCount(int no);

	BoardDTO updateForm(int no);

	int getAuthorNo(int no);

	int update(BoardDTO boardDTO);

	int delete(int no);
	
	void deleteFile(String fileName);
	
	int enrollFile(BoardDTO boardDTO);
	
	BoardDTO getFileInfo(int no);

}
