package broker.three.server;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * Server Side의 Process class...
 * 서버소켓을 가지면서 클라이언트의 접속을 기다린다...
 * 해당 클래스는 무한 루핑을 돌면서 계속적으로 서버에 접속하는 클라이언트를 accept하게 될 것이다.
 * 리스너 쓰레드....
 */
public class ProtocolHandler extends Thread{
	//필드선언
	ServerSocket server;
	Socket s;
	JuryThread jury;
	Database db;
	public static final int MIDDLE_PORT = 60000;	
	public ProtocolHandler(String serverIp){
		try {
			//ServerSocket, Database 생성
			server = new ServerSocket(MIDDLE_PORT);
			db = new Database(serverIp);
		}catch(Exception e) {
			
		}
		System.out.println("start protocol Handler.....service port :: "+MIDDLE_PORT);
	}	
	public void run() {
		//무한로핑 돌면서 클라이언특라 접속하면 받아서 소켓을 리턴...그것을 Jury에게 던진다.
		while(true) {
			try {
				s=server.accept(); //Socket이 리턴되면...jury생성
				jury = new JuryThread(s,db);
				jury.start();
			}catch(Exception e) {
				
			}
		}			
	}	
	public static void main (String[]  args) {
		ProtocolHandler handler  = new ProtocolHandler("127.0.0.1");
		handler.start();
	}
}







