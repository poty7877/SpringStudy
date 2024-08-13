package com.ysy.mapper;

import org.apache.ibatis.annotations.Select;



public interface TimeMapper { // 쿼리 처리 하는 인터페이스
	// mybatis는 쿼리문 처리를 xml + interface로 만든다
	// 인터페이스에서는 호출할 메서드명만 기술하고
	// xml에는 같은 이름으로 쿼리를 만든다.

	// c 추상 메서드

	// r 추상 메서드
	public String getTimeXML(); // resources/com/ysy/mapper/TimeMapper.xml의 쿼리를 실행한다

	// u 추상 메서드

	// d 추상 메서드

	// xml을 꼭 사용하지 않아도 된다.
	@Select("select sysdate from dual") // == resultSet
	public String getTime();
	
	
}
