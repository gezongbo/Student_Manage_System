package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

//ʹ��JDBC�����ݿ��е����ݽ���ɾ������
public class DeleteDemo {

	public static void main(String[] args) throws Exception {
		//1. ע���������
		Class .forName("com.mysql.jdbc.Driver");
		//2.������ݿ������
		//(1).����mysql��url��ַ
		String url="jdbc:mysql://localhost:3306/company";
		//(2).����mysql���û���
		String username="root";
		//(3).����mysql������
		String pwd="123456";
		Connection con=DriverManager.getConnection(url, username, pwd);
		System.out.println("���ӣ�"+con);
		//3.Ԥ����SQL���
		String sql="delete from t_employee where empno=?";
		PreparedStatement prep=con.prepareStatement(sql);
		//����sql����е��ʺţ�����1�����֣���1��ʼ����ʾ�ڼ����ʺ�
		//����2:���ʺ����õ�����;
		prep.setInt(1, 6666);
		//4.ִ��SQL��䣬�������޸ģ����룬ɾ����
		prep.executeUpdate();
		//5.�ر����ݿ������
		con.close();
		System.out.println("ɾ���ɹ�");
	}

}
