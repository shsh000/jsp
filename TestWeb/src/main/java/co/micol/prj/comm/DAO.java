package co.micol.prj.comm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// 데이터 베이스 연결
public class DAO { // Data Access Object
	public Connection conn;
	public PreparedStatement psmt;
	public ResultSet rs;

	public void getConnect() { // 연결 순서 : conn -> psmt -> rs
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 드라이버 로드
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr"); // DB 물리적 위치, 접속계정 id, pw
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public void disconnect() { // 연결 해제 순서 : rs -> psmt -> conn
		// 인스턴스가 할당이 됐으면 연결 끊기
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (psmt != null) {
			try {
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
