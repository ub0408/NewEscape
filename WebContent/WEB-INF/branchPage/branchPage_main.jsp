<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@include file="/branch_top.jsp"%>
<div>
	${dto.branch_name }�� ���Ű��� ȯ���մϴ�.<br>
	
	Ȩ������ �غ����Դϴ�.
	
	<br>
	�ּ� : ${dto.branch_address}<br>
	����ó : ${dto.branch_phone}<br>
	�����ð� : ${dto.branch_opentime} ~ ${dto.branch_closetime}<br>
</div>
<%@include file="/branch_bottom.jsp"%>