package kr.co.green.member.model.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MemberDTO {
	private int no;
	private String id;
	private String name;
	private String password;
	private String confirmPassword;
	private String status;
	private String createdAt;
	private String updatedAt;
	private String deletedAt;
}
