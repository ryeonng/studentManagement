package ver2;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

// 싱글톤 패턴 : 단 하나의 객체만 필요하다면, 싱글톤 패턴으로 설계할 수 있다.
public class DBConnectionManager {

	// 자기 자신의 참조 주소값을 담을 변수를 생성. 단 private로 생성
	private static DBConnectionManager instance;
	private HikariDataSource dataSource;
	
	// 외부에서 생성자를 호출하지 못하도록 막아야 한다.
	private DBConnectionManager() {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl("jdbc:mysql://localhost:3306/studentdb?serverTimezone=Asia/Seoul");
		config.setUsername("root");
		config.setPassword("asd123");
		config.setMaximumPoolSize(10); // Connectionpool
		dataSource = new HikariDataSource(config);
	}
	
	// 외부에서 클래스이름.getXXX 메서드를 만들어 주면 외부에서 이 객체를 사용할 수 있다.
	// 한 번에 하나의 스레드만 접근하도록 동기화 적용 : synchronized
	public synchronized static DBConnectionManager getInstance() {
		if(instance == null) { // 객체가 한 번도 생성된 적이 없다면,
			instance = new DBConnectionManager(); // 생성자 생성
		}
		return instance; // 객체 주소값을 던진다.
	}
	
	// Connection 객체를 반환 (구현체 - HikariCP)
	public Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}
}
