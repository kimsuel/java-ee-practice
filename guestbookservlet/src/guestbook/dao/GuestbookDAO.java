package guestbook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import guestbook.bean.GuestbookDTO;


public class GuestbookDAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "java";
	private String password = "itbank";
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private static GuestbookDAO instance; 
	

	public static GuestbookDAO getInstance(){ 
		if(instance == null) {
			synchronized(GuestbookDAO.class){
				instance = new GuestbookDAO();
			}
		}
		return instance;
	}

	public GuestbookDAO() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void write(GuestbookDTO guestbookDTO) {
		String sql = "insert into guestbook values(seq_guestbook.nextval,?,?,?,?,?,sysdate)";
		getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, guestbookDTO.getName());
			pstmt.setString(2, guestbookDTO.getEmail());
			pstmt.setString(3, guestbookDTO.getHomepage());
			pstmt.setString(4, guestbookDTO.getSubject());
			pstmt.setString(5, guestbookDTO.getContent());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public ArrayList<GuestbookDTO> guestbookList(int startNum, int endNum) {
		getConnection();
		ArrayList<GuestbookDTO> list = new ArrayList<GuestbookDTO>();
		String sql = "select * from " 
				+ "(select rownum rn, tt.* from " 
				+ "(select seq,name,email,homepage,subject,content,to_char(logtime,'YYYY.MM.DD') as logtime  "
				+ "from guestbook order by seq desc)tt) "
				+ "where rn>=? and rn<=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) { // 데이터가 없을 때까지 돌림
				GuestbookDTO guestbookDTO = new GuestbookDTO();
				// 한 줄 넣을 때마다 dto 생성
				
				guestbookDTO.setSeq(rs.getInt("seq"));
				guestbookDTO.setName(rs.getString("name"));
				guestbookDTO.setEmail(rs.getString("email"));
				guestbookDTO.setHomepage(rs.getString("homepage"));
				guestbookDTO.setSubject(rs.getString("subject"));
				guestbookDTO.setContent(rs.getString("content"));
				guestbookDTO.setLogtime(rs.getString("logtime"));
				// column명이 바뀌어서 알지 못하니까 as logtime으로 별칭 지정해줘야 함
				
				list.add(guestbookDTO);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			list = null; 
			// 에러가 떨어지면 바로 list 에 null값을 집어넣음
			// 그러면 null값을 넘겨줘서 nullpointerException이 떨어지므로
			// 프로그램을 중간에 멈출 수 있음
		}finally{
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public int getTotalA() {
		getConnection();
		int totalA=0;
		String sql = "select count(*) from guestbook";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				totalA = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return totalA;
	}
}