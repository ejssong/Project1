package project1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class mypage {

	private JFrame frame;
	private JTextField txt_id_update;
	private JTextField txt_pw_update;
	private JButton btnNewButton;
	private JButton btn_logout;
	private JButton btn_remove;
	private JButton btn_back;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mypage window = new mypage();
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
	public mypage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MY PAGE");
		lblNewLabel.setFont(new Font("Arial Black", Font.ITALIC, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(151, 45, 282, 35);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lbl_id_update = new JLabel("ID : ");
		lbl_id_update.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_id_update.setBounds(132, 181, 104, 25);
		frame.getContentPane().add(lbl_id_update);
		
		txt_id_update = new JTextField();
		txt_id_update.setText("");
		txt_id_update.setBounds(248, 181, 169, 24);
		frame.getContentPane().add(txt_id_update);
		txt_id_update.setColumns(10);
		
		JLabel lbl_pw_update = new JLabel("PASSWORD :");
		lbl_pw_update.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_pw_update.setBounds(132, 234, 104, 25);
		frame.getContentPane().add(lbl_pw_update);
		
		txt_pw_update = new JTextField();
		txt_pw_update.setText("");
		txt_pw_update.setColumns(10);
		txt_pw_update.setBounds(248, 236, 169, 24);
		frame.getContentPane().add(txt_pw_update);
		
		btnNewButton = new JButton("\uBCC0\uACBD");
		btnNewButton.setFont(new Font("±¼¸²", Font.PLAIN, 12));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(442, 236, 64, 24);
		frame.getContentPane().add(btnNewButton);
		
		btn_logout = new JButton("\uB85C\uADF8\uC544\uC6C3");
		btn_logout.setFont(new Font("±¼¸²Ã¼", Font.PLAIN, 12));
		btn_logout.setBackground(Color.WHITE);
		btn_logout.setBounds(373, 627, 87, 23);
		frame.getContentPane().add(btn_logout);
		
		btn_remove = new JButton("\uD68C\uC6D0\uD0C8\uD1F4");
		btn_remove.setFont(new Font("±¼¸²Ã¼", Font.PLAIN, 12));
		btn_remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_remove.setBackground(Color.WHITE);
		btn_remove.setBounds(472, 627, 87, 23);
		frame.getContentPane().add(btn_remove);
		
		
	
		ImageIcon deleteimg = new ImageIcon("./img/back.png");
		Image backimg = deleteimg.getImage();
		Image mypage_deleteimage = backimg.getScaledInstance(50, 40, Image.SCALE_SMOOTH);
		ImageIcon resultimg = new ImageIcon(mypage_deleteimage);
		
		btn_back = new JButton(resultimg);
		btn_back.setBorderPainted(false);
		btn_back.setIcon(new ImageIcon());
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		btn_back.setBackground(Color.WHITE);
		btn_back.setBounds(22, 39, 50, 40);
		frame.getContentPane().add(btn_back);
		frame.setBounds(100, 100, 600, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
