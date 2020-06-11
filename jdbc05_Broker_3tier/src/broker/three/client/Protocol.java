package broker.three.client;
/*
 * Protocol + jury 완성하면 끝
 * 서버 --------------- ProtocoHandler 돌림녀 됨
 * 클라이언트로 돌려서 똑같이 나오면 됨
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import javax.activation.CommandInfo;

import broker.three.exception.DuplicateSSNException;
import broker.three.exception.InvalidTransactionException;
import broker.three.exception.RecordNotFoundException;
import broker.three.vo.CustomerRec;
import broker.three.vo.SharesRec;
import broker.three.vo.StockRec;

//Datebase의 동명이인...
public class Protocol {
	
	public Protocol(String serverIp) {
		
	}
	
	//공통적인 로직 작성... 중복되는 코드
	public void writeCommand(Command cmd) {
		try {
			oos.writeObject(cmd);
			System.out.println("Client writeCommand.... end...");
		}catch(IOException e) {
			System.out.println("Client writeCommand.... error...");
		}
		
	}
	
	public int getResponse(); {// status 코드로 리턴받기 때문에 리턴타입 = int{
	//Readcommand가 아닌... Identifier로서 훌륭후다 
	//readObject()+getResult().getStatus() --> status code
		try {//응답 결과 : 성공 or 실패 & 리터값
			//굉장히 중요. 이해하면서 프로그래밍한다. 
			cmd=(Command)ois.readObject();
			System.out.println("client readObject()...end...");
		}catch{Exception e){
			System.out.println("client readObject()...erre..."+e);
		}
		//0, DuplicateE(-2), Record(-1), Invalid(-3)
		int status = cmd.getResults().getStatus(); 
		return status;
	}
	
	public void addCustomer(CustomerRec cust) throws DuplicateSSNException{
		/*
		 * 1. 도시락 싼다
		 * 2. 던진다... jury가 받는다
		 * ---------------------
		 * 3. 주리가 던진 도시락을 받는다
		 * 4. 도시락을 푼다
		 */
		cmd = new CommandInfo(Command.ADDCUSTOMER);
		cmd.setargs(str);
		
		writecommand(cmd);
		
		int status = gerResponse();
		if(status==2) throw new DuplicateSSNException("그런 회원 있습니다.")
		
	}
	
	public void deleteCustomer(String ssn) throws RecordNotFoundException{
		
	}
	
	public void updateCustomer(CustomerRec cust) throws RecordNotFoundException{
		
	}
	
	public Vector<SharesRec> getPortfolio(String ssn){
		return null;
	}
	
	public CustomerRec getCustomer(String ssn) {
		return null;
	}
	
	public ArrayList<CustomerRec> getAllCustomers(){
		return null;
	}
	
	public ArrayList<StockRec> getAllStocks(){
		return null;
	}
	
	public void buyShares(String ssn, String symbol, int quantity) {
		
	}
	
	public void sellShares(String ssn, String symbol, int quantity) throws InvalidTransactionException,RecordNotFoundException{
		
	}
}
