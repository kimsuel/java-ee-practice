package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Student {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "java";
	private String password = "itbank";

	public Student() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public void menu() {
		Scanner sc = new Scanner(System.in);
		int choice;

		while (true) {
			System.out.println("************");
			System.out.println("관리");
			System.out.println("************");
			System.out.println("1.입력");
			System.out.println("2.검색");
			System.out.println("3.삭제");
			System.out.println("4.종료");
			System.out.println("************");
			System.out.print("번호 선택 : ");
			choice = sc.nextInt();

			if (choice == 1) {
				insertArticle();
			} else if (choice == 2) {
				selectArticle();
			} else if (choice == 3) {
				deleteArticle();
			} else if (choice == 4) {
				break;
			}

		}

	}

	public void insertArticle() {
		Scanner sc = new Scanner(System.in);
		int choice;
		int code = 0;
		String value = null;
		String name;

		while (true) {
			System.out.println("************");
			System.out.println("1.학생");
			System.out.println("2.교수");
			System.out.println("3.관리자");
			System.out.println("4.이전메뉴");
			System.out.println("************");
			System.out.print("번호 선택 : ");
			choice = sc.nextInt();
			if (choice == 4)
				break;

			System.out.print("이름 입력 : ");
			name = sc.next();

			if (choice == 1) {
				System.out.print("학번 입력 : ");
				value = sc.next();
				code = 1;
			} else if (choice == 2) {
				System.out.print("과목 입력 : ");
				value = sc.next();
				code = 2;
			} else if (choice == 3) {
				System.out.print("부서 입력 : ");
				value = sc.next();
				code = 3;
			}

			// DB---------------------------------------------------------------
			Connection conn = getConnection();
			PreparedStatement pstmt = null;
			String sql = "insert into student values(?,?,?)";

			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, name);
				pstmt.setString(2, value);
				pstmt.setInt(3, code);

				int su = pstmt.executeUpdate();
				System.out.println(su + "행이 삽입되었습니다.");
			} catch (SQLException e) {
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
		}

	}

	public void selectArticle() {
		Scanner sc = new Scanner(System.in);
		int choice;
		String name = null;
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {
			while (true) {
				System.out.println("************");
				System.out.println("1.이름 검색");
				System.out.println("2.전체 검색");
				System.out.println("3.이전 메뉴");
				System.out.println("************");
				System.out.print("번호 선택 : ");
				choice = sc.nextInt();

				if (choice == 3)
					break;
				if (choice == 1) {
					System.out.print("검색 할 이름 입력 : ");
					name = sc.next();
				}
				if (choice == 1) {
					sql = "select * from student where name like ?";
				} else
					sql = "select * from student";

				pstmt = conn.prepareStatement(sql);
				if (choice == 1)
					pstmt.setString(1, "%" + name + "%");
				rs = pstmt.executeQuery(); // 실행
				while (rs.next()) {
					System.out.print("이름= "+rs.getString("name")+"\t");
					if(rs.getInt("code")==1) {
						System.out.println("학번="+rs.getString("value"));
					}else if(rs.getInt("code")==2) {
						System.out.println("과목="+rs.getString("value"));
					}else if(rs.getInt("code")==3) {
						System.out.println("부서="+rs.getString("value"));
					}
				

				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	public void deleteArticle() {
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제 할 이름 입력 : ");
		String name;
		name =sc.next();
		/////////////////////////////////////
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "delete student where name=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			int su = pstmt.executeUpdate();

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
		System.out.println(name + "이 삭제 되었습니다.");

	}

	public static void main(String[] args) {
		Student student = new Student();
		student.menu();
		System.out.println("프로그램을 종료합니다");
	}

}
