package project1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import JDBC.MemberDTO;
import JDBC.calculateDAO;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JProgressBar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.JSeparator;

public class distance_add {

	private JFrame frame;
	private JTextField txt_car;
	private JTextField txt_bus;
	private JTextField txt_walk;
	private JTextField txt_elec;
	private JLabel lbl_car;
	private JLabel lbl_bus;
	private JLabel lbl_walk;
	private JLabel lbl_elec;

//   public static void main(String[] args) {
//      EventQueue.invokeLater(new Runnable() {
//         public void run() {
//            try {
//               distance_add window = new distance_add();
//               window.frame.setVisible(true);
//            } catch (Exception e) {
//               e.printStackTrace();
//            }
//         }
//      });
//   }

	public distance_add(MemberDTO dto) {
		initialize(dto);
		frame.setVisible(true);
	}

	private void initialize(MemberDTO dto) {

		frame = new JFrame();
		frame.getContentPane().setFont(new Font("굴림체", Font.PLAIN, 12));
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.getContentPane().setLayout(null);

		calculateDAO dao = new calculateDAO();
		// dto에 저장된 id값 가져오기
		String id = dto.getId();

		ImageIcon image13 = new ImageIcon("img/logo.jpg");
		Image img13 = image13.getImage();
		Image scale6 = img13.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon result13 = new ImageIcon(scale6);

		JLabel lbl_logo = new JLabel(result13);
		lbl_logo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_logo.setBounds(12, 10, 75, 75);
		frame.getContentPane().add(lbl_logo);

		ImageIcon exitimg5 = new ImageIcon("img/mypage.png");
		Image getexitimg5 = exitimg5.getImage();
		Image exitscaleimg5 = getexitimg5.getScaledInstance(38, 38, Image.SCALE_SMOOTH);
		ImageIcon result5 = new ImageIcon(exitscaleimg5);

		ImageIcon exitimg4 = new ImageIcon("img/logout.png");
		Image exitimg6 = exitimg4.getImage();
		Image exitscaleimg6 = exitimg6.getScaledInstance(38, 38, Image.SCALE_SMOOTH);
		ImageIcon result6 = new ImageIcon(exitscaleimg6);

		ImageIcon exitimg = new ImageIcon("img/back.png");
		Image exitimg1 = exitimg.getImage();
		Image exitscaleimg = exitimg1.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon result = new ImageIcon(exitscaleimg);

		JButton btn_back = new JButton(result);
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				main main = new main(dto);
			}
		});
		btn_back.setFont(new Font("굴림", Font.BOLD, 12));
		btn_back.setBackground(Color.WHITE);
		btn_back.setBounds(12, 410, 40, 40);
		frame.getContentPane().add(btn_back);

		JLabel lbl_title = new JLabel("\uC774\uB3D9 \uAC70\uB9AC \uC785\uB825");
		lbl_title.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setBounds(0, 101, 584, 82);
		frame.getContentPane().add(lbl_title);

		String[] col = { "승용차", "대중교통", "전기자동차", "도보 및 자전거" };
		frame.setBounds(100, 100, 600, 850);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton btn_add = new JButton("\uD3EC\uC778\uD2B8 \uBC1B\uAE30");

		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 콤보 박스의 값 알아오기

//            String field = (String) comboBox.getSelectedItem();
//            System.out.println("콤보박스의 선택 값 :" + field);
				String label1 = lbl_car.getText();
				String label2 = lbl_bus.getText();
				String label3 = lbl_walk.getText();
				String label4 = lbl_elec.getText();
				double text1 = Double.parseDouble(txt_car.getText());
				double text2 = Double.parseDouble(txt_bus.getText());
				double text3 = Double.parseDouble(txt_walk.getText());
				double text4 = Double.parseDouble(txt_elec.getText());

				dao.insert(id, label1, label2, label3, label4, text1, text2, text3, text4);

//				lbl_error.setText("잘못된 정보입니다. 다시 입력하세요. ");
//				// JOptionPane.showMessageDialog(null, "로그인실패");
//				txt_car.setText(""); // 빈칸으로 다시 돌리기
//				txt_bus.setText("");
//				txt_walk.setText("");
//				txt_elec.setText("");
//				frame.dispose();

				JOptionPane.showMessageDialog(null, "탄소점수 계산완료!");
				
				
			}
		});

		JButton btn_re_enter = new JButton("\uB2E4\uC2DC \uC785\uB825");
		btn_re_enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_car.setText("0");
				txt_bus.setText("0");
				txt_walk.setText("0");
				txt_elec.setText("0");

			}
		});
		btn_re_enter.setBackground(new Color(255, 255, 255));
		btn_re_enter.setFont(new Font("굴림체", Font.PLAIN, 13));
		btn_re_enter.setBorderPainted(false);
		btn_re_enter.setBounds(339, 232, 103, 23);
		frame.getContentPane().add(btn_re_enter);

		btn_add.setFont(new Font("굴림체", Font.BOLD, 20));
		btn_add.setBackground(Color.WHITE);
		btn_add.setBounds(203, 617, 168, 38);
		btn_add.setBorderPainted(false);
		frame.getContentPane().add(btn_add);

		lbl_car = new JLabel("\uC2B9\uC6A9\uCC28");
		lbl_car.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_car.setFont(new Font("굴림체", Font.PLAIN, 16));
		lbl_car.setBounds(130, 294, 101, 23);
		frame.getContentPane().add(lbl_car);

		lbl_bus = new JLabel("\uB300\uC911\uAD50\uD1B5");
		lbl_bus.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_bus.setFont(new Font("굴림체", Font.PLAIN, 16));
		lbl_bus.setBounds(130, 367, 101, 30);
		frame.getContentPane().add(lbl_bus);

		lbl_walk = new JLabel("\uB3C4\uBCF4 \uBC0F \uC790\uC804\uAC70");
		lbl_walk.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_walk.setFont(new Font("굴림체", Font.PLAIN, 16));
		lbl_walk.setBounds(116, 453, 115, 21);
		frame.getContentPane().add(lbl_walk);

		lbl_elec = new JLabel("\uC804\uAE30\uCC28");
		lbl_elec.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_elec.setFont(new Font("굴림체", Font.PLAIN, 16));
		lbl_elec.setBounds(130, 521, 101, 21);
		frame.getContentPane().add(lbl_elec);

		txt_car = new JTextField();
		txt_car.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				txt_car.setText("");
			}
		});
		txt_car.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_car.setFont(new Font("굴림", Font.PLAIN, 16));
		txt_car.setText("0");
		txt_car.setBounds(243, 294, 108, 23);
		frame.getContentPane().add(txt_car);
		txt_car.setColumns(10);

		txt_bus = new JTextField();
		txt_bus.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				txt_bus.setText("");

			}
		});
		txt_bus.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_bus.setFont(new Font("굴림", Font.PLAIN, 16));
		txt_bus.setText("0");
		txt_bus.setColumns(10);
		txt_bus.setBounds(243, 372, 108, 21);
		frame.getContentPane().add(txt_bus);

		txt_walk = new JTextField();
		txt_walk.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				txt_walk.setText("");
			}
		});
		txt_walk.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_walk.setFont(new Font("굴림", Font.PLAIN, 16));
		txt_walk.setText("0");
		txt_walk.setColumns(10);
		txt_walk.setBounds(243, 453, 108, 21);
		frame.getContentPane().add(txt_walk);

		txt_elec = new JTextField();
		txt_elec.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				txt_elec.setText("");
			}
		});
		txt_elec.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_elec.setFont(new Font("굴림", Font.PLAIN, 16));
		txt_elec.setText("0");
		txt_elec.setColumns(10);
		txt_elec.setBounds(243, 521, 108, 22);
		frame.getContentPane().add(txt_elec);

		JLabel lblinfo = new JLabel("점수산출식이 궁금하다면 ?");
		lblinfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				imginfo1 img = new imginfo1();
				// 창 닫으면 안꺼지게 하기
			}
		});
		lblinfo.setFont(new Font("굴림체", Font.PLAIN, 14));
		lblinfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblinfo.setBounds(27, 757, 201, 30);
		frame.getContentPane().add(lblinfo);

		JLabel lblNewLabel = new JLabel("Km");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel.setBounds(363, 294, 59, 23);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Km");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(363, 369, 59, 23);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Km");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(363, 450, 59, 23);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Km");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(363, 519, 59, 23);
		frame.getContentPane().add(lblNewLabel_2_1);

		JLabel lbl_mypage = new JLabel("MY PAGE");
		lbl_mypage.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				mypage mypage = new mypage(dto);
			}
		});
		lbl_mypage.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lbl_mypage.setBounds(389, 39, 75, 33);
		frame.getContentPane().add(lbl_mypage);

		JLabel lbl_logout = new JLabel("LOGOUT");
		lbl_logout.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				main main = new main(dto);
			}
		});
		lbl_logout.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lbl_logout.setBounds(476, 39, 75, 33);
		frame.getContentPane().add(lbl_logout);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(40, 785, 174, 2);
		frame.getContentPane().add(separator);
	}
}
