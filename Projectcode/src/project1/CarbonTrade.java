package project1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import JDBC.MemberDTO;
import JDBC.calculateDAO;
import project1.login;
import project1.main;
import project1.mypage;

import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CarbonTrade {

   private JFrame frame;
   private JTable table_data;

   /**
    * Launch the application.
    */
//   public static void main(String[] args) {
//      EventQueue.invokeLater(new Runnable() {
//         public void run() {
//            try {
//               CarbonInfo window = new CarbonInfo();
//               window.frame.setVisible(true);
//            } catch (Exception e) {
//               e.printStackTrace();
//            }
//         }
//      });
//   }

   public CarbonTrade(MemberDTO dto) {
      initialize(dto);
      frame.setVisible(true);
   }

   private void initialize(MemberDTO dto) {
      calculateDAO dao = new calculateDAO();
      frame = new JFrame();
      frame.getContentPane().setBackground(new Color(240, 255, 240));
      frame.setBounds(100, 100, 557, 700);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      
      String[] col = { "날짜", "종가(원)", "대비", "등락률(%)", "거래량(kg)" };
      Object[][] data = { { "01/25", 250, 20 + "증가", 8.7,  "34, 746" },
            { "01/24", 230, 20 + "증가", 9.5, "23,500" }, { "01/23", 210, 13 + "증가", 6.59,  "23,154" },
            { "01/22", 197, 12 + "증가", 6.48,  "19,300" }, { "01/21", 185, 5 + "증가", 2.7,  "13,100" },
            { "01/20", 180, 20 + "증가", 12.5,  "18,200" }, { "01/19", 160, 10 + "증가", 6.7,  "17,154" } };
      DefaultTableModel model = new DefaultTableModel(data, col);
      // 로고넣고시펑요
      ImageIcon logo_img = new ImageIcon("img/logo.jpg");
      Image logo_img2 = logo_img.getImage();
      Image logo_image = logo_img2.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
      ImageIcon logo = new ImageIcon(logo_image);
      JLabel lbl_logo = new JLabel(logo);
      lbl_logo.setBounds(12, 10, 100, 100);
      lbl_logo.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            frame.dispose();
            main main = new main(dto);
         }
      });
      frame.getContentPane().setLayout(null);
      frame.getContentPane().add(lbl_logo);

      JPanel panel = new JPanel();
      panel.setBounds(0, 0, 541, 661);
      panel.setBackground(Color.WHITE);
      frame.getContentPane().add(panel);

      // 로그아웃
      JButton btn_exit = new JButton("LOG OUT");
      btn_exit.setBounds(414, 10, 115, 30);
      btn_exit.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            frame.dispose();
            login login1 = new login();
            login1.main(null);
         }
      });
      panel.setLayout(null);
      btn_exit.setFont(new Font("Times New Roman", Font.BOLD, 15));
      btn_exit.setBorderPainted(false);
      btn_exit.setBackground(Color.WHITE);
      panel.add(btn_exit);

      // 마이페이지
      JButton btn_mypage = new JButton("MY PAGE");
      btn_mypage.setBounds(312, 10, 110, 30);
      btn_mypage.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            frame.dispose();
            mypage mypage = new mypage(dto);
         }
      });
      btn_mypage.setFont(new Font("Times New Roman", Font.BOLD, 15));
      btn_mypage.setBorderPainted(false);
      btn_mypage.setBackground(Color.WHITE);
      panel.add(btn_mypage);

      JLabel lbl_title = new JLabel("\uD0C4\uC18C\uBC30\uCD9C\uAD8C \uAC70\uB798\uC18C");
      lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
      lbl_title.setFont(new Font("굴림", Font.BOLD, 30));
      lbl_title.setBounds(52, 101, 461, 69);
      panel.add(lbl_title);

      JScrollPane scroll_data = new JScrollPane();
      scroll_data.setBounds(52, 235, 461, 359);
      panel.add(scroll_data);

      table_data = new JTable(model);
      
      scroll_data.getViewport().setBackground(Color.white);
      table_data.setBackground(Color.white);
      scroll_data.setViewportView(table_data);

      JLabel lbl_point = new JLabel(dao.totalPoint() + "");
      lbl_point.setFont(new Font("굴림", Font.PLAIN, 15));
      lbl_point.setHorizontalAlignment(SwingConstants.CENTER);
      lbl_point.setBounds(456, 180, 57, 45);
      panel.add(lbl_point); 

      JLabel lbl_point_1 = new JLabel("\uB0B4 \uD3EC\uC778\uD2B8 :");
      lbl_point_1.setFont(new Font("굴림", Font.PLAIN, 15));
      lbl_point_1.setHorizontalAlignment(SwingConstants.RIGHT);
      lbl_point_1.setBounds(365, 180, 94, 45);
      panel.add(lbl_point_1);

      // 셀 가운데 정렬
      DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();
      tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
      // 정렬할 테이블의 ColumnModel을 가져옴

      TableColumnModel tcmSchedule = table_data.getColumnModel();
      for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {

         tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
      }
   }
}