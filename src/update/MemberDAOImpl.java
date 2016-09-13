package update;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;



public class MemberDAOImpl implements MemberDAO{
	
/*	   private JdbcTemplate jdbcTemplate; 
	     public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
	    	 this.jdbcTemplate=jdbcTemplate;  
	     }*/
		

	@Override
	public List list() {
		// TODO Auto-generated method stub
		return Member.ListMember();
	}

	@Override
	public MemberDTO getMember(String id) {
		// TODO Auto-generated method stub
		return Member.getMember(id);
	}

	@Override
	public void insertMember(MemberDTO dto) {
		// TODO Auto-generated method stub
	/*	String sql="insert into member values(?,?,?,?,?,?,?,?,?,?,?,?)";
		Object obj[] = new Object[]{
		dto.getId(),dto.getName(),dto.getBirth(),dto.getPasswd(),dto.getPhon(),dto.getEmail(),dto.getNickname(),
		dto.getFva(),null,0,0,0				
		};
		jdbcTemplate.update(sql,obj);*/
		Member.insertMember(dto);
	}

	@Override
	public void deleteMember(String id) {
		// TODO Auto-generated method stub
		Member.deleteMember(id);
		
	}

	@Override
	public void updateMember(MemberDTO dto) {
		// TODO Auto-generated method stub
		Member.updateMember(dto);
		
	}
	private class UserResultSetMapper implements RowMapper{
       
		@Override
		public Object mapRow(ResultSet rs, int arg1) throws SQLException {
			// TODO Auto-generated method stub
			
			  MemberDTO dto = new MemberDTO();
			  dto.setId(rs.getString("id"));
			  dto.setName(rs.getString("name"));
			  dto.setBirth(rs.getString("birth"));
			  dto.setPasswd(rs.getString("passwd"));
			  dto.setPhon(rs.getString("phon"));
			  dto.setEmail(rs.getString("email"));
			  dto.setNickname(rs.getString("nickname"));
			  dto.setFva(rs.getString("fva"));
			  dto.setMember_grade(rs.getString("member_grade"));
			  dto.setBranch_id(rs.getInt("branch_id"));
			  dto.setWin(rs.getInt("win"));
			  dto.setLose(rs.getInt("lose"));
			  return dto;

}
	}

	@Override
	public MemberDTO getId(MemberDTO dto) {
		// TODO Auto-generated method stub
	/*	String sql = "select * from member where name= ? and email= ? ";
		Object obj[]= new Object[]{dto.getName(),dto.getEmail()};
		RowMapper rse = new UserResultSetMapper();
	   try{
		MemberDTO dto1 = (MemberDTO)jdbcTemplate.queryForObject(sql,obj ,rse);
		return dto1;
	   }catch(Exception e){
		  e.getStackTrace(); 
	    return null;
	   }*/
		return Member.getId(dto);
	}


	@Override
	public String getPassword(MemberDTO dto) {
		// TODO Auto-generated method stub
		/*String sql = "select passwd from member where id=? and name=? and email=?";
	    RowMapper mapper = new passWordMapper();
		
	    Object [] obj = new Object[]{dto.getId(),dto.getName(),dto.getEmail()};
	    try{
	    String passwd = (String)jdbcTemplate.queryForObject(sql,obj ,mapper);
	    return passwd;
	    }catch(Exception e){
		return null;
	    }*/
		return Member.getPassword(dto);
	}
	
	class passWordMapper implements RowMapper{

		@Override
		public Object mapRow(ResultSet rs, int arg1) throws SQLException {
			// TODO Auto-generated method stub
			String passwd = rs.getString("passwd");
			return passwd;
		}
		
	}


	@Override
	public void PassChange(MemberDTO dto) {
	/*	String sql = "update member set passwd=? where id=?";
		Object[] obj = new Object[]{dto.getPasswd(),dto.getId()};
	    jdbcTemplate.update(sql, obj);*/
		Member.passChange(dto);
	}
	


	@Override
	public String getPassword(String id) {
		/*String sql = "select passwd from member where id=?";
		  RowMapper mapper = new passWordMapper();
		  Object[] obj = new Object[]{id};
		try{
	    String passwd = (String)jdbcTemplate.queryForObject(sql,obj, mapper);
		return passwd;
		}catch(Exception e){
		return null;
		}*/
    
		return Member.getPassword(id);
	}
	

}
	