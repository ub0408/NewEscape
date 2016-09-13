package branch;

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
public class Branch {

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

	public static List listBranch(){
		List list = null;
		SqlSession session = sqlMapper.openSession();
		list = session.selectList("listBranch");
		session.close();
		return list;
	}
	
	public static BranchDTO getBranch(int branch_id){
		SqlSession session = sqlMapper.openSession();
		
		BranchDTO dto = null;
		dto = (BranchDTO)session.selectOne("getBranch", branch_id);
		
		session.close();
		return dto;
	}
	
	
	public static void insertBranch(BranchDTO dto){
		SqlSession session = sqlMapper.openSession();
		
		session.insert("insertBranch",dto);
		session.commit();
		
		session.close();
	}
	
	public static void updateBranch(BranchDTO dto) {
		SqlSession session = sqlMapper.openSession();
		session.update("updateBranch", dto);
		session.commit();
		session.close();
	}
	
	public static void deleteBranch(int branch_id) {
		SqlSession session = sqlMapper.openSession();
		session.delete("deleteBranch", branch_id);
		session.commit();
		session.close();
	}
	
}
