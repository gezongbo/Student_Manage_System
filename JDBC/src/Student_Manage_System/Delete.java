package Student_Manage_System;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;


//ɾ��ѧ����Ϣ����
public class Delete {
	//����ѧ����ѧ�ź���������ѧ����Ϣ����ɾ����ѧ����Ϣ
	public static void Delete_toinfo(String id,String name) throws Exception{
		//����company���ݿ�
		Connection con=DBUtil.getCon("studentdb");
		String sql="delete from student_info where ID=? and Name=?";
		PreparedStatement prep=con.prepareStatement(sql);
		//����sql����е��ʺţ�����1�����֣���1��ʼ����ʾ�ڼ����ʺ�
		//����2:���ʺ����õ�����;
		prep.setString(1, id);
		prep.setString(2, name);
		//4.ִ��SQL��䣬�������޸ģ����룬ɾ����
		prep.executeUpdate();
		System.out.println("ѧ����Ϣɾ���ɹ�");
		JOptionPane.showMessageDialog(null, "ѧ����Ϣɾ���ɹ�!");
		//5.�ر����ݿ������
		con.close();
		
	}
	//����ѧ����ѧ�ź���������ѧ���ɼ�����ɾ����ѧ����Ϣ
	public static void Delete_toscore(String id,String name) throws Exception{
		//����company���ݿ�
		Connection con=DBUtil.getCon("studentdb");
		String sql="delete from student_score where ID=? and Name=?";
		PreparedStatement prep=con.prepareStatement(sql);
		//����sql����е��ʺţ�����1�����֣���1��ʼ����ʾ�ڼ����ʺ�
		//����2:���ʺ����õ�����;
		prep.setString(1, id);
		prep.setString(2, name);
		//4.ִ��SQL��䣬�������޸ģ����룬ɾ����
		prep.executeUpdate();
		System.out.println("ѧ���ɼ�ɾ���ɹ�");
		JOptionPane.showMessageDialog(null, "ѧ���ɼ�ɾ���ɹ�!");
		//5.�ر����ݿ������
		con.close();
		
	}

}
