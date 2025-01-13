package kr.co.green.test.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ListDTO {

	
	private int id;
	private String title;
	private String author;
	private String createdDate;
}
