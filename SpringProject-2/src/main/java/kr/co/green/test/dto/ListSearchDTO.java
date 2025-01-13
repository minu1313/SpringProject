package kr.co.green.test.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ListSearchDTO {
	private String category = "title";
	private String searchText = "";
}
