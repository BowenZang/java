package cn.markzang.rmi;

import java.io.IOException;

/**
 * <h3>客户端</h3>
 *
 * @author BowenZang
 * @since 2019年02月27日
 */
public class UserClient {

	public static void main(String[] args) throws IOException {
		User user = new User_Stub();
		
		int age = user.getAge();
		
		System.out.println(age);
	}

}
