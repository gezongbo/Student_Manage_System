package Student_Manage_System;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;
//修改学生的信息，这里通过学号查找学生，并需要重新输入学生正确信息用于修改
//这里有个问题，学生的学号是唯一确定的，不能修改。

public class Update {
    
	//根据学生的学号，修改学生信息表中的其他信息
	public static void Update_toinfo(String id,String name,String nsex,
			String nage,String nstudydate,String nmajor,int nclass,String naddress,String ntel) throws Exception{
		//连接company数据库
		Connection con=DBUtil.getCon("studentdb");
		String sql="update student_info set Sex=?,Age=?,Studydate=?,Major=?," +
				"Class=?,Address=?,Tel=?,Name=? where ID=?";
		PreparedStatement prep=con.prepareStatement(sql);
		//设置sql语句中的问号，参数1：数字，从1开始，表示第几个问号
		//参数2:对问号设置的内容;
		//判断内容是否为空

		prep.setString(1, nsex);//修改后的性别
		prep.setString(2, nage);//修改后的年龄
		prep.setString(3, nstudydate);//修改后的入学日期
		prep.setString(4, nmajor);//修改后的专业
		prep.setInt(5, nclass);//修改后的班级
		prep.setString(6, naddress);//修改后的地址
		prep.setString(7, ntel);//修改后的联系方式
		prep.setString(8,name);//修改后的学生学号
		prep.setString(9, id);//要修改学生的姓名

		//4.执行SQL语句，适用于修改，插入，删除；
		prep.executeUpdate();
		System.out.println("学生信息修改成功");
		JOptionPane.showMessageDialog(null, "学生信息修改成功");
		//5.关闭数据库的连接
		con.close();
		
	}
	//根据学生的学号，修改学生成绩表中的其他信息
	public static void Update_toscore(String id,String name,String nmajor,
			int nclass,String nmath,String njava,String nmysql) throws Exception{
		//连接company数据库
		Connection con=DBUtil.getCon("studentdb");
		String sql="update student_score set Major=?,Class=?,Math=?," +
				"Java=?,MySQL=?,Name=? where ID=?";
		PreparedStatement prep=con.prepareStatement(sql);
		//设置sql语句中的问号，参数1：数字，从1开始，表示第几个问号
		//参数2:对问号设置的内容;
		prep.setString(1, nmajor);//修改后的专业
		prep.setInt(2, nclass);//修改后的班级
		prep.setString(3, nmath);//修改后的math成绩
		prep.setString(4, njava);//修改后的java成绩
		prep.setString(5, nmysql);//修改后的mysql成绩
		prep.setString(6, name);//修改后的学生学号
		prep.setString(7, id);//要修改学生的姓名
		//4.执行SQL语句，适用于修改，插入，删除；
		prep.executeUpdate();
		System.out.println("学生成绩修改成功");
		JOptionPane.showMessageDialog(null, "学生成绩修改成功");
		//5.关闭数据库的连接
		con.close();
		
	}

}
