package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
	private Connection conn = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;

	// DB 처리 & 동적 연결
	private void getConn() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String password = "hr";
			conn = DriverManager.getConnection(url, user, password);
			// createTable();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private void close() {
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
//			System.out.println("테이블 생성 성공");
//			close();
//		}
//
//	}

	// 회원가입
	public int Register(String id, String first_name, String last_name, String tel, String password, String car) {
		int result = 0;
		try {

			getConn();

			String sql = "insert into customers values(?,?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);

			// DTO에서 값 가져오기
			psmt.setString(1, id);
			psmt.setString(2, first_name);
			psmt.setString(3, last_name);
			psmt.setString(4, tel);
			psmt.setString(5, password);
			psmt.setString(6, car);
			// 값 데이터베이스에 저장

			result = psmt.executeUpdate();

			if (result > 0) {
				System.out.println("가입성공");
			} else {
				System.out.println("가입실패");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();

		}

		return result;

	}

	// 아이디 중복 확인
	public boolean ExistID(String id) {

		try {
			getConn();
			String sql = "select count(*) cnt from customers where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);

			rs = psmt.executeQuery();

			// 일치하는 column 이 존재하면 true , 없으면 false
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

	// 로그인
	public MemberDTO login(MemberDTO dto) {
		MemberDTO resultDTO = null;
		try {
			getConn();
			String sql = "select * from customers where id = ? and password = ?";

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPassword());

			rs = psmt.executeQuery();

			if (rs.next()) {
				String id2 = rs.getString("id");
				String pw2 = rs.getString("password");
				String phone = rs.getString("phone");
				String first = rs.getString("first_name");
				String last = rs.getString("last_name");
				String car = rs.getString("car");
				resultDTO = new MemberDTO(id2, first, last, phone, pw2, car);

			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			close();
		}

		return resultDTO;

	}
	// 회원정보수정

	public int update(MemberDTO dto) {
		int result = 0;
		try {
			getConn();
			String sql = "UPDATE CUSTOMERS SET PASSWORD = ?, PHONE = ? , CAR = ? WHERE ID = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getPassword());
			psmt.setString(2, dto.getTel());
			psmt.setString(3, dto.getCar());
			psmt.setString(4, dto.getId());

			result = psmt.executeUpdate();

			if (result > 0) {

				System.out.println("업데이트 완료 !");
			} else {

				System.out.println("업데이트 실패! ");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;

	}

	// 회원 탈퇴
	public int delete(MemberDTO dto) {

		int result = 0;

		try {
			getConn();
			String sql = "DELETE FROM CUSTOMERS WHERE ID = ? AND PASSWORD =?";
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPassword());

			result = psmt.executeUpdate();

			if (result > 0) {
				System.out.println("테이블 삭제 완료!");
			} else {
				System.out.println("오류발생");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return 0;

	}

}
