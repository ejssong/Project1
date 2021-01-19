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

	public int insert(String how, double distance) {
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

		// �츮�� 100%�� ���� ����� ź�� ���ⷮ
		double standard = (243.8) * (34.5);

		// �̵����ܺ� ���� �� ����Ʈ ���
		// �¿����϶�
		if (how.equals("�¿���")) {
			c_day += c_car * distance; // ���⼭ += �� ���� ������ �̵������� ������ ��츦 ���
			if (c_day >= standard) {
				score = 0;
				point = 0;
			} else {
				score = ((double) (standard - c_day) / (double) standard) * 100;
				score = (int) score; // .0 ���ִ� ����� ��� �ƽôº�...
				point = score;
			}
		}

		// ���߱����϶�
		if (how.equals("���߱���")) {
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

		// �����ڵ���, ����, ������ �϶�
		if (how.equals("�����ڵ���")) {
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

		System.out.println("���� �Ϸ��� ������ >> " + (int)score);
		System.out.println("���� ���� ����Ʈ�� >> " + (int)point);

		try {

			getConnection();
			String sql = "insert into result values(?, ?)";
			psmt = conn.prepareStatement(sql);
			
			psmt.setDouble(1,score);
			psmt.setDouble(2, point);

			result = psmt.executeUpdate();

			if (result > 0) {
				System.out.println("�߰� ����!");
			} else {
				System.out.println("�߰� ����! ");
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