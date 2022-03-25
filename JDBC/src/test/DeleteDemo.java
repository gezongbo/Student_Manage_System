package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

//使用JDBC对数据库中的数据进行删除操作
public class DeleteDemo {

	public static void main(String[] args) throws Exception {
		//1. 注册加载驱动
		Class .forName("com.mysql.jdbc.Driver");
		//2.获得数据库的连接
		//(1).连接mysql的url地址
		String url="jdbc:mysql://localhost:3306/company";
		//(2).连接mysql的用户名
		String username="root";
		//(3).连接mysql的密码
		String pwd="123456";
		Connection con=DriverManager.getConnection(url, username, pwd);
		System.out.println("连接："+con);
		//3.预编译SQL语句
		String sql="delete from t_employee where empno=?";
		PreparedStatement prep=con.prepareStatement(sql);
		//设置sql语句中的问号，参数1：数字，从1开始，表示第几个问号
		//参数2:对问号设置的内容;
		prep.setInt(1, 6666);
		//4.执行SQL语句，适用于修改，插入，删除；
		prep.executeUpdate();
		//5.关闭数据库的连接
		con.close();
		System.out.println("删除成功");
	}

}
