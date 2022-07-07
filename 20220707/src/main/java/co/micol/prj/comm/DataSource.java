package co.micol.prj.comm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// 싱글톤 single ton 클래스
public class DataSource {
	private static DataSource dataSource = new DataSource(); // 인스턴스 생성
	private Connection conn;

	private DataSource() {} // private 생성자 생성

	public static DataSource getInstance() { // 인스턴스를 리턴
		return dataSource;
	}

	public Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "micol", "1234");
			System.out.println("DB 연결 성공");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("DB 연결 실패");
		}
		return conn;
	}
}
