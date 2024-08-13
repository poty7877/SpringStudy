package com.ysy.sample;

import java.sql.Date;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

@Log4j2
@ToString // lombok이 객체 출력을 문자열로 해줌
@Getter	  // Getter 만 생성
@Component
// @AllArgsConstructor // 필드에 있는 모든 값을 이용해서 생성자를 만듬
// @NoArgsConstructor // 필드에 있는 값을 안쓰는 기본생성자가 만들어짐 new SampleHotel();
@RequiredArgsConstructor // @NonNull, final이 붙은 필드만 생성자 값으로 넣음.
public class SampleHotel {
	@NonNull
	private Chef chef;
	private final String hotelName;
	private Date hotelAge;
	
	 // public SampleHotel(Chef chef) { // 생성자 //-> 객체 생성지 Chef를 만듬 this.chef = chef;}
	 // SampleHotel sampleHotel = new SampleHotel(chef);
	 
}
