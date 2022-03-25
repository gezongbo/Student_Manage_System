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

//登录界面
public class Login {
	JTextField name=new JTextField(10);
	JPasswordField pwd=new JPasswordField(10);
    public void Init(){
    	JFrame f=new JFrame();
    	JPanel p=new JPanel();
    	JLabel label_name=new JLabel();
		JLabel label_pwd = new JLabel();
		JButton btn1=new JButton("登录");
		JButton btn2=new JButton("注册");
    	JButton btn3=new JButton("取消");
    	//创建MyClick内部类，绑定到按钮btn1;
    	MyClick mc=new MyClick();
    	btn1.addMouseListener(mc);
    	p.add(label_name);
    	p.add(label_pwd);
    	p.add(name);
    	p.add(pwd);
    	p.add(btn1);
    	p.add(btn2);
    	f.add(p);
    	f.setVisible(true);//设置窗体可见
    	f.setSize(600,600);
    	f.setLocation(700, 100);
    	
    	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗体
    }
	public static void main(String[] args) {
		Login login=new Login();
		login.Init();

	}
	//定义内部类--实现按钮的事件监听
	public class MyClick extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			//登录，数据库中有表格，判断是否登录成功！；
			//注册：即插入数据。
			//获取登录的账号和密码
			String username=name.getText();
			String userpwd=pwd.getText();
			System.out.println(username);
			System.out.println(userpwd);
			
			//在数据库中进行查找，如果查找成功，账号和密码正确；
			//获取数据库的连接
			try {
				Connection con=DBUtil.getCon("company");
				//预编译SQL语句
				String sql="select * from t_employee where empno=? and ename=?";
				PreparedStatement prep=con.prepareStatement(sql);
				prep.setString(1, username);
				prep.setString(2, userpwd);
				//执行SQL语句
				ResultSet result=prep.executeQuery();
				if(result.next())
				{
					System.out.println("登录成功！");
				}
				else
				{
					System.out.println("登录失败！");
				}
				//关闭数据库的连接
				con.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		}
	}
}
