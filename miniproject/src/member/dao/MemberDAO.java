package member.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import member.bean.MemberDTO;
import member.bean.ZipcodeDTO;


public class MemberDAO {
	private static MemberDAO instance; 
	private SqlSessionFactory sqlSessionFactory;
	
	public MemberDAO() {
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static MemberDAO getInstance(){ 
		if(instance == null) {
			synchronized(MemberDAO.class){
				instance = new MemberDAO();
			}
		}
		return instance;
	}
	
	public int write(MemberDTO memberDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int su = sqlSession.insert("memberSQL.write",memberDTO);
		sqlSession.commit();
		return su;
	}
	
	public MemberDTO login(Map<String,String> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MemberDTO memberDTO = sqlSession.selectOne("memberSQL.login",map);
		return memberDTO;
	}
	
	public MemberDTO memberList(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MemberDTO memberDTO = sqlSession.selectOne("memberSQL.memberList",id);
		return memberDTO;
	}
	
	public void modify(MemberDTO memberDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("memberSQL.modify",memberDTO);
		sqlSession.commit();
	}
	
	
	public List<ZipcodeDTO> getZipcodeList(Map<String,String> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<ZipcodeDTO> list = sqlSession.selectList("memberSQL.getZipcodeList",map);
		
		return list;
		
	}
	
}


