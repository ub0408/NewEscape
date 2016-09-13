<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="/mainPage_top.jsp"%>
<div>
<table border="1">
	<tr>
		<td>지점ID</td>
		<td>지점명</td>
		<td>지점주소</td>
		<td>지점 연락처</td>
		<td>예약가능 여부</td>
		<td>오픈시간</td>
		<td>마감시간</td>
		<td>바로가기</td>
		<td>수정 | 삭제</td>
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
			<td><a href="branchMain.branchPage?branch_id=${dto.branch_id}"> ${dto.branch_name} 홈페이지 바로가기</a></td>
			<td><a href="branchUpdate.branchPage?branch_id=${dto.branch_id}">수정</a> 
			|	<a href="branchDelete.branchPage?branch_id=${dto.branch_id }">삭제</a></td>
		</tr>
	</c:forEach>
</table>
<form name="f" action="branchInsert.mainPage" method="post">
<table>
	<tr>
		<td>지점명</td>
		<td><input type="text" name="branch_name"></td>
	</tr>
	<tr>
		<td>지점 주소</td>
		<td><input type="text" name="branch_address"></td>
	</tr>
	<tr>
		<td>지점 연락처</td>
		<td>
		<input type="text" name="phone1" maxlength="3" size="3"> - 
		<input type="text" name="phone2" maxlength="4" size="3"> - 
		<input type="text" name="phone3" maxlength="4" size="3">
		</td>
	</tr>
	<tr>
		<td>오픈 시간</td>
		<td><input type="text" name="open1" maxlength="2" size="2"> : 
			<input type="text" name="open2" maxlength="2" size="2"></td>
	</tr>
	<tr>
		<td>마감 시간</td>
		<td><input type="text" name="close1" maxlength="2" size="2"> : 
			<input type="text" name="close2" maxlength="2" size="2"></td>
	</tr>
	<tr>
		<td colspan="2">
		<input type="submit" value="지점 등록"> &nbsp;&nbsp;
		<a href="#">다시</a>
		</td>
	</tr>
</table>
</form>
</div>
<%@include file="/mainPage_bottom.jsp"%>