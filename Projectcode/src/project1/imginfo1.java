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
		//��� ���� �ǳ���?
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		// � �̹����� ���� �����Űǰ���?
		ImageIcon image = new ImageIcon("img/infotext.png");
		// ������ ��������� �ϰ� ��������
		Image imageTemp = image.getImage();
		ImageIcon resultImage = new ImageIcon(imageTemp.getScaledInstance(700, 630, Image.SCALE_SMOOTH));
		
		JLabel lblNewLabel = new JLabel(resultImage);
		lblNewLabel.setBounds(0, 32, 700, 630);
		frame.getContentPane().add(lblNewLabel);

	}
}
