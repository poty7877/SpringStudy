package com.ysy.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class JDBCTests { // jdbc 1단계, 2단계, 5단계 테스트

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			log.info("JDBCTest 1단계 성공");
		} catch (ClassNotFoundException e) {
			fail("JDBCTests.static{} 1단계 실패"); // 실패시 로그는 fail로 처리하는것을 권장
			fail(e.getMessage());
			// log.info("JDBCTests.static{} 1단계 실패");
			e.printStackTrace();
		}
	}

	@Test
	public void testConnection() {
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "book_ex", "book_ex");
			log.info(con); // 객체의 주소를 출력함
			log.info("JDBCTest 2단계 성공");
		} catch (SQLException e) {
			fail("JDBCTests.testConnection() 2단계 실패");
			fail(e.getMessage());
			// log.info("JDBCTests.testConnection() 2단계 실패")
			e.printStackTrace();
		}
	}

}
