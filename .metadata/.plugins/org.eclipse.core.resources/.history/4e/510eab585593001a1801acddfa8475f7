package broker.twotier.vo;
/**
 * 
 * @author HaBaRee
 * 
 * 고객에 대한 정보를 저장하는 Record Class...
 * 해당 고객은 주식을 사고 파는데 연관이 있는 고객이다..
 * 
 * 주식을 보유하지 않는 고객일수 있고 | 주식을 보유한 고객일수 있다.
 *
 */

import java.util.Vector;

public class CustomerRec {
	private String ssn;
	private String name; //컬럼명은 cust_name
	private String address;
	
	//
	private Vector<SharesRec> portfolio;

	public CustomerRec(String ssn, String name, String address, Vector<SharesRec> portfolio) {
		super();
		this.ssn = ssn;
		this.name = name;
		this.address = address;
		this.portfolio = portfolio;
	}
	
	public CustomerRec(String ssn, String name, String address) {
		this(ssn, name, address,null);		
	}
	
	public CustomerRec() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Vector<SharesRec> getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(Vector<SharesRec> portfolio) {
		this.portfolio = portfolio;
	}

	@Override
	public String toString() {
		return "CustomerRec [ssn=" + ssn + ", name=" + name + ", address=" + address + ", portfolio=" + portfolio + "]";
	}
}
























