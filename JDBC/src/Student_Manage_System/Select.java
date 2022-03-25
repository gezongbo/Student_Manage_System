package Student_Manage_System;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;


//查找学生信息操作
public class Select {
	static boolean is_select=false;//是否查找成功
	//显示学生信息
	public void display1(ResultSet result) throws Exception
	{
//		System.out.println("学号，姓名，性别，年龄，入学日期，专业，班级，家庭地址，联系方式");
//		DBUtil.notice("学号，姓名，性别，年龄，入学日期，专业，班级，家庭地址，联系方式\n");
		while(result.next()){
			is_select=true;
			JOptionPane.showMessageDialog(null, "学号："+result.getInt("ID")+","+"姓名："+result.getString("Name")+","+"性别："+result.getString("Sex")+","
					+"年龄："+result.getInt("Age")+","+"入学日期："+result.getString("Studydate")+","+"专业："+result.getString("Major")+","
					+"班级："+result.getInt("Class")+","+"地址："+result.getString("Address")+","+"联系方式："+result.getString("Tel"));

			System.out.println("学号："+result.getInt("ID")+","+"姓名："+result.getString("Name")+","+"性别："+result.getString("Sex")+","
					+"年龄："+result.getInt("Age")+","+"入学日期："+result.getString("Studydate")+","+"专业："+result.getString("Major")+","
					+"班级："+result.getInt("Class")+","+"地址："+result.getString("Address")+","+"联系方式："+result.getString("Tel"));
		}
	}
	//显示学生成绩
	public void display2(ResultSet result) throws Exception{
//		System.out.println("学号，姓名，专业，班级，Math，Java，MySQL");
//		DBUtil.notice("学号，姓名，专业，班级，Math，Java，MySQL");
		while(result.next()){
			is_select=true;
			JOptionPane.showMessageDialog(null, "学号："+result.getInt("ID")+","+"姓名："+result.getString("Name")+","+
					"专业："+result.getString("Major")+","+"班级："+result.getInt("Class")+","+
					"Math成绩："+result.getString("Math")+","+"Java成绩："+result.getString("Java")+","+
					"MySQL成绩："+result.getString("MySQL"));
			System.out.println("学号："+result.getInt("ID")+","+"姓名："+result.getString("Name")+","+
					"专业："+result.getString("Major")+","+"班级："+result.getInt("Class")+","+
					"Math成绩："+result.getString("Math")+","+"Java成绩："+result.getString("Java")+","+
					"MySQL成绩："+result.getString("MySQL"));
		}
	}
	//根据ID查找学生信息，用于判断该学号是否添加到信息表
	public static boolean Select_info_ID(String id) throws Exception{
		Connection con=DBUtil.getCon("studentdb");
		//预编译SQL语句
		String sql="select * from student_info where ID=? ";
		PreparedStatement prep=con.prepareStatement(sql);
		prep.setString(1, id);
		//执行SQL语句
		ResultSet result=prep.executeQuery();
		boolean is_select=false;
		if(result.next()){
			System.out.println("查找成功！");
			is_select=true;
		}
			
		//关闭数据库的连接
		con.close();
		return is_select;
	}
	//根据ID查找学生成绩,用于判断该学号是否添加到成绩表
	public static boolean Select_score_ID(String id) throws Exception{
		Connection con=DBUtil.getCon("studentdb");
		//预编译SQL语句
		String sql="select * from student_score where ID=? ";
		PreparedStatement prep=con.prepareStatement(sql);
		prep.setString(1, id);
		//执行SQL语句
		ResultSet result=prep.executeQuery();
		boolean is_select=false;
		if(result.next()){
			System.out.println("查找成功！");
			is_select=true;
		}
		//关闭数据库的连接
		con.close();
		return is_select;
	}
	//查找全部学生信息
	public static void Select_info() throws Exception{
		Connection con=DBUtil.getCon("studentdb");
		//预编译SQL语句
		String sql="select * from student_info ";
		PreparedStatement prep=con.prepareStatement(sql);
		//执行SQL语句
		ResultSet result=prep.executeQuery();
		Select s=new Select();
		System.out.print("全部学生信息查找成功！");
		JOptionPane.showMessageDialog(null, "全部学生信息查找成功！");
		s.display1(result);
		//关闭数据库的连接
		con.close();
	}
	//根据ID and Name 查找学生信息
	public static boolean Select_info(String id,String name) throws Exception{
		Connection con=DBUtil.getCon("studentdb");
		//预编译SQL语句
		String sql="select * from student_info where ID=? and Name=?";
		PreparedStatement prep=con.prepareStatement(sql);
		prep.setString(1, id);
		prep.setString(2, name);
		//执行SQL语句
		ResultSet result=prep.executeQuery();
		is_select=false;
		Select s=new Select();
		s.display1(result);

			
			
		//关闭数据库的连接
		con.close();
		return is_select;
	}
	//根据Major查找学生信息
	public static boolean Select_major_info(String major) throws Exception{
		Connection con=DBUtil.getCon("studentdb");
		//预编译SQL语句
		String sql="select * from student_info where Major=?";
		PreparedStatement prep=con.prepareStatement(sql);
		prep.setString(1, major);
		//执行SQL语句
		ResultSet result=prep.executeQuery();
		is_select=false;
		Select s=new Select();
		s.display1(result);
			
		//关闭数据库的连接
		con.close();
		return is_select;
	}
	//根据Class查找学生信息
	public static boolean Select_class_info(String classid) throws Exception{
		Connection con=DBUtil.getCon("studentdb");
		//预编译SQL语句
		String sql="select * from student_info where Class=?";
		PreparedStatement prep=con.prepareStatement(sql);
		prep.setString(1, classid);
		//执行SQL语句
		ResultSet result=prep.executeQuery();
		ResultSet result1=result;
		Select s=new Select();
		is_select=false;
		
//			System.out.print("学生信息查找成功！");
//			JOptionPane.showMessageDialog(null, "学生信息查找成功！");
		s.display1(result);
		//关闭数据库的连接
		con.close();
		return is_select;
	}
	
	//查找全部学生成绩
	public static void Select_score() throws Exception{
		Connection con=DBUtil.getCon("studentdb");
		//预编译SQL语句
		String sql="select * from student_score";
		PreparedStatement prep=con.prepareStatement(sql);
		//执行SQL语句
		ResultSet result=prep.executeQuery();
		Select s=new Select();
		System.out.print("全部学生成绩查找成功！");
		JOptionPane.showMessageDialog(null, "全部学生成绩查找成功！");
		s.display2(result);
		//关闭数据库的连接
		con.close();
	}
	//根据ID 和姓名，查找学生成绩
	public static boolean Select_score(String id,String name) throws Exception{
		Connection con=DBUtil.getCon("studentdb");
		//预编译SQL语句
		String sql="select * from student_score where ID=? and Name=?";
		PreparedStatement prep=con.prepareStatement(sql);
		prep.setString(1, id);
		prep.setString(2, name);
		//执行SQL语句
		ResultSet result=prep.executeQuery();
		is_select=false;
		Select s=new Select();
		s.display2(result);
		
//			System.out.print("学生成绩查找成功！");
//			JOptionPane.showMessageDialog(null, "学生成绩查找成功！");
			
			

		//关闭数据库的连接
		con.close();
		return is_select;
	}
	//根据Major查找学生成绩
	public static boolean Select_major_score(String major) throws Exception{
		Connection con=DBUtil.getCon("studentdb");
		//预编译SQL语句
		String sql="select * from student_score where Major=?";
		PreparedStatement prep=con.prepareStatement(sql);
		prep.setString(1, major);
		//执行SQL语句
		ResultSet result=prep.executeQuery();
		Select s=new Select();
		is_select=false;
		
//			System.out.print("学生成绩查找成功！");
//			JOptionPane.showMessageDialog(null, "学生成绩查找成功！");
		s.display2(result);

		//关闭数据库的连接
		con.close();
		return is_select;
	}
	//根据Class查找学生成绩
	public static boolean Select_class_score(String classid) throws Exception{
		Connection con=DBUtil.getCon("studentdb");
		//预编译SQL语句
		String sql="select * from student_score where Class=?";
		PreparedStatement prep=con.prepareStatement(sql);
		prep.setString(1, classid);
		//执行SQL语句
		ResultSet result=prep.executeQuery();
		ResultSet result1=result;
		Select s=new Select();
		is_select=false;
		
//			System.out.print("学生成绩查找成功！");
//			JOptionPane.showMessageDialog(null, "学生成绩查找成功！");
		s.display2(result);

		//关闭数据库的连接
		con.close();
		return is_select;
	}
	//查找avg
    public static void Select_avg() throws Exception{
    	Connection con=DBUtil.getCon("studentdb");
		//预编译SQL语句
		String sql="select avg(Math),avg(Java),avg(MySQL) from student_score ";
		PreparedStatement prep=con.prepareStatement(sql);
		//执行SQL语句
		ResultSet result=prep.executeQuery();
		
		System.out.println("查看各科成绩平均分：Math，Java，MySQL");
		JOptionPane.showMessageDialog(null, "查看各科成绩平均分：Math，Java，MySQL");
		while(result.next()){
				JOptionPane.showMessageDialog(null, "Math平均分："+result.getString("avg(Math)")+","+"Java平均分："+result.getString("avg(Java)")+","+
						"MySQL平均分："+result.getString("avg(MySQL)"));
				System.out.println("Math平均分："+result.getString("avg(Math)")+","+"Java平均分："+result.getString("avg(Java)")+","+
						"MySQL平均分："+result.getString("avg(MySQL)"));
			}
		
		//关闭数据库的连接
		con.close();
	}
	//查找max
    public static void Select_max() throws Exception{
    	Connection con=DBUtil.getCon("studentdb");
		//预编译SQL语句
		String sql="select max(Math),max(Java),max(MySQL) from student_score";
		PreparedStatement prep=con.prepareStatement(sql);
		//执行SQL语句
		ResultSet result=prep.executeQuery();
		
		System.out.println("查看各科成绩最高分：Math，Java，MySQL");
		JOptionPane.showMessageDialog(null,"查看各科成绩最高分：Math，Java，MySQL");
		while(result.next()){
				JOptionPane.showMessageDialog(null,"Math最高分："+result.getString("max(Math)")+","+"Java最高分："+result.getString("max(Java)")+","+"MySQL最高分："+result.getString("max(MySQL)"));
				System.out.println("Math最高分："+result.getString("max(Math)")+","+"Java最高分："+result.getString("max(Java)")+","+"MySQL最高分："+result.getString("max(MySQL)"));
			}
		
		//关闭数据库的连接
		con.close();
	}
	//查找min
    public static void Select_min() throws Exception{
    	Connection con=DBUtil.getCon("studentdb");
		//预编译SQL语句
		String sql="select min(Math),min(Java),min(MySQL) from student_score";
		PreparedStatement prep=con.prepareStatement(sql);
		//执行SQL语句
		ResultSet result=prep.executeQuery();
		
		System.out.println("查看各科成绩最低分：Math，Java，MySQL");
		JOptionPane.showMessageDialog(null,"查看各科成绩最低分：Math，Java，MySQL");
			while(result.next()){
				JOptionPane.showMessageDialog(null,"Math最低分："+result.getString("min(Math)")+","+"Java最低分："+result.getString("min(Java)")+","+"MySQL最低分："+result.getString("min(MySQL)"));
				System.out.println("Math最低分："+result.getString("min(Math)")+","+"Java最低分："+result.getString("min(Java)")+","+"MySQL最低分："+result.getString("min(MySQL)"));
			}
		//关闭数据库的连接
		con.close();
	}

}
