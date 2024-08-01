package ver2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// DTO의 기능은 단지 데이터만 담는 것이 아니다.
// 기능이 추가될 수 있다.

@Data // 게터+세터
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor 
@Builder // 클래스 생성
@ToString // 오버라이드 처리
public class StudentDTO {
	
	private int id;
	private String name;
	private int age;
	private String email;
	
}
