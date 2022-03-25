package Student_Manage_System;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;


public class Insert {
	//��ѧ����Ϣ�����ѧ����Ϣ
    public static void Inser_toinfo(String id,String name
    		,String sex,int age,String date,String major,int classid
    		,String address,String tel) throws Exception{
    	//����company���ݿ�
		Connection con=DBUtil.getCon("studentdb");
		//Ԥ����SQL���
		String sql="insert into student_info values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement prep=con.prepareStatement(sql);
		prep.setString(1, id);//����ID
		prep.setString(2, name);//����Name
		prep.setString(3,sex);//����Sex
		prep.setInt(4, age);//����Age
		prep.setString(5,date);//����StudyDate
		prep.setString(6, major);//����Major
		prep.setInt(7, classid);//����Class
		prep.setString(8, address);//����Address
		prep.setString(9, tel);//����Tel
		
		//ִ��SQL���
		prep.executeUpdate();
		System.out.print("ѧ����Ϣ����ɹ���");
		JOptionPane.showMessageDialog(null, "ѧ����Ϣ����ɹ���");
		//�ر����ݿ������
		con.close();

    }
    //��ѧ���ɼ������ѧ���ɼ�
    public static void Inser_toscore(String id,String name,String major
    		,int classid,String math,String java,String mysql) throws Exception{
    	//����company���ݿ�
		Connection con=DBUtil.getCon("studentdb");
		//Ԥ����SQL���
		String sql="insert into student_score values(?,?,?,?,?,?,?)";
		PreparedStatement prep=con.prepareStatement(sql);
		prep.setString(1, id);//����ID
		prep.setString(2, name);//����Name
		prep.setString(3, major);//����Major
		prep.setInt(4, classid);//����Class
		prep.setString(5, math);//����math score
		prep.setString(6, java);//����java score
		prep.setString(7, mysql);//����mysql score
		
		//ִ��SQL���
		prep.executeUpdate();
		System.out.print("ѧ���ɼ�����ɹ���");
		JOptionPane.showMessageDialog(null, "ѧ���ɼ�����ɹ���");
		
		//�ر����ݿ������
		con.close();
    }

}
