package ver1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentRepositoryImpl {

	public static final String ADD_STUDENT = " insert into students(name, age, email) values(?, ?, ?) ";
	
	public static final String VIEW_STUDENT = " select * from students ";
	
	public static final String UPDATE_NAME = " update students set name = ? where age = ? ";
	public static final String UPDATE_AGE = " update students set age = ? where name = ? ";
	
	public static final String DELETE = " delete from students where name = ? and age = ? and email = ? ";

	public void addStudent(String name, int age, String email) throws SQLException{
		
		int resultRowCount = 0;
		
		try (Connection conn = DBConnectionManager.getConnection()){
			PreparedStatement pstmt = conn.prepareStatement(ADD_STUDENT);
			
			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.executeUpdate();
		}
		
		
	}
	
} // end of class

