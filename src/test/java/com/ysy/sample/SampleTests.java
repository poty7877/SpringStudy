package com.ysy.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

// 필수 사항 3가지 -> pom.xml 에 spring.test 코드 필수
@RunWith(SpringJUnit4ClassRunner.class) // 메서드 별로 테스트 우클릭 run as junit 가능하게.
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") // 참조할 파일
@Log4j2 // log 출력용

public class SampleTests {
	@Setter(onMethod_ = @Autowired) // setRestaurant(Restaurant) =
									// Restaurant restaurant = new Restaurant(restaurant);
	private Restaurant restaurant;

	@Test // import org.junit.Test; 메서드 별로 테스트가 진행 됨 (메서드명 블럭설정 -> 우클릭 -> Run as -> Junit
			// )
	public void testExist() {
		assertNotNull(restaurant); // restaurant 객체가 null이어도 실행.

		log.info(restaurant);
		log.info("----------------");
		log.info(restaurant.getChef()); // restaurant 안에있는 chef를 가져와라

	}

}
