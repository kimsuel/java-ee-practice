package board.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import board.bean.BoardDTO;


public class BoardDAO {

	private static BoardDAO instance; 
	private SqlSessionFactory sqlSessionFactory;
	
	public BoardDAO() {
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static BoardDAO getInstance(){ 
		if(instance == null) {
			synchronized(BoardDAO.class){
				instance = new BoardDAO();
			}
		}
		return instance;
	}
	
	public void boardWrite(Map<String, String> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("boardSQL.boardWrite",map);
		sqlSession.commit();
		sqlSession.close();
	}
	
	public List<BoardDTO> boardList(Map<String,Integer> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<BoardDTO> list = sqlSession.selectList("boardSQL.boardList", map);
		sqlSession.close();
		return list;
	}
	
	public int getBoardTotalA() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int totalA = sqlSession.selectOne("boardSQL.getBoardTotalA");
		sqlSession.close();
		return totalA;
	}
	
	public BoardDTO boardView(int seq) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		BoardDTO boardDTO = sqlSession.selectOne("boardSQL.boardView",seq);
		sqlSession.close();
		return boardDTO;
	}
	
	public void boardModify(BoardDTO boardDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("boardSQL.boardModify",boardDTO);
		sqlSession.commit();
	}

	public void hitUpdate(int seq) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("boardSQL.hitUpdate", seq);
		sqlSession.commit();
		sqlSession.close();
	}

	public void boardReply(Map<String,String> map) {
		// 원글 정보
		BoardDTO boardDTO = boardView(Integer.parseInt(map.get("pseq"))); // 원글
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//step update ( 답글이 더 추가될 시 순서 바꿈 )
		sqlSession.update("boardSQL.boardReply1", boardDTO);
		
		//insert( 답글 추가)
		//map에 ref, lev, step 추가
		map.put("ref", boardDTO.getRef()+"");
		map.put("lev", boardDTO.getLev()+1+"");
		map.put("step", boardDTO.getStep()+1+"");
		
		sqlSession.insert("boardSQL.boardReply2", map);
		
		//reply update ( 원글의 답글 수 증가 )
		sqlSession.update("boardSQL.boardReply3", boardDTO.getSeq());
		sqlSession.commit();
		sqlSession.close();
	}

	public void boardDelete(int seq) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		/*sqlSession.update("boardSQL.boardDelete1",map);*/
		sqlSession.delete("boardSQL.boardDelete",seq);
		sqlSession.commit();
		sqlSession.close();
	}

	public List<BoardDTO> search(Map<String, String> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<BoardDTO> list = sqlSession.selectList("boardSQL.search", map);
		sqlSession.close();
		return list;
	}

	public int searchTotalA(Map<String, String> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int totalA = sqlSession.selectOne("boardSQL.searchTotalA",map);
		sqlSession.close();
		return totalA;
	}
}
