package dbtest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateTest {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "java";
	private String password = "itbank";

	public UpdateTest() {

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}// UpdateTest();

	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public void updateArticle() {
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �� �̸� �Է� : ");
		String name = sc.next();

		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "update dbtest set age=age+1, height = height+0.1 where name like ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + name + "%");
			int su = pstmt.executeUpdate();
			System.out.println(su + "���� ���� �Ǿ����ϴ�.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		new UpdateTest().updateArticle();
	}

}
