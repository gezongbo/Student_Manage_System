package Snow;

import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Start {

	public static void main(String[] args) throws Exception {
		Start s=new Start();
		s.Init();
	}
	//³õÊ¼»¯
	public void Init() throws Exception{
		JFrame f=new JFrame();
		
		Sky s=new Sky();
		f.add(s);
		f.setTitle("°×Ñ©Æ®Æ®");
		f.setVisible(true);
		f.setSize(2000, 1000);
		
		f.setLocation(3, 6);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setIconImage(ImageIO.read(new File("images/sky.jpg")));
		s.action();
		
		
	}

}
