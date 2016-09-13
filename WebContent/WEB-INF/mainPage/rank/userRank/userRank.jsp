<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../../../../mainPage_top.jsp"%>

	<table border="1">
		<tr>
			<th>아이디</th>
			<th>이  름</th>
			<th>승  수</th>
		<tr>
			<c:set var="pageSize" value="${requestScope.pageSize}" />
			<c:set var="pageNum" value="${requestScope.pageNum}" />
			<c:set var="currentPage" value="${requestScope.currentPage}" />
			<c:set var="startRow" value="${requestScope.startRow}" />
			<c:set var="endRow" value="${requestScope.endRow}" />
			<c:set var="count" value="${requestScope.count}" />
			<c:if test="${endRow > count}">
				<c:set var="endRow" value="${count}" />
			</c:if>
			<c:set var="list" value="${list }" />
			<c:choose>
				<c:when test="${list =null}">
					<tr>
						<td colspan="6">등록된 글이 없습니다.</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="dto" items="${list}">
						<tr>
							<td>${dto.id}</td>
							<td>${dto.name}</td> 
							<td>${dto.win}</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
	</table>

	<c:if test="${count>0}">
		<c:set var="pageCount" value="${requestScope.pageCount}" />
		<c:set var="pageBlock" value="3" />
		<c:set var="startPage" value="${requestScope.startPage}" />
		<c:set var="endPage" value="${requestScope.endPage}" />
		<c:if test="${endPage>pageCount }">
			<c:set var="endPage" value="${pageCount}" />
		</c:if>

		<c:if test="${startPage>pageBlock }">
				[<a href="userRank.member?pageNum=${startPage-pageBlock}">이전</a>]
			</c:if>
		<c:forEach var="i" begin="${startPage}" end="${endPage}">
					[<a href="userRank.member?pageNum=${i}">${i}</a>]
			</c:forEach>
		<c:if test="${endPage<pageCount}">
				[<a href="userRank.member?pageNum=${startPage+pageBlock}">다음</a>]
			</c:if>
	</c:if>

<%@include file="../../../../mainPage_bottom.jsp"%>