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
			Class.forName(driver);	//Ŭ���� Ÿ������ ����
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
		System.out.print("�̸� �Է� : ");
		String name = sc.next();
		System.out.print("���� �Է� : ");
		int age = sc.nextInt();
		System.out.print("Ű �Է� : ");
		double height = sc.nextDouble();
		
		Connection conn = getConnection();
		String sql = "insert into dbtest values(?,?,?,sysdate)";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,name);
			pstmt.setInt(2,age);
			pstmt.setDouble(3,height);
		//Statement		�ڹ� ��ɾ oracle���� ������ �ٲ��ִ� ��ɾ�. 
		//�� �ڽ�Ŭ���� PreparedStatement
			int su = pstmt.executeUpdate();  		//pstmt�� ������Ѷ�.
			
			System.out.println(su+"���� ���ԵǾ����ϴ�.");
			
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
		//������ �ְ� ���� ������ �����ض�. try���� ������ ���� ��� catch�� �Ѿ�� �ʰ� �ٷ� �����µ� finally�� ������ �ְǾ��� ������ ����ȴ�.
	}

	public static void main(String[] args) {
		new InsertTest().insertArticle();
	}

}
