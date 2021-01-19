package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

	public int insert(String how, double distance) {
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

		// 우리가 100%로 놓고 계산할 탄소 배출량
		double standard = (243.8) * (34.5);

		// 이동수단별 점수 및 포인트 계산
		// 승용차일때
		if (how.equals("승용차")) {
			c_day += c_car * distance; // 여기서 += 을 해준 이유는 이동수단이 복수일 경우를 고려
			if (c_day >= standard) {
				score = 0;
				point = 0;
			} else {
				score = ((double) (standard - c_day) / (double) standard) * 100;
				score = (int) score; // .0 없애는 기발한 방법 아시는분...
				point = score;
			}
		}

		// 대중교통일때
		if (how.equals("대중교통")) {
			c_day += c_bus * distance;
			if (c_day >= standard) {
				score = 0;
				point = 0;
			} else {
				score = ((double) (standard - c_day) / (double) standard) * 100;
				score = (int) score;
				point = score;
			}
		}

		// 전기자동차, 도보, 자전거 일때
		if (how.equals("전기자동차")) {
			c_day += c_elec * distance;
			if (c_day >= standard) {
				score = 0;
				point = 0;
			} else {
				score = ((double) (standard - c_day) / (double) standard) * 100;
				score = (int) score;
				point = score;
			}
		}

		System.out.println("오늘 하루의 점수는 >> " + (int)score);
		System.out.println("오늘 얻은 포인트는 >> " + (int)point);

		try {

			getConnection();
			String sql = "insert into result values(?, ?)";
			psmt = conn.prepareStatement(sql);
			
			psmt.setDouble(1,score);
			psmt.setDouble(2, point);

			result = psmt.executeUpdate();

			if (result > 0) {
				System.out.println("추가 성공!");
			} else {
				System.out.println("추가 실패! ");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			getClose();
		}

		return result;
	}

}