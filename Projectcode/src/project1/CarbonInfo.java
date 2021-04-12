package project1;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import JDBC.MemberDTO;

import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class CarbonInfo {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					CarbonInfo window = new CarbonInfo();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public CarbonInfo(MemberDTO dto) {
		initialize(dto);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(MemberDTO dto) {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(240, 255, 240));
		frame.setBounds(100, 100, 780, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 로고
		ImageIcon logo_img = new ImageIcon("img/logo.jpg");
		Image logo_img2 = logo_img.getImage();
		Image logo_image = logo_img2.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon logo = new ImageIcon(logo_image);
		JLabel lbl_logo = new JLabel(logo);
		lbl_logo.setBounds(12, 10, 100, 100);
		lbl_logo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				main main = new main(dto);
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lbl_logo);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 764, 661);
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		// 로그아웃
		JButton btn_exit = new JButton("LOG OUT");
		btn_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				login login1 = new login();
				login1.main(null);
			}
		});
		btn_exit.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btn_exit.setBorderPainted(false);
		btn_exit.setBackground(Color.WHITE);
		btn_exit.setBounds(602, 10, 126, 30);
		panel.add(btn_exit);

		// 마이페이지
		JButton btn_mypage = new JButton("MY PAGE");
		btn_mypage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				mypage mypage = new mypage(dto);
			}
		});
		btn_mypage.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btn_mypage.setBorderPainted(false);
		btn_mypage.setBackground(Color.WHITE);
		btn_mypage.setBounds(511, 10, 118, 30);
		panel.add(btn_mypage);
		
		JLabel lbl_title = new JLabel("\uD0C4\uC18C \uBC30\uCD9C\uAD8C \uAC70\uB798\uC81C\uB3C4\uB780?");
		lbl_title.setFont(new Font("굴림", Font.BOLD, 20));
		lbl_title.setBounds(247, 62, 270, 39);
		panel.add(lbl_title);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textArea.setText(" - \uC815\uBD80\uAC00 \uC628\uC2E4\uAC00\uC2A4\uB97C \uBC30\uCD9C\uD558\uB294 \uC0AC\uC5C5\uC7A5\uC744 \uB300\uC0C1\uC73C\uB85C \uC5F0\uB2E8\uC704 \uBC30\uCD9C\uAD8C \uD560\uB2F9\uD558\uC5EC \uD560\uB2F9\uBC94\uC704 \r\n  \uB0B4\uC5D0\uC11C \uBC30\uCD9C\uD589\uC704\uB97C \uD560 \uC218 \uC788\uB3C4\uB85D \uD558\uACE0, \uD560\uB2F9\uB41C \uC0AC\uC5C5\uC7A5\uC758 \uC2E4\uC9C8\uC801 \uC628\uC2E4\uAC00\uC2A4 \uBC30\uCD9C\uB7C9\uC744 \r\n  \uD3C9\uAC00\uD558\uC5EC \uC5EC\uBD84 \uB610\uB294 \uBD80\uC871\uBD84\uC758 \uBC30\uCD9C\uAD8C\uC5D0 \uB300\uD558\uC5EC\uB294 \uC0AC\uC5C5\uC7A5\uAC04 \uAC70\uB798\uB97C \uD5C8\uC6A9\uD558\uB294 \uC81C\uB3C4\r\n\r\n - \u2460 \uAD50\uD1A0\uC758\uC815\uC11C \uBC1C\uD6A8('05.2) \u2192 \u2461 \uAD6D\uAC00 \uC628\uC2E4\uAC00\uC2A4 \uAC10\uCD95\uBAA9\uD45C \uC124\uC815('09.11) \r\n \u2192 \u2462 \uB179\uC0C9\uC131\uC7A5\uAE30\uBCF8\uBC95 \uC81C\uC815('10.1) \u2192 \u2463 \uBC30\uCD9C\uAD8C\uAC70\uB798\uC81C\uBC95 \uC81C\uC815('12.5)  \r\n \u2192 \u2464 \uBC30\uCD9C\uAD8C\uAC70\uB798\uC18C \uC9C0\uC815('14.1)\r\n\r\n - \uC9C0\uAD6C\uC628\uB09C\uD654\uC640 \uC774\uC5D0 \uB300\uD55C \uB300\uC751\r\n - \uC628\uC2E4\uAC00\uC2A4 \uC800\uAC10\uC744 \uC704\uD55C \uD658\uACBD\uC815\uCC45 \uC218\uB2E8");
		textArea.setBounds(87, 121, 677, 279);
		panel.add(textArea);
		
		ImageIcon c_img = new ImageIcon("img/infopic.png");
		Image c_img2 = c_img.getImage();
		Image c_image = c_img2.getScaledInstance(560, 250, Image.SCALE_SMOOTH);
		ImageIcon c = new ImageIcon(c_image);
		
		JLabel lbl_definition = new JLabel(c);
		lbl_definition.setBounds(40, 388, 658, 263);
		panel.add(lbl_definition);
		
		ImageIcon exitimg = new ImageIcon("img/back.png");
		Image exitimg1 = exitimg.getImage();
		Image exitscaleimg = exitimg1.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon result = new ImageIcon(exitscaleimg);
		
		
		JLabel lbl_back = new JLabel(result);
		lbl_back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				main main = new main(dto);
			}
		});
		lbl_back.setBounds(12, 298, 63, 57);
		panel.add(lbl_back);
	}
}
