<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/branch_top.jsp"%>
<div>
<table border="1">
	<tr>
		<td>��ID</td>
		<td>���̸�</td>
		<td>���̵�</td>
		<td>����ο�</td>
		<td>����</td>
		<td>���½ð�</td>
		<td>�����ð�</td>
		<td>�漳��</td>
		<td>���� | ����</td>
	</tr>
	<c:forEach var="dto" items="${list}">
		<tr>
			<td>${dto.room_id}</td>
			<td>${dto.room_name}</td>
			<td>${dto.room_difficulty}</td>
			<td>${dto.room_maxuser}</td>
			<td>${dto.room_price}</td>
			<td>${dto.room_opentime}</td>
			<td>${dto.room_closetime}</td>
			<td>${dto.room_content}</td>
			<td>
				���� | 
				<a href="roomDelete.branchPage?branch_id=<%=request.getParameter("branch_id") %>&room_id=${dto.room_id}">����</a>
			</td>
		</tr>
	</c:forEach>
	<tr>
		<td colspan="9">
			<a href="roomInsert.branchPage?branch_id=<%=request.getParameter("branch_id") %>">���߰�</a>
		</td>
	</tr>
</table>
</div>
<%@include file="/branch_bottom.jsp"%>