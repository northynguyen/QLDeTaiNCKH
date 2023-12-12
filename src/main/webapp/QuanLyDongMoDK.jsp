<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="Models.ThongTinTaiKhoan"%>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<link rel="stylesheet" href="Access/Style/Css/LeftSideBar.css" />
<link rel="stylesheet" href="Access/Style/Css/Root/Root.css" />
<link rel="stylesheet" href="Access/Style/Css/Login.css" />
<link rel="stylesheet" href="Access/Style/Css/formP.css" />
<link rel="stylesheet" href="Access/Style/Css/TaoTaiKhoan.css" />
<link rel="stylesheet" href="Access/Style/Css/ThemThongTin.css" />
<link rel="stylesheet" href="../Access/Style/Css/LeftSideBar.css" />
<link rel="stylesheet" href="../Access/Style/Css/Root/Root.css" />
<link rel="stylesheet" href="../Access/Style/Css/Login.css" />
<link rel="stylesheet" href="../Access/Style/Css/formP.css" />
<link rel="stylesheet" href="../Access/Style/Css/TaoTaiKhoan.css" />
<link rel="stylesheet" href="../Access/Style/Css/ThemThongTin.css" />
<link flex href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="../Access/Style/Js/LeftSideBar.js" defer></script>
</head>
<body>
	<%
	String err = (String) request.getAttribute("err");
	String suc = (String) request.getAttribute("suc");
	%>
	<%
	ThongTinTaiKhoan account = (ThongTinTaiKhoan) session.getAttribute("account");
	%>
	<%if (account == null) {response.sendRedirect(request.getContextPath() + "/Login.jsp");} %>

	<jsp:include page="Components/LeftSideBarAdmin.jsp" />
	<div class="container-main">
		<jsp:include page="Components/NavBar.jsp" />
		<!--  IMPORT CODE PHẦN NÀY -->
		<div class="main_content">
			<div class="form form-DX" style="position: relative;">
				
					<div class="form-title">
						<h1>QUẢN LÝ ĐÓNG MỞ ĐĂNG KÝ</h1>
						<i class="fa fa-refresh" aria-hidden="true"></i>
					</div>
					<hr></hr>	
					<form class="login-form" action="<%=request.getContextPath()%>/DongMoDK/mo" method="post" accept-charset="UTF-8">				
						<button >Mở đăng ký đề tài</button>		
					</form>		
					<form class="login-form" action="<%=request.getContextPath()%>/DongMoDK/dong" method="post" accept-charset="UTF-8">				
						<button id = "editbut">Đóng đăng ký đề tài</button>			
					</form>		
					<%
					if (err != null) {
					%>
					<div class="error-message"><%=err%></div>
					<%
					}
					%>					
					<%
					if (suc != null) {
					%>
					<div class="success-message"><%=suc%></div>
					<%
					}
					%>				
			</div>
		</div>
		<!--  IMPORT CODE PHẦN NÀY -->
	</div>
</body>

<script>
	var settingsmenu = document.querySelector(".settings-menu");
	function settingsMenuToggle() {
		settingsmenu.classList.toggle("settings-menu-height");
	}
	function checkPassword() {
		password = document.getElementById("password").value;
		repassword = document.getElementById("re-password").value;
		if (password != repassword) {
			document.getElementById("msg").innerHTML = "Mật khẩu không khớp!";
			return false;
		} else {
			document.getElementById("msg").innerHTML = "";
			return true;
		}
	}
	function hideErr() {
		var err = document.getElementById("err")
		if (err != null)
			err.style.display="none";		
	}

</script>
</html>