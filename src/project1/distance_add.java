package project1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import JDBC.calculateDAO;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class distance_add {

	private JFrame frame;
	private JTextField txt_start;
	private JTextField txt_end;
	private JTextField txt_distance;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					distance_add window = new distance_add();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public distance_add() {
		initialize();
	}

	private void initialize() {
		
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.getContentPane().setLayout(null);

		JLabel lbl_logo = new JLabel("logo");
		lbl_logo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_logo.setBounds(12, 10, 59, 45);
		frame.getContentPane().add(lbl_logo);

		JButton btn_mypage = new JButton("MY PAGE");
		btn_mypage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
//				mypage mypage = new mypage();
//				mypage.main(null);
			}
		});
		btn_mypage.setFont(new Font("Arial", Font.BOLD, 12));
		btn_mypage.setBorderPainted(false);
		btn_mypage.setBackground(Color.WHITE);
		btn_mypage.setBounds(392, 10, 92, 30);
		frame.getContentPane().add(btn_mypage);

		JButton btn_exit = new JButton("LOG OUT");
		btn_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				login login = new login();
				login.main(null);
			}
		});
		btn_exit.setFont(new Font("Arial", Font.BOLD, 12));
		btn_exit.setBorderPainted(false);
		btn_exit.setBackground(Color.WHITE);
		btn_exit.setBounds(469, 10, 103, 30);
		frame.getContentPane().add(btn_exit);

		JButton btn_back = new JButton("\uC774\uC804 \uD398\uC774\uC9C0");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				frame.dispose();
//				main main1 = new main(null);
//				main1.main(null);
			}
		});
		btn_back.setFont(new Font("±¼¸²", Font.BOLD, 12));
		btn_back.setBackground(Color.WHITE);
		btn_back.setBounds(12, 622, 103, 49);
		frame.getContentPane().add(btn_back);

		JLabel lbl_title = new JLabel("\uC774\uB3D9 \uAC70\uB9AC \uC785\uB825");
		lbl_title.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setBounds(22, 50, 550, 82);
		frame.getContentPane().add(lbl_title);

		JLabel lbl_start = new JLabel("\uCD9C\uBC1C\uC9C0");
		lbl_start.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		lbl_start.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_start.setBounds(66, 152, 85, 45);
		frame.getContentPane().add(lbl_start);

		txt_start = new JTextField();
		txt_start.setBounds(178, 152, 341, 45);
		frame.getContentPane().add(txt_start);
		txt_start.setColumns(10);

		txt_end = new JTextField();
		txt_end.setColumns(10);
		txt_end.setBounds(178, 248, 341, 45);
		frame.getContentPane().add(txt_end);

		JLabel lbl_end = new JLabel("\uB3C4\uCC29\uC9C0");
		lbl_end.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_end.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		lbl_end.setBounds(66, 248, 85, 45);
		frame.getContentPane().add(lbl_end);

		JButton btn_re_enter = new JButton("\uB2E4\uC2DC \uC785\uB825");
		btn_re_enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_start.setText(null);
				txt_end.setText(null);
			}
		});
		btn_re_enter.setBackground(new Color(255, 255, 255));
		btn_re_enter.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		btn_re_enter.setBounds(32, 542, 103, 30);
		frame.getContentPane().add(btn_re_enter);

		JLabel lbl_distance = new JLabel("\uC774\uB3D9 \uAC70\uB9AC");
		lbl_distance.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_distance.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		lbl_distance.setBounds(66, 332, 85, 45);
		frame.getContentPane().add(lbl_distance);

		txt_distance = new JTextField();
		txt_distance.setColumns(10);
		txt_distance.setBounds(178, 335, 200, 45);
		frame.getContentPane().add(txt_distance);

		JButton btn_car = new JButton("\uC2B9\uC6A9\uCC28");
		btn_car.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btn_car.setBackground(new Color(255, 255, 255));
		btn_car.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		btn_car.setBounds(69, 425, 152, 45);
		frame.getContentPane().add(btn_car);

		JButton btn_pulc_trans = new JButton("\uB300\uC911\uAD50\uD1B5");
		btn_pulc_trans.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		btn_pulc_trans.setBackground(Color.WHITE);
		btn_pulc_trans.setBounds(215, 425, 152, 45);
		frame.getContentPane().add(btn_pulc_trans);

		JButton btn_self = new JButton("\uC790\uC804\uAC70 \r\n\uBC0F \uBCF4\uB3C4");
		btn_self.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		btn_self.setBackground(Color.WHITE);
		btn_self.setBounds(367, 425, 152, 45);
		frame.getContentPane().add(btn_self);
		
		String[] col = { "½Â¿ëÂ÷", "´ëÁß±³Åë","Àü±âÀÚµ¿Â÷","µµº¸ ¹× ÀÚÀü°Å" };
		JComboBox comboBox = new JComboBox(col);
		comboBox.setBounds(178, 494, 200, 30);
		frame.getContentPane().add(comboBox);
		frame.setBounds(100, 100, 600, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btn_add = new JButton("\uCD94\uAC00");
		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ÄÞº¸ ¹Ú½ºÀÇ °ª ¾Ë¾Æ¿À±â
				String field = (String)comboBox.getSelectedItem();

				System.out.println("ÄÞº¸¹Ú½ºÀÇ ¼±ÅÃ °ª :" + field);
				
				calculateDAO dao = new calculateDAO();
				dao.insert(field, Double.parseDouble(txt_distance.getText()));
				
				
				
//				//DAO ¿¬°á
//				frame.dispose();
//				result result = new result();
//				result.main(null);
			}
		});
		btn_add.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		btn_add.setBackground(Color.WHITE);
		btn_add.setBounds(441, 542, 103, 30);
		frame.getContentPane().add(btn_add);
		
		
		
	}
}