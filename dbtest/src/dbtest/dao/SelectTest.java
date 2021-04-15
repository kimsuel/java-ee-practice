package dbtest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTest {
	private String driver ="oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username ="java";
	private String password = "itbank";
	
	public SelectTest() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}//SelectTest()
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public void selectArticle() {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "select * from dbtest";
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); //½ÇÇà
			while(rs.next()) {
				System.out.println(rs.getString("name")+"\t"
									+rs.getInt("age")+"\t"
									+rs.getDouble("height")+"\t"
									+rs.getString("ligtime"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
				if(rs!=null) rs.close();
				}catch(SQLException e) {
				e.printStackTrace();
			}
		
	}
	}
	
	
	public static void main(String[] args) {
		new SelectTest().selectArticle();

	}

}
