package Student_Manage_System;
//ע����޸��������
/* 1.ע���û���Ϣ(������login_info�������������)
 * 2.�޸��û�����(���������û�ID and Tel��Ϊ����������
 * ��login_info����в��ң������ҵ����޸����룬��δ���ҵ���������ʾ��
 * 1��2����һ������ʵ�֣�
 */
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class Register {

	//�û�ע��������ƣ��Լ���ع��ܵ�ʵ��
	//�����û�ע�����
	JTextField t1= new JTextField();//����һ���ı���������������û�ID
	JPasswordField pwd = new JPasswordField();//����һ�����������
	JTextField t3=new JTextField();//����һ���ı����������������ϵ��ʽ
	JTextField t2 = new JTextField();//����һ���ı��������������ְλ
	JTextField t4 = new JTextField();//��������ID
	JTextField t5 = new JTextField();//����������ϵ��ʽTel
	JPasswordField pwd2 = new JPasswordField();//��������������	
	public void init(){//ע������ʼ��
		JFrame f = new JFrame();//��������
		JPanel p = new JPanel();//�������
		JButton btn1 = new JButton("ȷ��");//����ȷ�ϰ�ť
		JButton btn2 = new JButton("ȡ��");//����ȡ����ť
		JButton btn3 = new JButton("�޸�����");//�����޸����밴ť
		
		//��������ʾЧ�����
		t1.setToolTipText("�˺Ų���Ϊ�գ��10λ����");
		t2.setToolTipText("����������ְλ��teacher|student��");
		t3.setToolTipText("������������ϵ��ʽ���10λ����");
		pwd.setToolTipText("����λ�����ַ����16λ");
		
        //����ȷ�ϡ���ȡ�������޸����롱��ť���¼�����
		insertData is = new insertData();
		btn1.addMouseListener(is);
		cancelData1 cn = new cancelData1();
		btn2.addMouseListener(cn);
		modifyData1 md = new modifyData1();
		btn3.addMouseListener(md);
		//�����ı������ĳ���Ϊ9,������������ID��Tel��Password��Job�ĳ���
		t1.setColumns(16);t2.setColumns(16);
		t3.setColumns(16);pwd.setColumns(16);
		//�����ı������Ϊ�ɱ༭״̬
		t1.setEditable(true);t2.setEditable(true);
		t3.setEditable(true);pwd.setEditable(true);
		
		
		//������ǩ�����û�����ʱ����ʾ
		JLabel label1 = new JLabel();JLabel label2 = new JLabel();
		JLabel label3 = new JLabel();JLabel label4 = new JLabel();
		label1.setText("ID:");label2.setText("Password");
		label3.setText("Job");label4.setText("Telephone number");
		
		//ʹ��FlowLayout����
		FlowLayout flow = new FlowLayout(FlowLayout.RIGHT,125,40);
		p.setLayout(flow);
		
		f.setVisible(true);
		f.setSize(600, 450);
		f.setLocation(650, 350);
		f.setTitle("�û�ע��");
		

		//������������
		p.add(label3);p.add(t2);p.add(label1);p.add(t1);
		p.add(label4);p.add(t3);p.add(label2);p.add(pwd);
		p.add(btn1);p.add(btn2);p.add(btn3);
		//�������봰��
		f.add(p);
		//���ùرմ���Ҳ�ر����к�̨
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
		
		//���û���������ݲ�����Ӧ�ı�
		public class insertData extends MouseAdapter{
			
			public void mouseClicked(MouseEvent e) {
				
				
//					while(true){
//						
//							
//						}
				try {
					//��������ȡ��Ϣ
					//String strName = t1.getText();
					String id = t1.getText();
					//��String����ת����int����
					
					//Long id = Long.parseLong(strName);//��String����ת��ΪLong����
					String strpwd = pwd.getText();
					String strjob = t2.getText();
					String tel = t3.getText();
					//int tel = Integer.parseInt(strtel);//��String����ת��λint����
					//�����ݿ⽨������
					Connection con;
					con = DBUtil.getCon("studentdb");
					String job1= "teacher";
					String job2="student";
//						if((strjob.equals(job1) || strjob.equals(job2))&& Long.toString(id).length()<=10 && 
//					Integer.toString(tel).length()<=10 && 
//							strpwd.length()<=16 )//�ж��û����������Ƿ�Ϲ�
						if(strjob.equals(job1) || strjob.equals(job2))
						{	
							//Ԥ����sql���
							String str1 = "select * from Login_info where ID=?";
							PreparedStatement prep1=con.prepareStatement(str1);
							//���õ�һ���ʺ���ID����������
							//prep1.setLong(1,id);
							prep1.setString(1,id);
							//ִ��sql���
							ResultSet rs = prep1.executeQuery();	
							//prep2.executeUpdate();
						
							if(rs.next()){
								JOptionPane.showMessageDialog(null, "���˺��Ѿ����ڣ����������룡");
//								break;
							}
							else{
								String str2 = "insert into Login_info (Job,ID,Tel,Pwd) values(?,?,?,?)";
								PreparedStatement prep2 = con.prepareStatement(str2);//Ԥ����
								prep2.setString(1,strjob);
								prep2.setString(2,id);
								prep2.setString(3,tel);
								//prep2.setLong(2,id);
								//prep2.setInt(3,tel);
								prep2.setString(4,strpwd);
								prep2.executeUpdate();
								JOptionPane.showMessageDialog(null,"�����˺�ע�����","Title",JOptionPane.WARNING_MESSAGE);
								con.close();
								//break;
							}
							
						}
						else{
							
							JOptionPane.showMessageDialog(null,"��������˺Ż��������" ,"Title",JOptionPane.WARNING_MESSAGE);
//							break;
						}
					
					
				}
				catch (Exception e2) {
					
					e2.printStackTrace();
				}
				
				
			}
		}
		//����modifyData����ȡ����ť���¼�����
		public class cancelData1 extends MouseAdapter{

			public void mouseClicked(MouseEvent e) {

				System.exit(0);
			}
		}
			
		
		public class modifyData1 extends MouseAdapter{
			
			JButton btn4 = new JButton("ȷ��");
			JButton btn5 = new JButton("ȡ��");
			
			//�����޸�����Ľ���
			public void mouseClicked(MouseEvent e){
				//���޸�������������������ʾ
				t4.setToolTipText("���������ID���ʮλ");
				t5.setToolTipText("������������ϵ��ʽ���ʮλ");
				pwd2.setToolTipText("�������������������16λ");
				//�������塢��塢��ť������򡢱�ǩ
				JFrame f2 = new JFrame();
				JPanel p2 = new JPanel();
	
				JLabel label5 = new JLabel();label5.setText("ID:");
				JLabel label6 = new JLabel();label6.setText("Telephone number:");
				JLabel label7 = new JLabel();label7.setText("Password:");

				//ȷ��������������
				f2.setSize(550,500);
				f2.setLocation(700, 400);
				f2.setVisible(true);
				f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//ȷ��������������
				t4.setEditable(true);t5.setEditable(true);
				t4.setColumns(16);t5.setColumns(16);
				pwd2.setEditable(true);pwd2.setColumns(16);
				//����ص�����������
				p2.add(label5);p2.add(t4);p2.add(label6);p2.add(t5);
				p2.add(label7);p2.add(pwd2);p2.add(btn4);p2.add(btn5);
				//����FlowLayout����
				FlowLayout flow2 = new FlowLayout(FlowLayout.RIGHT,100,60);
				p2.setLayout(flow2);
				f2.add(p2);
				modifyData2 md2 = new modifyData2();
				btn4.addMouseListener(md2);
				cancelData1 cn1 = new cancelData1();
				btn5.addMouseListener(cn1);
			}
		
			
			}
		//�����¼����������޸Ľ�����ع��ܵ�ʵ��
		public class modifyData2 extends MouseAdapter{
			public void mouseClicked(MouseEvent e) {
			
//				while(true){
//				
//					
//				}
				try {
					//ע��������ݿ�
					Connection con2 = DBUtil.getCon("studentdb");
					String id3=t4.getText();
					String Tel4=t5.getText();
					//String str3=t4.getText();
					//Long id3 = Long.parseLong(str3);
					//String str4=t5.getText();
					//int Tel4 = Integer.parseInt(str4);
					String str5 = pwd2.getText();
					//if(Long.toString(id3).length()<=10 && Integer.toString(Tel4).length()<=10 && str5.length()<=16)
					//{
						//Ԥ����
						String str6 = "select * from Login_info where ID=? and Tel=?";
						PreparedStatement prep3 = con2.prepareStatement(str6);
						//prep3.setLong(1,id3);
						//prep3.setInt(2,Tel4);
						prep3.setString(1, id3);
						prep3.setString(2,Tel4);
						//ִ�в�ѯ���
						ResultSet rs2 = prep3.executeQuery();
						if(rs2.next()){
							//Ԥ����
							//System.out.println(str3);
							String str7 = "update Login_info set Pwd=? where ID=? and Tel=?";
							PreparedStatement prep4 = con2.prepareStatement(str7);
							prep4.setString(1, str5);
							//prep4.setLong(2, id3);
							//prep4.setInt(3,Tel4);
							prep4.setString(2, id3);
							prep4.setString(3, Tel4);
							prep4.executeUpdate();
							JOptionPane.showMessageDialog(null,"�����޸ĳɹ���" ,"Title",JOptionPane.INFORMATION_MESSAGE);
							con2.close();
							//break;
						}
						else{
							JOptionPane.showMessageDialog(null,"����ѯ����Ϣ����������������!" ,"Title",JOptionPane.WARNING_MESSAGE);
//							break;
						}
//					}
//					else{
//						JOptionPane.showMessageDialog(null,"����������ݸ�ʽ����ȷ����������!","Title",JOptionPane.WARNING_MESSAGE );
//						break;
//					}
				
				} catch (Exception e1) {
				
				}
			}
				
		}


//	public static void main(String[] args) {
//		Register r=new Register();
//		r.init();
//
//	}

}
