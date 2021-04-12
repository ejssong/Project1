package project1;

//test1
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

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
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;

public class login {

	private JFrame frame;
	private JTextField txt_id;
	private MemberDTO dto = null;
	private JPasswordField txt_password;
	private JLabel lbl_error;
	private JSeparator separator;
	private JSeparator separator1;

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
		frame.setForeground(new Color(0, 0, 0));
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 600, 850);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// 이미지 삽입
		ImageIcon image1 = new ImageIcon("img/login.jpg");
		Image img1 = image1.getImage();
		Image scale1 = img1.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon result1 = new ImageIcon(scale1);

		JLabel lbl_login1 = new JLabel(result1);
		lbl_login1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String id = txt_id.getText();
				String pw = txt_password.getText();

				dto = dao.login(new MemberDTO(id, pw));
				txt_id.setText(id);
				txt_password.setText(pw);

				if (dto != null) {
					separator.setForeground(Color.black);
					separator1.setForeground(Color.black);
					main main1 = new main(dto);
					frame.dispose();
				} else {
					separator.setForeground(Color.red);
					separator1.setForeground(Color.red);
					lbl_error.setForeground(Color.red);
					lbl_error.setText("잘못된 정보입니다. 다시 입력하세요. ");
					// JOptionPane.showMessageDialog(null, "로그인실패");
					txt_id.setText(""); // 빈칸으로 다시 돌리기
					txt_password.setText("");
				}

			}
		});
		lbl_login1.setBounds(365, 376, 30, 30);
		frame.getContentPane().add(lbl_login1);

		JLabel lbl_login = new JLabel("Log In ");
		lbl_login.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_login.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 35));
		lbl_login.setBounds(0, 75, 584, 81);
		frame.getContentPane().add(lbl_login);

		JLabel lblNewLabel = new JLabel("ID ");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel.setBounds(200, 237, 68, 37);
		frame.getContentPane().add(lblNewLabel);

		txt_id = new JTextField();
		txt_id.setFont(new Font("굴림", Font.PLAIN, 13));
		getTxt_id().setForeground(Color.BLACK);
		getTxt_id().setBounds(200, 285, 135, 21);
		getTxt_id().setOpaque(false);
		getTxt_id().setBorder(null);

		frame.getContentPane().add(getTxt_id());
		getTxt_id().setColumns(10);

		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblPassword.setBounds(200, 339, 135, 30);

		frame.getContentPane().add(lblPassword);

		JLabel lblNewLabel_1 = new JLabel("\uD68C\uC6D0 \uAC00\uC785 >> ");
		lblNewLabel_1.setFont(new Font("굴림체", Font.BOLD, 16));
		lblNewLabel_1.setBounds(186, 643, 116, 54);
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
		btn_register.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btn_register.setBackground(new Color(255, 255, 255));
		btn_register.setBounds(290, 648, 105, 43);
		frame.getContentPane().add(btn_register);

		txt_password = new JPasswordField();
		txt_password.setForeground(Color.BLACK);
		txt_password.setBounds(200, 376, 135, 21);
		txt_password.setBorder(null);
		frame.getContentPane().add(txt_password);

		separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(200, 304, 148, 2);
		frame.getContentPane().add(separator);

		separator1 = new JSeparator();
		separator1.setForeground(Color.BLACK);
		separator1.setBounds(200, 401, 148, 2);
		frame.getContentPane().add(separator1);

		lbl_error = new JLabel("");
		lbl_error.setFont(new Font("굴림체", Font.PLAIN, 11));
		lbl_error.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_error.setBounds(179, 447, 225, 15);
		frame.getContentPane().add(lbl_error);

	}

	public JTextField getTxt_id() {
		return txt_id;
	}
}
