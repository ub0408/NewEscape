package room;

import com.ibatis.common.resources.Resources;

import java.io.Reader;
import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * This is not a best practices class. It's just an example to give you an idea
 * of how iBATIS works. For a more complete example, see JPetStore 5.0 at
 * http://www.ibatis.com.
 */
public class Room {

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

	public static List listRoom(Integer branch_id){
		List list = null;
		SqlSession session = sqlMapper.openSession();
		try{
			list = session.selectList("listRoom", branch_id);
		}catch(Exception e){
			System.out.println("listRoom���� �����߻�(��ϵ� ���� �����ϴ�");
		}
		session.close();
		return list;
	}
	
	public static List getRoom(Integer room_id){
		List list = null;
		SqlSession session = sqlMapper.openSession();
		try{
			list = session.selectList("getRoom", room_id);
		}catch(Exception e){
			System.out.println("getRoom���� �����߻�(��ϵ� ���� �����ϴ�");
		}
		session.close();
		return list;
	}
	
	public static void insertRoom(RoomDTO dto){
		SqlSession session = sqlMapper.openSession();
		
		session.insert("insertRoom", dto);
		session.commit();
		
		session.close();
	}
	
	public static void deleteRoom(Integer room_id){
		SqlSession session = sqlMapper.openSession();
		
		session.delete("deleteRoom", room_id);
		session.commit();
		
		session.close();
	}	
	
	
	
	
	
	
}
