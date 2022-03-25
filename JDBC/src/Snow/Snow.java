package Snow;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Snow extends Thread{
	//背景
	BufferedImage snow_image;
	//大小
	int width,height;
	//位置
	int x,y;
	//速度
	int speed;
	public Snow() throws Exception{
		Random r=new Random();
		//对雪花的特征初始化
		snow_image=ImageIO.read(new File("images/snow.png"));
		width=snow_image.getWidth();
		height=snow_image.getHeight();
		x=r.nextInt(2000);
		y=0;
		speed=r.nextInt(10)+1;
	}
	//行为
	//在run方法中实现雪花的行为
	public void run() {
		while(true)
		{
			y=y+speed;//改变雪花的y坐标位置
			if(y>=1000)
			{
				y=0;
				Random r=new Random();//重新进入天空，改变x坐标。
				x=r.nextInt(2000);//随机产生坐标
				speed=r.nextInt(10)+1;//随机改变雪花的速度	
			}
			try {
				Thread.sleep(30);//线程睡眠
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
