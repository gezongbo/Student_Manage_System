package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//ʹ��JDBC��ɶ����ݿ������ݵĲ�ѯ����
public class SelectDemo {

	public static void main(String[] args) throws Exception {
		/*// 1.ע���������
		Class.forName("com.mysql.jdbc.Driver");
		//2.������ݿ������
		//(1) url
		String url="jdbc:mysql://localhost:3306/company";
		//(2) username
		String username="root";
		//(3)pwd
		String pwd="123456";
		Connection con=DriverManager.getConnection(url, username, pwd);
		System.out.println("MySQL���ӳɹ���"+con);
		*/
		Connection con=DBUtil.getCon("company");
		//3.Ԥ����SQL���
		String sql="select * from t_employee";
		PreparedStatement prep=con.prepareStatement(sql);
		//4.ִ��SQL���
		ResultSet result=prep.executeQuery();
		//System.out.println(result);
		//result.next()return true,��ʾHave data;
		//result.next()return false,��ʾNo data;
		while(result.next())
		{
			System.out.println(result.getInt("empno")+"|"+result.getString("ename"));
		}
		//5.�ر����ݿ������
		con.close();
		
	}

}
