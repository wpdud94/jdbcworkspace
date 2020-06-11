package jdbc.step3;
//메타 데이터화
/*
 문제점 
 step2에서는 DB서버에 대한 정보, 쿼리가 프로그램 상에 하드코딩 되어져 있다.
 
 해결책
 별도의 모듈에 DB서버에 대한 정보를 뽑내어서 별도로 처리
 이를 메타데이터화 시킨다 라고 표현함
 가장 세련된 기법 - XML
 그 다음 - Properties 파일
 그다음 - 인터페이스
 
 모듈화
메타데이터를 또 다른 객체로 설정
 
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;
import query.PersonSQL;

public class DBConnectionTest1 {
	public DBConnectionTest1() throws ClassNotFoundException, SQLException {
		//1. 드라이버 로딩
		Class.forName(ServerInfo.DRIVER_NAME); 
		System.out.println("1. Driver Loading...");
		
		//2. DB연결... DriverManager의 getConnection()
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		System.out.println("2. DB 연결 성공...");
		
		//insert-------------------------------------------------
		//3. 쿼리준비... Connection의 prepareStatement()
		/*String query = "INSERT INTO person(ssn, name, address) VALUES(?,?,?)"; //기니까 미리 뽑기
		PreparedStatement st = conn.prepareCall(query);
		System.out.println("3. PreparedStatement 생성 완료");
		
		//4. ?에 값을 바인딩하고 쿼리문 실행.PreparedStatement의    excuteUpdate()
		st.setInt(1, 333);
		st.setString(2, "정우성");
		st.setString(3, "혜화동");
		
		System.out.println(st.executeUpdate()+"명 추가됨");*/
		//insert 끝... 주석으로~... 3명 넣음-----------------------
		
		// delete ------------------------------------------------
		/*String query = "DELETE FROM person WHERE ssn=?";
		PreparedStatement st = conn.prepareStatement(query);
		System.out.println("PreparedStatement 생성 완료");
		
		st.setInt(1, 333);
		
		System.out.println(st.executeUpdate()+"명이 삭제됐습니다.");
		*/
		
		// update ------------------------------------------------
		/*String query = "Update person set name = ?, address = ? WHERE ssn = ?";
		PreparedStatement st = conn.prepareStatement(query);
		System.out.println("PreparedStatement 생성 완료");
		st.setString(1, "박나리");
		st.setString(2, "서초동");
		st.setInt(3, 111);
		System.out.println(st.executeUpdate()+"명 수정됨");*/
		
		//select... 모든 레코드를 다 가져온다.
		PreparedStatement st = conn.prepareStatement(PersonSQL.ALL_PERSON);
		
		ResultSet rs = st.executeQuery(); // int | ResultSet --> 왜 다를까? 
		/*
		 select는 데이터를 가져온느 것. 가져올 때 ResultSet에 담아서 가져옴
		 ResultSet의 형태는 table과 똑같이 만듦. 
		 */
		while(rs.next()){// 커서 한 번 내려감
			int ssn = rs.getInt("ssn");//컬럼명이 더 정확
			String name = rs.getString("name");
			String addr = rs.getString("address");
			System.out.println(ssn+", "+name+", "+addr);
			
		}
		
		
		//5.
		st.close();
		conn.close();
	}
	

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		new DBConnectionTest1();

	}

}
