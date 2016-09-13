package member.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import member.MemberDAO;
import member.MemberDTO;

@Controller
public class MemberController {
	private MemberDAO memberDAO;
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	@RequestMapping(value="/memberIdChk.member")
	public ModelAndView memberIdChk(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/member/memberIdChkForm.jsp");
		return mav;
	}

	@RequestMapping(value="/memberIdChkPro.member")
	public ModelAndView memberIdChkPro(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		ModelAndView mav = new ModelAndView();
		MemberDTO dto = memberDAO.getMember(arg0.getParameter("id"));
		if(dto==null){
			mav.setViewName("memberIdChk.member");
		}else{
			mav.setViewName("WEB-INF/member/memberJoinForm.jsp");
		}
		return mav;
	}

	@RequestMapping(value="/memberJoinPro.member")
	public ModelAndView memberJoin(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/member/memberJoinForm.jsp");
		return mav;
	}

	@RequestMapping(value="/login.member")
	public ModelAndView login(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/member/login.jsp");
		return mav;
	}

	@RequestMapping(value="/loginPro.member")
	public ModelAndView loginPro(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		MemberDTO dto = memberDAO.getMember(arg0.getParameter("id")/*, arg0.getParameter("passwd")*/);
		ModelAndView mav = new ModelAndView();
		if(dto==null){
			mav.setViewName("WEB-INF/member/login.jsp");
		}else{
			mav.setViewName("escapeMasterHomePage.jsp");
		}
		return mav;
	}

	@RequestMapping(value="/memberManage.mainPage")
	public ModelAndView memberList(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		List list = memberDAO.list();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/mainPage/memberManage/memberManage_main.jsp");
		mav.addObject("list", list);
		return mav;
	}

	@RequestMapping(value="/memberSearchId.mainPage")
	public ModelAndView memberSearchId(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		String id = arg0.getParameter("id");
		List<MemberDTO> list = new ArrayList();
		MemberDTO dto = memberDAO.searchMemberId(id);
		list.add(dto);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/mainPage/memberManage/memberManage_main.jsp");
		mav.addObject("list", list);
		return mav;
	}
	
	@RequestMapping(value="/memberSearchName.mainPage")
	public ModelAndView memberSearchName(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		String name = arg0.getParameter("name");
		List<MemberDTO> list = new ArrayList();
		MemberDTO dto = memberDAO.searchMemberName(name);
		list.add(dto);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/mainPage/memberManage/memberManage_main.jsp");
		mav.addObject("list", list);
		return mav;
	}
	
	
	@RequestMapping(value="/memberGradeUp.managePage")
	public ModelAndView memberGradeUp(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		String id = arg0.getParameter("id");
		MemberDTO dto = memberDAO.searchMemberId(id);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/mainPage/memberManage/memberManage_main.jsp");
		mav.addObject("list", list);
		return mav;
	}
}
