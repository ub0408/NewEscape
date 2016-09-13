package member;

import com.ibatis.common.resources.Resources;

import java.io.Reader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * This is not a best practices class. It's just an example to give you an idea
 * of how iBATIS works. For a more complete example, see JPetStore 5.0 at
 * http://www.ibatis.com.
 */
public class Member {

	/**
	 * SqlMapClient instances are thread safe, so you only need one. In this
	 * case, we'll use a static singleton. So sue me. ;-)
	 */
	private static SqlSessionFactory sqlMapper;

	/**
	 * It's not a good idea to put code that can fail in a class initializer,
	 * but for sake of argument, here's how you configure an SQL Map.
	 */
	static {
		try {
			Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		} catch (IOException e) {
			// Fail fast.
			throw new RuntimeException("Something bad happened while building the SqlMapClient instance." + e, e);
		}
	}

	public static List listMember(){
		SqlSession session = sqlMapper.openSession();
		List list = session.selectList("listMember");
		session.close();
		return list;
	}
	
	public static MemberDTO getMember(String id){
		SqlSession session = sqlMapper.openSession();
		
		MemberDTO dto = null;
		dto = (MemberDTO)session.selectOne("getMember", id);
		session.commit();
		session.close();
		return dto;
	}
	
	
	public static void insertMember(MemberDTO dto){
		SqlSession session = sqlMapper.openSession();
		
		session.insert("insertMember",dto);
		session.commit();
		
		session.close();
	}
	
	public static MemberDTO getMemberId(String id){
		SqlSession session = sqlMapper.openSession();
		
		MemberDTO dto = null;
		dto = (MemberDTO)session.selectOne("getMemberId", id);
		session.commit();
		session.close();
		return dto;
	}
	
	public static MemberDTO getMemberName(String name){
		SqlSession session = sqlMapper.openSession();
		
		MemberDTO dto = (MemberDTO)session.selectOne("getMemberName", name);
		session.commit();
		session.close();
		return dto;
	}
	
	public static List rankList(HashMap map) {
		List list = null;
		SqlSession session = sqlMapper.openSession();
		list = session.selectList("rankList", map);
		session.close();
		return list;
	}
	
	public static int count(){
		SqlSession session = sqlMapper.openSession();
		int res = session.selectOne("count");
		session.close();
		return res;
	}
}
