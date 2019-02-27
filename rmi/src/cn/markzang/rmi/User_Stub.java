package cn.markzang.rmi;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * <h3>通信</h3>
 *
 * @author BowenZang
 * @since 2019年02月27日
 */
public class User_Stub extends User {
	
	private Socket socket;
	
	public User_Stub() throws IOException {
		this.socket = new Socket("localhost", 8888);
	}
	
	public int getAge() {
		try {
			ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
			outputStream.writeObject("age");
			outputStream.flush();
			
			ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
			
			return inputStream.readInt();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
}
