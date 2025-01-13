package kr.co.green.member.model.service;

import kr.co.green.member.model.dto.MemberDTO;

public interface MemberService {
	public int signup(MemberDTO memberDTO);
	public MemberDTO signin(MemberDTO memberDTO);
	public boolean checkId(String memberId);
}
