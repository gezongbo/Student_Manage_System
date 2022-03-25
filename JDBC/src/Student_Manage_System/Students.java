package Student_Manage_System;
//学生界面
/*权限：
 * 1、查找该学生成绩或信息
 * 2、查找该学生成绩平均分
 * 3、查找该学生成绩最高分
 * 4、查找该学生成绩最低分
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Snow.Sky;


public class Students {
	JFrame f=new JFrame();
	//学生界面初始化
	public void init() throws Exception
	{
		//创建菜单栏
		JMenuBar bar=new JMenuBar();
		//创建菜单
		JMenu Select_menu=new JMenu("查找功能");
		//创建菜单项
		JMenuItem select_item1=new JMenuItem("学生信息");JMenuItem select_item2=new JMenuItem("学生成绩");
		JMenuItem select_item3=new JMenuItem("学生平均分");JMenuItem select_item4=new JMenuItem("学生最高分");
		JMenuItem select_item5=new JMenuItem("学生最低分");JMenuItem close_item=new JMenuItem("退出");
		
		//给菜单项绑定事件监听
		select_item1.addActionListener(al);select_item2.addActionListener(al);
	    select_item3.addActionListener(al);select_item4.addActionListener(al);
	    select_item5.addActionListener(al);
	   
		//给Close绑定事件监听
		close_item.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.exit(0);//结束
			}
			});
		//将菜单添加到菜单栏
		bar.add(Select_menu);

		//将菜单项添加到菜单
		Select_menu.add(select_item1);Select_menu.add(select_item2);Select_menu.add(select_item3);
		Select_menu.add(select_item4);Select_menu.add(select_item5);Select_menu.add(close_item);
		
		//添加分隔线
		Select_menu.addSeparator();
		
		Sky s=new Sky();
		f.add(s);
		f.setJMenuBar(bar);
		f.setTitle("学生查询系统界面");
		f.setSize(2000, 1000);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		s.action();
	}
	//事件监听
	ActionListener al=new ActionListener(){
		
		public void actionPerformed(ActionEvent e) {
			String str=e.getActionCommand();//获得事件源内容
			Get_info get=new Get_info();//从窗口获取ID,Name
			Select s=new Select();//查询功能类
			if(str.equals("学生信息"))
			{
				try {
					get.student_id_name("查找信息");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(str.equals("学生成绩"))
			{
				try {
					get.student_id_name("查找成绩");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(str.equals("学生平均分"))
			{
				try {
					s.Select_avg();
				} catch (Exception e1) {
					e1.printStackTrace();
				}	
			}
			if(str.equals("学生最高分"))
			{
				try {
					s.Select_max();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			if(str.equals("学生最低分"))
			{
				try {
					s.Select_min();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			
			
		}
	};
	public static void main(String[] args) throws Exception {
		Students stu=new Students();
		stu.init();

	}

}
