package Student_Manage_System;
//教师(管理员)界面
/*权限：
 * 1.增：增加学生信息或成绩；
 * 2.删：根据学生ID and Name ,删除学生信息或成绩
 * 3.改：(1)修改某个学生的全部信息(学号除外)；
 *            (2)修改某个学生的全部成绩(学号除外)；这里的全部信息，是指输入信息不能为空；
 * 4.查：(1)查找某个学生信息或成绩
 *                a.按ID and Name，查找学生信息或成绩,avg,max,min
 *                b.按Major ,查找同一专业学生信息或成绩,avg,max,min
 *                c.按Class,查找同一班级学生信息或成绩,avg,max,min
 *            (2) 查找全部学生信息或成绩
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import Snow.Sky;



public class Teacher {

	JFrame f=new JFrame();
	//管理员界面初始化
	public void init() throws Exception
	{
		//创建菜单栏
		JMenuBar bar=new JMenuBar();
		//创建菜单
		JMenu Insert_menu=new JMenu("增加功能");
		JMenu Delete_menu=new JMenu("删除功能");
		JMenu Select_menu=new JMenu("查找功能");
		JMenu Update_menu=new JMenu("修改功能");
		JMenu Close_menu=new JMenu("退出");
		
		
		//创建菜单项
		JMenuItem add_item1=new JMenuItem("增加信息");
		JMenuItem add_item2=new JMenuItem("增加成绩");
		JMenuItem delete_item1=new JMenuItem("删除信息");
		JMenuItem delete_item2=new JMenuItem("删除成绩");
		JMenuItem select_item1=new JMenuItem("查找信息");
		JMenuItem select_item2=new JMenuItem("查找成绩");
		JMenuItem select_item3=new JMenuItem("查找全部信息");
		JMenuItem select_item4=new JMenuItem("查找全部成绩");
		JMenuItem select_item5=new JMenuItem("查找同一专业信息");
		JMenuItem select_item6=new JMenuItem("查找同一专业成绩");
		JMenuItem select_item7=new JMenuItem("查找同一班级信息");
		JMenuItem select_item8=new JMenuItem("查找同一班级成绩");
		JMenuItem update_item1=new JMenuItem("修改信息");
		JMenuItem update_item2=new JMenuItem("修改成绩");
		JMenuItem close_item=new JMenuItem("退出");
		
		//给菜单项绑定事件监听
		add_item1.addActionListener(al);add_item2.addActionListener(al);
		delete_item1.addActionListener(al);delete_item2.addActionListener(al);
		select_item1.addActionListener(al);select_item2.addActionListener(al);
		select_item3.addActionListener(al);select_item4.addActionListener(al);
		select_item5.addActionListener(al);select_item6.addActionListener(al);
		select_item7.addActionListener(al);select_item8.addActionListener(al);
		update_item1.addActionListener(al);update_item2.addActionListener(al);
		//给Close绑定事件监听
		close_item.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.exit(0);//结束
			}
			});
		//将菜单添加到菜单栏
		bar.add(Insert_menu);bar.add(Delete_menu);bar.add(Select_menu);
		bar.add(Update_menu);bar.add(Close_menu);
		//将菜单项添加到菜单
		Insert_menu.add(add_item1);Insert_menu.add(add_item2);
		Delete_menu.add(delete_item1);Delete_menu.add(delete_item2);
		Select_menu.add(select_item1);Select_menu.add(select_item2);
		Select_menu.add(select_item3);Select_menu.add(select_item4);
		Select_menu.add(select_item5);Select_menu.add(select_item6);
		Select_menu.add(select_item7);Select_menu.add(select_item8);
		Update_menu.add(update_item1);Update_menu.add(update_item2);
		Close_menu.add(close_item);
		//添加分隔线
		Insert_menu.addSeparator();Delete_menu.addSeparator();
		Select_menu.addSeparator();Update_menu.addSeparator();
		Sky s=new Sky();
		f.add(s);
		f.setJMenuBar(bar);
		f.setTitle("管理员信息管理系统");
		f.setSize(2000, 1000);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		s.action();
//		s.repaint();
		
	}
	//事件监听
	ActionListener al=new ActionListener(){
		
		public void actionPerformed(ActionEvent e) {
			String str=e.getActionCommand();//获得事件源内容
			Get_info get=new Get_info();//通过窗口获取学生信息
			Select s=new Select();//查找功能类
			if(str.equals("增加信息")){
				try {
					
					get.student_info_init("增加信息");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(str.equals("增加成绩")){
				try {
					get.student_score_init("增加成绩");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(str.equals("删除信息")){
				try {
					get.student_id_name("删除信息");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(str.equals("删除成绩")){
				try {
					get.student_id_name("删除成绩");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(str.equals("查找信息")){
				try {
					get.student_id_name("查找信息");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(str.equals("查找成绩")){
				try {
					get.student_id_name("查找成绩");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(str.equals("查找全部信息")){
				try {
					s.Select_info();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			if(str.equals("查找全部成绩")){
				try {
					s.Select_score();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			if(str.equals("查找同一专业信息")){
				try {
					get.student_Major("查找同一专业信息");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(str.equals("查找同一专业成绩")){
				try {
					get.student_Major("查找同一专业成绩");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(str.equals("查找同一班级信息")){
				try {
					get.student_Class("查找同一班级信息");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(str.equals("查找同一班级成绩")){
				try {
					get.student_Class("查找同一班级成绩");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(str.equals("修改信息")){
				try {
					get.student_info_init("修改信息");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(str.equals("修改成绩")){
				try {
					get.student_score_init("修改成绩");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			
		}
	};
	
	public static void main(String[] args) throws Exception {
		Teacher tea=new Teacher();
		tea.init();
		

	}

}
