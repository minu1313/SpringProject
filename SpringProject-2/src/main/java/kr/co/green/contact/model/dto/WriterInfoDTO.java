package kr.co.green.contact.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WriterInfoDTO {
	private int writerNo;
	private String writerName;
	private String writerEmail;
	
	private ContactAskDTO contactAskDTO = new ContactAskDTO();
	private ContactAnswerDTO contactAnswerDTO = new ContactAnswerDTO();
	
	

}
