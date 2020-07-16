package org.zerock.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {
	@Test
	public void testConnectionHikariCP() throws SQLException {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl("jdbc:mysql://localhost:3306/book_ex");
		config.setUsername("root");
		config.setPassword("1234");
		
		HikariDataSource dataSource = new HikariDataSource(config);
		
		log.info(dataSource.getJdbcUrl());
		log.info(dataSource.getUsername());
		log.info(dataSource.getPassword());
		log.info(dataSource);
		log.info(dataSource.getConnection());
	}
	
//	private static final String DRIVER = "com.mysql.jdbc.Driver";
//	private static final String URL = "jdbc:mysql://127.0.0.1:3306/sakila";
//	
//	private static final String USER = "user";
//	private static final String PW = "user123";
//
//	@Test
//	public void testConnection() throws ClassNotFoundException {
//		Class.forName(DRIVER);
//		
//		try(Connection conn = DriverManager.getConnection(URL, USER, PW)) {
//			System.out.println(conn);
//			Statement st = conn.createStatement();
//			ResultSet rs = st.executeQuery("select * from actor");
//			
//			while(rs.next()) {
//				log.info(rs.getString("first_name"));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
	
}
