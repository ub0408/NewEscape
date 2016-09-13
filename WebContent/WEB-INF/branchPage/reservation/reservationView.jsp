<%@page import="org.springframework.web.context.request.RequestScope"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/branch_top.jsp"%>
<div>
날짜선택 : <br>
테마선택 : <br>
	<c:forEach var="dto" items="${list}">
	<table border="1" width="500">
		<tr>
			<td>
				${dto.room_name}
			</td>
			<td align="right">
				난이도 : ${dto.room_difficulty}<br>
				인원 : ${dto.room_maxuser}
			</td>
		</tr>
		<tr>
			<td width="100" height="100">
				사진
			</td>
			<td>
			<table border="1">
				<tr>
					<td>
						${dto.room_opentime}
					</td>
					<td>
						${dto.room_closetime}
					</td>
				</tr>
			</table>
			</td>
		</tr>
	</table>
	</c:forEach>
</div>
<%@include file="/branch_bottom.jsp"%>