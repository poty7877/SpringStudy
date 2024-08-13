package com.ysy.sample;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Data // lombok이 dto처럼 관리함
@Component // 스프링이 관리함 root-context.xml 에 context:component-scan 패키지 추가 필수!
public class Restaurant {
	// 필드
	@Setter(onMethod_ = @Autowired) // 자동으로 setChef()라는 메서드를 컴파일 시 생성한다
	private Chef chef;				// setChef(Chef);
	private String restaurantName;
	private Date openTime;
	private Date closeTime;

	// 생성자

	// 메서드

}
