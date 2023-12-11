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
<link rel="stylesheet" href="../Access/Style/Css/LeftSideBar.css" />
<link rel="stylesheet" href="../Access/Style/Css/Root/Root.css" />
<link rel="stylesheet" href="../Access/Style/Css/Login.css" />
<link rel="stylesheet" href="../Access/Style/Css/formP.css" />
<link rel="stylesheet" href="../Access/Style/Css/TaoTaiKhoan.css" />
<link flex href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="../Access/Style/Js/LeftSideBar.js" defer></script>
</head>
<body>
	<%
	String SignUpErr = (String) request.getAttribute("SignUpErr");
	String SignUpSucsses = (String) request.getAttribute("SignUpSucsses");
	String EmailErr = (String) request.getAttribute("EmailErr");
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
				<form class="login-form"
					action="<%=request.getContextPath()%>/TTTK/create" method="post" onsubmit="return checkPassword()"
					accept-charset="UTF-8">
					<div class="form-title">
						<h1>TẠO TÀI KHOẢN</h1>
						<i class="fa fa-refresh" aria-hidden="true"></i>
					</div>
					<hr></hr>
					<table>
						<tr>
							<td>
								<p>
									Họ và tên: <input name="name" class="input-infor" type="text"
										placeholder="Họ và tên" required />
								</p>
							</td>
							<td>
								<p>
									Tên tài khoản: <input name="MaTK" class="input-account"
										type="text" placeholder="Tên tài khoản" required onclick = "hideErr()"/>
								</p> <%
 if (SignUpErr != null) {
 %>
								<div id = "err" class="error-message"><%=SignUpErr%></div> <%
 }
 %>
							</td>
						</tr>
						<tr>
							<td>
								<p>
									Giới tính: <select name="gender" class="input-select">
										<option value="Nam">Nam</option>
										<option value="Nữ">Nữ</option>
									</select>
								</p>
							</td>

							<td>
								<p>
									Mật khẩu: <input id="password" name="password"
										class="input-account" type="password" placeholder="Mật khẩu"
										required onkeyup="checkPassword()" />
								</p>
							</td>

						</tr>
						<tr>
							<td>
								<p>
									Khoa: <select name="khoa" class="input-select">
										<c:forEach var="khoa" items="${ListKhoa}">
											<option value="${khoa.getMaKhoa()}">${khoa.getTenKhoa()}</option>
										</c:forEach>
									</select>
								</p>
							</td>
							<td>
								<p>
									Nhập lại mật khẩu: <input id="re-password"
										class="input-account" type="password"
										placeholder="Nhập lại mật khẩu" required
										onkeyup="checkPassword()" />
								</p> <span id="msg" style="color: red;"></span>
							</td>
						</tr>
						<tr>
							<td>
								<p>
									Số điện thoại: <input name="sdt" class="input-infor"
										type="text" placeholder="Số điện thoại" />
								</p>
							<td />


						</tr>
						<tr>
							<td>
								<p>
									Email: <input name="email" class="input-infor" type="email"
										placeholder="Địa chỉ Email" required onclick = "hideErr()"/>
								</p><%
								if (EmailErr != null) {
 %>
								<div id = "err" class="error-message"><%=EmailErr%></div> <%
 }
 %>
							<td />

						</tr>
						<tr>
							<td>
								<p>
									Địa chỉ: <input name="address" class="input-infor" type="text"
										placeholder="Địa chỉ" />
								</p>
							</td>
							<td>
								<p>
									Role: <select name="role" class="input-select-role">
										<option value="Chủ nhiệm">Chủ nhiệm</option>
										<option value="Quản lý">Phòng quản lý ĐTKH</option>
									</select>
								</p>
							</td>
						</tr>




					</table>
					<%
					if (SignUpSucsses != null) {
					%>
					<div class="success-message"><%=SignUpSucsses%></div>
					<%
					}
					%>
					<button>TẠO TÀI KHOẢN</button>

				</form>
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