package org.zerock.domain;

import java.util.Date;

import lombok.Data;

@Data
public class MemberVO {

	private Long mno;
	private String name;
	private String email;
	private String id;
	private String pw;
	private Date regdate;
	
}
