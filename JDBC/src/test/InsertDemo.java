package test;

import java.sql.Connection;
import java.sql.PreparedStatement;

//ʹ��JDBC�����ݿ��еı���в������ݵĲ���
public class InsertDemo {

	public static void main(String[] args) throws Exception {
		//����company���ݿ�
		Connection con=DBUtil.getCon("company");
		//Ԥ����SQL���
		String sql="insert into t_employee values(?,?,?,?,?,?,?,?)";
		PreparedStatement prep=con.prepareStatement(sql);
		prep.setInt(1, 6666);//����Ա�����
		prep.setString(2, "bobo");//����Ա������
		prep.setString(3,"manager");//����Ա��ְλ
		prep.setInt(4, 7566);//�����쵼���
		prep.setString(5,"2021-10-22");//������ְ����
		prep.setDouble(6, 2000);//���빤��sal
		prep.setDouble(7, 200);//�������
		prep.setInt(8, 10);//���벿�ű��
		
		//ִ��SQL���
		//prep.executeQuery();
		prep.executeUpdate();
		System.out.print("����ɹ���");
		
		//�ر����ݿ������
		con.close();

	}

}
