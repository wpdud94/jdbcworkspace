package jdbc.step4;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

//메타 데이터화_Properties
/*
실제값들의 메타데이터화
인터페이스 --> properties라는 파일로 할 거임
** properties 파일은 java진영에서 놓지 않는 것
Collection
	|
set	List				Map
						|
					HasTable	Hashmap
 						|
 					Properties
properties : key & value 로 구성되는데, value type이 object가 아닌 string임
==> 메타데이터화하라고 대놓고 주는 것
 */
public class DBConnectionTest1 {
	public static void main(String[] args) throws Exception {
		Properties p = new Properties();
		p.load(new FileInputStream("src/config/db.properties")); //class는 src먹고 들어가고 file은 src명시 해야함
		
		String driver = p.getProperty("jdbc.mysql.driver");
		String url = p.getProperty("jdbc.mysql.url");
		String user = p.getProperty("jdbc.mysql.user");
		String pass = p.getProperty("jdbc.mysql.pass");
		
		String selectAll = p.getProperty("jdbc.sql.selectAll");
		
		Class.forName(driver);
		System.out.println("1. 드라이버 로딩...");
		
		Connection conn = DriverManager.getConnection(url, user, pass);
		System.out.println("2. DB 연결 성공...");
		
		PreparedStatement st = conn.prepareStatement(selectAll);
		System.out.println("3. PreparedStatement 생성 완료...");
		
		System.out.println("==============4. Query 실행 ================");
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getString("name")+", "+rs.getString("address"));
		}
		
		
	}

}
