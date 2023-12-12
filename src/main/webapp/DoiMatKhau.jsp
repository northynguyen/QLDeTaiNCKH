<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.time.LocalDate"%>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<link rel="stylesheet" href="Access/Style/Css/LeftSideBar.css" />
<link rel="stylesheet" href="Access/Style/Css/Root/Root.css" />
<link rel="stylesheet" href="Access/Style/Css/Login.css" />
<link rel="stylesheet" href="Access/Style/Css/formP.css" />
<link rel="stylesheet" href="Access/Style/Css/formThoai.css" />
<link rel="stylesheet" href="../Access/Style/Css/LeftSideBar.css" />
<link rel="stylesheet" href="../Access/Style/Css/Root/Root.css" />
<link rel="stylesheet" href="../Access/Style/Css/Login.css" />
<link rel="stylesheet" href="../Access/Style/Css/formP.css" />
<link rel="stylesheet" href="../Access/Style/Css/formThoai.css" />
<!-- Boxicons CSS -->
<link flex href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="../Access/Style/Js/LeftSideBar.js" defer></script>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>
<body>
	<jsp:include page="Components/LeftSideBar.jsp" />
	<div class="container-main">
		<jsp:include page="Components/NavBar.jsp" />
		<!--  IMPORT CODE PHẦN NÀY -->
		<div class="main_content">
			<div class="form form-DoiMK">
				<form class="login-form" accept-charset="UTF-8"
					action="<%=request.getContextPath()%>/doimatkhau/change"
					method="POST" onsubmit="return checkPassword()">
					<div class="form-title">
						<h1>ĐỔI MẬT KHẨU</h1>
						<i class="fa fa-refresh" aria-hidden="true"></i>
					</div>
					<hr>
					<br>
					<table>
						<tr>
							<td><p>Nhập mật khẩu</p> <input name="mk" type="text"
								placeholder="Nhập mật khẩu" required /></td>

						</tr>
						<tr>
							<td><p>Nhập mật khẩu mới</p> <input name="mkm" id="password"
								type="text" placeholder="Nhập mật khẩu mới" required /></td>
						</tr>
						<tr>
							<td><p>Nhập lại mật khẩu</p> <input name="nlmk"
								id="re-password" type="text" placeholder="Nhập lại mật khẩu"
								required onkeyup="checkPassword()" /> <span id="msg"
								style="color: red;"></span></td>
						</tr>
					</table>
					<span name="msgFromCTL" class="ThongBao"
						style="color: <%if (request.getAttribute("mesErrol") != null) {%> red <%} else if (request.getAttribute("mesSS") != null) {%> green <%}%>">
						<%
						if (request.getAttribute("mesErrol") != null) {
						%> <%=request.getAttribute("mesErrol")%> <%
						 } else if (request.getAttribute("mesSS") != null) {
						 %> <%=request.getAttribute("mesSS")%> <%
						 }
						 %>
					</span>
					<button>Đổi mật khẩu</button>
				</form>

			</div>
		</div>
		<!--  IMPORT CODE PHẦN NÀY -->
	</div>
</body>
<script>
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
		var err = document.getElementById("err");
		if (err != null)
			err.style.display = "none";
	}
</script>



</html>