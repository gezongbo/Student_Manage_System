package Student_Manage_System;
//������������棬��ȡѧ����Ϣ��������ɾ��ĵȲ���
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

//��ȡѧ����Ϣ
public class Get_info {
	//�������
	JFrame f=new JFrame();
	FlowLayout layout=new FlowLayout(FlowLayout.LEFT,30,40);//����
	JPanel p=new JPanel(layout);
	
	//�ı���
	JTextField id=new JTextField(11);JTextField name=new JTextField(11);
	JTextField sex=new JTextField(11);JTextField age=new JTextField(11);
	JTextField studydate=new JTextField(11);JTextField major=new JTextField(11);
	JTextField classid=new JTextField(11);JTextField address=new JTextField(11);
	JTextField tel=new JTextField(11);JTextField math=new JTextField(11);
	JTextField java=new JTextField(11);JTextField mysql=new JTextField(11);
	
    //��ǩ
    JLabel label_id=new JLabel("ѧ��");JLabel label_name = new JLabel("����");
	JLabel label_sex=new JLabel("�Ա�");JLabel label_age = new JLabel("����");
	JLabel label_studydate=new JLabel("��ѧ����");JLabel label_major = new JLabel("רҵ");
	JLabel label_classid=new JLabel("�༶");JLabel label_address = new JLabel("��ͥ��ַ");
	JLabel label_tel=new JLabel("��ϵ��ʽ");JLabel label_math = new JLabel("Math�ɼ�");
	JLabel label_java=new JLabel("Java�ɼ�");JLabel label_mysql=new JLabel("MySQL�ɼ�");
	//��ť
	JButton btn1=new JButton("ȷ��");JButton btn2=new JButton("ȡ��");
	 String flag;//��־
	//��ȡѧ����Ϣ�Ľ���
    public  void student_info_init(String str) throws Exception
    {

    	flag=str;
    	//get_info�ڲ��࣬�󶨵���ťbtn1;
		get_info info=new get_info();
		btn1.addActionListener(info);
		btn2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.exit(0);//����
			}
			});
    	p.add(label_id);p.add(id);p.add(label_name);p.add(name);p.add(label_sex);p.add(sex);
    	p.add(label_age);p.add(age);p.add(label_studydate);p.add(studydate);
    	p.add(label_major);p.add(major);p.add(label_classid);p.add(classid);
    	p.add(label_address);p.add(address);p.add(label_tel);p.add(tel);
    	id.setToolTipText("������ѧ����ѧ��");
    	name.setToolTipText("�벻Ҫ��������");
    	sex.setToolTipText("�벻Ҫ��������");
    	studydate.setToolTipText("�밴�����¸�ʽ,����:20190901");
    	major.setToolTipText("�벻Ҫ��������");
    	address.setToolTipText("�벻Ҫ��������");
    	p.add(btn1);p.add(btn2);
    	f.add(p);
    	f.setVisible(true);//���ô���ɼ�
    	f.setSize(280,700);
    	f.setLocation(700, 100);
    	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�رմ���
    }
  
  //��ȡѧ���ɼ��Ľ���
    public void student_score_init(String str) throws Exception
    {
 
    	flag=str;
    	//get_score�ڲ��࣬�󶨵���ťbtn1;
		get_score score=new get_score();
		btn1.addMouseListener(score);
		btn2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.exit(0);//����
			}
			});
    	p.add(label_id);p.add(id);p.add(label_name);p.add(name);
    	p.add(label_major);p.add(major);p.add(label_classid);p.add(classid);
    	p.add(label_math);p.add(math);p.add(label_java);p.add(java);p.add(label_mysql);p.add(mysql);
    	p.add(btn1);p.add(btn2);
    	id.setToolTipText("������ѧ����ѧ��");
    	name.setToolTipText("�벻Ҫ��������");
    	major.setToolTipText("�벻Ҫ��������");
    	math.setToolTipText("�ɼ���Χ:[0,100]");
    	java.setToolTipText("�ɼ���Χ:[0,100]");
    	mysql.setToolTipText("�ɼ���Χ:[0,100]");
    	f.add(p);
    	f.setVisible(true);//���ô���ɼ�
    	f.setSize(280,600);
    	f.setLocation(700, 100);
    	
    	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�رմ���
    }
    //��ȡѧ��id����������
    public void student_id_name(String str) throws Exception{
    
    	flag=str;
    	//�ڲ��࣬�󶨵���ťbtn1;
    	myClick mc=new myClick();
    	btn1.addMouseListener(mc);
    	btn2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.exit(0);//����
			}
			});

    	p.add(label_id);p.add(id);p.add(label_name);p.add(name);p.add(btn1);p.add(btn2);
    	id.setToolTipText("������ѧ����ѧ��");
    	name.setToolTipText("�벻Ҫ��������");
    	f.add(p);
    	f.setVisible(true);//���ô���ɼ�
    	f.setSize(220,500);
    	f.setLocation(700, 100);
    	
    	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�رմ���
    }
  //��ȡѧ��רҵ��Ϣ����
    public void student_Major(String str) throws Exception{
    	
    	flag=str;
    	//�ڲ��࣬�󶨵���ťbtn1;
    	myClick mc=new myClick();
    	btn1.addMouseListener(mc);
    	btn2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.exit(0);//����
			}
			});
    	
    	p.add(label_major);p.add(major);
    	p.add(btn1);p.add(btn2);
    	major.setToolTipText("�벻Ҫ��������");
    	f.add(p);
    	f.setVisible(true);//���ô���ɼ�
    	f.setSize(200,300);
    	f.setLocation(700, 100);
    	
    	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�رմ���
    }
  //��ȡѧ���༶��Ϣ����
    public void student_Class(String str) throws Exception{
    	flag=str;
    	//�ڲ��࣬�󶨵���ťbtn1;
    	myClick mc=new myClick();
    	btn1.addMouseListener(mc);
    	btn2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.exit(0);//����
			}
			});
    	
    	p.add(label_classid);p.add(classid);
    	p.add(btn1);p.add(btn2);
    	f.add(p);
    	f.setVisible(true);//���ô���ɼ�
    	f.setSize(200,300);
    	f.setLocation(700, 100);
    	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�رմ���
    }
	//�����ڲ���--ʵ�ְ�ť���¼�����
	public class myClick extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			//��ȡѧ����ѧ�ź�����
			String userid=id.getText();
			String username=name.getText();
			String usermajor=major.getText();
			String userclassid=classid.getText();
			try {
				Select s=new Select();
				Delete d=new Delete();
				
				if(flag=="������Ϣ"){//����ѧ����ѧ�ź���������ѧ����Ϣ
					if(s.Select_info(userid, username)){
						System.out.print("ѧ����Ϣ���ҳɹ���");
//						JOptionPane.showMessageDialog(null, "ѧ����Ϣ���ҳɹ���");
					}
					else{
						//δ���ҵ���ѧ��
						System.out.print("������Ϣ����");
						JOptionPane.showMessageDialog(null, "������Ϣ����");
					}
					
				}
				if(flag=="���ҳɼ�"){//����ѧ����ѧ�ź���������ѧ���ɼ�
					if(s.Select_score(userid, username)){
						System.out.print("ѧ���ɼ����ҳɹ���");
					}
					else{//δ���ҵ���ѧ��
						System.out.print("������Ϣ����");
						JOptionPane.showMessageDialog(null, "������Ϣ����");
					}
				}	
				if(flag=="����ͬһרҵ��Ϣ"){//����ѧ��Major����ѧ����Ϣ
					if(s.Select_major_info(usermajor)){
						System.out.print("���ҳɹ���");
					}
					else{
						//δ���ҵ���רҵ
						System.out.print("������Ϣ����");
						JOptionPane.showMessageDialog(null, "������Ϣ����");
					}
				}
				if(flag=="����ͬһרҵ�ɼ�"){//����ѧ��Major����ѧ���ɼ�
					if(s.Select_major_score(usermajor)){
						System.out.print("���ҳɹ���");
					}
					else{//δ���ҵ���רҵ
						System.out.print("������Ϣ����");
						JOptionPane.showMessageDialog(null, "������Ϣ����");
					}
				}
				if(flag=="����ͬһ�༶��Ϣ"){//����ѧ��Class����ѧ����Ϣ
					if(s.Select_class_info(userclassid)){
						System.out.print("���ҳɹ���");
					}
					else{//δ���ҵ��ð༶
						System.out.print("������Ϣ����");
						JOptionPane.showMessageDialog(null, "������Ϣ����");
					}
				}
				if(flag=="����ͬһ�༶�ɼ�"){//����ѧ��Class����ѧ���ɼ�
					if(s.Select_class_score(userclassid)){
						
					}
					else{//δ���ҵ��ð༶
						System.out.print("������Ϣ����");
						JOptionPane.showMessageDialog(null, "������Ϣ����");
					}
				}
				if(flag=="ɾ����Ϣ"){//����ѧ����ѧ�ź�����ɾ��ѧ����Ϣ
					//�����ѧ�Ų����ڣ���ʾ
					if(!s.Select_info_ID(userid)){
						System.out.print("��ѧ�Ų����ڣ������ظ�ɾ��ѧ����Ϣ��");
						JOptionPane.showMessageDialog(null, "��ѧ�Ų����ڣ������ظ�ɾ��ѧ����Ϣ��");
					}
					else if(s.Select_info(userid,username)){//����Ҫɾ��ѧ����ID���������ҳɹ���ɾ����ѧ����Ϣ
						d.Delete_toinfo(userid, username);
					}
					else{
						System.out.print("������Ϣ����");
						JOptionPane.showMessageDialog(null, "������Ϣ����");
					}
				}
				if(flag=="ɾ���ɼ�"){//����ѧ����ѧ�ź�����ɾ��ѧ���ɼ�
					//�����ѧ�Ų����ڣ���ʾ
					if(!s.Select_score_ID(userid)){
						System.out.print("��ѧ�Ų����ڣ������ظ�ɾ��ѧ���ɼ���");
						JOptionPane.showMessageDialog(null, "��ѧ�Ų����ڣ������ظ�ɾ��ѧ���ɼ���");
					}
					else if(s.Select_score(userid,username)){//����Ҫɾ��ѧ����ID���������ҳɹ���ɾ����ѧ���ɼ�
						d.Delete_toscore(userid, username);
					}
					else{
						System.out.print("������Ϣ����");
						JOptionPane.showMessageDialog(null, "������Ϣ����");
					}
				}	
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		}
	}
    //��ȡ��Ϣ�����ȷ����ť���¼�����
    public class get_info implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//��ȡ���������
			String userid=id.getText();
			String username=name.getText();
			String usersex=sex.getText();
			String userage=age.getText();
			String userstudydate=studydate.getText();
			String usermajor=major.getText();
			String userclassid=classid.getText();
			String useraddress=address.getText();
			String usertel=tel.getText();
			
			//String תInt
			int useragei=Integer.parseInt(userage);
			int userclassidi=Integer.parseInt(userclassid);
			Insert insert=new Insert();
			Select select=new Select();
			Update update=new Update();
			try {
				if(flag=="������Ϣ"){
					//�����ѧ�Ŵ��ڣ���ʾ
					if(select.Select_info_ID(userid)){
						System.out.print("��ѧ���Ѵ��ڣ������ظ����ѧ����Ϣ��");
						JOptionPane.showMessageDialog(null, "��ѧ���Ѵ��ڣ������ظ����ѧ����Ϣ��");
					}
					else{//�������ѧ����Ϣ
						insert.Inser_toinfo(userid, username, usersex, useragei, userstudydate, usermajor, userclassidi, useraddress, usertel);
					}
					
				}
				
				if(flag=="�޸���Ϣ"){//����ѧ�ţ��޸�����ѡ��
					//��ѧ�Ų��Ҳ�������ʾ
					if(!select.Select_info_ID(userid)){
    					System.out.print("����ѧ������");
						JOptionPane.showMessageDialog(null, "������Ϣ����");
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
  //��ȡ�ɼ������ȷ����ť���¼�����
    public class get_score extends MouseAdapter{
    	public void mouseClicked(MouseEvent e) {
    		//��ȡ���������
    		String userid=id.getText();
    		String username=name.getText();
    		String usermajor=major.getText();
    		String userclassid=classid.getText();
    		String usermath=math.getText();
    		String userjava=java.getText();
    		String usermysql=mysql.getText();
    		//String תInt
    		int userclassidi=Integer.parseInt(userclassid);
    		Insert insert=new Insert();
    		Select select=new Select();
    		Update update=new Update();
    		try {
    			if(flag=="���ӳɼ�"){
    				//�����ѧ�Ŵ��ڣ���ʾ
    				if(select.Select_score_ID(userid))
    				{
    					System.out.print("��ѧ���Ѵ��ڣ������ظ����ѧ���ɼ���");
						JOptionPane.showMessageDialog(null, "��ѧ���Ѵ��ڣ������ظ����ѧ���ɼ���");
    				}
    				else{//�������ѧ���ɼ�
    					insert.Inser_toscore(userid, username, usermajor, userclassidi, usermath, userjava, usermysql);
    				}
    				
    			}
    			
    			if(flag=="�޸ĳɼ�"){//����ѧ�ţ��޸�����ѡ��
    				//��ѧ�Ų��Ҳ�������ʾ
    				if(!select.Select_score_ID(userid)){
    					System.out.print("����ѧ������");
						JOptionPane.showMessageDialog(null, "����ѧ������");
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
