package ver1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class StudentExample {

	// 로깅 처리 및 로그
	private static final Logger LOGGER = Logger.getLogger(StudentExample.class.getName());
	
	public static void main(String[] args) {
		
		try {
			
			Connection conn = DBConnectionManager.getConnection();
			
			Scanner scanner = new Scanner(System.in);
			System.out.print("학생 이름을 입력하세요 : ");
			String name = scanner.nextLine();
			
			System.out.print("이메일을 입력하세요. : ");
			String email = scanner.nextLine();
			
			if(authenticateStudent(conn, name, email)) {
				System.out.println("로그인 성공");
			} else {
				System.out.println("로그인 실패 - 학생 이름과 이메일을 확인해 주세요.");
			}
			
		} catch (SQLException e) {
			LOGGER.log(Level.INFO, "MySQL 연결 오류");
			e.printStackTrace();
		}
		
	} // end of main
	
	private static boolean authenticateStudent(Connection conn, String name, String email) {
		String query = "select * from tbstudent where name = ? and email = ? ";
		boolean result = false;
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			ResultSet rs = pstmt.executeQuery();
			
			result = rs.next();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

} // end of class
