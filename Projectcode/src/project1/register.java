package project1;

import JDBC.MemberDAO;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JSeparator;

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
	JCheckBox checkbox1;
	JButton btn_id_check;
	MemberDAO dao = new MemberDAO();
	private JSeparator separator;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private JSeparator separator_4;
	private JSeparator separator_5;
	private JLabel lbl_error;
	private JLabel lbl_error1;
	private JPanel panel;

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
		frame.setBounds(100, 100, 600, 850);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		ImageIcon logo_img = new ImageIcon("img/logo.jpg");
		Image logo_img2 = logo_img.getImage();
		Image logo_image = logo_img2.getScaledInstance(271, 241, Image.SCALE_SMOOTH);
		ImageIcon logo = new ImageIcon(logo_image);

		ImageIcon exitimg = new ImageIcon("img/back11111.png");
		Image exitimg1 = exitimg.getImage();
		Image exitscaleimg = exitimg1.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon result = new ImageIcon(exitscaleimg);

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 584, 851);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lbl_register = new JLabel("Register");
		lbl_register.setBounds(0, 71, 583, 45);
		panel.add(lbl_register);
		lbl_register.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_register.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));

		JLabel lbl_id = new JLabel("ID ");
		lbl_id.setBounds(215, 207, 50, 15);
		panel.add(lbl_id);
		lbl_id.setFont(new Font("Arial", Font.BOLD, 15));

		txt_id = new JTextField();
		txt_id.setBounds(215, 232, 91, 21);
		panel.add(txt_id);
		txt_id.setBorder(null);
		txt_id.setColumns(10);

		JLabel lbl_name = new JLabel("NAME");
		lbl_name.setBounds(215, 296, 50, 15);
		panel.add(lbl_name);
		lbl_name.setFont(new Font("Arial", Font.BOLD, 15));

		txt_last_name = new JTextField();
		txt_last_name.setBounds(215, 321, 50, 21);
		panel.add(txt_last_name);
		txt_last_name.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txt_last_name.setText("");
			}
		});
		txt_last_name.setForeground(Color.BLACK);
		txt_last_name.setBorder(null);
		txt_last_name.setText("\uC131");
		txt_last_name.setColumns(10);

		JLabel lbl_password = new JLabel("PASSWORD");
		lbl_password.setBounds(214, 373, 115, 15);
		panel.add(lbl_password);
		lbl_password.setFont(new Font("Arial", Font.BOLD, 15));

		txt_password = new JPasswordField();
		txt_password.setBounds(215, 396, 161, 21);
		panel.add(txt_password);
		txt_password.setEchoChar('*');
		txt_password.setToolTipText("\uC554\uD638");
		txt_password.setBorder(null);
		txt_password.setHorizontalAlignment(SwingConstants.LEFT);

		btn_id_check = new JButton("\uC911\uBCF5\uD655\uC778");
		btn_id_check.setBounds(332, 238, 91, 23);
		panel.add(btn_id_check);
		btn_id_check.setFont(new Font("굴림", Font.PLAIN, 13));

		btn_id_check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (dao.ExistID(txt_id.getText())) {
					separator.setForeground(Color.red);
					lbl_error.setText("존재하는 아이디 입니다. 다시입력하세요. ");
					lbl_error.setForeground(Color.red);
					txt_id.setText(""); // 빈칸으로 다시 돌리기
				} else {
					separator.setForeground(Color.black);
					lbl_error.setText("사용가능한 아이디입니다.");

				}

			}
		});
		btn_id_check.setBackground(Color.WHITE);
		btn_id_check.setBorderPainted(false);

		btn_register = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btn_register.setBounds(0, 720, 583, 23);
		panel.add(btn_register);
		btn_register.setFont(new Font("굴림", Font.PLAIN, 15));
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
						|| !checkbox.isSelected() || !checkbox1.isSelected()) {
					// txt_id.setBorder(BorderFactory.createLineBorder(Color.BLUE));
					// JOptionPane.showMessageDialog(null,"아이디 입력하세요. ");
					lbl_error1.setForeground(Color.red);
					lbl_error1.setText(" 빈칸 존재 ");

				} else {
					dao.Register(id, first, last, password, phone, car);
					JOptionPane.showMessageDialog(null, "회원가입 완료. 적격심사를 시작합니다.");
					frame.dispose();
					login login1 = new login();
					login1.main(null);

				}

			}
		});
		btn_register.setBackground(Color.WHITE);
		btn_register.setBorderPainted(false);

		checkbox = new JCheckBox("\uAC1C\uC778\uC815\uBCF4 \uC218\uC9D1 \uBC0F \uC0AC\uC6A9 \uB3D9\uC758");
		checkbox.setBounds(151, 623, 287, 23);
		panel.add(checkbox);
		checkbox.setHorizontalAlignment(SwingConstants.CENTER);
		checkbox.setFont(new Font("굴림", Font.PLAIN, 13));
		checkbox.setBackground(Color.WHITE);

		checkbox1 = new JCheckBox("\uC801\uACA9\uC2EC\uC0AC \uC815\uBCF4 \uB3D9\uC758");
		checkbox1.setBounds(134, 659, 278, 23);
		panel.add(checkbox1);
		checkbox1.setHorizontalAlignment(SwingConstants.CENTER);
		checkbox1.setFont(new Font("굴림", Font.PLAIN, 13));
		checkbox1.setBackground(Color.WHITE);

		txt_first_name = new JTextField();
		txt_first_name.setBounds(275, 321, 99, 21);
		panel.add(txt_first_name);
		txt_first_name.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txt_first_name.setText("");
			}
		});
		txt_first_name.setForeground(Color.BLACK);
		txt_first_name.setText("\uC774\uB984");
		txt_first_name.setBorder(null);
		txt_first_name.setColumns(10);

		JLabel lbl_car = new JLabel("\uCC28\uB7C9 \uBC88\uD638");
		lbl_car.setBounds(214, 526, 115, 21);
		panel.add(lbl_car);
		lbl_car.setFont(new Font("굴림체", Font.PLAIN, 15));

		JLabel lbl_phone = new JLabel("PHONE NUMBER");
		lbl_phone.setBounds(215, 448, 131, 15);
		panel.add(lbl_phone);
		lbl_phone.setFont(new Font("Arial", Font.BOLD, 15));

		txt_phone = new JTextField();
		txt_phone.setBounds(215, 473, 159, 21);
		panel.add(txt_phone);
		txt_phone.setColumns(10);
		txt_phone.setBorder(null);

		txt_car = new JTextField();
		txt_car.setBounds(215, 549, 159, 21);
		panel.add(txt_car);
		txt_car.setColumns(10);
		txt_car.setBorder(null);

		JLabel lbl_back = new JLabel(result);
		lbl_back.setBounds(532, 10, 40, 797);
		panel.add(lbl_back);

		separator = new JSeparator();
		separator.setBounds(215, 258, 115, 3);
		panel.add(separator);
		separator.setForeground(new Color(0, 0, 0));

		separator_1 = new JSeparator();
		separator_1.setBounds(215, 420, 159, 3);
		panel.add(separator_1);
		separator_1.setForeground(Color.BLACK);

		separator_2 = new JSeparator();
		separator_2.setBounds(215, 497, 159, 3);
		panel.add(separator_2);
		separator_2.setForeground(Color.BLACK);

		separator_3 = new JSeparator();
		separator_3.setBounds(215, 572, 159, 3);
		panel.add(separator_3);
		separator_3.setForeground(Color.BLACK);

		separator_4 = new JSeparator();
		separator_4.setBounds(213, 346, 50, 3);
		panel.add(separator_4);
		separator_4.setForeground(Color.BLACK);

		separator_5 = new JSeparator();
		separator_5.setBounds(276, 346, 100, 3);
		panel.add(separator_5);
		separator_5.setForeground(Color.BLACK);

		lbl_error = new JLabel("");
		lbl_error.setBounds(215, 271, 278, 15);
		panel.add(lbl_error);
		lbl_error.setFont(new Font("굴림체", Font.PLAIN, 11));

		lbl_error1 = new JLabel("");
		lbl_error1.setBounds(204, 585, 159, 15);
		panel.add(lbl_error1);
		lbl_error1.setFont(new Font("굴림체", Font.PLAIN, 13));
		lbl_error1.setHorizontalAlignment(SwingConstants.LEFT);
		
	}
}
