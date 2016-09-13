package branch.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import branch.BranchDAO;
import branch.BranchDTO;
import room.RoomDAO;


@Controller
public class BranchController {
	private BranchDAO branchDAO;
	private RoomDAO roomDAO;
	public void setBranchDAO(BranchDAO branchDAO) {
		this.branchDAO = branchDAO;
	} 
	public void setRoomDAO(RoomDAO roomDAO){
		this.roomDAO = roomDAO;
	}
	
	@RequestMapping(value="/branchManage.mainPage")
	public ModelAndView branchManage(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		List list = branchDAO.list();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/mainPage/branchManage/branchManage_main.jsp");
		mav.addObject("list", list);
		return mav;
	}
	
	@RequestMapping(value="/branchMain.branchPage")
	public ModelAndView branchMain(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		Integer branch_id = Integer.parseInt(arg0.getParameter("branch_id"));
		BranchDTO dto = branchDAO.getBranch(branch_id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/branchPage/branchPage_main.jsp");
		mav.addObject("dto", dto);
		return mav;
	}
	
	@RequestMapping(value="/roomManage.branchPage")
	public ModelAndView roomManage(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		Integer branch_id = Integer.parseInt(arg0.getParameter("branch_id"));
		List list = roomDAO.list(branch_id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/branchPage/roomManage/roomManage_main.jsp");
		mav.addObject("list", list);
		return mav;
	}
	
	@RequestMapping(value="/roomView.branchPage")
	public ModelAndView roomView(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		Integer branch_id = Integer.parseInt(arg0.getParameter("branch_id"));
		List list = roomDAO.list(branch_id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/branchPage/roomView/roomView.jsp");
		mav.addObject("list", list);
		return mav;
	}
	
	@RequestMapping(value="/branchInsert.mainPage")
	public ModelAndView branchInsert(HttpServletRequest rs, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		BranchDTO dto = new BranchDTO();
		dto.setBranch_address(rs.getParameter("branch_address"));
		dto.setBranch_closetime(rs.getParameter("close1")+":"+rs.getParameter("close2"));
		dto.setBranch_map("null");
		dto.setBranch_name(rs.getParameter("branch_name"));
		dto.setBranch_opentime(rs.getParameter("open1")+":"+rs.getParameter("open2"));
		dto.setBranch_phone(rs.getParameter("phone1")+"-"+rs.getParameter("phone2")+"-"+rs.getParameter("phone3"));
		dto.setBranch_picture1("null");
		dto.setBranch_picture2("null");
		dto.setBranch_picture3("null");
		dto.setBranch_reserve("false");
		branchDAO.insertBranch(dto);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/mainPage/branchManage/branchManage_main.jsp");
		mav.addObject("list", branchDAO.list());
		return mav;
	}
	
	@RequestMapping(value="/branchUpdate.branchPage")
	public ModelAndView branchUpdate(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		Integer branch_id = Integer.parseInt(arg0.getParameter("branch_id"));
		BranchDTO dto = branchDAO.getBranch(branch_id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/mainPage/branchManage/branchUpdate.jsp");
		mav.addObject("dto", dto);
		return mav;
	}
	
	@RequestMapping(value="/branchUpdatePro.branchPage")
	public ModelAndView branchUpdatePro(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		BranchDTO dto = new BranchDTO();
		dto.setBranch_id(Integer.parseInt(arg0.getParameter("branch_id")));
		dto.setBranch_address(arg0.getParameter("branch_address"));
		dto.setBranch_phone(arg0.getParameter("phone1")+"-"+arg0.getParameter("phone2")+"-"+arg0.getParameter("phone3"));
		dto.setBranch_opentime(arg0.getParameter("open1")+":"+arg0.getParameter("open2"));
		dto.setBranch_closetime(arg0.getParameter("close1")+":"+arg0.getParameter("close2"));
		dto.setBranch_reserve(arg0.getParameter("branch_reserve"));
		branchDAO.updateBranch(dto);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:branchManage.mainPage");
		return mav;
	}
	
	@RequestMapping(value="/branchDelete.branchPage")
	public ModelAndView branchDelete(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		int branch_id = Integer.parseInt(arg0.getParameter("branch_id"));
		branchDAO.deleteBranch(branch_id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:branchManage.mainPage");
		return mav;
	}
}
