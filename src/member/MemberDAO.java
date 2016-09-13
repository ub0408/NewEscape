package member;

import java.util.List;

public interface MemberDAO {
	public List list();
	public MemberDTO getMember(String id);
	public void insertMember(MemberDTO dto);
	public void deleteMember(String id);
	public void updateMember(MemberDTO dto);
	public MemberDTO searchMemberId(String id);
	public MemberDTO searchMemberName(String name);
}
