package Student_Manage_System;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;


//删除学生信息操作
public class Delete {
	//根据学生的学号和姓名，在学生信息表中删除该学生信息
	public static void Delete_toinfo(String id,String name) throws Exception{
		//连接company数据库
		Connection con=DBUtil.getCon("studentdb");
		String sql="delete from student_info where ID=? and Name=?";
		PreparedStatement prep=con.prepareStatement(sql);
		//设置sql语句中的问号，参数1：数字，从1开始，表示第几个问号
		//参数2:对问号设置的内容;
		prep.setString(1, id);
		prep.setString(2, name);
		//4.执行SQL语句，适用于修改，插入，删除；
		prep.executeUpdate();
		System.out.println("学生信息删除成功");
		JOptionPane.showMessageDialog(null, "学生信息删除成功!");
		//5.关闭数据库的连接
		con.close();
		
	}
	//根据学生的学号和姓名，在学生成绩表中删除该学生信息
	public static void Delete_toscore(String id,String name) throws Exception{
		//连接company数据库
		Connection con=DBUtil.getCon("studentdb");
		String sql="delete from student_score where ID=? and Name=?";
		PreparedStatement prep=con.prepareStatement(sql);
		//设置sql语句中的问号，参数1：数字，从1开始，表示第几个问号
		//参数2:对问号设置的内容;
		prep.setString(1, id);
		prep.setString(2, name);
		//4.执行SQL语句，适用于修改，插入，删除；
		prep.executeUpdate();
		System.out.println("学生成绩删除成功");
		JOptionPane.showMessageDialog(null, "学生成绩删除成功!");
		//5.关闭数据库的连接
		con.close();
		
	}

}
