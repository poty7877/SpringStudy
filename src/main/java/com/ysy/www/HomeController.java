package com.ysy.www;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

/**
 * Handles requests for the application home page.
 */

@Data // dto 객체 관리용 (lombok)
@Controller // 분기 담당
@Log4j2  // System.out.println -> log.info()로 콘솔출력 (파일로 보관이 가능)
public class HomeController {
	
	/*
	 * private static final Logger logger =
	 * LoggerFactory.getLogger(HomeController.class);
	 */
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	//http://localhost:80/ 가 요청되면 응답하는 메서드 
	public String home(Locale locale, Model model) { // Model model = request 영역 처럼 도는 Spring용 메모리 영역
		
		log.info("Log4j2........................");
		log.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate ); // Model 영역에 값을 생성하여 집어넣음. 
		
		return "home"; // 스프링에 Controller의 역할을 담당하는 servlet-context.xml을 가서 처리를함.
		// <beans:bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		// <beans:property name="prefix" value="/WEB-INF/views/" /> return 앞에 붙음
		// <beans:property name="suffix" value=".jsp" /> return 뒤에 붙음
		// </beans:bean>
		// 결론: return -> /WEB-INF/views/home.jsp 로 완성이 됨
	}
	
}
