package project1;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class imginfo1 {

	private JFrame frame;
	public imginfo1() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//어디서 띄우면 되나용?
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		// 어떤 이미지를 띄우고 싶으신건가용?
		ImageIcon image = new ImageIcon("img/infotext.png");
		// 사이즈 어느정도로 하고 싶으신지
		Image imageTemp = image.getImage();
		ImageIcon resultImage = new ImageIcon(imageTemp.getScaledInstance(700, 630, Image.SCALE_SMOOTH));
		
		JLabel lblNewLabel = new JLabel(resultImage);
		lblNewLabel.setBounds(0, 32, 700, 630);
		frame.getContentPane().add(lblNewLabel);

	}
}
