package org.zerock.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class HikariCPTests {
	@Setter(onMethod_ = {@Autowired})
	private DataSource dataSource;
	
	@Setter(onMethod_ = {@Autowired})
	private SqlSessionFactory sqlSessionFactory;

	@Test
	public void testConnection() {
//		try(Connection con = dataSource.getConnection()) {
////			log.info(con);
////			log.info("---------------");
//		} catch(Exception e) {
//			fail(e.getMessage());
//		}
		
		try(SqlSession session = sqlSessionFactory.openSession();
				Connection con = session.getConnection();
				) {
//			log.info(session);
			log.info(con);
		} catch (SQLException e) {
			fail(e.getMessage());
		}
	}

//	@Test
//	public void testConn() throws ClassNotFoundException {
//		String url="jdbc:mysql://localhost:3306/sakila?useSSL=false"; 
//		String username="root"; String password="1234"; 
//		String query ="select * from actor"; 
//		Class.forName("com.mysql.jdbc.Driver"); 
//		Connection con;
//		try {
//			con = DriverManager.getConnection(url,username,password);
//			Statement st= con.createStatement(); 
//			ResultSet rs= st.executeQuery(query); 
//			rs.next(); String name= rs.getString("first_name"); 
//			System.out.println(name);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} 
//	}
}
