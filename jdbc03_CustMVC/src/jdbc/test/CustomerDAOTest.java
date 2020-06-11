package jdbc.test;

import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;
import jdbc.dao.imple.CustomerDAOimpl;
import jdbc.vo.Customer;

public class CustomerDAOTest {
	
	
	public static void main(String[] args) {
		CustomerDAOimpl dao = CustomerDAOimpl.getInstance();
		
		/*try {
			service.registerCustomer(new Customer("id1", "pass1", "강제영", "사근동"));
		} catch (SQLException e) {
			System.out.println("회원 가입 실패");*/
		
		/*try {
			service.registerCustomer(new Customer("id2", "pass2", "김희애", "서초동"));
		} catch (SQLException e) {
			System.out.println("회원 가입 실패");
		}*/
		
		/*try {
			service.registerCustomer(new Customer("id3", "pass3", "아이유", "청담동"));
		} catch (SQLException e) {
			System.out.println("회원 가입 실패");
		}*/
		
		/*try {
			service.deleteCustomer("id3");
		} catch (SQLException e) {
			System.out.println("회원 탈퇴 실패");
		}*/
		//로그인 --> 로그인 정보는 Web에서 사용할 것
		try {
			Customer cust1 = dao.login(new Customer("id1", "pass1"));
			System.out.println(dao.login(new Customer("id1", "pass1")).getName()+" 님, 로그인되셨습니다.");
		} catch (SQLException e) {
			System.out.println("ID 혹은 패스워드가 틀렸습니다.");
		} catch (NullPointerException e) {
			System.out.println("ID 혹은 패스워드가 틀렸습니다.");
		}

		try {
			dao.updateCustomer(new Customer("id3", "pass4", "아이린", "소곡동"));
		} catch (SQLException e) {
			System.out.println("회원 정보 수정 실패");
		}
		
		try {
			System.out.println(dao.getCustomer("id1").getName()+" 님의 정보를 출력합니다.");
			System.out.println(dao.getCustomer("id1"));
		} catch (SQLException e) {
			System.out.println("해당 회원을 찾을 수 없습니다.");
		}
		
		try {
			ArrayList<Customer> temp = dao.getAllCustomer();
			for(Customer cust : temp) System.out.println(cust);
		} catch (SQLException e) {
			System.out.println("회원목록을 불러올 수 없습니다.");
		}
		
	}
	
	//static 초기화 불럭
		static {
				try {
					Class.forName(ServerInfo.DRIVER_NAME);
					System.out.println("Driver Loading OK...");
				} catch (ClassNotFoundException e) {
					System.out.println("Driver Loading Fail...");
				}
			}


}
