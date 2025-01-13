package kr.co.green.board.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SearchDTO {
	private String category = "title";
	private String searchText = "";
}
