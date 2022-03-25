package test;

import java.sql.Connection;
import java.sql.PreparedStatement;

//使用JDBC对数据库中的表进行插入数据的操作
public class InsertDemo {

	public static void main(String[] args) throws Exception {
		//连接company数据库
		Connection con=DBUtil.getCon("company");
		//预编译SQL语句
		String sql="insert into t_employee values(?,?,?,?,?,?,?,?)";
		PreparedStatement prep=con.prepareStatement(sql);
		prep.setInt(1, 6666);//插入员工编号
		prep.setString(2, "bobo");//插入员工姓名
		prep.setString(3,"manager");//插入员工职位
		prep.setInt(4, 7566);//插入领导编号
		prep.setString(5,"2021-10-22");//插入入职日期
		prep.setDouble(6, 2000);//插入工资sal
		prep.setDouble(7, 200);//插入提成
		prep.setInt(8, 10);//插入部门编号
		
		//执行SQL语句
		//prep.executeQuery();
		prep.executeUpdate();
		System.out.print("插入成功！");
		
		//关闭数据库的连接
		con.close();

	}

}
