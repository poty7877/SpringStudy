package com.ysy.sample;

import java.sql.Date;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data // DTO 관리용 lombok.
@Component // 스프링이 객체를 관리함
//@AllArgsConstructor // 모든값을 받는 생성자가 만들어짐

public class Chef {
	private String name;
	private int age;
	private Date regDate;

}
