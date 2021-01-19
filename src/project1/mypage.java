package project1;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import JDBC.MemberDTO;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import JDBC.MemberDAO;

public class mypage extends login {

	private JFrame frame;
	private JTextField txt_id_update;
	private JTextField txt_pw_update;
	private JButton btn_update;
	private JButton btn_logout;
	private JButton btn_delete;
	private JButton btn_back;
	private JTextField txt_phone_update;
	private JTextField txt_car_update;

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
		lblNewLabel.setFont(new Font("Arial Black", Font.ITALIC, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(151, 45, 282, 35);
		frame.getContentPane().add(lblNewLabel);

		JLabel lbl_id_update = new JLabel("ID : ");
		lbl_id_update.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_id_update.setBounds(132, 181, 104, 25);
		frame.getContentPane().add(lbl_id_update);

		txt_id_update = new JTextField();
		// ID는 업데이트 할 수 없음.
//		txt_id_update.setEditable(false);
//		txt_id_update.setVisible(true);
		txt_id_update.setText(dto.getId());
		txt_id_update.setBounds(248, 181, 169, 24);
		frame.getContentPane().add(txt_id_update);
		txt_id_update.setColumns(10);

		JLabel lbl_pw_update = new JLabel("PASSWORD :");
		lbl_pw_update.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_pw_update.setBounds(132, 234, 104, 25);
		frame.getContentPane().add(lbl_pw_update);

		txt_pw_update = new JTextField();
		txt_pw_update.setText(dto.getPassword());
		txt_pw_update.setColumns(10);
		txt_pw_update.setBounds(248, 236, 169, 24);
		frame.getContentPane().add(txt_pw_update);

		btn_update = new JButton("\uBCC0\uACBD");
		btn_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 정보 DB 수정

				int result = dao.update(txt_id_update.getText(), txt_pw_update.getText(), txt_phone_update.getText(),
						txt_car_update.getText());
				;
				if (result > 0) {
					// result = True
					JOptionPane.showMessageDialog(null, "업데이트 완료");
				} else {
					JOptionPane.showMessageDialog(null, "업데이트 실패");
				}

			}
		});
		btn_update.setFont(new Font("굴림", Font.PLAIN, 12));
		btn_update.setBackground(Color.WHITE);
		btn_update.setBounds(261, 444, 64, 24);
		frame.getContentPane().add(btn_update);

		btn_logout = new JButton("\uB85C\uADF8\uC544\uC6C3");
		btn_logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btn_logout.setFont(new Font("굴림체", Font.PLAIN, 12));
		btn_logout.setBackground(Color.WHITE);
		btn_logout.setBounds(373, 627, 87, 23);
		frame.getContentPane().add(btn_logout);

		btn_delete = new JButton("\uD68C\uC6D0\uD0C8\uD1F4");
		btn_delete.setFont(new Font("굴림체", Font.PLAIN, 12));
		btn_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {



				int result1 = dao.delete(txt_id_update.getText());

				if (result1 > 0) {
					JOptionPane.showMessageDialog(null, "삭제완료");
				} else {
					JOptionPane.showMessageDialog(null, "삭제실패");
				}
				
				login login1 = new login();
				login1.main(null);
			}
		});
		btn_delete.setBackground(Color.WHITE);
		btn_delete.setBounds(472, 627, 87, 23);
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
			}
		});

		btn_back.setBackground(Color.WHITE);
		btn_back.setBounds(22, 39, 50, 40);
		frame.getContentPane().add(btn_back);

		JLabel lbl_phone = new JLabel("PHONE :");
		lbl_phone.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_phone.setBounds(132, 290, 104, 25);
		frame.getContentPane().add(lbl_phone);

		txt_phone_update = new JTextField();
		txt_phone_update.setText(dto.getTel());
		txt_phone_update.setColumns(10);
		txt_phone_update.setBounds(248, 292, 169, 24);
		frame.getContentPane().add(txt_phone_update);

		JLabel lbl_car = new JLabel("CAR : ");
		lbl_car.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_car.setBounds(132, 345, 104, 25);
		frame.getContentPane().add(lbl_car);

		txt_car_update = new JTextField();
		txt_car_update.setText(dto.getCar());
		txt_car_update.setColumns(10);
		txt_car_update.setBounds(248, 347, 169, 24);
		frame.getContentPane().add(txt_car_update);
		frame.setBounds(100, 100, 600, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
