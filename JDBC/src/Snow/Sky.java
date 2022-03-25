package Snow;

import java.awt.Graphics;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Sky extends JPanel{

	//����
	BufferedImage bg;
	//ѩ��
	Snow[] snow=new Snow[100];
	public Sky() throws Exception{
		bg=ImageIO.read(new File("images/kong.jpg"));
		for(int i=0;i<snow.length;i++)
		{
			snow[i]=new Snow();
			snow[i].start();
		}
		
	}
	//����
	public void paint(Graphics g){
	
		
		
		g.drawImage(bg, 0, 0,2000, 1000,null);//������
	
		
			for(int i=0;i<snow.length;i++)
			{
				g.drawImage(snow[i].snow_image, snow[i].x, snow[i].y,snow[i].width,snow[i].height,null);//��ѩ��
			}
		
		
	}
	
	//�Զ��巽������paint()�ظ�ִ��
	public void action(){
		while(true)
		{
			//repaint()�̳и���JPanel,
			repaint();//��paint()����һ�Σ�
		}
	}
	
	

}
