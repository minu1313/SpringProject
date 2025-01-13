package kr.co.green.board.model.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import kr.co.green.board.model.dto.BoardDTO;
import kr.co.green.board.model.dto.SearchDTO;
import kr.co.green.board.util.Pagination;

public interface BoardService {
	public Map<String, Object> getAllPosts(Pagination pagination,int currentPage,int postCount,
			  											int pageLimit, int boardLimit, SearchDTO searchDTO);
	public int getTotalCount(SearchDTO searchDTO); // 전체 게시글 수
	public int enroll(BoardDTO boardDTO,MultipartFile file);
	public BoardDTO detail(int no);
	public BoardDTO updateForm(int no);
	public int update(BoardDTO boardDTO,MultipartFile file, int memberNo);
	public int delete(int no, int memberNo, String fileName);
}
