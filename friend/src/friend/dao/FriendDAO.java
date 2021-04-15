package friend.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import friend.bean.FriendDTO;

public class FriendDAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "java";
	private String password = "itbank";

	private static FriendDAO instance;

	public static FriendDAO getInstance() {
		if (instance == null) {
			synchronized (FriendDAO.class) {
				instance = new FriendDAO();
			}
		}
		return instance;
	}

	public FriendDAO() {
		try {
			Class.forName(driver);// 생성
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

	public int friendInsert(FriendDTO dto) {
		int su = 0;
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into friend values(?,?,?,?,?,?,?,?,?,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getSeq());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getTel1());
			pstmt.setString(4, dto.getTel2());
			pstmt.setString(5, dto.getTel3());
			pstmt.setInt(6, dto.getGender());
			pstmt.setInt(7, dto.getRead());
			pstmt.setInt(8, dto.getMovie());
			pstmt.setInt(9, dto.getMusic());
			pstmt.setInt(10, dto.getGame());
			pstmt.setInt(11, dto.getShopping());

			su = pstmt.executeUpdate();// 실행

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

		return su;
	}

	public int getSeq() {
		int seq = 0;
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select seq_friend.nextval from dual";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			rs.next();
			seq = rs.getInt(1);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return seq;
	}

	public ArrayList<FriendDTO> getFriendList() {
		ArrayList<FriendDTO> list = new ArrayList<FriendDTO>();
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from FRIEND";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				FriendDTO dto = new FriendDTO();
				dto.setSeq(rs.getInt("seq"));
				dto.setName(rs.getString("name"));
				dto.setTel1(rs.getString("tel1"));
				dto.setTel2(rs.getString("tel2"));
				dto.setTel3(rs.getString("tel3"));
				dto.setGender(rs.getInt("gender"));
				dto.setRead(rs.getInt("read"));
				dto.setMovie(rs.getInt("movie"));
				dto.setMusic(rs.getInt("music"));
				dto.setGame(rs.getInt("game"));
				dto.setShopping(rs.getInt("shopping"));

				list.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			list = null;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}

	public int friendUpdate(FriendDTO dto) {
		int su = 0;
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "update friend set name=?" + ",tel1=?" + ",tel2=?" + ",tel3=?" + ",gender=?" + ",read=?"
				+ ",movie=?" + ",music=?" + ",game=?" + ",shopping=? where seq=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getTel1());
			pstmt.setString(3, dto.getTel2());
			pstmt.setString(4, dto.getTel3());
			pstmt.setInt(5, dto.getGender());
			pstmt.setInt(6, dto.getRead());
			pstmt.setInt(7, dto.getMovie());
			pstmt.setInt(8, dto.getMusic());
			pstmt.setInt(9, dto.getGame());
			pstmt.setInt(10, dto.getShopping());
			pstmt.setInt(11, dto.getSeq());

			su = pstmt.executeUpdate();

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

		return su;
	}

	public int friendDelete(int seq) {
		int su = 0;
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "delete freind where seq=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,seq);

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
		return su;
	}

}
