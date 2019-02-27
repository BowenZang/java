package cn.markzang.rmi;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * <h3>通信</h3>
 *
 * <p>ServerSocket</p>
 *
 * @author BowenZang
 * @since 2019年02月27日
 */
public class User_Skeleton extends Thread {
	
	private UserServer userServer;
	
	public User_Skeleton(UserServer userServer) {
		this.userServer = userServer;
	}
	
	@Override
	public void run() {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(8888);
			Socket socket = serverSocket.accept();
			
			while (null != socket) {
				ObjectInputStream read = new ObjectInputStream(socket.getInputStream());
				
				String method = (String) read.readObject();
				
				if ("age".equals(method)) {
					int age = userServer.getAge();
					// 传送给客户端
					ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
					outputStream.writeInt(age);
					outputStream.flush();
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (null != serverSocket) {
				try {
					serverSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
