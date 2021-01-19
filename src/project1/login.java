package project1;
//test1
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;
import JDBC.MemberDAO;
import JDBC.MemberDTO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class login {

	private JFrame frame;
	private JTextField txt_id;
	private JTextField txt_password;
	private MemberDTO dto = null;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public login() {
		initialize();
	}

	private void initialize() {

		MemberDAO dao = new MemberDAO();

		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 600, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lbl_login = new JLabel("Log in ");
		lbl_login.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_login.setFont(new Font("Arial Black", Font.ITALIC, 18));
		lbl_login.setBounds(0, 45, 574, 35);
		frame.getContentPane().add(lbl_login);

		JLabel lblNewLabel = new JLabel("ID ");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(225, 157, 57, 15);
		frame.getContentPane().add(lblNewLabel);

		txt_id = new JTextField();
		txt_id.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				txt_id.setText("");
			}
		});
		getTxt_id().setForeground(UIManager.getColor("Button.shadow"));
		getTxt_id().setText("\uC544\uC774\uB514 \uC785\uB825");
		getTxt_id().setBounds(225, 185, 135, 21);
		frame.getContentPane().add(getTxt_id());
		getTxt_id().setColumns(10);

		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Arial", Font.BOLD, 14));
		lblPassword.setBounds(225, 237, 89, 15);
		frame.getContentPane().add(lblPassword);

		txt_password = new JTextField();
		txt_password.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				txt_password.setText("");
			}
		});
		txt_password.setForeground(UIManager.getColor("Button.shadow"));
		txt_password.setText("\uBE44\uBC00\uBC88\uD638 \uC785\uB825");
		txt_password.setColumns(10);
		txt_password.setBounds(225, 262, 135, 21);
		frame.getContentPane().add(txt_password);

		JLabel lblNewLabel_1 = new JLabel("\uD68C\uC6D0 \uAC00\uC785 >> ");
		lblNewLabel_1.setBounds(225, 463, 76, 15);
		frame.getContentPane().add(lblNewLabel_1);

		JButton btn_register = new JButton("Register");
		btn_register.setBorderPainted(false);
		btn_register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 회원가입 페이지로 이동
				frame.dispose();
				register register1 = new register();
				register1.main(null);
				

			}
		});
		btn_register.setFont(new Font("Arial", Font.ITALIC, 12));
		btn_register.setBackground(new Color(255, 255, 255));
		btn_register.setBounds(301, 459, 84, 23);
		frame.getContentPane().add(btn_register);

		JButton btnNewButton = new JButton("\uB85C\uADF8\uC778");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = txt_id.getText();
				String pw = txt_password.getText();
				
				dto = dao.login(new MemberDTO(id, pw));
				txt_id.setText(id);
				txt_password.setText(pw);
				
				main main1 = new main(dto);
				frame.dispose();
		
			}
		});
		
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(247, 307, 91, 23);
		frame.getContentPane().add(btnNewButton);
	}

	public JTextField getTxt_id() {
		return txt_id;
	}
	

}
