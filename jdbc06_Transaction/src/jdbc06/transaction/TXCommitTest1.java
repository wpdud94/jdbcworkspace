package jdbc06.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import config.ServerInfo;

public class TXCommitTest1 {

	public static void main(String[] args) throws Exception {
		Class.forName(ServerInfo.DRIVER_NAME);
		System.out.println("Driver loading");
		
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASS);
		System.out.println("DBServer Connection...");
		
		String query1 = "INSERT INTO encore(name) VALUES(?)";
		String query2 = "SELECT no, name FROM encore WHERE no = ?";
		
		//여기서 transation 시작
		conn.setAutoCommit(false);
		
		PreparedStatement ps1 = conn.prepareStatement(query1);
		ps1.setString(1, "전지현");
		ps1.executeUpdate();
		
		//no=7 레코드 존재x... 실패...  위의 코드까지 RollBack...
		//no=7 레코드 존재x... 성공... Commit...
		//이렇게 묶어서 진행한는 게 Transaction
		PreparedStatement ps2 = conn.prepareStatement(query2);
		ps2.setInt(1, 21);
		ResultSet rs = ps2.executeQuery();
		
		if(!rs.next()) {// 레코드가 존재하지 않는다면
			conn.rollback();
			System.out.println("찾는 번호에 해당하는 해원이 없어서 rollback");
		}else {//레코드가 존재한다면
			conn.commit();
			System.out.println("발견");
		}
		
		// 다시 원래 대로
		conn.setAutoCommit(true);
/*
원래는
try에서 commit
catch에서 rollback
 */
	}

}
