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



//用户登录界面
public class UserLogin {
	
	JTextField name=new JTextField(10);
	JPasswordField pwd=new JPasswordField(10);
	//用户登录界面初始化
    public void Init() throws Exception{
    	JFrame f=new JFrame();
    	FlowLayout layout = new FlowLayout(FlowLayout.RIGHT,135,50);
    	JPanel p=new JPanel(layout);
    
    	JLabel label_name=new JLabel();
		JLabel label_pwd = new JLabel();
		JButton btn1=new JButton("登录");
		JButton btn2=new JButton("注册");
    	JButton btn3=new JButton("取消");
    	label_name.setText("用户名");//设置标签内容
		label_pwd.setText("密码");
    	//创建MyClick1内部类，绑定到登录按钮;
    	MyClick1 mc1=new MyClick1();
    	btn1.addMouseListener(mc1);
    	//创建MyClick2内部类，绑定到注册按钮;
    	MyClick2 mc2=new MyClick2();
    	btn2.addMouseListener(mc2);
    	//创建MyClick3内部类，绑定到退出按钮;
    	MyClick3 mc3=new MyClick3();
    	btn3.addMouseListener(mc3);
    	
    	
    	//将标签，文本域，按钮等添加到面板
    	p.add(label_name);p.add(name);
    	p.add(label_pwd);p.add(pwd);
    	p.add(btn1);p.add(btn2);p.add(btn3);
    	f.add(p);//将面板添加到窗体
    	f.setVisible(true);//设置窗体可见
    	f.setSize(600,450);
    	f.setLocation(650, 350);
    	f.setTitle("登录界面");
    	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗体
  
    }
    
    //登录按钮的事件监听
	public class MyClick1 extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			//登录，数据库中有表格，判断是否登录成功！；
			//注册：即插入数据。
			//获取登录的账号和密码
			String username=name.getText();
			String userpwd=pwd.getText();

			//在数据库中进行查找，如果查找成功，账号和密码正确；
			//获取数据库的连接
			try {
				Connection con=DBUtil.getCon("studentdb");
				//预编译SQL语句
				//这里需要判断是学生登录还是老师登录
				String sql="select * from login_info where ID=? and Pwd=? and Job=?";
				//执行SQL语句
				//教师登录，跳转教师界面；
				PreparedStatement prep1=con.prepareStatement(sql);
				prep1.setString(1, username);//用户名
				prep1.setString(2, userpwd);//密码
				prep1.setString(3, "teacher");//工作是teacher
				ResultSet is_teacher=prep1.executeQuery();
				//学生登录，跳转学生界面；
				PreparedStatement prep2=con.prepareStatement(sql);
				prep2.setString(1, username);
				prep2.setString(2, userpwd);
				prep2.setString(3, "student");//工作是student
				ResultSet is_student=prep2.executeQuery();
				if(is_teacher.next())//管理员登录
				{ //跳转管理员界面
					System.out.println("老师你好，登录成功！");
					JOptionPane.showMessageDialog(null, "老师您好，登录成功！");
					Teacher tea=new Teacher();
					tea.init();
					//DBUtil.notice("老师你好，登录成功！");
				}
				else if(is_student.next())//学生登录
				{//跳转学生界面
					System.out.println("学生你好，登录成功！");
					JOptionPane.showMessageDialog(null, "登录成功！");
					Students stu=new Students();
					stu.init();
					//DBUtil.notice("学生你好，登录成功！");
				}
				else
				{
					System.out.println("登录失败！");
					JOptionPane.showMessageDialog(null, "登录失败！");
				}
				con.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		}
	}
	//注册按钮的事件监听
	public class MyClick2 extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			//System.out.print("注册成功");
			//跳转进入注册界面
			try {
				//DBUtil.notice("注册成功!");
				Register r=new Register();
				r.init();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	//退出按钮的事件监听
	public class MyClick3 extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			//System.out.print(" 退出成功");
			//结束程序
			try {
				JOptionPane.showMessageDialog(null, "退出成功!");
				System.exit(0);//结束
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	//启动注册界面
	public static void main(String[] args) throws Exception {
		UserLogin login=new UserLogin();
		login.Init();

	}

}

