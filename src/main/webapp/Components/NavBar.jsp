<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="Models.ThongTinTaiKhoan"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<link rel="stylesheet" href="../Access/Style/Css/LeftSideBar.css" />
<link rel="stylesheet" href="../Access/Style/Css/Root/Root.css" />
<!-- Boxicons CSS -->
<link flex href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css"
	rel="stylesheet" />
<script src="../Access/Style/Js/LeftSideBar.js" defer></script>
</head>
<body>
	<%
	ThongTinTaiKhoan account = (ThongTinTaiKhoan) session.getAttribute("account");
	%>
	<!-- Navbar -->
	<nav class="navbar flex">
		<i class="bx bx-menu" id="sidebar-open"></i>
		<h3>ĐẠI HỌC SƯ PHẠM KỸ THUẬT TP.HCM</h3>
		<span class="nav_image" onclick="settingsMenuToggle()"> <img
			src="https://cdn.pixabay.com/photo/2017/07/18/23/23/user-2517433_640.png?fbclid=IwAR1r1c6ynegByu0GEhclZBf-LuAwQumotH1wwJxlO5xLYHciVhXABPRZ6Ns"
			alt="logo_img" />
		</span>

		<!--   setting hide -->
		<div class="settings-menu">
			<div id="dark-btn">
				<span></span>
			</div>
			<div class="settings-menu-inner">
				<div class="user-profile">
					<img src="https://cdn.pixabay.com/photo/2017/07/18/23/23/user-2517433_640.png?fbclid=IwAR1r1c6ynegByu0GEhclZBf-LuAwQumotH1wwJxlO5xLYHciVhXABPRZ6Ns" />
					<div style="padding-left: 10px;">
						<p><%=account.getHoTen()%></p>
						<a href="./InforLogin">Thông tin cá nhân</a>
					</div>
				</div>
				<hr />
				<div class="settings-links">
					<img
						src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABgAAAAYCAYAAADgdz34AAAAAXNSR0IArs4c6QAAAPtJREFUSEvt1TFKA0EYxfFfvEKwEEEIFqb1Cjams5HcQbASG7FRTKFYWMU7WNkFEvAKFjZ2oiBW4g2CGphAXHbzZVeCFplqmG/m/Wceb2Zq5txqc9Y3K2AXe9hKG7pDF7fRBmcBXOKwQOgEp9MgEaCNmyRwhuvU38dx6m9jUASJAPfYxAGuMiIjQAd9tKoChlj69nsZ7xmRFbzhA/WqgM+0sOikUT1MUSQQ1f8GsINzNKOMZ+qPKc69yfE8b1+xWlJ8PP0J6xEg9LUAnrsu7wQLwA9XFhZNBur/pOgFaxUv2jMa0UUbPRUX2CgJecARwqeipO706dGP9mvYFyImMRnCUhKsAAAAAElFTkSuQmCC"
						class="settings-icon" /> <a
						href="<%=request.getContextPath()%>/doimatkhau/show">Đổi mật
						khẩu </a>
				</div>
				<div class="settings-links">
					<img src="https://i.postimg.cc/PJC9GrMb/logout.png"
						class="settings-icon" /> <a
						href="<%=request.getContextPath()%>/Logout">Logout
					</a>
				</div>
			</div>
		</div>
	</nav>
</body>
</html>