package Student_Manage_System;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



//�û���¼����
public class UserLogin {
	
	JTextField name=new JTextField(10);
	JPasswordField pwd=new JPasswordField(10);
	//�û���¼�����ʼ��
    public void Init() throws Exception{
    	JFrame f=new JFrame();
    	FlowLayout layout = new FlowLayout(FlowLayout.RIGHT,135,50);
    	JPanel p=new JPanel(layout);
    
    	JLabel label_name=new JLabel();
		JLabel label_pwd = new JLabel();
		JButton btn1=new JButton("��¼");
		JButton btn2=new JButton("ע��");
    	JButton btn3=new JButton("ȡ��");
    	label_name.setText("�û���");//���ñ�ǩ����
		label_pwd.setText("����");
    	//����MyClick1�ڲ��࣬�󶨵���¼��ť;
    	MyClick1 mc1=new MyClick1();
    	btn1.addMouseListener(mc1);
    	//����MyClick2�ڲ��࣬�󶨵�ע�ᰴť;
    	MyClick2 mc2=new MyClick2();
    	btn2.addMouseListener(mc2);
    	//����MyClick3�ڲ��࣬�󶨵��˳���ť;
    	MyClick3 mc3=new MyClick3();
    	btn3.addMouseListener(mc3);
    	
    	
    	//����ǩ���ı��򣬰�ť����ӵ����
    	p.add(label_name);p.add(name);
    	p.add(label_pwd);p.add(pwd);
    	p.add(btn1);p.add(btn2);p.add(btn3);
    	f.add(p);//�������ӵ�����
    	f.setVisible(true);//���ô���ɼ�
    	f.setSize(600,450);
    	f.setLocation(650, 350);
    	f.setTitle("��¼����");
    	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�رմ���
  
    }
    
    //��¼��ť���¼�����
	public class MyClick1 extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			//��¼�����ݿ����б���ж��Ƿ��¼�ɹ�����
			//ע�᣺���������ݡ�
			//��ȡ��¼���˺ź�����
			String username=name.getText();
			String userpwd=pwd.getText();

			//�����ݿ��н��в��ң�������ҳɹ����˺ź�������ȷ��
			//��ȡ���ݿ������
			try {
				Connection con=DBUtil.getCon("studentdb");
				//Ԥ����SQL���
				//������Ҫ�ж���ѧ����¼������ʦ��¼
				String sql="select * from login_info where ID=? and Pwd=? and Job=?";
				//ִ��SQL���
				//��ʦ��¼����ת��ʦ���棻
				PreparedStatement prep1=con.prepareStatement(sql);
				prep1.setString(1, username);//�û���
				prep1.setString(2, userpwd);//����
				prep1.setString(3, "teacher");//������teacher
				ResultSet is_teacher=prep1.executeQuery();
				//ѧ����¼����תѧ�����棻
				PreparedStatement prep2=con.prepareStatement(sql);
				prep2.setString(1, username);
				prep2.setString(2, userpwd);
				prep2.setString(3, "student");//������student
				ResultSet is_student=prep2.executeQuery();
				if(is_teacher.next())//����Ա��¼
				{ //��ת����Ա����
					System.out.println("��ʦ��ã���¼�ɹ���");
					JOptionPane.showMessageDialog(null, "��ʦ���ã���¼�ɹ���");
					Teacher tea=new Teacher();
					tea.init();
					//DBUtil.notice("��ʦ��ã���¼�ɹ���");
				}
				else if(is_student.next())//ѧ����¼
				{//��תѧ������
					System.out.println("ѧ����ã���¼�ɹ���");
					JOptionPane.showMessageDialog(null, "��¼�ɹ���");
					Students stu=new Students();
					stu.init();
					//DBUtil.notice("ѧ����ã���¼�ɹ���");
				}
				else
				{
					System.out.println("��¼ʧ�ܣ�");
					JOptionPane.showMessageDialog(null, "��¼ʧ�ܣ�");
				}
				con.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		}
	}
	//ע�ᰴť���¼�����
	public class MyClick2 extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			//System.out.print("ע��ɹ�");
			//��ת����ע�����
			try {
				//DBUtil.notice("ע��ɹ�!");
				Register r=new Register();
				r.init();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	//�˳���ť���¼�����
	public class MyClick3 extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			//System.out.print(" �˳��ɹ�");
			//��������
			try {
				JOptionPane.showMessageDialog(null, "�˳��ɹ�!");
				System.exit(0);//����
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	//����ע�����
	public static void main(String[] args) throws Exception {
		UserLogin login=new UserLogin();
		login.Init();

	}

}

