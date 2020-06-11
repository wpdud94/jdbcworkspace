package jdbc.step1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
JDBC 작업 4단계
1. 드라이버 로딩...(클라이언트(지금은 자바 프로그램) 메모리단에 올리기)
2. DB서버와 연결... JDBC:mysql://ip:3306/scott  (앞에는 프로토콜 이름이, 뒤에는 address, 모든 통신에는 포트가 필요. mysql포트는 3306|이까지는 mysql서버까지 들어감.|우리가 사용한 스키마까지 설정해야함.)
3. 쿼리준비 ...
	conn 반환
	쿼리 반환 기능이 있음... api 참고... connection interface 	
	PreparedStatement st = conn.prepareStatement("spl query"); 라는 게 들어가면 됨. PreparedStatement 반환. st는 관습
4. 값이 바인딩 + 쿼리문이 실행
	쿼리문이 실행될 때 실제로 DB서버에 값이 들어감.
	1) ?에 해당하는 값을 먼저 바인딩
	2) 쿼리문 실행
		st.excuteUpdate() : int 반환 -- DML : insert, delete, update
		st.excuteQuery() : ResultSet 반환 -- select
 */

public class DBConnectionTest1 {
	
	public DBConnectionTest1() {
		//1. 드라이버 로딩법
		//Class.forName("Driver"); //드라이버 이름 -> 위치 알면됨. 근데 이러면 기계가 못참음. fullname 필요. FQCN(FullQualifiedClassName)
		//------------------------------------------------------------
		/*try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Drive Loading Success");
		} catch (ClassNotFoundException e) { // 이 오류는 클래스를 찾지 못할 때(없거나, 경로 오류, 이름 잘못)
			System.out.println("Drive Loading Fail");
		}*/
		//------------------------------------------------------------
		// 위처럼 하면 경로설정 오류남. 경로 잡는 거 아님. 
		//C:\Program Files\Java\jdk1.8.0_201(자바홈)\jre\lib\ext 에 드라이버를 넣으면 드라이버를 calss path로 잡힘. 이때 jre에도 깔아주어야. 
		//C:\Program Files\Java\jre1.8.0_201\lib\ext 여기에도 드라이버 복사
		
		try {
			//1.
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Drive Loading Success");
			
			//2.
			String url = "JDBC:mysql://127.0.0.1:3306/scott?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8"; //127.0.0.1 이 자기 자신
			Connection conn = DriverManager.getConnection(url, "root", "1234"); // name convention
			System.out.println("DBConnection Success!!"); //mysql은  timezone 필요
			
			//3.
			String query ="INSERT INTO person(ssn, name, address) VALUES(?,?,?)";
			//쿼리문이 길어서 변수로 하나 뽑아낼 것.
			PreparedStatement st = conn.prepareStatement(query);
			System.out.println("Creating PreparedStatement.....");
			//이까지는 값을 넣을 틀을 준비한 것.
			// api에서 PreparedStatement 인터페이스 확인
			// 쿼리문이 미리 들어가지만, 실행되는 건 아님. 그거는 지금부터
			// excuteUpdate() 메소드 : DML 쿼리문을 실행하는 메소드. 이때 DB에 직접적으로 값이 추가(중요)
			// 이 안에 쿼리문은 안 들어감. PreparedStatement에 미리 들어감.
			// 이 친구가 실행하는 쿼리문은 DML계열만. insert, delete, update...
			// 반환값은 int라 실행되면 1, 안 되면 0이 나옴.
			// select문은 다른 것.
			// excuteQuery() 메소드 : Select 쿼리문을 실행하는 메소드 (중요)
			// 반환은 RuesultSet
			
			//4. 
			st.setInt(1, 111); // index = ? 위치, 뒤에 것은 값. 타입이 숫자니가 int
			st.setString(2, "박나래"); //타입이 string이니까
			st.setString(3, "여의도");
			
			int row=st.executeUpdate();
			System.out.println(row+"명 추가됨");
			//WorkBench에서 확인
			
			} catch (ClassNotFoundException e) { // 이 오류는 클래스를 찾지 못할 때(없거나, 경로 오류, 이름 잘못)
			System.out.println("Drive Loading Fail");
			} catch (SQLException e) {
			System.out.println("DBConnection Fail!!");
			}
		
			
	}
	
	public static void main(String[] args) {
		new DBConnectionTest1();

	}

}
