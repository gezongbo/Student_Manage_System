package Student_Manage_System;
//ѧ������
/*Ȩ�ޣ�
 * 1�����Ҹ�ѧ���ɼ�����Ϣ
 * 2�����Ҹ�ѧ���ɼ�ƽ����
 * 3�����Ҹ�ѧ���ɼ���߷�
 * 4�����Ҹ�ѧ���ɼ���ͷ�
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
	//ѧ�������ʼ��
	public void init() throws Exception
	{
		//�����˵���
		JMenuBar bar=new JMenuBar();
		//�����˵�
		JMenu Select_menu=new JMenu("���ҹ���");
		//�����˵���
		JMenuItem select_item1=new JMenuItem("ѧ����Ϣ");JMenuItem select_item2=new JMenuItem("ѧ���ɼ�");
		JMenuItem select_item3=new JMenuItem("ѧ��ƽ����");JMenuItem select_item4=new JMenuItem("ѧ����߷�");
		JMenuItem select_item5=new JMenuItem("ѧ����ͷ�");JMenuItem close_item=new JMenuItem("�˳�");
		
		//���˵�����¼�����
		select_item1.addActionListener(al);select_item2.addActionListener(al);
	    select_item3.addActionListener(al);select_item4.addActionListener(al);
	    select_item5.addActionListener(al);
	   
		//��Close���¼�����
		close_item.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.exit(0);//����
			}
			});
		//���˵���ӵ��˵���
		bar.add(Select_menu);

		//���˵�����ӵ��˵�
		Select_menu.add(select_item1);Select_menu.add(select_item2);Select_menu.add(select_item3);
		Select_menu.add(select_item4);Select_menu.add(select_item5);Select_menu.add(close_item);
		
		//��ӷָ���
		Select_menu.addSeparator();
		
		Sky s=new Sky();
		f.add(s);
		f.setJMenuBar(bar);
		f.setTitle("ѧ����ѯϵͳ����");
		f.setSize(2000, 1000);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		s.action();
	}
	//�¼�����
	ActionListener al=new ActionListener(){
		
		public void actionPerformed(ActionEvent e) {
			String str=e.getActionCommand();//����¼�Դ����
			Get_info get=new Get_info();//�Ӵ��ڻ�ȡID,Name
			Select s=new Select();//��ѯ������
			if(str.equals("ѧ����Ϣ"))
			{
				try {
					get.student_id_name("������Ϣ");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(str.equals("ѧ���ɼ�"))
			{
				try {
					get.student_id_name("���ҳɼ�");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(str.equals("ѧ��ƽ����"))
			{
				try {
					s.Select_avg();
				} catch (Exception e1) {
					e1.printStackTrace();
				}	
			}
			if(str.equals("ѧ����߷�"))
			{
				try {
					s.Select_max();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			if(str.equals("ѧ����ͷ�"))
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
