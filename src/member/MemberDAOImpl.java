package member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class MemberDAOImpl implements MemberDAO{
	
	   private JdbcTemplate jdbcTemplate; 
	     public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
	    	 this.jdbcTemplate=jdbcTemplate;  
	     }
		

	@Override
	public List list() {
		List list = Member.listMember();
		return list;
	}

	@Override
	public MemberDTO getMember(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertMember(MemberDTO dto) {
		// TODO Auto-generated method stub
		String sql="insert into member values(?,?,?,?,?,?,?,?,?,?,?,?)";
		Object obj[] = new Object[]{
		dto.getId(),dto.getName(),dto.getBirth(),dto.getPasswd(),dto.getPhon(),dto.getEmail(),dto.getNickname(),
		dto.getFva(),null,0,0,0				
		};
		jdbcTemplate.update(sql,obj);
	}

	@Override
	public void deleteMember(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateMember(MemberDTO dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MemberDTO searchMemberId(String id) {
		MemberDTO dto = Member.getMemberId(id);
		
		return dto;
	}
	
	@Override
	public MemberDTO searchMemberName(String name) {
		MemberDTO dto = Member.getMemberName(name);
		
		return dto;
	}

}
