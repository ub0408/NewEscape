<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/mainPage_top.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table>
	<tr>
		<td width="100" width="100">id</td>
		<td width="100" width="100">name</td>
		<td width="100" width="100">birth</td>
		<td width="100" width="100">passwd</td>
		<td width="100" width="100">phon</td>
		<td width="100" width="100">email</td>
		<td width="100" width="100">nickname</td>
		<td width="100" width="100">fva</td>
		<td width="100" width="100">member_grade</td>
		<td width="100" width="100">branch_id</td>
		<td width="100" width="100">win</td>
		<td width="100" width="100">lose</td>
	</tr>
	<c:forEach var="dto" items="${list }">
		<tr>
			<td width="100">${dto.id }</td>
			<td width="100">${dto.name }</td>
			<td width="100">${dto.birth }</td>
			<td width="100">${dto.passwd }</td>
			<td width="100">${dto.phon }</td>
			<td width="100">${dto.email }</td>
			<td width="100">${dto.nickname }</td>
			<td width="100">${dto.fva }</td>
			<td width="100">
			<c:choose>
				<c:when test="${dto.member_grade=='normal' }">
				<select name="grade">
					<option value="normal" selected="selected">�Ϲ�ȸ��</option>
					<option value="branch">������</option>
					<option value="manager">�Ѱ�����</option>
				</select>
				</c:when>
				<c:when test="${dto.member_grade=='branch' }">
				<select name="grade">
					<option value="normal">�Ϲ�ȸ��</option>
					<option value="branch" selected="selected">������</option>
					<option value="manager">�Ѱ�����</option>
				</select>
				</c:when>
				<c:otherwise>
					<select name="grade">
					<option value="normal">�Ϲ�ȸ��</option>
					<option value="branch">������</option>
					<option value="manager" selected="selected">�Ѱ�����</option>
				</select>
				</c:otherwise>
			</c:choose>
			</td>
			<td width="100">${dto.branch_id }</td>
			<td width="100">${dto.win }</td>
			<td width="100">${dto.lose }</td>
			<td><a href="memberGradeUp.managePage"><input type="button" value="���Ѻο�"></a></td>
		</tr>
	</c:forEach>
</table>
<table>
	<tr>
		<td>
			<form name="f" action="memberSearchId.mainPage" method="post">
			<input type="Search" name="id" value="���̵� �˻�" onfocus="if(this.value=='���̵� �˻�'){this.value=''}" onblur="if(this.value=='') {this.value='���̵� �˻�'}">
			</form>
		</td>
		<td>
			<form name="f" action="memberSearchName.mainPage" method="post">
			<input type="Search" name="name" value="�̸� �˻�" onfocus="if(this.value=='�̸� �˻�'){this.value=''}" onblur="if(this.value=='') {this.value='�̸� �˻�'}">
			</form>
		</td>
	</tr>
</table>

<%@ include file="/mainPage_bottom.jsp"%>