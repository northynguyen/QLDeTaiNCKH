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
<link rel="stylesheet" href="Access/Style/Css/QuanLyThoiGian.css" />
<link rel="stylesheet" href="../Access/Style/Css/LeftSideBar.css" />
<link rel="stylesheet" href="../Access/Style/Css/Root/Root.css" />
<link rel="stylesheet" href="../Access/Style/Css/Login.css" />
<link rel="stylesheet" href="../Access/Style/Css/formP.css" />
<link rel="stylesheet" href="../Access/Style/Css/TaoTaiKhoan.css" />
<link rel="stylesheet" href="../Access/Style/Css/QuanLyThoiGian.css" />

<link flex href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css" rel="stylesheet" />
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
				<form class="login-form" action="<%=request.getContextPath()%>/DeTai/xoathoigian" method="post" accept-charset="UTF-8">
					<div class="form-title">
						<h1>QUẢN LÝ THỜI GIAN</h1>
						<i class="fa fa-refresh" aria-hidden="true"></i>
					</div>
					<hr></hr>
					<table class = "table-DeTai" id = "myTable">			
						<tr class = "columns-title">
							<th style="width: 25%;">Mã thời gian</th>
							<th style="width: 25%;">Ngày mở ĐK</th>
							<th style="width: 25%;">Ngày đóng ĐK</th>
							<th style="width: 25%;">Ngày nộp đề tài</th>						
						</tr>	
						<c:forEach var="thoigian" items="${listthoigian}">
								<tr onclick="changeBackgroundColor(this)">
									<input id="mathoigianNC" type="hidden" name="mathoigianNC">
									<td><p>
											<c:out value="${thoigian.getMaThoiGianNCKH()}" />
										</p></td>
									<td><p>
											<c:out value="${thoigian.getNgayMoDK()}" />
										</p></td>
									<td><p>
											<c:out value="${thoigian.getNgayKetThucDK()}" />
										</p></td>
									<td><p>
											<c:out value="${thoigian.getNgayNopDeTai()}" />
										</p></td>
								</tr>
							</c:forEach>		
					</table>
					<button type="button" onclick= "ThemThoiGian()">Thêm</button>
					<button id = "editbut" type="button" onclick= "SuaThoiGian()" disabled>Sửa</button>	
					<button id = "deletebut" type="submit" disabled>Xóa</button>	
					</form>
				<div style ="display: none" id= "themthoigian">
					<form class="login-form" action="<%=request.getContextPath()%>/DeTai/themthoigian" method="post" accept-charset="UTF-8">	
					<table >	
						<input style ="display: none" name="mathoigian" id="mathoigian" class="input-infor" type="text" readonly/>	
						<tr>
							<p>
								Ngày mở đăng ký: 
								<input name="ngaymo"  id="ngaymo" class="input-infor" type="date" required/>
							</p>
						</tr>
						<tr>							
							<p>
								Ngày kết thúc đăng ký: 
								<input name="ngayketthuc" id="ngayketthuc"  class="input-infor" type="date" required/>							
							</p>					
						</tr>
						<tr>							
							<p>
								Ngày nộp đề tài: 
								<input name="ngaynop" id="ngaynop"  class="input-infor" type="date" required/>
							</p>			
						</tr>
					</table>
					<button type="submit" id="submitbut" class="submit">THÊM THỜI GIAN</button>					
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
	function ThemThoiGian(){
		var thoigian = document.getElementById("themthoigian");
		document.getElementById("submitbut").innerHTML = "THÊM THỜI GIAN";
		thoigian.classList.toggle('show')
		var input = document.getElementById("mathoigian");
        input.readOnly = false;
		var editbut = document.getElementById("editbut");
		var deletebut = document.getElementById("deletebut");
		editbut.disabled = true;
		deletebut.disabled = true;
		document.getElementById("ngaymo").value = "";
		document.getElementById("ngayketthuc").value = "";
		document.getElementById("ngaynop").value = "";
		document.getElementById("mathoigian").value = "";
	}
	function SuaThoiGian(){
		var thoigian = document.getElementById("themthoigian");
		document.getElementById("submitbut").innerHTML = "SỬA THỜI GIAN";
		thoigian.classList.toggle('show')
		var khoa = document.getElementById("themkhoa");
		khoa.classList.remove('show')
		var input = document.getElementById("mathoigian");
        input.readOnly = true;
	}
	function changeBackgroundColor(row) {
		// Lấy tất cả các hàng trong bảng
		var rows = document.getElementById("myTable").getElementsByTagName("tr");
		var mathoigian = row.cells[0].innerText;
		document.getElementById("mathoigianNC").value = mathoigian;
		// Đặt màu nền của tất cả các hàng về mặc định (trắng)
		for (var i = 0; i < rows.length; i++) {
			rows[i].style.backgroundColor = "";
			
		var editbut = document.getElementById("editbut");
		var deletebut = document.getElementById("deletebut");
		editbut.disabled = false;
		deletebut.disabled = false;
		}
		document.getElementById("mathoigian").value = row.cells[0].innerText;
		document.getElementById("mathoigianNC").value = row.cells[0].innerText;
		document.getElementById("ngaymo").value = row.cells[1].innerText;
		document.getElementById("ngayketthuc").value = row.cells[2].innerText;
		document.getElementById("ngaynop").value = row.cells[3].innerText;

		// Đặt màu nền của hàng được nhấp vào thành màu tím nhạt
		row.style.backgroundColor = "lavender";
	}
</script>
</html>