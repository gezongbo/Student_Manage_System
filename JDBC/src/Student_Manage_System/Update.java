package Student_Manage_System;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;
//�޸�ѧ������Ϣ������ͨ��ѧ�Ų���ѧ��������Ҫ��������ѧ����ȷ��Ϣ�����޸�
//�����и����⣬ѧ����ѧ����Ψһȷ���ģ������޸ġ�

public class Update {
    
	//����ѧ����ѧ�ţ��޸�ѧ����Ϣ���е�������Ϣ
	public static void Update_toinfo(String id,String name,String nsex,
			String nage,String nstudydate,String nmajor,int nclass,String naddress,String ntel) throws Exception{
		//����company���ݿ�
		Connection con=DBUtil.getCon("studentdb");
		String sql="update student_info set Sex=?,Age=?,Studydate=?,Major=?," +
				"Class=?,Address=?,Tel=?,Name=? where ID=?";
		PreparedStatement prep=con.prepareStatement(sql);
		//����sql����е��ʺţ�����1�����֣���1��ʼ����ʾ�ڼ����ʺ�
		//����2:���ʺ����õ�����;
		//�ж������Ƿ�Ϊ��

		prep.setString(1, nsex);//�޸ĺ���Ա�
		prep.setString(2, nage);//�޸ĺ������
		prep.setString(3, nstudydate);//�޸ĺ����ѧ����
		prep.setString(4, nmajor);//�޸ĺ��רҵ
		prep.setInt(5, nclass);//�޸ĺ�İ༶
		prep.setString(6, naddress);//�޸ĺ�ĵ�ַ
		prep.setString(7, ntel);//�޸ĺ����ϵ��ʽ
		prep.setString(8,name);//�޸ĺ��ѧ��ѧ��
		prep.setString(9, id);//Ҫ�޸�ѧ��������

		//4.ִ��SQL��䣬�������޸ģ����룬ɾ����
		prep.executeUpdate();
		System.out.println("ѧ����Ϣ�޸ĳɹ�");
		JOptionPane.showMessageDialog(null, "ѧ����Ϣ�޸ĳɹ�");
		//5.�ر����ݿ������
		con.close();
		
	}
	//����ѧ����ѧ�ţ��޸�ѧ���ɼ����е�������Ϣ
	public static void Update_toscore(String id,String name,String nmajor,
			int nclass,String nmath,String njava,String nmysql) throws Exception{
		//����company���ݿ�
		Connection con=DBUtil.getCon("studentdb");
		String sql="update student_score set Major=?,Class=?,Math=?," +
				"Java=?,MySQL=?,Name=? where ID=?";
		PreparedStatement prep=con.prepareStatement(sql);
		//����sql����е��ʺţ�����1�����֣���1��ʼ����ʾ�ڼ����ʺ�
		//����2:���ʺ����õ�����;
		prep.setString(1, nmajor);//�޸ĺ��רҵ
		prep.setInt(2, nclass);//�޸ĺ�İ༶
		prep.setString(3, nmath);//�޸ĺ��math�ɼ�
		prep.setString(4, njava);//�޸ĺ��java�ɼ�
		prep.setString(5, nmysql);//�޸ĺ��mysql�ɼ�
		prep.setString(6, name);//�޸ĺ��ѧ��ѧ��
		prep.setString(7, id);//Ҫ�޸�ѧ��������
		//4.ִ��SQL��䣬�������޸ģ����룬ɾ����
		prep.executeUpdate();
		System.out.println("ѧ���ɼ��޸ĳɹ�");
		JOptionPane.showMessageDialog(null, "ѧ���ɼ��޸ĳɹ�");
		//5.�ر����ݿ������
		con.close();
		
	}

}
