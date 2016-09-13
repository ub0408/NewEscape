package room.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import room.RoomDAO;
import room.RoomDTO;

@Controller
public class RoomController {
	private RoomDAO roomDAO;
	public void setRoomDAO(RoomDAO roomDAO){
		this.roomDAO = roomDAO;
	}
	
	@RequestMapping(value="/roomInsert.branchPage")
	public ModelAndView insertRoom(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/branchPage/roomManage/roomInsertForm.jsp");
		return mav;
	}
	
	@RequestMapping(value="/roomInsertPro.branchPage")
	public ModelAndView insertRoomPro(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		Integer branch_id = Integer.parseInt(arg0.getParameter("branch_id"));
		RoomDTO dto = new RoomDTO();
		//branch_id, room_id, room_name, room_difficulty, room_maxuser, room_price, room_opentime, room_closetime, room_content
		dto.setBranch_id(branch_id);
		dto.setRoom_name(arg0.getParameter("room_name"));
		dto.setRoom_difficulty(Integer.parseInt(arg0.getParameter("room_difficulty")));
		dto.setRoom_maxuser(Integer.parseInt(arg0.getParameter("room_maxuser")));
		dto.setRoom_price(Integer.parseInt(arg0.getParameter("room_price")));
		dto.setRoom_opentime(arg0.getParameter("room_opentime"));
		dto.setRoom_closetime(arg0.getParameter("room_closetime"));
		dto.setRoom_content(arg0.getParameter("room_content"));
		roomDAO.insertRoom(dto);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/roomManage.branchPage?branch_id="+branch_id);
		return mav;
	}
	
	@RequestMapping(value="/roomDelete.branchPage")
	public ModelAndView deleteRoom(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception{
		Integer branch_id = Integer.parseInt(arg0.getParameter("branch_id"));//������������ ���� �޾ƿ�
		Integer room_id = Integer.parseInt(arg0.getParameter("room_id"));//������ ���� �޾ƿ�
		roomDAO.deleteRoom(room_id);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/roomManage.branchPage?branch_id="+branch_id);
		return mav;
	}
	
	@RequestMapping(value="/roomReservationView.branchPage")
	public ModelAndView reservationRoom(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception{
		String branch_id = arg0.getParameter("branch_id");
		String room_id = arg0.getParameter("room_id");
		ModelAndView mav = new ModelAndView();
		List list;
		if(room_id == null){
			list = roomDAO.list(Integer.parseInt(branch_id));
			mav.setViewName("WEB-INF/branchPage/reservation/reservationView.jsp");
		}else{
			list = roomDAO.getRoom(Integer.parseInt(room_id));
			mav.setViewName("WEB-INF/branchPage/reservation/reservationView.jsp");
		}
		mav.addObject("list", list);
		return mav;
	}
	
	
}
