<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/branch_top.jsp"%>
<div>
	<c:forEach var="dto" items="${list}">
	<table border="1" width="500">
		<tr>
			<td rowspan="3" width="100" height="100">
				����
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
				���̵� : ${dto.room_difficulty}
			</td>
			<td>
				�ο� : 2�� ~ ${dto.room_maxuser}��
			</td>
			<td>
				<a href="roomReservationView.branchPage?branch_id=<%=request.getParameter("branch_id") %>&room_id=${dto.room_id}">�����ϱ�</a>
			</td>
		</tr>
	</table>
	</c:forEach>
</div>
<%@include file="/branch_bottom.jsp"%>