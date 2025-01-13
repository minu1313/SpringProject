package kr.co.green.board.model.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BoardDTO {
	private int no;
	private String title;
	private String content;
	private String createdDate;
	private String updatedDate;
	private int viewCount;
	private AuthorDTO authorDTO = new AuthorDTO();
	private FileDTO fileDTO = new FileDTO();;
	
	
	
}
