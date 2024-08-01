package ver1;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DBConnectionManager {

	private static HikariDataSource dataSource;
	
	private static final String URL = "jdbc:mysql://localhost:3306/studentdb?serverTimezone=Asia/Seoul";
	private static final String USER = "root";
	private static final String PASSWORD = "asd123";
	
	static {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(URL);
		config.setUsername(USER);
		config.setPassword(PASSWORD);
		config.setMaximumPoolSize(10); // 최대 연결 수 10개
		
		dataSource = new HikariDataSource(config);
		
	}
	
	public static Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}
	
	// 테스트 코드
	public static void main(String[] args) {
		
		try {
			Connection conn = DBConnectionManager.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
} // end of class
