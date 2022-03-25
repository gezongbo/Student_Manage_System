package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//使用JDBC完成对数据库中数据的查询操作
public class SelectDemo {

	public static void main(String[] args) throws Exception {
		/*// 1.注册加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2.获得数据库的连接
		//(1) url
		String url="jdbc:mysql://localhost:3306/company";
		//(2) username
		String username="root";
		//(3)pwd
		String pwd="123456";
		Connection con=DriverManager.getConnection(url, username, pwd);
		System.out.println("MySQL连接成功！"+con);
		*/
		Connection con=DBUtil.getCon("company");
		//3.预编译SQL语句
		String sql="select * from t_employee";
		PreparedStatement prep=con.prepareStatement(sql);
		//4.执行SQL语句
		ResultSet result=prep.executeQuery();
		//System.out.println(result);
		//result.next()return true,表示Have data;
		//result.next()return false,表示No data;
		while(result.next())
		{
			System.out.println(result.getInt("empno")+"|"+result.getString("ename"));
		}
		//5.关闭数据库的连接
		con.close();
		
	}

}
