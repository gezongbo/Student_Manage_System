package Student_Manage_System;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBUtil {
	//��װһ����ȡ���ݿ����ӵķ���,dbname������������ݿ������
	//�������ݿ����������޸�
	public static Connection getCon(String dbname) throws Exception
	{
		//1. ע���������
		Class .forName("com.mysql.jdbc.Driver");
		//2.������ݿ������
		//(1).����mysql��url��ַ
		String url="jdbc:mysql://localhost:3306/"+dbname;
		//(2).����mysql���û���
		String username="root";
		//(3).����mysql������
		String pwd="123456";
		
		Connection con=DriverManager.getConnection(url, username, pwd);
		System.out.println("MySQL���ӳɹ���"+con);
		return con;
	}
	
	
}
