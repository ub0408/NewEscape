<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="/mainPage_top.jsp" %>
<form name="f" action="branchUpdatePro.branchPage" method="post">
<table>
	<tr>
		<td>지점명</td>
		<td><input type="text" name="branch_name" value="${dto.branch_name }" readonly></td>
	</tr>
	<tr>
		<td>지점 주소</td>
		<td><input type="text" name="branch_address" value="${dto.branch_address }"></td>
	</tr>
	<tr>
		<td>지점 연락처</td>
		<td>
		<c:set var="phonenumber" value="${dto.branch_phone }"/>
		<c:set var="phone" value="${fn:split(phonenumber, '-') }"/>
		
		<input type="text" name="phone1" maxlength="3" size="3" value="${phone[0] }"> - 
		<input type="text" name="phone2" maxlength="4" size="3" value="${phone[1] }"> - 
		<input type="text" name="phone3" maxlength="4" size="3" value="${phone[2] }">
		</td>
	</tr>
	<tr>
		<c:set var="opentime" value="${dto.branch_opentime }"/>
		<c:set var="open" value="${fn:split(opentime, ':') }"/>
		<td>오픈 시간</td>
		<td><input type="text" name="open1" maxlength="2" size="2" value="${open[0] }"> : 
			<input type="text" name="open2" maxlength="2" size="2" value="${open[1] }"></td>
	</tr>
	<tr>
		<c:set var="closetime" value="${dto.branch_closetime }"/>
		<c:set var="close" value="${fn:split(closetime, ':') }"/>
		<td>마감 시간</td>
		<td><input type="text" name="close1" maxlength="2" size="2" value="${close[0] }"> : 
			<input type="text" name="close2" maxlength="2" size="2" value="${close[1] }"></td>
	</tr>
	<tr>
		<td>
			<c:if test="${dto.branch_reserve==true }">
			<input type="radio" name="branch_reserve" value="true" checked>예약가능
			<input type="radio" name="branch_reserve" value="false">예약 불가능
			</c:if>
			<input type="radio" name="branch_reserve" value="true">예약가능
			<input type="radio" name="branch_reserve" value="false" checked>예약 불가능
		</td>
	</tr>
	<tr>
	<input type="hidden" name="branch_id" value="${dto.branch_id }">
		<td colspan="2">
		<input type="submit" value="지점 수정"> &nbsp;&nbsp;
		<a href="#">다시</a>
		</td>
	</tr>
</table>
</form>
<%@ include file="/mainPage_bottom.jsp" %>