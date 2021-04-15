package memberjsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import memberjsp.bean.MemberjspDTO;
import memberjsp.bean.ZipcodeDTO;


public class MemberjspDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private DataSource ds;
	
	private static MemberjspDAO instance; 
	

	public static MemberjspDAO getInstance(){ 
		if(instance == null) {
			synchronized(MemberjspDAO.class){
				instance = new MemberjspDAO();
			}
		}
		return instance;
	}

	public MemberjspDAO() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle"); // 20개 커넥션 불러옴
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}


	
	public String[] login(String id, String pwd) {
		String sql = "select * from member where id=? and pwd=?";
		String[] ar = new String[3];
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				ar[0] = rs.getString("name");
				ar[1] = rs.getString("email1");
				ar[2] = rs.getString("email2");
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
		return ar;
	}
	
	public MemberjspDTO memberList(String id) {
		String sql = "select * from member where id=?";
		MemberjspDTO memberjspDTO = null;
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				memberjspDTO = new MemberjspDTO();
				memberjspDTO.setName(rs.getString("name"));
				memberjspDTO.setId(rs.getString("id"));
				memberjspDTO.setPwd(rs.getString("pwd"));
				memberjspDTO.setGender(rs.getString("gender"));
				memberjspDTO.setEmail1(rs.getString("email1"));
				memberjspDTO.setEmail2(rs.getString("email2"));
				memberjspDTO.setTel1(rs.getString("tel1"));
				memberjspDTO.setTel2(rs.getString("tel2"));
				memberjspDTO.setTel3(rs.getString("tel3"));
				memberjspDTO.setZipcode(rs.getString("zipcode"));
				memberjspDTO.setAddr1(rs.getString("addr1"));
				memberjspDTO.setAddr2(rs.getString("addr2"));
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
		return memberjspDTO;
	}
	
	public void modify(MemberjspDTO memberjspDTO) {
		String sql = "update member set name=?"
								+ ", pwd=?"
								+ ", gender=?"
								+ ", email1=?"
								+ ", email2=?"
								+ ", tel1=?"
								+ ", tel2=?"
								+ ", tel3=?"
								+ ", zipcode=?"
								+ ", addr1=?"
								+ ", addr2=?"
								+ ", logtime=sysdate "
								+ "where id=?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, memberjspDTO.getName());
			pstmt.setString(2, memberjspDTO.getPwd());
			pstmt.setString(3, memberjspDTO.getGender());
			pstmt.setString(4, memberjspDTO.getEmail1());
			pstmt.setString(5, memberjspDTO.getEmail2());
			pstmt.setString(6, memberjspDTO.getTel1());
			pstmt.setString(7, memberjspDTO.getTel2());
			pstmt.setString(8, memberjspDTO.getTel3());
			pstmt.setString(9, memberjspDTO.getZipcode());
			pstmt.setString(10, memberjspDTO.getAddr1());
			pstmt.setString(11, memberjspDTO.getAddr2());
			pstmt.setString(12, memberjspDTO.getId());
			
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
	
	public int write(MemberjspDTO memberjspDTO) {
		int su=0;
		String sql = "insert into member values(?,?,?,?,?,?,?,?,?,?,?,?,sysdate)";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, memberjspDTO.getName());
			pstmt.setString(2, memberjspDTO.getId());
			pstmt.setString(3, memberjspDTO.getPwd());
			pstmt.setString(4, memberjspDTO.getGender());
			pstmt.setString(5, memberjspDTO.getEmail1());
			pstmt.setString(6, memberjspDTO.getEmail2());
			pstmt.setString(7, memberjspDTO.getTel1());
			pstmt.setString(8, memberjspDTO.getTel2());
			pstmt.setString(9, memberjspDTO.getTel3());
			pstmt.setString(10, memberjspDTO.getZipcode());
			pstmt.setString(11, memberjspDTO.getAddr1());
			pstmt.setString(12, memberjspDTO.getAddr2());
			
			su = pstmt.executeUpdate();
			
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
		
		return su;
	}
	
	public ArrayList<ZipcodeDTO> getZipcodeList(String sido, String sigungu, String roadname) {
		String sql = "select * from newzipcode where sido like ? and nvl(sigungu,0) like ? and roadname like ?";
		ZipcodeDTO zipcodeDTO = null;
		ArrayList<ZipcodeDTO> list = new ArrayList<ZipcodeDTO>();
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, "%"+sido+"%");
			pstmt.setString(2, "%"+sigungu+"%");
			pstmt.setString(3, "%"+roadname+"%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				zipcodeDTO = new ZipcodeDTO();
				zipcodeDTO.setZipcode(rs.getString("zipcode"));
				zipcodeDTO.setSido(rs.getString("sido"));
				zipcodeDTO.setSigungu(rs.getString("sigungu")==null? "":rs.getString("sigungu"));
				zipcodeDTO.setYubmyundong(rs.getString("yubmyundong"));
				zipcodeDTO.setRi(rs.getString("ri")==null ? "":rs.getString("ri"));
				zipcodeDTO.setRoadname(rs.getString("roadname"));
				zipcodeDTO.setBuildingname(rs.getString("buildingname")==null? "":rs.getString("buildingname"));
				
				list.add(zipcodeDTO);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			list=null; // 에러가 났을 때 list의 값을 null로 초기화
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
	
}


