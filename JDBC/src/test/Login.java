package test;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

//��¼����
public class Login {
	JTextField name=new JTextField(10);
	JPasswordField pwd=new JPasswordField(10);
    public void Init(){
    	JFrame f=new JFrame();
    	JPanel p=new JPanel();
    	JLabel label_name=new JLabel();
		JLabel label_pwd = new JLabel();
		JButton btn1=new JButton("��¼");
		JButton btn2=new JButton("ע��");
    	JButton btn3=new JButton("ȡ��");
    	//����MyClick�ڲ��࣬�󶨵���ťbtn1;
    	MyClick mc=new MyClick();
    	btn1.addMouseListener(mc);
    	p.add(label_name);
    	p.add(label_pwd);
    	p.add(name);
    	p.add(pwd);
    	p.add(btn1);
    	p.add(btn2);
    	f.add(p);
    	f.setVisible(true);//���ô���ɼ�
    	f.setSize(600,600);
    	f.setLocation(700, 100);
    	
    	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�رմ���
    }
	public static void main(String[] args) {
		Login login=new Login();
		login.Init();

	}
	//�����ڲ���--ʵ�ְ�ť���¼�����
	public class MyClick extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			//��¼�����ݿ����б���ж��Ƿ��¼�ɹ�����
			//ע�᣺���������ݡ�
			//��ȡ��¼���˺ź�����
			String username=name.getText();
			String userpwd=pwd.getText();
			System.out.println(username);
			System.out.println(userpwd);
			
			//�����ݿ��н��в��ң�������ҳɹ����˺ź�������ȷ��
			//��ȡ���ݿ������
			try {
				Connection con=DBUtil.getCon("company");
				//Ԥ����SQL���
				String sql="select * from t_employee where empno=? and ename=?";
				PreparedStatement prep=con.prepareStatement(sql);
				prep.setString(1, username);
				prep.setString(2, userpwd);
				//ִ��SQL���
				ResultSet result=prep.executeQuery();
				if(result.next())
				{
					System.out.println("��¼�ɹ���");
				}
				else
				{
					System.out.println("��¼ʧ�ܣ�");
				}
				//�ر����ݿ������
				con.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		}
	}
}
