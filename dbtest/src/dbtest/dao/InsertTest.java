package dbtest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertTest {
	private String driver ="oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "java";
	private String password = "itbank";
	public InsertTest() {
		//driver loading
		try {
			Class.forName(driver);	//클래스 타입으로 생성
			System.out.println("driver loading success");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public Connection getConnection() {
		Connection conn = null;
		try{
			conn = DriverManager.getConnection(url,username,password);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public void insertArticle() {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름 입력 : ");
		String name = sc.next();
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		System.out.print("키 입력 : ");
		double height = sc.nextDouble();
		
		Connection conn = getConnection();
		String sql = "insert into dbtest values(?,?,?,sysdate)";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,name);
			pstmt.setInt(2,age);
			pstmt.setDouble(3,height);
		//Statement		자바 명령어를 oracle에서 먹히게 바꿔주는 명령어. 
		//의 자식클래스 PreparedStatement
			int su = pstmt.executeUpdate();  		//pstmt를 실행시켜라.
			
			System.out.println(su+"행이 삽입되었습니다.");
			
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//에러가 있건 없건 무조건 수행해라. try에서 에러가 없을 경우 catch로 넘어가지 않고 바로 끝내는데 finally는 에러가 있건없건 무조건 실행된다.
	}

	public static void main(String[] args) {
		new InsertTest().insertArticle();
	}

}
