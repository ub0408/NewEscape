<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="/branch_top.jsp"%>
<div align="center">

<form name="f" action="roomInsertPro.branchPage" method="post">
<!-- branch_id, room_id, room_name, room_difficulty, room_maxuser, room_price, room_opentime, room_closetime, room_content -->
	<table border="1">
		<tr bgcolor="yellow">
				<th colspan="2">�� �� ��</th>
			</tr>
			<tr>
				<th bgcolor="yellow">���̸�</th>
				<td><input type="text" name="room_name"></td>
			</tr>
			<tr>
				<th bgcolor="yellow">���̵�</th>
				<td><input type="text" name="room_difficulty"></td>
			</tr>
			<tr>
				<th bgcolor="yellow">�ִ��ο�</th>
				<td><input type="text" name="room_maxuser"></td>
			</tr>
			<tr>
				<th bgcolor="yellow">1�δ� ����</th>
				<td><input type="text" name="room_price"></td>
			</tr>
			<tr>
				<th bgcolor="yellow">���½ð�</th>
				<td><input type="text" name="room_opentime"></td>
			</tr>
			<tr>
				<th bgcolor="yellow">�����ð�</th>
				<td><input type="text" name="room_closetime"></td>
			</tr>
			<tr>
				<th bgcolor="yellow">�漳��</th>
				<td><input type="text" name="room_content"></td>
			</tr>
			<tr>
				<td colspan="3" bgcolor="yellow" align="center">
					<input type="hidden" name="branch_id" value="<%=request.getParameter("branch_id") %>">

					<input type="submit" value="����">
					<input type="reset" value="�ٽþ���">
					<input type="button" value="��Ϻ���" onClick="window.location='roomManage.branchPage?branch_id=<%=request.getParameter("branch_id") %>'">
				</td>
			</tr>
	</table>
</form>
</div>
<%@include file="/branch_bottom.jsp"%>