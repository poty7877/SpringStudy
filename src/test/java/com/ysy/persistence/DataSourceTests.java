package com.ysy.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ysy.mapper.TimeMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class) // 메서드 별로 테스트 우클릭 run as junit 가능하게.
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") // 참조할 파일
@Log4j2 // log 출력용
public class DataSourceTests {

	@Setter(onMethod_ = @Autowired)
	private DataSource dataSource;

	@Setter(onMethod_ = @Autowired)
	private SqlSessionFactory sqlSessionFactory;

	@Setter(onMethod_ = @Autowired)
	private TimeMapper timeMapper;

	@Test
	public void testGetTimeXml() {
		log.info(timeMapper.getClass().getName());
		// INFO com.ysy.persistence.DataSourceTests(testGetTimeXml39) -
		// com.sun.proxy.$Proxy36
		log.info(timeMapper.getTimeXML());
		// INFO com.ysy.persistence.DataSourceTests(testGetTimeXml41) - 2024-08-13
		// 16:29:20
	}

	@Test
	public void getTime() {
		log.info(timeMapper.getClass().getName()); // 클래스으 이름을 출력
		// INFO com.ysy.persistence.DataSourceTests(getTime39) - com.sun.proxy.$Proxy36
		log.info(timeMapper.getTime()); // select 쿼리가 있는 메서드
		// INFO com.ysy.persistence.DataSourceTests(getTime40) - 2024-08-13 15:58:37
	}

	@Test
	public void testMyBatis() {
		// 동적 쿼리문을 처리해주는 sql 매핑용 테스트

		try {
			SqlSession sqlSession = sqlSessionFactory.openSession(); // 세션오픈
			Connection con = sqlSession.getConnection();
			log.info("---------------");
			log.info(sqlSession);
			log.info(con);
			// INFO com.ysy.persistence.DataSourceTests(testMyBatis40) -
			// org.apache.ibatis.session.defaults.DefaultSqlSession@4ce14f05
			// ----------------------------------------------------------------------
			// INFO com.ysy.persistence.DataSourceTests(testMyBatis41) -
			// HikariProxyConnection@1910492961 wrapping
			// oracle.jdbc.driver.T4CConnection@6dc1484
			log.info("---------------");
		} catch (Exception e) {
			fail(e.getMessage());

		}
	}

	@Test
	public void testConnection() {

		try {
			Connection con = dataSource.getConnection();
			log.info("HikariCP 1단계, 2단계 연결 성공");
			log.info(con);
			// INFO com.ysy.persistence.DataSourceTests(testConnection33) -
			// HikariProxyConnection@663277822 wrapping
			// oracle.jdbc.driver.T4CConnection@3249a1ce
		} catch (SQLException e) {
			fail("HikariCP 1단계, 2단계 연결 실패");
			fail(e.getMessage());
		}
	}

}
