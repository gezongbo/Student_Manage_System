package Student_Manage_System;
//注册和修改密码界面
/* 1.注册用户信息(即：在login_info表格中增加数据)
 * 2.修改用户密码(即：根据用户ID and Tel作为查找条件，
 * 在login_info表格中查找，若查找到，修改密码，若未查找到，给出提示）
 * 1和2各用一个函数实现；
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

	//用户注册界面的设计，以及相关功能的实现
	//生成用户注册界面
	JTextField t1= new JTextField();//创建一个文本输入框用于输入用户ID
	JPasswordField pwd = new JPasswordField();//创建一个密码输入框
	JTextField t3=new JTextField();//创建一个文本输入框用于输入联系方式
	JTextField t2 = new JTextField();//创建一个文本输入框用于输入职位
	JTextField t4 = new JTextField();//用于输入ID
	JTextField t5 = new JTextField();//用于输入联系方式Tel
	JPasswordField pwd2 = new JPasswordField();//用于输入新密码	
	public void init(){//注册界面初始化
		JFrame f = new JFrame();//创建窗体
		JPanel p = new JPanel();//创建面板
		JButton btn1 = new JButton("确认");//创建确认按钮
		JButton btn2 = new JButton("取消");//创建取消按钮
		JButton btn3 = new JButton("修改密码");//创建修改密码按钮
		
		//输入框的提示效果添加
		t1.setToolTipText("账号不能为空，最长10位数字");
		t2.setToolTipText("请输入您的职位（teacher|student）");
		t3.setToolTipText("请输入您的联系方式，最长10位数字");
		pwd.setToolTipText("密码位任意字符，最长16位");
		
        //给“确认”“取消”“修改密码”按钮绑定事件监听
		insertData is = new insertData();
		btn1.addMouseListener(is);
		cancelData1 cn = new cancelData1();
		btn2.addMouseListener(cn);
		modifyData1 md = new modifyData1();
		btn3.addMouseListener(md);
		//设置文本输入框的长度为9,用来控制输入ID、Tel、Password、Job的长度
		t1.setColumns(16);t2.setColumns(16);
		t3.setColumns(16);pwd.setColumns(16);
		//设置文本输入框为可编辑状态
		t1.setEditable(true);t2.setEditable(true);
		t3.setEditable(true);pwd.setEditable(true);
		
		
		//创建标签用于用户输入时的提示
		JLabel label1 = new JLabel();JLabel label2 = new JLabel();
		JLabel label3 = new JLabel();JLabel label4 = new JLabel();
		label1.setText("ID:");label2.setText("Password");
		label3.setText("Job");label4.setText("Telephone number");
		
		//使用FlowLayout布局
		FlowLayout flow = new FlowLayout(FlowLayout.RIGHT,125,40);
		p.setLayout(flow);
		
		f.setVisible(true);
		f.setSize(600, 450);
		f.setLocation(650, 350);
		f.setTitle("用户注册");
		

		//将组件加入面板
		p.add(label3);p.add(t2);p.add(label1);p.add(t1);
		p.add(label4);p.add(t3);p.add(label2);p.add(pwd);
		p.add(btn1);p.add(btn2);p.add(btn3);
		//将面板加入窗口
		f.add(p);
		//设置关闭窗体也关闭运行后台
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
		
		//将用户输入的数据插入相应的表
		public class insertData extends MouseAdapter{
			
			public void mouseClicked(MouseEvent e) {
				
				
//					while(true){
//						
//							
//						}
				try {
					//从输入框获取信息
					//String strName = t1.getText();
					String id = t1.getText();
					//将String类型转换成int类型
					
					//Long id = Long.parseLong(strName);//将String类型转换为Long类型
					String strpwd = pwd.getText();
					String strjob = t2.getText();
					String tel = t3.getText();
					//int tel = Integer.parseInt(strtel);//将String类型转换位int类型
					//与数据库建立连接
					Connection con;
					con = DBUtil.getCon("studentdb");
					String job1= "teacher";
					String job2="student";
//						if((strjob.equals(job1) || strjob.equals(job2))&& Long.toString(id).length()<=10 && 
//					Integer.toString(tel).length()<=10 && 
//							strpwd.length()<=16 )//判断用户输入数据是否合规
						if(strjob.equals(job1) || strjob.equals(job2))
						{	
							//预编译sql语句
							String str1 = "select * from Login_info where ID=?";
							PreparedStatement prep1=con.prepareStatement(str1);
							//设置第一个问号是ID输入框的内容
							//prep1.setLong(1,id);
							prep1.setString(1,id);
							//执行sql语句
							ResultSet rs = prep1.executeQuery();	
							//prep2.executeUpdate();
						
							if(rs.next()){
								JOptionPane.showMessageDialog(null, "该账号已经存在，请重新输入！");
//								break;
							}
							else{
								String str2 = "insert into Login_info (Job,ID,Tel,Pwd) values(?,?,?,?)";
								PreparedStatement prep2 = con.prepareStatement(str2);//预编译
								prep2.setString(1,strjob);
								prep2.setString(2,id);
								prep2.setString(3,tel);
								//prep2.setLong(2,id);
								//prep2.setInt(3,tel);
								prep2.setString(4,strpwd);
								prep2.executeUpdate();
								JOptionPane.showMessageDialog(null,"您的账号注册完毕","Title",JOptionPane.WARNING_MESSAGE);
								con.close();
								//break;
							}
							
						}
						else{
							
							JOptionPane.showMessageDialog(null,"您输入的账号或密码错误" ,"Title",JOptionPane.WARNING_MESSAGE);
//							break;
						}
					
					
				}
				catch (Exception e2) {
					
					e2.printStackTrace();
				}
				
				
			}
		}
		//创建modifyData用于取消按钮的事件监听
		public class cancelData1 extends MouseAdapter{

			public void mouseClicked(MouseEvent e) {

				System.exit(0);
			}
		}
			
		
		public class modifyData1 extends MouseAdapter{
			
			JButton btn4 = new JButton("确定");
			JButton btn5 = new JButton("取消");
			
			//创建修改密码的界面
			public void mouseClicked(MouseEvent e){
				//给修改密码界面的输入框添加提示
				t4.setToolTipText("请输入你的ID最高十位");
				t5.setToolTipText("请输入您的联系方式最高十位");
				pwd2.setToolTipText("请输入您的新密码最高16位");
				//创建窗体、面板、按钮、输入框、标签
				JFrame f2 = new JFrame();
				JPanel p2 = new JPanel();
	
				JLabel label5 = new JLabel();label5.setText("ID:");
				JLabel label6 = new JLabel();label6.setText("Telephone number:");
				JLabel label7 = new JLabel();label7.setText("Password:");

				//确定窗体的相关属性
				f2.setSize(550,500);
				f2.setLocation(700, 400);
				f2.setVisible(true);
				f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//确定组件的相关属性
				t4.setEditable(true);t5.setEditable(true);
				t4.setColumns(16);t5.setColumns(16);
				pwd2.setEditable(true);pwd2.setColumns(16);
				//将相关的组件加入面板
				p2.add(label5);p2.add(t4);p2.add(label6);p2.add(t5);
				p2.add(label7);p2.add(pwd2);p2.add(btn4);p2.add(btn5);
				//创建FlowLayout布局
				FlowLayout flow2 = new FlowLayout(FlowLayout.RIGHT,100,60);
				p2.setLayout(flow2);
				f2.add(p2);
				modifyData2 md2 = new modifyData2();
				btn4.addMouseListener(md2);
				cancelData1 cn1 = new cancelData1();
				btn5.addMouseListener(cn1);
			}
		
			
			}
		//创建事件监听用于修改界面相关功能的实现
		public class modifyData2 extends MouseAdapter{
			public void mouseClicked(MouseEvent e) {
			
//				while(true){
//				
//					
//				}
				try {
					//注册加载数据库
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
						//预编译
						String str6 = "select * from Login_info where ID=? and Tel=?";
						PreparedStatement prep3 = con2.prepareStatement(str6);
						//prep3.setLong(1,id3);
						//prep3.setInt(2,Tel4);
						prep3.setString(1, id3);
						prep3.setString(2,Tel4);
						//执行查询语句
						ResultSet rs2 = prep3.executeQuery();
						if(rs2.next()){
							//预编译
							//System.out.println(str3);
							String str7 = "update Login_info set Pwd=? where ID=? and Tel=?";
							PreparedStatement prep4 = con2.prepareStatement(str7);
							prep4.setString(1, str5);
							//prep4.setLong(2, id3);
							//prep4.setInt(3,Tel4);
							prep4.setString(2, id3);
							prep4.setString(3, Tel4);
							prep4.executeUpdate();
							JOptionPane.showMessageDialog(null,"密码修改成功！" ,"Title",JOptionPane.INFORMATION_MESSAGE);
							con2.close();
							//break;
						}
						else{
							JOptionPane.showMessageDialog(null,"您查询的信息不存在请重新输入!" ,"Title",JOptionPane.WARNING_MESSAGE);
//							break;
						}
//					}
//					else{
//						JOptionPane.showMessageDialog(null,"您输入的数据格式不正确请重新输入!","Title",JOptionPane.WARNING_MESSAGE );
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
