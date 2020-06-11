package broker.twotier.test;

import broker.twotier.dao.Database;
import broker.twotier.vo.CustomerRec;

public class DatabaseTest {

	public static void main(String[] args) throws Exception{
		Database db = new Database("127.0.0.1");
		db.addCustomer(new CustomerRec("123-123", "아이유", "판교"));

	}

}
 