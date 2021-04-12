package project1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import JDBC.MemberDTO;
import JDBC.calculateDAO;
import JDBC.calculateVO;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTree;

public class previousData {

	private JFrame frame;
	private final JPanel panel = new JPanel();
	private JTable table_data;

//   public static void main(String[] args) {
//      EventQueue.invokeLater(new Runnable() {
//         public void run() {
//            try {
//               previousData window = new previousData();
//               window.frame.setVisible(true);
//            } catch (Exception e) {
//               e.printStackTrace();
//            }
//         }
//      });
//   }

	public previousData(MemberDTO dto) {
		initialize(dto);
		frame.setVisible(true);
	}

	private void initialize(MemberDTO dto) {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 800, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		panel.setBackground(new Color(255, 255, 255));
		panel.setForeground(Color.WHITE);
		panel.setBounds(0, 0, 784, 861);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lbl_title = new JLabel("\uC774\uC804 \uB370\uC774\uD130");
		lbl_title.setFont(new Font("굴림", Font.BOLD, 20));
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setBounds(196, 369, 392, 73);
		panel.add(lbl_title);

		ImageIcon logo_img = new ImageIcon("img/탄소.jpg");
		Image logo_img2 = logo_img.getImage();
		Image logo_image = logo_img2.getScaledInstance(271, 300, Image.SCALE_SMOOTH);
		ImageIcon logo = new ImageIcon(logo_image);

		ImageIcon menu_img = new ImageIcon("img/메뉴.png");
		Image menu_img2 = menu_img.getImage();
		Image menu_image = menu_img2.getScaledInstance(57, 45, Image.SCALE_SMOOTH);
		ImageIcon menu = new ImageIcon(menu_image);

		JLabel lbl_prvs = new JLabel(menu);
		lbl_prvs.setBackground(Color.WHITE);
		lbl_prvs.setBounds(12, 333, 57, 45);
		frame.getContentPane().add(lbl_prvs);

		JLabel lbl_my_page = new JLabel(menu);
		lbl_my_page.setBackground(Color.WHITE);
		lbl_my_page.setBounds(12, 535, 57, 45);
		frame.getContentPane().add(lbl_my_page);

		JScrollPane scroll_data = new JScrollPane();
		scroll_data.setBounds(67, 452, 650, 365);
		panel.add(scroll_data);

		// 이전 데이터 모두 띄우기
		calculateDAO cdao = new calculateDAO();
		String[] col = { "날짜", "이동수단", "이동 거리", "포인트" };
		ArrayList<calculateVO> list = cdao.select();

		Object[][] data = new Object[list.size()][col.length];

		for (int i = 0; i < list.size(); i++) {

			data[i][0] = list.get(i).getDt();
			data[i][1] = list.get(i).getHow();
			data[i][2] = list.get(i).getDistance();
			data[i][3] = list.get(i).getScore();

		}

		// Object[][] data = {{list.get(0).get.get,10,1,1},{"01/19",20}};
		table_data = new JTable(data, col);
		scroll_data.setViewportView(table_data);

		CategoryDataset dataset = createDataset(); // 밑에 만들어놓은 메소드
		// (타이틀, x축, y축, 데이터, 위치, 레이블, tooltip, url)
		JFreeChart chart = ChartFactory.createLineChart("점수 변화 추이", "날짜", "점수", dataset, PlotOrientation.VERTICAL,
				false, true, false); // chart를 만들때는 ChartFactory.create

		// 한글이 다깨져서 안깨지게 하기위함!
		chart.getTitle().setFont(new Font("굴림", Font.BOLD, 20)); // 타이틀

		CategoryPlot plot = chart.getCategoryPlot(); // x,y축 설정을 도와주는 착한친구

		plot.getDomainAxis().setLabelFont(new Font("굴림", Font.BOLD, 15));// x축
		plot.getRangeAxis().setLabelFont(new Font("굴림", Font.BOLD, 15));// y축
		plot.getRangeAxis().setRange(0, 120);// y축 범위
		plot.getRangeAxis().setLabelAngle(90 * (Math.PI / 180.0)); // y축회전
		plot.setBackgroundPaint(Color.white);
		// 셀 가운데 정렬
		DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();
		tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		// 정렬할 테이블의 ColumnModel을 가져옴

		TableColumnModel tcmSchedule = table_data.getColumnModel();
		for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
			tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
		}

		JPanel panel_graph = new ChartPanel(chart); // 업캐스팅
		panel_graph.setBounds(45, 84, 672, 271);
		panel.add(panel_graph);

		ImageIcon exitimg = new ImageIcon("img/back.png");
		Image exitimg1 = exitimg.getImage();
		Image exitscaleimg = exitimg1.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon result = new ImageIcon(exitscaleimg);

		JLabel lbl_back = new JLabel(result);
		lbl_back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				main main = new main(dto);
			}
		});
		lbl_back.setBounds(12, 27, 63, 57);
		panel.add(lbl_back);
		
				JLabel lbl_mypage = new JLabel("MY PAGE");
				lbl_mypage.setBounds(574, 33, 75, 33);
				panel.add(lbl_mypage);
				lbl_mypage.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						frame.dispose();
						mypage mypage = new mypage(dto);
					}
				});
				lbl_mypage.setFont(new Font("Times New Roman", Font.BOLD, 15));
				
				JLabel lbl_logout = new JLabel("LOGOUT");
				lbl_logout.setBounds(661, 33, 75, 33);
				panel.add(lbl_logout);
				lbl_logout.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						frame.dispose();
						main main = new main(dto);
					}
				});
				lbl_logout.setFont(new Font("Times New Roman", Font.BOLD, 15));

		ImageIcon exitimg5 = new ImageIcon("img/mypage.png");
		Image getexitimg5 = exitimg5.getImage();
		Image exitscaleimg5 = getexitimg5.getScaledInstance(38, 38, Image.SCALE_SMOOTH);
		ImageIcon result5 = new ImageIcon(exitscaleimg5);

		ImageIcon exitimg4 = new ImageIcon("img/logout.png");
		Image exitimg6 = exitimg4.getImage();
		Image exitscaleimg6 = exitimg6.getScaledInstance(38, 38, Image.SCALE_SMOOTH);
		ImageIcon result6 = new ImageIcon(exitscaleimg6);
		
		
	}

	private CategoryDataset createDataset() {

		calculateDAO cdao = new calculateDAO();
		String[] col = { "날짜", "이동수단", "이동 거리", "포인트" };
		ArrayList<calculateVO> list = cdao.select();

		DefaultCategoryDataset dataset = new DefaultCategoryDataset(); // chart에 넣을 수 있는 데이터 형태

		for (int i = 0; i < list.size(); i++) {
			// addValue(y축 데이터, "", x축데이터)
			dataset.addValue(list.get(i).getScore(), "", list.get(i).getDt());
		}

		return dataset;

	}
}