package Student_Manage_System;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBUtil {
	//封装一个获取数据库连接的方法,dbname这个参数是数据库的名字
	//还有数据库密码自行修改
	public static Connection getCon(String dbname) throws Exception
	{
		//1. 注册加载驱动
		Class .forName("com.mysql.jdbc.Driver");
		//2.获得数据库的连接
		//(1).连接mysql的url地址
		String url="jdbc:mysql://localhost:3306/"+dbname;
		//(2).连接mysql的用户名
		String username="root";
		//(3).连接mysql的密码
		String pwd="123456";
		
		Connection con=DriverManager.getConnection(url, username, pwd);
		System.out.println("MySQL连接成功！"+con);
		return con;
	}
	
	
}
