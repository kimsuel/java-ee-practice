package imageboard.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import board.bean.BoardDTO;
import imageboard.bean.ImageboardDTO;


public class ImageboardDAO {
	private static ImageboardDAO instance; 
	private SqlSessionFactory sqlSessionFactory;
	
	public ImageboardDAO() {
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static ImageboardDAO getInstance(){ 
		if(instance == null) {
			synchronized(ImageboardDAO.class){
				instance = new ImageboardDAO();
			}
		}
		return instance;
	}

	public void imageboardWrite(ImageboardDTO imageboardDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("imageboardSQL.imageboardWrite",imageboardDTO);
		sqlSession.commit();
		sqlSession.close();
	}

	public List<ImageboardDTO> imageboardList(Map<String, Integer> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<ImageboardDTO> list = sqlSession.selectList("imageboardSQL.imageboardList", map);
		sqlSession.close();
		return list;
	}

	public int getImageboardTotalA() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int totalA = sqlSession.selectOne("imageboardSQL.getImageboardTotalA");
		sqlSession.close();
		return totalA;
	}

	public ImageboardDTO imageboardView(int seq) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ImageboardDTO imageboardDTO = sqlSession.selectOne("imageboardSQL.imageboardView",seq);
		sqlSession.close();
		return imageboardDTO;
	}
	
	public void imageboardDelete(String[] seq) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		for(int i=0; i<seq.length; i++){
			sqlSession.delete("imageboardSQL.imageboardDelete",seq[i]);
		}
		sqlSession.commit();
		sqlSession.close();
	}

	public void imageboardDeleteAll() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.delete("imageboardSQL.imageboardDeleteAll");
		sqlSession.commit();
		sqlSession.close();
	}

}
