package update;

import java.util.List;


public interface MemberDAO {
	public List list();
	public MemberDTO getMember(String id);
	public void insertMember(MemberDTO dto);
	public void deleteMember(String id);
	public void updateMember(MemberDTO dto);
	public String getPassword(MemberDTO dto);
	public MemberDTO getId(MemberDTO dto);
	public void PassChange(MemberDTO dto);
	public String getPassword(String id);
	
}
