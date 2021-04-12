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

   // 연결하는 메서드
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

   // 닫는 메소드
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
      // 변수 생성 공간
      // gui에서 이동수단을 선택하고 입력버튼을 누르면 변수가 선언되면서 입력된 값으로 설정되게 만들면 될거 같습니다.

      double c_car = 243.8; // 자동차 탄소 배출량
      double c_bus = 17.7; // 대중교통 탄소 배출량
      double c_elec = 0; // 전기차 탄소 배출량
      double c_walk = 0; // 도보 및 자전거 탄소 배출량
      double c_day = 0; // 오늘 하루 배출한 탄소량
      double score = 0; // 오늘 획득한 점수
      double point = 0; // 오늘 획득한 포인트
      int result = 0;
      int score1 = 0; // (int)score
      // 우리가 100%로 놓고 계산할 탄소 배출량
      double standard = (243.8) * (34.5);

      // 이동수단이랑 거리 arraylist 만들기
      ArrayList<String> how1 = new ArrayList<String>();
      ArrayList<Integer> distance = new ArrayList<Integer>();

      // 이동수단별 점수 및 포인트 계산
      // 승용차일때
      if (txt_car != 0) {
         c_day += c_car * txt_car; // 여기서 += 을 해준 이유는 이동수단이 복수일 경우를 고려
         if (c_day >= standard) {
            score = 0;
            point = 0;
         } else {
            score = ((double) (standard - c_day) / (double) standard) * 100;
            score1 = (int) score; // .0 없애는 기발한 방법 아시는분...
            point = score1;
         }
         how1.add(lbl_car); // 이동수단 리스트에 승용차 추가
         distance.add((int) txt_car); // 이동거리 리스트에 승용차 이동거리 추가
      }

      // 대중교통일때
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
         how1.add(lbl_car); // 이동수단 리스트에 대중교통 추가
         distance.add((int) txt_bus); // 이동거리 리스트에 승용차 이동거리 추가
      }

      // 도보, 자전거 일때
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
         how1.add(lbl_walk); // 이동수단 리스트에 도보 추가
         distance.add((int) txt_walk); // 이동거리 리스트에 승용차 이동거리 추가
      }

      // 전기자동차 일때
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
         how1.add(lbl_elec); // 이동수단 리스트에 전기자동차 추가
         distance.add((int) txt_elec); // 이동거리 리스트에 승용차 이동거리 추가
      }

      System.out.println("오늘 하루의 점수는 >> " + score1);
      System.out.println("오늘 얻은 포인트는 >> " + point);

      try {

         getConnection();
         // values (result_id, user_id, date, distance,how,score,point )

         // arraylist 크기만큼 insert 작업해주기
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
            System.out.println("추가 성공!");
         } else {
            System.out.println("추가 실패! ");
         }

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         getClose();
      }

      return result;
   }

   // 이전 데이터 불러오기
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