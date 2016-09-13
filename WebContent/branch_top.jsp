<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> ESCAPE MASTER HOME PAGE </title>
	<script src="http://s.codepen.io/assets/libs/modernizr.js" type="text/javascript"></script>

    <link rel="stylesheet" href="resources/main/normalize.css">

        <link rel="stylesheet" href="resources/main/style.css">
        
</head>
<body>
	<div class="sidebar-overlay"></div>

<!-- Material sidebar -->
<aside id="sidebar" class="sidebar sidebar-stacked sidebar-default open" role="navigation">
    <!-- Sidebar header -->
    <div class="sidebar-header header-cover" style="background-image: url(http://placehold.it/100?text=logo);">
        <!-- Top bar -->
        <!-- <div class="top-bar"></div> -->
        <!-- Sidebar toggle button -->
        <!-- <button type="button" class="sidebar-toggle">
            <i class="icon-material-sidebar-arrow"></i>
        </button> -->
        <!-- Sidebar brand image -->
        <!-- <div class="sidebar-image">
            <img src="http://placehold.it/100?text=logo">
        </div> -->
        
    </div>
    <div class="sidebar-header2 header-cover">
    	<a data-toggle="dropdown" class="sidebar-brand" href="#settings-dropdown">
            	로그인 해주세요.
            <b class="caret"></b>
        </a>
    </div> 

    <!-- Sidebar navigation -->
    <ul class="nav sidebar-nav">
        <li class="dropdown">
            <ul id="settings-dropdown" class="dropdown-menu">
                <li>
                    <a href="#" tabindex="-1">
                        	로그인
                    </a>
                </li>
                <li>
                    <a href="#" tabindex="-1">
                        	회원가입
                    </a>
                </li>
                <li>
                    <a href="#" tabindex="-1">
                        	아이디 찾기
                    </a>
                </li>
                <li>
                    <a href="#" tabindex="-1">
                        	비밀번호 찾기
                    </a>
                </li>
            </ul>
        </li>
        <li>
        	<a href="#" tabindex="-1">
        		가맹소개
        	</a>
        </li>
        <li> 
        	<a href="roomView.branchPage?branch_id=<%=request.getParameter("branch_id") %>" tabindex="-1">
        		테마
            </a>
        </li>
        <li>
        	<a href="roomReservationView.branchPage?branch_id=<%=request.getParameter("branch_id") %>" tabindex="-1">
        		실시간예약
        	</a>
        </li>
        <li>
            <a href="#" tabindex="-1">
        		QnA
        	</a>
        </li>
    </ul>
    <div class="sidebar-header2 header-cover">
    	<a data-toggle="dropdown" class="sidebar-brand" href="#settings-dropdown2">
            	관리자 모드
            <b class="caret"></b>
        </a>
    </div>

    <!-- Sidebar navigation -->
    <ul class="nav sidebar-nav">
        <li class="dropdown">
            <ul id="settings-dropdown2" class="dropdown-menu">
                <li>
                	<a href="roomManage.branchPage?branch_id=<%=request.getParameter("branch_id") %>" tabindex="-1">
                        	방관리
                    </a>
                </li>
            </ul>
        </li>
    </ul>
    
</aside>

<div class="wrapper">
    <div class="constructor">