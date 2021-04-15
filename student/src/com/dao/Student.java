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
			System.out.println("����");
			System.out.println("************");
			System.out.println("1.�Է�");
			System.out.println("2.�˻�");
			System.out.println("3.����");
			System.out.println("4.����");
			System.out.println("************");
			System.out.print("��ȣ ���� : ");
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
			System.out.println("1.�л�");
			System.out.println("2.����");
			System.out.println("3.������");
			System.out.println("4.�����޴�");
			System.out.println("************");
			System.out.print("��ȣ ���� : ");
			choice = sc.nextInt();
			if (choice == 4)
				break;

			System.out.print("�̸� �Է� : ");
			name = sc.next();

			if (choice == 1) {
				System.out.print("�й� �Է� : ");
				value = sc.next();
				code = 1;
			} else if (choice == 2) {
				System.out.print("���� �Է� : ");
				value = sc.next();
				code = 2;
			} else if (choice == 3) {
				System.out.print("�μ� �Է� : ");
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
				System.out.println(su + "���� ���ԵǾ����ϴ�.");
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
				System.out.println("1.�̸� �˻�");
				System.out.println("2.��ü �˻�");
				System.out.println("3.���� �޴�");
				System.out.println("************");
				System.out.print("��ȣ ���� : ");
				choice = sc.nextInt();

				if (choice == 3)
					break;
				if (choice == 1) {
					System.out.print("�˻� �� �̸� �Է� : ");
					name = sc.next();
				}
				if (choice == 1) {
					sql = "select * from student where name like ?";
				} else
					sql = "select * from student";

				pstmt = conn.prepareStatement(sql);
				if (choice == 1)
					pstmt.setString(1, "%" + name + "%");
				rs = pstmt.executeQuery(); // ����
				while (rs.next()) {
					System.out.print("�̸�= "+rs.getString("name")+"\t");
					if(rs.getInt("code")==1) {
						System.out.println("�й�="+rs.getString("value"));
					}else if(rs.getInt("code")==2) {
						System.out.println("����="+rs.getString("value"));
					}else if(rs.getInt("code")==3) {
						System.out.println("�μ�="+rs.getString("value"));
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
		System.out.print("���� �� �̸� �Է� : ");
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
		System.out.println(name + "�� ���� �Ǿ����ϴ�.");

	}

	public static void main(String[] args) {
		Student student = new Student();
		student.menu();
		System.out.println("���α׷��� �����մϴ�");
	}

}
