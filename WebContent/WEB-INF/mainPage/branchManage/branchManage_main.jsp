<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="/mainPage_top.jsp"%>
<div>
<table border="1">
	<tr>
		<td>����ID</td>
		<td>������</td>
		<td>�����ּ�</td>
		<td>���� ����ó</td>
		<td>���డ�� ����</td>
		<td>���½ð�</td>
		<td>�����ð�</td>
		<td>�ٷΰ���</td>
		<td>���� | ����</td>
	</tr>
	<c:forEach var="dto" items="${list}">
		<tr>
			<td>${dto.branch_id}</td>
			<td>${dto.branch_name}</td>
			<td>${dto.branch_address}</td>
			<td>${dto.branch_phone}</td>
			<td>${dto.branch_reserve}</td>
			<td>${dto.branch_opentime}</td>
			<td>${dto.branch_closetime}</td>
			<td><a href="branchMain.branchPage?branch_id=${dto.branch_id}"> ${dto.branch_name} Ȩ������ �ٷΰ���</a></td>
			<td><a href="branchUpdate.branchPage?branch_id=${dto.branch_id}">����</a> 
			|	<a href="branchDelete.branchPage?branch_id=${dto.branch_id }">����</a></td>
		</tr>
	</c:forEach>
</table>
<form name="f" action="branchInsert.mainPage" method="post">
<table>
	<tr>
		<td>������</td>
		<td><input type="text" name="branch_name"></td>
	</tr>
	<tr>
		<td>���� �ּ�</td>
		<td><input type="text" name="branch_address"></td>
	</tr>
	<tr>
		<td>���� ����ó</td>
		<td>
		<input type="text" name="phone1" maxlength="3" size="3"> - 
		<input type="text" name="phone2" maxlength="4" size="3"> - 
		<input type="text" name="phone3" maxlength="4" size="3">
		</td>
	</tr>
	<tr>
		<td>���� �ð�</td>
		<td><input type="text" name="open1" maxlength="2" size="2"> : 
			<input type="text" name="open2" maxlength="2" size="2"></td>
	</tr>
	<tr>
		<td>���� �ð�</td>
		<td><input type="text" name="close1" maxlength="2" size="2"> : 
			<input type="text" name="close2" maxlength="2" size="2"></td>
	</tr>
	<tr>
		<td colspan="2">
		<input type="submit" value="���� ���"> &nbsp;&nbsp;
		<a href="#">�ٽ�</a>
		</td>
	</tr>
</table>
</form>
</div>
<%@include file="/mainPage_bottom.jsp"%>