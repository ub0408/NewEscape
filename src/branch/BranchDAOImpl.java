package branch;

import java.util.List;

public class BranchDAOImpl implements BranchDAO{
	@Override
	public List<BranchDTO> list() {
		List list = Branch.listBranch();
		return list;
	}

	@Override
	public BranchDTO getBranch(Integer branch_id) {
		BranchDTO dto = Branch.getBranch(branch_id);
		return dto;
	}

	@Override
	public void insertBranch(BranchDTO dto) {
		Branch.insertBranch(dto);
	}

	public void updateBranch(BranchDTO dto) {
		Branch.updateBranch(dto);
	}
	
	public void deleteBranch(int branch_id) {
		Branch.deleteBranch(branch_id);
	}
}
