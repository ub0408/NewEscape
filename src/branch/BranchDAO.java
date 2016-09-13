package branch;

import java.util.List;

public interface BranchDAO {
	public List<BranchDTO> list();
	public BranchDTO getBranch(Integer branch_id);
	public void insertBranch(BranchDTO dto);
	public void updateBranch(BranchDTO dto);
	public void deleteBranch(int branch_id);
}
