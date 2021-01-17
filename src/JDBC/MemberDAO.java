package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	// DB ó�� & ���� ����
	public Connection getConn() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String password = "hr";
			conn = DriverManager.getConnection(url, user, password);
			//createTable();
			

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;

	}

	public void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

//	public void createTable() {
//
//		try {
//			String sql = "CREATE TABLE CUSTOMERS"
//						+ "(ID VARCHAR2(15),"
//						+ "FIRST_NAME VARCHAR2(15) NOT NULL," 
//						+ "LAST_NAME VARCHAR2(15) NOT NULL,"
//						+ "PASSWORD VARCHAR2(15) NOT NULL," 
//						+ "PHONE VARCHAR2(15) NOT NULL,"
//						+ "CAR VARCHAR2(20),"
//						+ "CONSTRAINT CUSTOMERS_PK_ID PRIMARY KEY(ID))";
//			psmt = conn.prepareStatement(sql);
//			psmt.execute();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//			
//		} finally {
//			System.out.println("���̺� ���� ����");
//			close();
//		}
//
//	}
	// ȸ������
	public int Register(String id, String first_name, String last_name, String tel, String password, String car) {
		int result = 0;
		try {
			
			conn = getConn();

			String sql = "insert into customers values(?,?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);

			// DTO���� �� ��������
			psmt.setString(1, id);
			psmt.setString(2, first_name);
			psmt.setString(3, last_name);
			psmt.setString(4, tel);
			psmt.setString(5, password);
			psmt.setString(6, car);
			// �� �����ͺ��̽��� ����

			result = psmt.executeUpdate();

			if (result > 0) {
				System.out.println("���Լ���");
			} else {
				System.out.println("���Խ���");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();

		}

		return result;

	}
	// ���̵� �ߺ� Ȯ��

	public boolean ExistID(String id) {

		try {
			conn = getConn();
			String sql = "select count(*) cnt from customers where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);

			rs = psmt.executeQuery();

			// ��ġ�ϴ� column �� �����ϸ� true , ������ false
			if (rs.next()) {
				int cnt = rs.getInt("cnt");
				if (cnt > 0) {
					return true;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			close();

		}
		return false;

	}

	// �α���
	public boolean login(String id, String password) {
		try {
			conn = getConn();
			String sql = "select * from customers where id = ? and password = ?";

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, id);
			psmt.setString(2, password);

			rs = psmt.executeQuery();

			if (rs.next()) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			close();
		}

		return false;

	}

}
