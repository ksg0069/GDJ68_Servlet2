package com.iu.main.test;

import java.sql.Date;

import com.iu.main.member.MemberDAO;
import com.iu.main.member.MemberDTO;

public class MemberTest {

	public static void main(String[] args) {
		
		
		MemberDAO memberDAO = new MemberDAO();
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("id2");
		memberDTO.setPw("pw1");
		memberDTO.setName("name1");
		memberDTO.setEmail("kse@naver.com");
		
		try {
			int result = memberDAO.join(memberDTO);
			System.out.println(result==1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
