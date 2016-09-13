package update;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ibatis.common.resources.Resources;

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
	
	public static void insertMember(MemberDTO dto){
		
		SqlSession session = sqlMapper.openSession();
		
		session.insert("insertMember", dto);
		session.commit();
		session.close();
	}
	
	public static MemberDTO getId(MemberDTO dto){
		MemberDTO member = null;
		SqlSession session = sqlMapper.openSession();
		
		try{
			member = session.selectOne("getId", dto);
			
	    }catch(Exception e){
			
			return null;
		}
		
		session.close();
		return member;
		
	}
	
	public static String getPassword(MemberDTO dto){
		
		String password =null;
		SqlSession session = sqlMapper.openSession();
		
		try{
			password = session.selectOne("getPassword", dto);
			
		}catch(Exception e){
			return null;
		}
		session.close();
		return password;
		
	}
	
	public static void passChange(MemberDTO dto){
		
		SqlSession session = sqlMapper.openSession();
		session.update("passChange", dto);
		session.commit();
		session.close();
		
	}
	
	public static String getPassword(String id){
		
		String password = null;
		SqlSession session = sqlMapper.openSession();
		try{
			password = session.selectOne("getPassword1", id);
		}catch(Exception e){
			
			return null;
		}
		session.close();
		return password;
	}
	
	public static void deleteMember(String id){
	  SqlSession session = sqlMapper.openSession();
	  session.delete("deleteMember", id);
	  session.commit();
	  session.close();
	}
	
	public static void updateMember(MemberDTO dto){
		
		SqlSession session = sqlMapper.openSession();
		session.update("updateMember", dto);
		session.commit();
		session.close();
	}
	
	public static List ListMember(){
		
		List list = null;
		SqlSession session = sqlMapper.openSession();
		try{
			list = session.selectList("ListMember");
			
		}catch(Exception e){
			System.err.println("현재 등록된 회원이 없습니다.!");
			return null;
		}
		session.close();
		return list;
	}
	
	public static MemberDTO getMember(String id){
		
		MemberDTO dto = null;
		SqlSession session = sqlMapper.openSession();
	    try{
	    	dto = session.selectOne("getMember", id);
	    	
	    }catch(Exception e){
	    	System.err.println("회원의 정보를 불러올 수 없습니다.");
	    	return null;
	    }
	    session.close();
	    return dto;
	}

	
	
}
