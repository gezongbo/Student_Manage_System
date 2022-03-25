package Student_Manage_System;
//��ʦ(����Ա)����
/*Ȩ�ޣ�
 * 1.��������ѧ����Ϣ��ɼ���
 * 2.ɾ������ѧ��ID and Name ,ɾ��ѧ����Ϣ��ɼ�
 * 3.�ģ�(1)�޸�ĳ��ѧ����ȫ����Ϣ(ѧ�ų���)��
 *            (2)�޸�ĳ��ѧ����ȫ���ɼ�(ѧ�ų���)�������ȫ����Ϣ����ָ������Ϣ����Ϊ�գ�
 * 4.�飺(1)����ĳ��ѧ����Ϣ��ɼ�
 *                a.��ID and Name������ѧ����Ϣ��ɼ�,avg,max,min
 *                b.��Major ,����ͬһרҵѧ����Ϣ��ɼ�,avg,max,min
 *                c.��Class,����ͬһ�༶ѧ����Ϣ��ɼ�,avg,max,min
 *            (2) ����ȫ��ѧ����Ϣ��ɼ�
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
	//����Ա�����ʼ��
	public void init() throws Exception
	{
		//�����˵���
		JMenuBar bar=new JMenuBar();
		//�����˵�
		JMenu Insert_menu=new JMenu("���ӹ���");
		JMenu Delete_menu=new JMenu("ɾ������");
		JMenu Select_menu=new JMenu("���ҹ���");
		JMenu Update_menu=new JMenu("�޸Ĺ���");
		JMenu Close_menu=new JMenu("�˳�");
		
		
		//�����˵���
		JMenuItem add_item1=new JMenuItem("������Ϣ");
		JMenuItem add_item2=new JMenuItem("���ӳɼ�");
		JMenuItem delete_item1=new JMenuItem("ɾ����Ϣ");
		JMenuItem delete_item2=new JMenuItem("ɾ���ɼ�");
		JMenuItem select_item1=new JMenuItem("������Ϣ");
		JMenuItem select_item2=new JMenuItem("���ҳɼ�");
		JMenuItem select_item3=new JMenuItem("����ȫ����Ϣ");
		JMenuItem select_item4=new JMenuItem("����ȫ���ɼ�");
		JMenuItem select_item5=new JMenuItem("����ͬһרҵ��Ϣ");
		JMenuItem select_item6=new JMenuItem("����ͬһרҵ�ɼ�");
		JMenuItem select_item7=new JMenuItem("����ͬһ�༶��Ϣ");
		JMenuItem select_item8=new JMenuItem("����ͬһ�༶�ɼ�");
		JMenuItem update_item1=new JMenuItem("�޸���Ϣ");
		JMenuItem update_item2=new JMenuItem("�޸ĳɼ�");
		JMenuItem close_item=new JMenuItem("�˳�");
		
		//���˵�����¼�����
		add_item1.addActionListener(al);add_item2.addActionListener(al);
		delete_item1.addActionListener(al);delete_item2.addActionListener(al);
		select_item1.addActionListener(al);select_item2.addActionListener(al);
		select_item3.addActionListener(al);select_item4.addActionListener(al);
		select_item5.addActionListener(al);select_item6.addActionListener(al);
		select_item7.addActionListener(al);select_item8.addActionListener(al);
		update_item1.addActionListener(al);update_item2.addActionListener(al);
		//��Close���¼�����
		close_item.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.exit(0);//����
			}
			});
		//���˵���ӵ��˵���
		bar.add(Insert_menu);bar.add(Delete_menu);bar.add(Select_menu);
		bar.add(Update_menu);bar.add(Close_menu);
		//���˵�����ӵ��˵�
		Insert_menu.add(add_item1);Insert_menu.add(add_item2);
		Delete_menu.add(delete_item1);Delete_menu.add(delete_item2);
		Select_menu.add(select_item1);Select_menu.add(select_item2);
		Select_menu.add(select_item3);Select_menu.add(select_item4);
		Select_menu.add(select_item5);Select_menu.add(select_item6);
		Select_menu.add(select_item7);Select_menu.add(select_item8);
		Update_menu.add(update_item1);Update_menu.add(update_item2);
		Close_menu.add(close_item);
		//��ӷָ���
		Insert_menu.addSeparator();Delete_menu.addSeparator();
		Select_menu.addSeparator();Update_menu.addSeparator();
		Sky s=new Sky();
		f.add(s);
		f.setJMenuBar(bar);
		f.setTitle("����Ա��Ϣ����ϵͳ");
		f.setSize(2000, 1000);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		s.action();
//		s.repaint();
		
	}
	//�¼�����
	ActionListener al=new ActionListener(){
		
		public void actionPerformed(ActionEvent e) {
			String str=e.getActionCommand();//����¼�Դ����
			Get_info get=new Get_info();//ͨ�����ڻ�ȡѧ����Ϣ
			Select s=new Select();//���ҹ�����
			if(str.equals("������Ϣ")){
				try {
					
					get.student_info_init("������Ϣ");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(str.equals("���ӳɼ�")){
				try {
					get.student_score_init("���ӳɼ�");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(str.equals("ɾ����Ϣ")){
				try {
					get.student_id_name("ɾ����Ϣ");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(str.equals("ɾ���ɼ�")){
				try {
					get.student_id_name("ɾ���ɼ�");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(str.equals("������Ϣ")){
				try {
					get.student_id_name("������Ϣ");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(str.equals("���ҳɼ�")){
				try {
					get.student_id_name("���ҳɼ�");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(str.equals("����ȫ����Ϣ")){
				try {
					s.Select_info();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			if(str.equals("����ȫ���ɼ�")){
				try {
					s.Select_score();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			if(str.equals("����ͬһרҵ��Ϣ")){
				try {
					get.student_Major("����ͬһרҵ��Ϣ");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(str.equals("����ͬһרҵ�ɼ�")){
				try {
					get.student_Major("����ͬһרҵ�ɼ�");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(str.equals("����ͬһ�༶��Ϣ")){
				try {
					get.student_Class("����ͬһ�༶��Ϣ");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(str.equals("����ͬһ�༶�ɼ�")){
				try {
					get.student_Class("����ͬһ�༶�ɼ�");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(str.equals("�޸���Ϣ")){
				try {
					get.student_info_init("�޸���Ϣ");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(str.equals("�޸ĳɼ�")){
				try {
					get.student_score_init("�޸ĳɼ�");
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
