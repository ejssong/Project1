package project1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import JDBC.MemberDAO;
import JDBC.MemberDTO;
import JDBC.calculateDAO;

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
import javax.swing.Icon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class main {

	private JFrame frame;

//   public static void main(String[] args) {
//      EventQueue.invokeLater(new Runnable() {
//         public void run() {
//            try {
//               main window = new main();
//               window.frame.setVisible(true);
//            } catch (Exception e) {
//               e.printStackTrace();
//            }
//         }
//      });
//   }

	public main(MemberDTO dto) {
		initialize(dto);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(MemberDTO dto) {
		calculateDAO dao = new calculateDAO();
		// dto에 저장된 id값 가져오기
		String id = dto.getId();

		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 600, 850);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		ImageIcon image13 = new ImageIcon("img/logo.jpg");
		Image img13 = image13.getImage();
		Image scale6 = img13.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon result13 = new ImageIcon(scale6);

		JLabel lbl_logo = new JLabel(result13);
		lbl_logo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_logo.setBounds(12, 10, 75, 75);
		frame.getContentPane().add(lbl_logo);

		ImageIcon image2 = new ImageIcon("img/add.png");
		Image img2 = image2.getImage();
		Image scale2 = img2.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon result2 = new ImageIcon(scale2);

		JButton btn_add_data = new JButton(result2);
		btn_add_data.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				distance_add add = new distance_add(dto);

				frame.dispose();
			}
		});
		btn_add_data.setBackground(Color.WHITE);
		btn_add_data.setBorderPainted(false);
		btn_add_data.setBounds(141, 351, 100, 100);
		frame.getContentPane().add(btn_add_data);

		ImageIcon image3 = new ImageIcon("img/info.png");
		Image img3 = image3.getImage();
		Image scale3 = img3.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon result3 = new ImageIcon(scale3);

		JButton btn_info = new JButton(result3);
		btn_info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarbonInfo info = new CarbonInfo(dto);
				frame.dispose();

			}
		});
		btn_info.setBackground(Color.WHITE);
		btn_info.setBorderPainted(false);
		btn_info.setBounds(141, 562, 100, 100);
		frame.getContentPane().add(btn_info);

		// 이미지 삽입
		ImageIcon image1 = new ImageIcon("img/previousdata.jpg");
		Image img1 = image1.getImage();
		Image scale1 = img1.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon result1 = new ImageIcon(scale1);

		JButton btn_previous = new JButton(result1);
		btn_previous.setBackground(Color.WHITE);
		btn_previous.setBorderPainted(false);
		btn_previous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				previousData previous = new previousData(dto);
				frame.dispose();
			}
		});
		btn_previous.setBounds(337, 351, 100, 100);
		frame.getContentPane().add(btn_previous);

		JLabel lblNewLabel = new JLabel("이전데이터");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setText("\uC774\uC804 \uC810\uC218 \uBCF4\uAE30");
		lblNewLabel.setToolTipText("\uC774\uC804 \uB370\uC774\uD130");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 16));
		lblNewLabel.setBounds(331, 468, 116, 27);
		frame.getContentPane().add(lblNewLabel);

		JLabel lbl_add = new JLabel("\uD0C4\uC18C \uC810\uC218 \uACC4\uC0B0\uD558\uAE30 ");
		lbl_add.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_add.setFont(new Font("굴림", Font.PLAIN, 16));
		lbl_add.setBounds(116, 468, 167, 27);
		frame.getContentPane().add(lbl_add);

		JLabel lbl_info = new JLabel("탄소 배출권 거래제");
		lbl_info.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_info.setFont(new Font("굴림", Font.PLAIN, 16));
		lbl_info.setBounds(116, 672, 153, 27);
		frame.getContentPane().add(lbl_info);

		// MemberDTO에서 저장된 first_name 가져오기
		JLabel lbl_title = new JLabel();
		if (dto != null) {
			lbl_title.setText(" 안녕하세요 , " + dto.getFirst_name() + " 님 ");
		}
		lbl_title.setFont(new Font("굴림", Font.BOLD, 20));
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setBounds(0, 109, 584, 45);
		frame.getContentPane().add(lbl_title);

		ImageIcon exitimg = new ImageIcon("img/mypage.png");
		Image exitimg1 = exitimg.getImage();
		Image exitscaleimg = exitimg1.getScaledInstance(38, 38, Image.SCALE_SMOOTH);
		ImageIcon result = new ImageIcon(exitscaleimg);
		ImageIcon exitimg4 = new ImageIcon("img/logout.png");
		Image exitimg5 = exitimg4.getImage();
		Image exitscaleimg4 = exitimg5.getScaledInstance(38, 38, Image.SCALE_SMOOTH);
		ImageIcon result4 = new ImageIcon(exitscaleimg4);

		JProgressBar progressBar = new JProgressBar();
		progressBar.setForeground(new Color(153, 204, 0));
		progressBar.setFont(new Font("굴림", Font.BOLD, 18));
		progressBar.setBounds(57, 232, 469, 45);
		frame.getContentPane().add(progressBar);

		int num = dao.value(id);
		System.out.println(num);
		progressBar.setStringPainted(true);
		progressBar.setValue(num);
		progressBar.setString(num + "점");

		JLabel lbl_total1 = new JLabel("MY POINT ");
		lbl_total1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_total1.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_total1.setBounds(125, 736, 143, 45);
		frame.getContentPane().add(lbl_total1);

		JLabel lbl_total = new JLabel(dao.totalPoint() + "");
		lbl_total.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_total.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_total.setBounds(311, 736, 153, 45);
		frame.getContentPane().add(lbl_total);

		ImageIcon exitimgmoney = new ImageIcon("img/money.png");
		Image exitmoney = exitimgmoney.getImage();
		Image exitscalemoney = exitmoney.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon result11 = new ImageIcon(exitscalemoney);

		JButton btn_info_1 = new JButton(result11);
		btn_info_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarbonTrade trade = new CarbonTrade(dto);
				frame.dispose();
			}
		});
		btn_info_1.setBorderPainted(false);
		btn_info_1.setBackground(Color.WHITE);
		btn_info_1.setBounds(344, 562, 100, 100);
		frame.getContentPane().add(btn_info_1);

		JLabel lbl_info_1 = new JLabel("탄소 배출권 거래");
		lbl_info_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_info_1.setFont(new Font("굴림", Font.PLAIN, 16));
		lbl_info_1.setBounds(322, 672, 142, 27);
		frame.getContentPane().add(lbl_info_1);

		JLabel lbl_mypage = new JLabel("MY PAGE");
		lbl_mypage.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				mypage mypage = new mypage(dto);
			}
		});
		lbl_mypage.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lbl_mypage.setBounds(398, 33, 75, 33);
		frame.getContentPane().add(lbl_mypage);

		JLabel lbl_logout = new JLabel("LOGOUT");
		lbl_logout.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				login login = new login();
				login.main(null);
			}
		});
		lbl_logout.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lbl_logout.setBounds(486, 33, 75, 33);
		frame.getContentPane().add(lbl_logout);
		
		JLabel lblNewLabel_1 = new JLabel("\uC624\uB298 \uB2F9\uC2E0\uC758 \uD0C4\uC18C \uC810\uC218\uB294?");
		lblNewLabel_1.setFont(new Font("함초롬바탕", Font.BOLD, 16));
		lblNewLabel_1.setBounds(57, 202, 199, 22);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lbl_total_1 = new JLabel(">>");
		lbl_total_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_total_1.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_total_1.setBounds(218, 736, 153, 45);
		frame.getContentPane().add(lbl_total_1);
	}
}