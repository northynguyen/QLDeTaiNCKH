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
				<form class="login-form" action="<%=request.getContextPath()%>/DeTai/xoakhoa" method="post" accept-charset="UTF-8">	
					<div class="form-title">
						<h1>QUẢN LÝ KHOA</h1>
						<i class="fa fa-refresh" aria-hidden="true"></i>
					</div>
					<hr></hr>
					<table class = "table-DeTai" id = "myTable">			
						<tr class = "columns-title">
							<th> Mã khoa</th>
							<th> Tên khoa</th>
					
						</tr>	
						<c:forEach var="khoa" items="${listkhoa}">
								<tr onclick="changeBackgroundColor(this)">
									<input id="makhoalist" type="hidden" name="makhoalist">
									<td><p>
											<c:out value="${khoa.getMaKhoa()}" />
										</p></td>
									<td><p>
											<c:out value="${khoa.getTenKhoa()}" />
										</p></td>
								</tr>
							</c:forEach>		
					</table>
					<button type="button" onclick= "ThemKhoa()">Thêm</button>
					<button id = "editbut" type="button" onclick= "SuaKhoa()" disabled>Sửa</button>	
					<button id = "deletebut" type="submit" disabled>Xóa</button>	
					</form>
				<div style ="display: none" id= "themkhoa">
					<form class="login-form" action="<%=request.getContextPath()%>/DeTai/themkhoa" method="post" accept-charset="UTF-8">	
					<table >								
							<p>
								Mã khoa: 
								<input name="makhoa" id="makhoa"  class="input-infor" type="text" required/>							
							</p>					
						</tr>
						<tr>							
							<p>
								Tên khoa:
								<input name="tenkhoa" id="tenkhoa"  class="input-infor" type="text" required/>
							</p>			
						</tr>
					</table>
					<input style="display:none" name="loai" id="loai"  class="input-infor" type="text" required/>
					<button type="submit" id="submitbut" class="submit">THÊM KHOA</button>					
				</div>				
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
	function ThemKhoa(){	
		var khoa = document.getElementById("themkhoa");
		khoa.classList.toggle('show')
		document.getElementById("submitbut").innerHTML = "THÊM KHOA";
		var input = document.getElementById("makhoa");
        input.readOnly = false;
		var editbut = document.getElementById("editbut");
		var deletebut = document.getElementById("deletebut");
		editbut.disabled = true;
		deletebut.disabled = true;
		document.getElementById("makhoa").value = "";
		document.getElementById("tenkhoa").value = "";
		document.getElementById("loai").value = "them";
	}
	function SuaKhoa(){
		var khoa = document.getElementById("themkhoa");
		document.getElementById("submitbut").innerHTML = "SỬA KHOA";
		khoa.classList.toggle('show')		
		var input = document.getElementById("makhoa");
        input.readOnly = true;
        document.getElementById("loai").value = "sua";
	}
	function changeBackgroundColor(row) {
		// Lấy tất cả các hàng trong bảng
		var rows = document.getElementById("myTable").getElementsByTagName("tr");
		var mathoigian = row.cells[0].innerText;
		document.getElementById("makhoalist").value = mathoigian;
		// Đặt màu nền của tất cả các hàng về mặc định (trắng)
		for (var i = 0; i < rows.length; i++) {
			rows[i].style.backgroundColor = "";		
		}
		var editbut = document.getElementById("editbut");
		var deletebut = document.getElementById("deletebut");
		editbut.disabled = false;
		deletebut.disabled = false;
		document.getElementById("makhoalist").value = row.cells[0].innerText;
		document.getElementById("makhoa").value = row.cells[0].innerText;
		document.getElementById("tenkhoa").value = row.cells[1].innerText;
		// Đặt màu nền của hàng được nhấp vào thành màu tím nhạt
		row.style.backgroundColor = "lavender";
	}

</script>
</html>