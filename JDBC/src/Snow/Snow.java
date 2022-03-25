package Snow;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Snow extends Thread{
	//����
	BufferedImage snow_image;
	//��С
	int width,height;
	//λ��
	int x,y;
	//�ٶ�
	int speed;
	public Snow() throws Exception{
		Random r=new Random();
		//��ѩ����������ʼ��
		snow_image=ImageIO.read(new File("images/snow.png"));
		width=snow_image.getWidth();
		height=snow_image.getHeight();
		x=r.nextInt(2000);
		y=0;
		speed=r.nextInt(10)+1;
	}
	//��Ϊ
	//��run������ʵ��ѩ������Ϊ
	public void run() {
		while(true)
		{
			y=y+speed;//�ı�ѩ����y����λ��
			if(y>=1000)
			{
				y=0;
				Random r=new Random();//���½�����գ��ı�x���ꡣ
				x=r.nextInt(2000);//�����������
				speed=r.nextInt(10)+1;//����ı�ѩ�����ٶ�	
			}
			try {
				Thread.sleep(30);//�߳�˯��
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
