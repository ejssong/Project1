package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class calculateDAO {

   // Field
   private Connection conn = null;
   private PreparedStatement psmt = null;
   private ResultSet rs = null;

   // �����ϴ� �޼���
   private void getConnection() {
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         String url = "jdbc:oracle:thin:@localhost:1521:xe";
         String user = "hr";
         String password = "hr";
         conn = DriverManager.getConnection(url, user, password);

      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   // �ݴ� �޼ҵ�
   private void getClose() {
      try {
         if (rs != null) {
            rs.close();
         }
         if (psmt != null) {
            psmt.close();
         }
         if (conn != null) {
            conn.close();
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   public int insert(String id, String lbl_car, String lbl_bus, String lbl_walk, String lbl_elec, double txt_car,
         double txt_bus, double txt_walk, double txt_elec) {
      // ���� ���� ����
      // gui���� �̵������� �����ϰ� �Է¹�ư�� ������ ������ ����Ǹ鼭 �Էµ� ������ �����ǰ� ����� �ɰ� �����ϴ�.

      double c_car = 243.8; // �ڵ��� ź�� ���ⷮ
      double c_bus = 17.7; // ���߱��� ź�� ���ⷮ
      double c_elec = 0; // ������ ź�� ���ⷮ
      double c_walk = 0; // ���� �� ������ ź�� ���ⷮ
      double c_day = 0; // ���� �Ϸ� ������ ź�ҷ�
      double score = 0; // ���� ȹ���� ����
      double point = 0; // ���� ȹ���� ����Ʈ
      int result = 0;
      int score1 = 0; // (int)score
      // �츮�� 100%�� ���� ����� ź�� ���ⷮ
      double standard = (243.8) * (34.5);

      // �̵������̶� �Ÿ� arraylist �����
      ArrayList<String> how1 = new ArrayList<String>();
      ArrayList<Integer> distance = new ArrayList<Integer>();

      // �̵����ܺ� ���� �� ����Ʈ ���
      // �¿����϶�
      if (txt_car != 0) {
         c_day += c_car * txt_car; // ���⼭ += �� ���� ������ �̵������� ������ ��츦 ���
         if (c_day >= standard) {
            score = 0;
            point = 0;
         } else {
            score = ((double) (standard - c_day) / (double) standard) * 100;
            score1 = (int) score; // .0 ���ִ� ����� ��� �ƽôº�...
            point = score1;
         }
         how1.add(lbl_car); // �̵����� ����Ʈ�� �¿��� �߰�
         distance.add((int) txt_car); // �̵��Ÿ� ����Ʈ�� �¿��� �̵��Ÿ� �߰�
      }

      // ���߱����϶�
      if (txt_bus != 0) {
         c_day += c_bus * txt_bus;
         if (c_day >= standard) {
            score = 0;
            point = 0;
         } else {
            score = ((double) (standard - c_day) / (double) standard) * 100;
            score1 = (int) score;
            point = score1;
         }
         how1.add(lbl_car); // �̵����� ����Ʈ�� ���߱��� �߰�
         distance.add((int) txt_bus); // �̵��Ÿ� ����Ʈ�� �¿��� �̵��Ÿ� �߰�
      }

      // ����, ������ �϶�
      if (txt_walk != 0) {
         c_day += c_elec * txt_walk;
         if (c_day >= standard) {
            score = 0;
            point = 0;
         } else {
            score = ((double) (standard - c_day) / (double) standard) * 100;
            score1 = (int) score;
            point = score1;
         }
         how1.add(lbl_walk); // �̵����� ����Ʈ�� ���� �߰�
         distance.add((int) txt_walk); // �̵��Ÿ� ����Ʈ�� �¿��� �̵��Ÿ� �߰�
      }

      // �����ڵ��� �϶�
      if (txt_elec != 0) {
         c_day += c_elec * txt_elec;
         if (c_day >= standard) {
            score = 0;
            point = 0;
         } else {
            score = ((double) (standard - c_day) / (double) standard) * 100;
            score1 = (int) score;
            point = score1;
         }
         how1.add(lbl_elec); // �̵����� ����Ʈ�� �����ڵ��� �߰�
         distance.add((int) txt_elec); // �̵��Ÿ� ����Ʈ�� �¿��� �̵��Ÿ� �߰�
      }

      System.out.println("���� �Ϸ��� ������ >> " + score1);
      System.out.println("���� ���� ����Ʈ�� >> " + point);

      try {

         getConnection();
         // values (result_id, user_id, date, distance,how,score,point )

         // arraylist ũ�⸸ŭ insert �۾����ֱ�
         for (int i = 0; i < how1.size(); i++) {
            String sql = "insert into result values(result_seq.nextval,?,SYSDATE,?,?,?,?)";
            psmt = conn.prepareStatement(sql);

            psmt.setString(1, id);
            psmt.setInt(2, distance.get(i).intValue());
            psmt.setString(3, how1.get(i).toString());
            psmt.setDouble(4, score1);
            psmt.setDouble(5, point);

            result = psmt.executeUpdate();

         }

         if (result > 0) {
            System.out.println("�߰� ����!");
         } else {
            System.out.println("�߰� ����! ");
         }

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         getClose();
      }

      return result;
   }

   // ���� ������ �ҷ�����
   public ArrayList<calculateVO> select() {
      ArrayList<calculateVO> list = new ArrayList<calculateVO>();

      try {
         getConnection();

         String sql = "select dt, how, distance, score from result order by dt";
         psmt = conn.prepareStatement(sql);
         rs = psmt.executeQuery();

         while (rs.next()) {
            String dt = rs.getString("dt");
            String how = rs.getString("how");
            int distance = rs.getInt("distance");
            int score = rs.getInt("score");

            calculateVO vo = new calculateVO(dt, how, distance, score);
            list.add(vo);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         getClose();
      }

      return list;

   }

   public int value(String id) {
      int result = 0;

      try {
         getConnection();
         String sql = "select point from result where user_id = ?";

         psmt = conn.prepareStatement(sql);
         psmt.setString(1, id);
         rs = psmt.executeQuery();

         while (rs.next()) {
            result = rs.getInt("point");
         }

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         getClose();
      }

      return result;
   }

   public int totalPoint() {
      int result = 0;

      try {
         getConnection();
         String sql = "SELECT SUM(POINT) AS POINT " 
               + "FROM RESULT " 
               + "WHERE RESULT_ID IN (SELECT MIN(RESULT_ID) "
                              + "FROM RESULT " 
                              + "GROUP BY DT)";
         psmt = conn.prepareStatement(sql);

         rs = psmt.executeQuery();

         while (rs.next()) {
            result = rs.getInt("POINT");
         }

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         getClose();
      }

      return result;
   }

}