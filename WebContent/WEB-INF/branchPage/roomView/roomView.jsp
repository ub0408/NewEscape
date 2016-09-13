<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/branch_top.jsp"%>
<div>
	<c:forEach var="dto" items="${list}">
	<table border="1" width="500">
		<tr>
			<td rowspan="3" width="100" height="100">
				사진
			</td>
			<td colspan="3">
				${dto.room_name}
			</td>
		</tr>
		<tr>
			<td colspan="3">
				${dto.room_content}
			</td>
		</tr>
		<tr>
			<td>
				난이도 : ${dto.room_difficulty}
			</td>
			<td>
				인원 : 2명 ~ ${dto.room_maxuser}명
			</td>
			<td>
				<a href="roomReservationView.branchPage?branch_id=<%=request.getParameter("branch_id") %>&room_id=${dto.room_id}">예약하기</a>
			</td>
		</tr>
	</table>
	</c:forEach>
</div>
<%@include file="/branch_bottom.jsp"%>