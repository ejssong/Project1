package project1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.JSeparator;
import javax.swing.JProgressBar;
import java.awt.ScrollPane;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextPane;
import javax.swing.DropMode;

public class main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main window = new main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 600, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lbl_logo = new JLabel("logo");
		lbl_logo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_logo.setBounds(12, 10, 59, 45);
		frame.getContentPane().add(lbl_logo);
	
		
		ImageIcon image2 = new ImageIcon("img/search.jpg");
		Image img2 = image2.getImage();
		Image scale2 = img2.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
		ImageIcon result2 = new ImageIcon(scale2);
		
		
		JButton btn_add_data = new JButton(result2);
		btn_add_data.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_add_data.setBackground(Color.WHITE);
		btn_add_data.setBorderPainted(false);
		btn_add_data.setBounds(255, 195, 75, 75);
		frame.getContentPane().add(btn_add_data);
		
		ImageIcon image3 = new ImageIcon("img/info.png");
		Image img3 = image3.getImage();
		Image scale3 = img3.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
		ImageIcon result3 = new ImageIcon(scale3);
		
		JButton btn_info = new JButton(result3);
		btn_info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_info.setBackground(Color.WHITE);
		btn_info.setBorderPainted(false);
		btn_info.setBounds(420, 195, 75, 75);
		frame.getContentPane().add(btn_info);
		
		//이미지 삽입
		ImageIcon image1 = new ImageIcon("img/previousdata.jpg");
		Image img1 = image1.getImage();
		Image scale1 = img1.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
		ImageIcon result1 = new ImageIcon(scale1);

		JButton btn_previous = new JButton(result1);
		btn_previous.setBackground(Color.WHITE);
		btn_previous.setBorderPainted(false);
		btn_previous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_previous.setBounds(90, 195, 75, 75);
		frame.getContentPane().add(btn_previous);

		JLabel lblNewLabel = new JLabel("이전데이터");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setText("\uC774\uC804\uB370\uC774\uD130");
		lblNewLabel.setToolTipText("\uC774\uC804\uB370\uC774\uD130");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel.setBounds(69, 291, 103, 15);
		frame.getContentPane().add(lblNewLabel);

		JLabel lbl_add = new JLabel("\uB370\uC774\uD130 \uCD94\uAC00  ");
		lbl_add.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_add.setFont(new Font("굴림", Font.PLAIN, 12));
		lbl_add.setBounds(241, 291, 103, 15);
		frame.getContentPane().add(lbl_add);

		JLabel lbl_info = new JLabel("\uB354 \uB9CE\uC740 \uC815\uBCF4");
		lbl_info.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_info.setFont(new Font("굴림", Font.PLAIN, 12));
		lbl_info.setBounds(413, 291, 103, 15);
		frame.getContentPane().add(lbl_info);

		JTextPane txtpnInfo = new JTextPane();
		txtpnInfo.setDropMode(DropMode.INSERT);
		txtpnInfo.setText("info ");
		txtpnInfo.setBounds(42, 343, 320, 170);
		frame.getContentPane().add(txtpnInfo);
		
		// 여기에 데이터베이스 first_name 가져오기
		JLabel lbl_title = new JLabel("{}님 얀녕하세요 ");
		lbl_title.setFont(new Font("굴림", Font.PLAIN, 15));
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setBounds(12, 114, 574, 26);
		frame.getContentPane().add(lbl_title);
		
//		ImageIcon exitimg = new ImageIcon(
//				"C:\\Users\\smhrd\\Desktop\\workspace\\project1\\src\\image\\logout.png");
//		Image exitimg1 = exitimg.getImage();
//		Image exitscaleimg = exitimg1.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
//		ImageIcon result5 = new ImageIcon(exitscaleimg);
		
		
		JButton btn_exit = new JButton("LOG OUT");
		btn_exit.setFont(new Font("Arial", Font.BOLD, 12));
		btn_exit.setBackground(Color.WHITE);
		btn_exit.setBorderPainted(false);
		btn_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_exit.setBounds(471, 25, 103, 30);
		frame.getContentPane().add(btn_exit);
		
//		ImageIcon mypageimg = new ImageIcon("img/mypage.png");
//		Image mypageimg1 = mypageimg.getImage();
//		Image mypage_scaleimg = mypageimg1.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
//		ImageIcon result4 = new ImageIcon(mypage_scaleimg);
		
		JButton btn_mypage = new JButton("MY PAGE");
		btn_mypage.setFont(new Font("Arial", Font.BOLD, 12));
		btn_mypage.setBorderPainted(false);
		btn_mypage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//마이 페이지로 이동
				frame.dispose();
				mypage mypage1 = new mypage();
				mypage1.main(null);
				
			}
		});
		btn_mypage.setBackground(Color.WHITE);
		btn_mypage.setBorderPainted(false);
		btn_mypage.setBounds(395, 25, 92, 30);
		frame.getContentPane().add(btn_mypage);
	}
}
