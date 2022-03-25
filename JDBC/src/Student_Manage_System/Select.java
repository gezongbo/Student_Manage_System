package Student_Manage_System;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;


//����ѧ����Ϣ����
public class Select {
	static boolean is_select=false;//�Ƿ���ҳɹ�
	//��ʾѧ����Ϣ
	public void display1(ResultSet result) throws Exception
	{
//		System.out.println("ѧ�ţ��������Ա����䣬��ѧ���ڣ�רҵ���༶����ͥ��ַ����ϵ��ʽ");
//		DBUtil.notice("ѧ�ţ��������Ա����䣬��ѧ���ڣ�רҵ���༶����ͥ��ַ����ϵ��ʽ\n");
		while(result.next()){
			is_select=true;
			JOptionPane.showMessageDialog(null, "ѧ�ţ�"+result.getInt("ID")+","+"������"+result.getString("Name")+","+"�Ա�"+result.getString("Sex")+","
					+"���䣺"+result.getInt("Age")+","+"��ѧ���ڣ�"+result.getString("Studydate")+","+"רҵ��"+result.getString("Major")+","
					+"�༶��"+result.getInt("Class")+","+"��ַ��"+result.getString("Address")+","+"��ϵ��ʽ��"+result.getString("Tel"));

			System.out.println("ѧ�ţ�"+result.getInt("ID")+","+"������"+result.getString("Name")+","+"�Ա�"+result.getString("Sex")+","
					+"���䣺"+result.getInt("Age")+","+"��ѧ���ڣ�"+result.getString("Studydate")+","+"רҵ��"+result.getString("Major")+","
					+"�༶��"+result.getInt("Class")+","+"��ַ��"+result.getString("Address")+","+"��ϵ��ʽ��"+result.getString("Tel"));
		}
	}
	//��ʾѧ���ɼ�
	public void display2(ResultSet result) throws Exception{
//		System.out.println("ѧ�ţ�������רҵ���༶��Math��Java��MySQL");
//		DBUtil.notice("ѧ�ţ�������רҵ���༶��Math��Java��MySQL");
		while(result.next()){
			is_select=true;
			JOptionPane.showMessageDialog(null, "ѧ�ţ�"+result.getInt("ID")+","+"������"+result.getString("Name")+","+
					"רҵ��"+result.getString("Major")+","+"�༶��"+result.getInt("Class")+","+
					"Math�ɼ���"+result.getString("Math")+","+"Java�ɼ���"+result.getString("Java")+","+
					"MySQL�ɼ���"+result.getString("MySQL"));
			System.out.println("ѧ�ţ�"+result.getInt("ID")+","+"������"+result.getString("Name")+","+
					"רҵ��"+result.getString("Major")+","+"�༶��"+result.getInt("Class")+","+
					"Math�ɼ���"+result.getString("Math")+","+"Java�ɼ���"+result.getString("Java")+","+
					"MySQL�ɼ���"+result.getString("MySQL"));
		}
	}
	//����ID����ѧ����Ϣ�������жϸ�ѧ���Ƿ���ӵ���Ϣ��
	public static boolean Select_info_ID(String id) throws Exception{
		Connection con=DBUtil.getCon("studentdb");
		//Ԥ����SQL���
		String sql="select * from student_info where ID=? ";
		PreparedStatement prep=con.prepareStatement(sql);
		prep.setString(1, id);
		//ִ��SQL���
		ResultSet result=prep.executeQuery();
		boolean is_select=false;
		if(result.next()){
			System.out.println("���ҳɹ���");
			is_select=true;
		}
			
		//�ر����ݿ������
		con.close();
		return is_select;
	}
	//����ID����ѧ���ɼ�,�����жϸ�ѧ���Ƿ���ӵ��ɼ���
	public static boolean Select_score_ID(String id) throws Exception{
		Connection con=DBUtil.getCon("studentdb");
		//Ԥ����SQL���
		String sql="select * from student_score where ID=? ";
		PreparedStatement prep=con.prepareStatement(sql);
		prep.setString(1, id);
		//ִ��SQL���
		ResultSet result=prep.executeQuery();
		boolean is_select=false;
		if(result.next()){
			System.out.println("���ҳɹ���");
			is_select=true;
		}
		//�ر����ݿ������
		con.close();
		return is_select;
	}
	//����ȫ��ѧ����Ϣ
	public static void Select_info() throws Exception{
		Connection con=DBUtil.getCon("studentdb");
		//Ԥ����SQL���
		String sql="select * from student_info ";
		PreparedStatement prep=con.prepareStatement(sql);
		//ִ��SQL���
		ResultSet result=prep.executeQuery();
		Select s=new Select();
		System.out.print("ȫ��ѧ����Ϣ���ҳɹ���");
		JOptionPane.showMessageDialog(null, "ȫ��ѧ����Ϣ���ҳɹ���");
		s.display1(result);
		//�ر����ݿ������
		con.close();
	}
	//����ID and Name ����ѧ����Ϣ
	public static boolean Select_info(String id,String name) throws Exception{
		Connection con=DBUtil.getCon("studentdb");
		//Ԥ����SQL���
		String sql="select * from student_info where ID=? and Name=?";
		PreparedStatement prep=con.prepareStatement(sql);
		prep.setString(1, id);
		prep.setString(2, name);
		//ִ��SQL���
		ResultSet result=prep.executeQuery();
		is_select=false;
		Select s=new Select();
		s.display1(result);

			
			
		//�ر����ݿ������
		con.close();
		return is_select;
	}
	//����Major����ѧ����Ϣ
	public static boolean Select_major_info(String major) throws Exception{
		Connection con=DBUtil.getCon("studentdb");
		//Ԥ����SQL���
		String sql="select * from student_info where Major=?";
		PreparedStatement prep=con.prepareStatement(sql);
		prep.setString(1, major);
		//ִ��SQL���
		ResultSet result=prep.executeQuery();
		is_select=false;
		Select s=new Select();
		s.display1(result);
			
		//�ر����ݿ������
		con.close();
		return is_select;
	}
	//����Class����ѧ����Ϣ
	public static boolean Select_class_info(String classid) throws Exception{
		Connection con=DBUtil.getCon("studentdb");
		//Ԥ����SQL���
		String sql="select * from student_info where Class=?";
		PreparedStatement prep=con.prepareStatement(sql);
		prep.setString(1, classid);
		//ִ��SQL���
		ResultSet result=prep.executeQuery();
		ResultSet result1=result;
		Select s=new Select();
		is_select=false;
		
//			System.out.print("ѧ����Ϣ���ҳɹ���");
//			JOptionPane.showMessageDialog(null, "ѧ����Ϣ���ҳɹ���");
		s.display1(result);
		//�ر����ݿ������
		con.close();
		return is_select;
	}
	
	//����ȫ��ѧ���ɼ�
	public static void Select_score() throws Exception{
		Connection con=DBUtil.getCon("studentdb");
		//Ԥ����SQL���
		String sql="select * from student_score";
		PreparedStatement prep=con.prepareStatement(sql);
		//ִ��SQL���
		ResultSet result=prep.executeQuery();
		Select s=new Select();
		System.out.print("ȫ��ѧ���ɼ����ҳɹ���");
		JOptionPane.showMessageDialog(null, "ȫ��ѧ���ɼ����ҳɹ���");
		s.display2(result);
		//�ر����ݿ������
		con.close();
	}
	//����ID ������������ѧ���ɼ�
	public static boolean Select_score(String id,String name) throws Exception{
		Connection con=DBUtil.getCon("studentdb");
		//Ԥ����SQL���
		String sql="select * from student_score where ID=? and Name=?";
		PreparedStatement prep=con.prepareStatement(sql);
		prep.setString(1, id);
		prep.setString(2, name);
		//ִ��SQL���
		ResultSet result=prep.executeQuery();
		is_select=false;
		Select s=new Select();
		s.display2(result);
		
//			System.out.print("ѧ���ɼ����ҳɹ���");
//			JOptionPane.showMessageDialog(null, "ѧ���ɼ����ҳɹ���");
			
			

		//�ر����ݿ������
		con.close();
		return is_select;
	}
	//����Major����ѧ���ɼ�
	public static boolean Select_major_score(String major) throws Exception{
		Connection con=DBUtil.getCon("studentdb");
		//Ԥ����SQL���
		String sql="select * from student_score where Major=?";
		PreparedStatement prep=con.prepareStatement(sql);
		prep.setString(1, major);
		//ִ��SQL���
		ResultSet result=prep.executeQuery();
		Select s=new Select();
		is_select=false;
		
//			System.out.print("ѧ���ɼ����ҳɹ���");
//			JOptionPane.showMessageDialog(null, "ѧ���ɼ����ҳɹ���");
		s.display2(result);

		//�ر����ݿ������
		con.close();
		return is_select;
	}
	//����Class����ѧ���ɼ�
	public static boolean Select_class_score(String classid) throws Exception{
		Connection con=DBUtil.getCon("studentdb");
		//Ԥ����SQL���
		String sql="select * from student_score where Class=?";
		PreparedStatement prep=con.prepareStatement(sql);
		prep.setString(1, classid);
		//ִ��SQL���
		ResultSet result=prep.executeQuery();
		ResultSet result1=result;
		Select s=new Select();
		is_select=false;
		
//			System.out.print("ѧ���ɼ����ҳɹ���");
//			JOptionPane.showMessageDialog(null, "ѧ���ɼ����ҳɹ���");
		s.display2(result);

		//�ر����ݿ������
		con.close();
		return is_select;
	}
	//����avg
    public static void Select_avg() throws Exception{
    	Connection con=DBUtil.getCon("studentdb");
		//Ԥ����SQL���
		String sql="select avg(Math),avg(Java),avg(MySQL) from student_score ";
		PreparedStatement prep=con.prepareStatement(sql);
		//ִ��SQL���
		ResultSet result=prep.executeQuery();
		
		System.out.println("�鿴���Ƴɼ�ƽ���֣�Math��Java��MySQL");
		JOptionPane.showMessageDialog(null, "�鿴���Ƴɼ�ƽ���֣�Math��Java��MySQL");
		while(result.next()){
				JOptionPane.showMessageDialog(null, "Mathƽ���֣�"+result.getString("avg(Math)")+","+"Javaƽ���֣�"+result.getString("avg(Java)")+","+
						"MySQLƽ���֣�"+result.getString("avg(MySQL)"));
				System.out.println("Mathƽ���֣�"+result.getString("avg(Math)")+","+"Javaƽ���֣�"+result.getString("avg(Java)")+","+
						"MySQLƽ���֣�"+result.getString("avg(MySQL)"));
			}
		
		//�ر����ݿ������
		con.close();
	}
	//����max
    public static void Select_max() throws Exception{
    	Connection con=DBUtil.getCon("studentdb");
		//Ԥ����SQL���
		String sql="select max(Math),max(Java),max(MySQL) from student_score";
		PreparedStatement prep=con.prepareStatement(sql);
		//ִ��SQL���
		ResultSet result=prep.executeQuery();
		
		System.out.println("�鿴���Ƴɼ���߷֣�Math��Java��MySQL");
		JOptionPane.showMessageDialog(null,"�鿴���Ƴɼ���߷֣�Math��Java��MySQL");
		while(result.next()){
				JOptionPane.showMessageDialog(null,"Math��߷֣�"+result.getString("max(Math)")+","+"Java��߷֣�"+result.getString("max(Java)")+","+"MySQL��߷֣�"+result.getString("max(MySQL)"));
				System.out.println("Math��߷֣�"+result.getString("max(Math)")+","+"Java��߷֣�"+result.getString("max(Java)")+","+"MySQL��߷֣�"+result.getString("max(MySQL)"));
			}
		
		//�ر����ݿ������
		con.close();
	}
	//����min
    public static void Select_min() throws Exception{
    	Connection con=DBUtil.getCon("studentdb");
		//Ԥ����SQL���
		String sql="select min(Math),min(Java),min(MySQL) from student_score";
		PreparedStatement prep=con.prepareStatement(sql);
		//ִ��SQL���
		ResultSet result=prep.executeQuery();
		
		System.out.println("�鿴���Ƴɼ���ͷ֣�Math��Java��MySQL");
		JOptionPane.showMessageDialog(null,"�鿴���Ƴɼ���ͷ֣�Math��Java��MySQL");
			while(result.next()){
				JOptionPane.showMessageDialog(null,"Math��ͷ֣�"+result.getString("min(Math)")+","+"Java��ͷ֣�"+result.getString("min(Java)")+","+"MySQL��ͷ֣�"+result.getString("min(MySQL)"));
				System.out.println("Math��ͷ֣�"+result.getString("min(Math)")+","+"Java��ͷ֣�"+result.getString("min(Java)")+","+"MySQL��ͷ֣�"+result.getString("min(MySQL)"));
			}
		//�ر����ݿ������
		con.close();
	}

}
