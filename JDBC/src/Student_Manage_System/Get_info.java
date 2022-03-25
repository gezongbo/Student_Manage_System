package Student_Manage_System;
//定义多个窗体界面，获取学生信息，用于增删查改等操作
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

//获取学生信息
public class Get_info {
	//窗体界面
	JFrame f=new JFrame();
	FlowLayout layout=new FlowLayout(FlowLayout.LEFT,30,40);//布局
	JPanel p=new JPanel(layout);
	
	//文本域
	JTextField id=new JTextField(11);JTextField name=new JTextField(11);
	JTextField sex=new JTextField(11);JTextField age=new JTextField(11);
	JTextField studydate=new JTextField(11);JTextField major=new JTextField(11);
	JTextField classid=new JTextField(11);JTextField address=new JTextField(11);
	JTextField tel=new JTextField(11);JTextField math=new JTextField(11);
	JTextField java=new JTextField(11);JTextField mysql=new JTextField(11);
	
    //标签
    JLabel label_id=new JLabel("学号");JLabel label_name = new JLabel("姓名");
	JLabel label_sex=new JLabel("性别");JLabel label_age = new JLabel("年龄");
	JLabel label_studydate=new JLabel("入学日期");JLabel label_major = new JLabel("专业");
	JLabel label_classid=new JLabel("班级");JLabel label_address = new JLabel("家庭地址");
	JLabel label_tel=new JLabel("联系方式");JLabel label_math = new JLabel("Math成绩");
	JLabel label_java=new JLabel("Java成绩");JLabel label_mysql=new JLabel("MySQL成绩");
	//按钮
	JButton btn1=new JButton("确认");JButton btn2=new JButton("取消");
	 String flag;//标志
	//获取学生信息的界面
    public  void student_info_init(String str) throws Exception
    {

    	flag=str;
    	//get_info内部类，绑定到按钮btn1;
		get_info info=new get_info();
		btn1.addActionListener(info);
		btn2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.exit(0);//结束
			}
			});
    	p.add(label_id);p.add(id);p.add(label_name);p.add(name);p.add(label_sex);p.add(sex);
    	p.add(label_age);p.add(age);p.add(label_studydate);p.add(studydate);
    	p.add(label_major);p.add(major);p.add(label_classid);p.add(classid);
    	p.add(label_address);p.add(address);p.add(label_tel);p.add(tel);
    	id.setToolTipText("请输入学生的学号");
    	name.setToolTipText("请不要输入中文");
    	sex.setToolTipText("请不要输入中文");
    	studydate.setToolTipText("请按照如下格式,例如:20190901");
    	major.setToolTipText("请不要输入中文");
    	address.setToolTipText("请不要输入中文");
    	p.add(btn1);p.add(btn2);
    	f.add(p);
    	f.setVisible(true);//设置窗体可见
    	f.setSize(280,700);
    	f.setLocation(700, 100);
    	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗体
    }
  
  //获取学生成绩的界面
    public void student_score_init(String str) throws Exception
    {
 
    	flag=str;
    	//get_score内部类，绑定到按钮btn1;
		get_score score=new get_score();
		btn1.addMouseListener(score);
		btn2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.exit(0);//结束
			}
			});
    	p.add(label_id);p.add(id);p.add(label_name);p.add(name);
    	p.add(label_major);p.add(major);p.add(label_classid);p.add(classid);
    	p.add(label_math);p.add(math);p.add(label_java);p.add(java);p.add(label_mysql);p.add(mysql);
    	p.add(btn1);p.add(btn2);
    	id.setToolTipText("请输入学生的学号");
    	name.setToolTipText("请不要输入中文");
    	major.setToolTipText("请不要输入中文");
    	math.setToolTipText("成绩范围:[0,100]");
    	java.setToolTipText("成绩范围:[0,100]");
    	mysql.setToolTipText("成绩范围:[0,100]");
    	f.add(p);
    	f.setVisible(true);//设置窗体可见
    	f.setSize(280,600);
    	f.setLocation(700, 100);
    	
    	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗体
    }
    //获取学生id和姓名界面
    public void student_id_name(String str) throws Exception{
    
    	flag=str;
    	//内部类，绑定到按钮btn1;
    	myClick mc=new myClick();
    	btn1.addMouseListener(mc);
    	btn2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.exit(0);//结束
			}
			});

    	p.add(label_id);p.add(id);p.add(label_name);p.add(name);p.add(btn1);p.add(btn2);
    	id.setToolTipText("请输入学生的学号");
    	name.setToolTipText("请不要输入中文");
    	f.add(p);
    	f.setVisible(true);//设置窗体可见
    	f.setSize(220,500);
    	f.setLocation(700, 100);
    	
    	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗体
    }
  //获取学生专业信息界面
    public void student_Major(String str) throws Exception{
    	
    	flag=str;
    	//内部类，绑定到按钮btn1;
    	myClick mc=new myClick();
    	btn1.addMouseListener(mc);
    	btn2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.exit(0);//结束
			}
			});
    	
    	p.add(label_major);p.add(major);
    	p.add(btn1);p.add(btn2);
    	major.setToolTipText("请不要输入中文");
    	f.add(p);
    	f.setVisible(true);//设置窗体可见
    	f.setSize(200,300);
    	f.setLocation(700, 100);
    	
    	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗体
    }
  //获取学生班级信息界面
    public void student_Class(String str) throws Exception{
    	flag=str;
    	//内部类，绑定到按钮btn1;
    	myClick mc=new myClick();
    	btn1.addMouseListener(mc);
    	btn2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.exit(0);//结束
			}
			});
    	
    	p.add(label_classid);p.add(classid);
    	p.add(btn1);p.add(btn2);
    	f.add(p);
    	f.setVisible(true);//设置窗体可见
    	f.setSize(200,300);
    	f.setLocation(700, 100);
    	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗体
    }
	//定义内部类--实现按钮的事件监听
	public class myClick extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			//获取学生的学号和姓名
			String userid=id.getText();
			String username=name.getText();
			String usermajor=major.getText();
			String userclassid=classid.getText();
			try {
				Select s=new Select();
				Delete d=new Delete();
				
				if(flag=="查找信息"){//根据学生的学号和姓名查找学生信息
					if(s.Select_info(userid, username)){
						System.out.print("学生信息查找成功！");
//						JOptionPane.showMessageDialog(null, "学生信息查找成功！");
					}
					else{
						//未查找到该学生
						System.out.print("输入信息有误！");
						JOptionPane.showMessageDialog(null, "输入信息有误！");
					}
					
				}
				if(flag=="查找成绩"){//根据学生的学号和姓名查找学生成绩
					if(s.Select_score(userid, username)){
						System.out.print("学生成绩查找成功！");
					}
					else{//未查找到该学生
						System.out.print("输入信息有误！");
						JOptionPane.showMessageDialog(null, "输入信息有误！");
					}
				}	
				if(flag=="查找同一专业信息"){//根据学生Major查找学生信息
					if(s.Select_major_info(usermajor)){
						System.out.print("查找成功！");
					}
					else{
						//未查找到该专业
						System.out.print("输入信息有误！");
						JOptionPane.showMessageDialog(null, "输入信息有误！");
					}
				}
				if(flag=="查找同一专业成绩"){//根据学生Major查找学生成绩
					if(s.Select_major_score(usermajor)){
						System.out.print("查找成功！");
					}
					else{//未查找到该专业
						System.out.print("输入信息有误！");
						JOptionPane.showMessageDialog(null, "输入信息有误！");
					}
				}
				if(flag=="查找同一班级信息"){//根据学生Class查找学生信息
					if(s.Select_class_info(userclassid)){
						System.out.print("查找成功！");
					}
					else{//未查找到该班级
						System.out.print("输入信息有误！");
						JOptionPane.showMessageDialog(null, "输入信息有误！");
					}
				}
				if(flag=="查找同一班级成绩"){//根据学生Class查找学生成绩
					if(s.Select_class_score(userclassid)){
						
					}
					else{//未查找到该班级
						System.out.print("输入信息有误！");
						JOptionPane.showMessageDialog(null, "输入信息有误！");
					}
				}
				if(flag=="删除信息"){//根据学生的学号和姓名删除学生信息
					//如果该学号不存在，提示
					if(!s.Select_info_ID(userid)){
						System.out.print("该学号不存在，请勿重复删除学生信息！");
						JOptionPane.showMessageDialog(null, "该学号不存在，请勿重复删除学生信息！");
					}
					else if(s.Select_info(userid,username)){//否则，要删除学生的ID和姓名查找成功，删除该学生信息
						d.Delete_toinfo(userid, username);
					}
					else{
						System.out.print("输入信息有误！");
						JOptionPane.showMessageDialog(null, "输入信息有误！");
					}
				}
				if(flag=="删除成绩"){//根据学生的学号和姓名删除学生成绩
					//如果该学号不存在，提示
					if(!s.Select_score_ID(userid)){
						System.out.print("该学号不存在，请勿重复删除学生成绩！");
						JOptionPane.showMessageDialog(null, "该学号不存在，请勿重复删除学生成绩！");
					}
					else if(s.Select_score(userid,username)){//否则，要删除学生的ID和姓名查找成功，删除该学生成绩
						d.Delete_toscore(userid, username);
					}
					else{
						System.out.print("输入信息有误！");
						JOptionPane.showMessageDialog(null, "输入信息有误！");
					}
				}	
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		}
	}
    //获取信息界面的确定按钮的事件监听
    public class get_info implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//获取输入框内容
			String userid=id.getText();
			String username=name.getText();
			String usersex=sex.getText();
			String userage=age.getText();
			String userstudydate=studydate.getText();
			String usermajor=major.getText();
			String userclassid=classid.getText();
			String useraddress=address.getText();
			String usertel=tel.getText();
			
			//String 转Int
			int useragei=Integer.parseInt(userage);
			int userclassidi=Integer.parseInt(userclassid);
			Insert insert=new Insert();
			Select select=new Select();
			Update update=new Update();
			try {
				if(flag=="增加信息"){
					//如果该学号存在，提示
					if(select.Select_info_ID(userid)){
						System.out.print("该学号已存在，请勿重复添加学生信息！");
						JOptionPane.showMessageDialog(null, "该学号已存在，请勿重复添加学生信息！");
					}
					else{//否则，添加学生信息
						insert.Inser_toinfo(userid, username, usersex, useragei, userstudydate, usermajor, userclassidi, useraddress, usertel);
					}
					
				}
				
				if(flag=="修改信息"){//除了学号，修改其他选项
					//若学号查找不到，提示
					if(!select.Select_info_ID(userid)){
    					System.out.print("输入学号有误！");
						JOptionPane.showMessageDialog(null, "输入信息有误！");
    				}
    				else{
    					update.Update_toinfo(userid, username, usersex, userage, userstudydate, usermajor, userclassidi, useraddress, usertel);
    				}
				}	
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}

	}
  //获取成绩界面的确定按钮的事件监听
    public class get_score extends MouseAdapter{
    	public void mouseClicked(MouseEvent e) {
    		//获取输入框内容
    		String userid=id.getText();
    		String username=name.getText();
    		String usermajor=major.getText();
    		String userclassid=classid.getText();
    		String usermath=math.getText();
    		String userjava=java.getText();
    		String usermysql=mysql.getText();
    		//String 转Int
    		int userclassidi=Integer.parseInt(userclassid);
    		Insert insert=new Insert();
    		Select select=new Select();
    		Update update=new Update();
    		try {
    			if(flag=="增加成绩"){
    				//如果该学号存在，提示
    				if(select.Select_score_ID(userid))
    				{
    					System.out.print("该学号已存在，请勿重复添加学生成绩！");
						JOptionPane.showMessageDialog(null, "该学号已存在，请勿重复添加学生成绩！");
    				}
    				else{//否则，添加学生成绩
    					insert.Inser_toscore(userid, username, usermajor, userclassidi, usermath, userjava, usermysql);
    				}
    				
    			}
    			
    			if(flag=="修改成绩"){//除了学号，修改其他选项
    				//若学号查找不到，提示
    				if(!select.Select_score_ID(userid)){
    					System.out.print("输入学号有误！");
						JOptionPane.showMessageDialog(null, "输入学号有误！");
    				}
    				else{
    					update.Update_toscore(userid, username, usermajor, userclassidi, usermath, userjava, usermysql);
    				}
    				
    			}	
    		}catch (Exception e1) {
				e1.printStackTrace();
			}

    	}
    }


}
