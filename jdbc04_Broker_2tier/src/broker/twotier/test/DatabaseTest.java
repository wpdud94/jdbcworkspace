package broker.twotier.test;

import java.util.ArrayList;
import java.util.Vector;

import broker.twotier.dao.impl.Database;
import broker.twotier.vo.CustomerRec;
import broker.twotier.vo.SharesRec;

public class DatabaseTest {

	public static void main(String[] args) throws Exception{
		Database db = new Database("127.0.0.1");
		//db.addCustomer(new CustomerRec("456", "김희애", "서초동"));
		
		//db.deleteCustomer("123");
		
		//db.updateCustomer(new CustomerRec("123", "아이유", "소격동"));
		
		//System.out.println(db.getCustomer("123"));
		
		/*ArrayList<CustomerRec> temp = db.getAllCustomers();
		for(CustomerRec cust : temp) System.out.println(cust);*/
		
		db.buyShares("123", "JDK", 500);
		Vector<SharesRec> temppt = db.getPortfolio("123");
		
		
	}

}
