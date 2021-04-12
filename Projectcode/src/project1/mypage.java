package project1;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import JDBC.MemberDTO;

import java.awt.Font;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import JDBC.MemberDAO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import javax.swing.JPasswordField;

public class mypage extends login {

	private JFrame frame;
	private JTextField txt_id_update;
	private JPasswordField txt_pw_update;
	private JButton btn_update;
	private JButton btn_logout;
	private JButton btn_delete;
	private JButton btn_back;
	private JTextField txt_phone_update;
	private JTextField txt_car_update;
	private JLabel lbl_back;
	private JLabel lblNewLabel_1;
	private JLabel lbl_text;

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					mypage window = new mypage();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	// 메인을 통해서만 mypage 들어올 수 있음.
	public mypage(MemberDTO dto) {
		initialize(dto);
		frame.setVisible(true);

	}

	private void initialize(MemberDTO dto) {
		MemberDAO dao = new MemberDAO();

		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("MY PAGE");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 104, 584, 54);
		frame.getContentPane().add(lblNewLabel);

		JLabel lbl_id_update = new JLabel("ID : ");
		lbl_id_update.setFont(new Font("Dialog", Font.PLAIN, 16));
		lbl_id_update.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_id_update.setBounds(131, 262, 111, 25);
		frame.getContentPane().add(lbl_id_update);

		txt_id_update = new JTextField();
		txt_id_update.setHorizontalAlignment(SwingConstants.CENTER);
		txt_id_update.setFont(new Font("굴림", Font.PLAIN, 13));
		// ID는 업데이트 할 수 없음.
		txt_id_update.setEditable(false);
		txt_id_update.setVisible(true);
		txt_id_update.setBorder(null);
		txt_id_update.setText(dto.getId());
		txt_id_update.setBounds(254, 264, 169, 24);
		frame.getContentPane().add(txt_id_update);
		txt_id_update.setColumns(10);

		JLabel lbl_pw_update = new JLabel("PASSWORD :");
		lbl_pw_update.setFont(new Font("Dialog", Font.PLAIN, 16));
		lbl_pw_update.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_pw_update.setBounds(131, 334, 111, 25);
		frame.getContentPane().add(lbl_pw_update);

		txt_pw_update = new JPasswordField();
		txt_pw_update.setText(dto.getPassword());
		txt_pw_update.setColumns(10);
		txt_pw_update.setBounds(254, 337, 169, 24);
		frame.getContentPane().add(txt_pw_update);

		btn_update = new JButton("\uBCC0\uACBD");
		btn_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 정보 DB 수정

				int result = dao.update(txt_id_update.getText(), txt_pw_update.getText(), txt_phone_update.getText(),
						txt_car_update.getText());
				if (result > 0) {
					// result = True
					lbl_text.setText("업데이트 완료되었습니다.");
					// JOptionPane.showMessageDialog(null, "업데이트 완료");
				} else {
					lbl_text.setForeground(Color.red);
					lbl_text.setText("업데이트 실패하였습니다. 다시 입력해주세요.");
					// JOptionPane.showMessageDialog(null, "업데이트 실패");
				}

			}
		});
		btn_update.setFont(new Font("굴림", Font.PLAIN, 13));
		btn_update.setBackground(Color.WHITE);
		btn_update.setBorderPainted(false);
		btn_update.setBounds(248, 552, 64, 24);
		frame.getContentPane().add(btn_update);

		btn_logout = new JButton("\uB85C\uADF8\uC544\uC6C3");
		btn_logout.setBorderPainted(false);
		btn_logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login login1 = new login();
				login1.main(null);
			}
		});
		btn_logout.setFont(new Font("굴림체", Font.PLAIN, 13));
		btn_logout.setBackground(Color.WHITE);
		btn_logout.setBounds(347, 679, 87, 23);
		frame.getContentPane().add(btn_logout);

		btn_delete = new JButton("\uD68C\uC6D0\uD0C8\uD1F4");
		btn_delete.setBorderPainted(false);
		btn_delete.setFont(new Font("굴림체", Font.PLAIN, 13));
		btn_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int result1 = dao.delete(txt_id_update.getText());

				if (result1 > 0) {
					JOptionPane.showMessageDialog(null, "삭제완료");
					login login1 = new login();
					login1.main(null);
				} else {
					JOptionPane.showMessageDialog(null, "삭제실패");
				}

			}
		});
		btn_delete.setBackground(Color.WHITE);
		btn_delete.setBounds(443, 679, 87, 23);
		frame.getContentPane().add(btn_delete);

		ImageIcon deleteimg = new ImageIcon("img/back.png");
		Image backimg = deleteimg.getImage();
		Image mypage_deleteimage = backimg.getScaledInstance(50, 40, Image.SCALE_SMOOTH);
		ImageIcon resultimg = new ImageIcon(mypage_deleteimage);

		btn_back = new JButton(resultimg);
		btn_back.setBorderPainted(false);
		btn_back.setIcon(new ImageIcon());
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				main main = new main(dto);
			}
		});

		btn_back.setBackground(Color.WHITE);
		btn_back.setBounds(12, 356, 50, 40);
		frame.getContentPane().add(btn_back);

		JLabel lbl_phone = new JLabel("PHONE :");
		lbl_phone.setFont(new Font("Dialog", Font.PLAIN, 16));
		lbl_phone.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_phone.setBounds(131, 416, 111, 25);
		frame.getContentPane().add(lbl_phone);

		txt_phone_update = new JTextField();
		txt_phone_update.setText(dto.getTel());
		txt_phone_update.setColumns(10);
		txt_phone_update.setBounds(254, 419, 169, 24);
		frame.getContentPane().add(txt_phone_update);

		JLabel lbl_car = new JLabel("CAR : ");
		lbl_car.setFont(new Font("Dialog", Font.PLAIN, 16));
		lbl_car.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_car.setBounds(131, 492, 111, 25);
		frame.getContentPane().add(lbl_car);

		txt_car_update = new JTextField();
		txt_car_update.setText(dto.getCar());
		txt_car_update.setColumns(10);
		txt_car_update.setBounds(254, 493, 169, 24);
		frame.getContentPane().add(txt_car_update);

		ImageIcon exitimg = new ImageIcon("img/back.png");
		Image exitimg1 = exitimg.getImage();
		Image exitscaleimg = exitimg1.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		ImageIcon result = new ImageIcon(exitscaleimg);

		JLabel lbl_back = new JLabel(result);
		lbl_back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				main main = new main(dto);

			}
		});
		lbl_back.setBounds(12, 403, 60, 54);
		frame.getContentPane().add(lbl_back);

		lblNewLabel_1 = new JLabel(" + 아이디는 변경 불가 합니다. ");
		lblNewLabel_1.setFont(new Font("굴림체", Font.PLAIN, 11));
		lblNewLabel_1.setForeground(SystemColor.windowBorder);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 611, 584, 15);
		frame.getContentPane().add(lblNewLabel_1);

		lbl_text = new JLabel("");
		lbl_text.setFont(new Font("굴림체", Font.PLAIN, 13));
		lbl_text.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_text.setBounds(12, 200, 560, 25);
		frame.getContentPane().add(lbl_text);
		frame.setBounds(100, 100, 600, 850);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
