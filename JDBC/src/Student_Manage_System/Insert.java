package Student_Manage_System;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;


public class Insert {
	//往学生信息表插入学生信息
    public static void Inser_toinfo(String id,String name
    		,String sex,int age,String date,String major,int classid
    		,String address,String tel) throws Exception{
    	//连接company数据库
		Connection con=DBUtil.getCon("studentdb");
		//预编译SQL语句
		String sql="insert into student_info values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement prep=con.prepareStatement(sql);
		prep.setString(1, id);//插入ID
		prep.setString(2, name);//插入Name
		prep.setString(3,sex);//插入Sex
		prep.setInt(4, age);//插入Age
		prep.setString(5,date);//插入StudyDate
		prep.setString(6, major);//插入Major
		prep.setInt(7, classid);//插入Class
		prep.setString(8, address);//插入Address
		prep.setString(9, tel);//插入Tel
		
		//执行SQL语句
		prep.executeUpdate();
		System.out.print("学生信息插入成功！");
		JOptionPane.showMessageDialog(null, "学生信息插入成功！");
		//关闭数据库的连接
		con.close();

    }
    //往学生成绩表插入学生成绩
    public static void Inser_toscore(String id,String name,String major
    		,int classid,String math,String java,String mysql) throws Exception{
    	//连接company数据库
		Connection con=DBUtil.getCon("studentdb");
		//预编译SQL语句
		String sql="insert into student_score values(?,?,?,?,?,?,?)";
		PreparedStatement prep=con.prepareStatement(sql);
		prep.setString(1, id);//插入ID
		prep.setString(2, name);//插入Name
		prep.setString(3, major);//插入Major
		prep.setInt(4, classid);//插入Class
		prep.setString(5, math);//插入math score
		prep.setString(6, java);//插入java score
		prep.setString(7, mysql);//插入mysql score
		
		//执行SQL语句
		prep.executeUpdate();
		System.out.print("学生成绩插入成功！");
		JOptionPane.showMessageDialog(null, "学生成绩插入成功！");
		
		//关闭数据库的连接
		con.close();
    }

}
