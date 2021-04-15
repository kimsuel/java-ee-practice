package user.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import user.bean.UserDTO;

public class UserDAO {
	private static UserDAO instance; 
	private SqlSessionFactory sqlSessionFactory;
	
	public UserDAO() {
		try {
			//바이트 단위로 읽어옴
			//InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			//문자 단위로 읽어옴
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static UserDAO getInstance(){ 
		if(instance == null) {
			synchronized(UserDAO.class){
				instance = new UserDAO();
			}
		}
		return instance;
	}

	public int write(UserDTO userDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		                      //factory를 통해 new SqlSession()한 것과 동일
		//SqlSession 객체를 통해 sql문 처리
		int su = sqlSession.insert("userSQL.write",userDTO);
		// userMapper.xml에 있는 insert를 부르는 것
		// insert가 많기 때문에 id로 이름 설정 - sqlSession.insert("id이름(보통 메소드 이름과 동일하게 사용)");
		// 자동으로 int값을 넘겨줌 
		
		sqlSession.commit();
		//sqlSession.close();
		return su;
	}

	public List<UserDTO> getUserList() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<UserDTO> list = sqlSession.selectList("userSQL.getUserList");
		//sqlSession.selectOne(arg0, arg1);
		// selectOne : list값이 하나 나올 때
		// selectList : list값이 여러 개 나올 때 - 자체적으로 List를 넘겨줌
		return list;
	}

	public UserDTO check(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserDTO userDTO = sqlSession.selectOne("userSQL.check",id);
		return userDTO;
	}
	
	/*public int update(UserDTO userDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int su = sqlSession.update("userSQL.update",userDTO);
		sqlSession.commit();
		
		return su;
	}
	*/
	
	public void update(Map<String,String> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("userSQL.update",map);
		sqlSession.commit();
	}

	public void delete(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.delete("userSQL.delete",id);
		sqlSession.commit();
	}

	public List<UserDTO> search(Map<String,String> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<UserDTO> list = sqlSession.selectList("userSQL.search", map);
		return list;
	}

}

