package project1;

import JDBC.MemberDAO;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class register {

	private JFrame frame;
	private JTextField txt_id;
	private JTextField txt_last_name;
	private JPasswordField txt_password;
	private JTextField txt_first_name;
	private JTextField txt_phone;
	private JTextField txt_car;
	JButton btn_register;
	JCheckBox checkbox;
	JButton btn_id_check;
	MemberDAO dao = new MemberDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					register window = new register();
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
	public register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 620, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lbl_register = new JLabel("Register");
		lbl_register.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_register.setFont(new Font("Arial Black", Font.ITALIC, 18));
		lbl_register.setBounds(1, 45, 604, 25);
		frame.getContentPane().add(lbl_register);

		JLabel lbl_id = new JLabel("ID ");
		lbl_id.setFont(new Font("Arial", Font.BOLD, 12));
		lbl_id.setBounds(223, 159, 50, 15);
		frame.getContentPane().add(lbl_id);

		txt_id = new JTextField();
		txt_id.setBounds(222, 191, 91, 21);
		frame.getContentPane().add(txt_id);
		txt_id.setColumns(10);

		JLabel lbl_name = new JLabel("NAME");
		lbl_name.setFont(new Font("Arial", Font.BOLD, 12));
		lbl_name.setBounds(221, 222, 50, 15);
		frame.getContentPane().add(lbl_name);

		txt_last_name = new JTextField();
		txt_last_name.setForeground(Color.LIGHT_GRAY);
		txt_last_name.setText("\uC131");
		txt_last_name.setColumns(10);
		txt_last_name.setBounds(222, 247, 50, 21);
		frame.getContentPane().add(txt_last_name);

		JLabel lbl_password = new JLabel("PASSWORD");
		lbl_password.setFont(new Font("Arial", Font.BOLD, 12));
		lbl_password.setBounds(217, 284, 115, 15);
		frame.getContentPane().add(lbl_password);

		txt_password = new JPasswordField();
		txt_password.setEchoChar('*');
		txt_password.setToolTipText("\uC554\uD638");
		txt_password.setHorizontalAlignment(SwingConstants.LEFT);
		txt_password.setBounds(221, 309, 161, 21);
		frame.getContentPane().add(txt_password);

		btn_id_check = new JButton("\uC911\uBCF5\uD655\uC778");
		btn_id_check.setFont(new Font("굴림", Font.PLAIN, 11));

		btn_id_check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (dao.ExistID(txt_id.getText())) {
					JOptionPane.showMessageDialog(null, "아이디 존재");
					txt_id.setText(""); // 빈칸으로 다시 돌리기
				} else {
					JOptionPane.showMessageDialog(null, "사용가능 아이디!");
				}

			}
		});
		btn_id_check.setBackground(Color.WHITE);
		btn_id_check.setBorderPainted(false);
		btn_id_check.setBounds(325, 188, 91, 23);
		frame.getContentPane().add(btn_id_check);

		btn_register = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btn_register.setFont(new Font("굴림", Font.PLAIN, 12));
		btn_register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = txt_id.getText();
				String first = txt_first_name.getText();
				String last = txt_last_name.getText();
				String phone = txt_phone.getText();
				String password = txt_password.getText();
				String car = txt_car.getText();

				// JOptionPane.showMessageDialog(null, "회원가입 완료!");

				if (id.isEmpty() || first.isEmpty() || last.isEmpty() || phone.isEmpty() || password.isEmpty()
						|| !checkbox.isSelected()) {
					// txt_id.setBorder(BorderFactory.createLineBorder(Color.BLUE));
					// JOptionPane.showMessageDialog(null,"아이디 입력하세요. ");
					System.out.println("빈칸 존재 ");

				} else {
					dao.Register(id, first, last, password, phone, car);
					JOptionPane.showMessageDialog(null, "회원가입 완료!");
					frame.dispose();
					login login1 = new login();
					login1.main(null);

				}

			}
		});
		btn_register.setBackground(Color.WHITE);
		btn_register.setBorderPainted(false);
		btn_register.setBounds(256, 520, 91, 23);
		frame.getContentPane().add(btn_register);

		checkbox = new JCheckBox("\uAC1C\uC778\uC815\uBCF4 \uC218\uC9D1 \uBC0F \uC0AC\uC6A9 \uB3D9\uC758");
		checkbox.setHorizontalAlignment(SwingConstants.CENTER);
		checkbox.setFont(new Font("굴림", Font.PLAIN, 11));
		checkbox.setBackground(Color.WHITE);
		checkbox.setBounds(18, 474, 567, 23);
		frame.getContentPane().add(checkbox);

		txt_first_name = new JTextField();
		txt_first_name.setForeground(Color.LIGHT_GRAY);
		txt_first_name.setText("\uC774\uB984");
		txt_first_name.setColumns(10);
		txt_first_name.setBounds(282, 247, 99, 21);
		frame.getContentPane().add(txt_first_name);

		JLabel lbl_car = new JLabel("\uCC28\uBC88\uD638");
		lbl_car.setFont(new Font("굴림체", Font.PLAIN, 12));
		lbl_car.setBounds(223, 400, 115, 15);
		frame.getContentPane().add(lbl_car);

		JLabel lbl_phone = new JLabel("PHONE NUMBER");
		lbl_phone.setFont(new Font("Arial", Font.BOLD, 12));
		lbl_phone.setBounds(219, 344, 115, 15);
		frame.getContentPane().add(lbl_phone);

		txt_phone = new JTextField();
		txt_phone.setColumns(10);
		txt_phone.setBounds(223, 369, 159, 21);
		frame.getContentPane().add(txt_phone);

		txt_car = new JTextField();
		txt_car.setColumns(10);
		txt_car.setBounds(223, 425, 159, 21);
		frame.getContentPane().add(txt_car);
	}

}
