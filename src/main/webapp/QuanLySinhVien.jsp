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
<link rel="stylesheet" href="Access/Style/Css/QuanLySinhVien.css" />
<link rel="stylesheet" href="../Access/Style/Css/LeftSideBar.css" />
<link rel="stylesheet" href="../Access/Style/Css/Root/Root.css" />
<link rel="stylesheet" href="../Access/Style/Css/Login.css" />
<link rel="stylesheet" href="../Access/Style/Css/formP.css" />
<link rel="stylesheet" href="../Access/Style/Css/QuanLySinhVien.css" />
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
	String errExcel = (String) request.getAttribute("errExcel");
	String sucExcel = (String) request.getAttribute("sucExcel");
	%>
	<%
	ThongTinTaiKhoan account = (ThongTinTaiKhoan) session.getAttribute("account");
	%>
	<%
	if (account == null) {
		response.sendRedirect(request.getContextPath() + "/Login.jsp");
	}
	%>

	<jsp:include page="Components/LeftSideBarAdmin.jsp" />
	<div class="container-main">
		<jsp:include page="Components/NavBar.jsp" />
		<!--  IMPORT CODE PHẦN NÀY -->
		<div class="main_content">
			<div class="form form-DX" style="position: relative;">
				<form class="login-form"
					action="<%=request.getContextPath()%>/TTSV/delete" method="post"
					accept-charset="UTF-8">
					<div class="form-title">
						<h1>QUẢN LÝ SINH VIÊN</h1>
						<i class="fa fa-refresh" aria-hidden="true"></i>
					</div>
					<hr></hr>
					<table class="table-DeTai" id="myTable">
						<tr class="columns-title">
							<th>MSSV</th>
							<th>Họ tên</th>
							<th>Giới tính</th>
							<th>Mã khoa</th>
							<th>SĐT</th>
							<th>Email</th>
							<th>Địa chỉ</th>
						</tr>
						<input id="mssvlist" type="hidden" name="mssvlist">
						<c:forEach var="sinhvien" items="${listSinhVien}">
							<tr onclick="changeBackgroundColor(this)">

								<td><p>
										<c:out value="${sinhvien.getMSSV()}" />
									</p></td>
								<td><p>
										<c:out value="${sinhvien.getHoTen()}" />
									</p></td>
								<td><p>
										<c:out value="${sinhvien.getGioiTinh()}" />
									</p></td>
								<td><p>
										<c:out value="${sinhvien.getMaKhoa()}" />
									</p></td>
								<td><p>
										<c:out value="${sinhvien.getSDT()}" />
									</p></td>
								<td><p>
										<c:out value="${sinhvien.getEmail()}" />
									</p></td>
								<td><p>
										<c:out value="${sinhvien.getDiaChi()}" />
									</p></td>
							</tr>
						</c:forEach>
					</table>
					<button type="button" onclick="ThemSinhVien()">Thêm</button>
					<button id="editbut" type="button" onclick="SuaSinhVien()" disabled>Sửa</button>
					<button id="deletebut" type="submit" disabled>Xóa</button>
					<%
					if (errExcel != null) {
					%>
					<div class="error-message"><%=errExcel%></div>
					<%
					}
					%>
					<%
					if (sucExcel != null) {
					%>
					<div class="success-message"><%=sucExcel%></div>
					<%
					}
					%>
				</form>
				<hr></hr>
				<div style="display: none" id="themsinhvien">
					<form class="login-form"
						action="<%=request.getContextPath()%>/TTSV/createThuCong"
						method="post" onsubmit="return checkPassword()"
						accept-charset="UTF-8">
						<table>
							<tr>
								<td>
									<p>
										Họ và tên: <input name="name" id="name" class="input-infor"
											type="text" placeholder="Họ và tên" required />
									</p>
								</td>
								<td>
									<p class>
										MSSV: <input name="MSSV" id="MSSV" class="input-account"
											type="text" placeholder="Tên tài khoản" required />
									</p> <%
 if (SignUpErr != null) {
 %>
									<div class="error-message"><%=SignUpErr%></div> <%
 }
 %>
								</td>
							</tr>
							<tr>
								<td>
									<p>
										Giới tính: <select name="gender" id="gender"
											class="input-select">
											<option value="Nam">Nam</option>
											<option value="Nữ">Nữ</option>
										</select>
									</p>
								</td>

								<td>
									<p>
										Email: <input name="email" id="email" class="input-account"
											type="email" placeholder="Địa chỉ Email" required />
									</p> <%
 if (EmailErr != null) {
 %>
									<div class="error-message"><%=EmailErr%></div> <%
 }
 %>
								
								<td />

							</tr>
							<tr>
								<td>
									<p>
										Khoa: <select name="khoa" id="khoa" class="input-select">
											<c:forEach var="khoa" items="${ListKhoa}">
												<option value="${khoa.getMaKhoa()}">${khoa.getTenKhoa()}</option>
											</c:forEach>
										</select>
									</p>
								</td>
								<td>
									<p>
										Địa chỉ: <input name="address" id="address"
											class="input-account" type="text" placeholder="Địa chỉ" />
									</p>
								</td>
							</tr>
							<tr>
								<td>
									<p>
										Số điện thoại: <input name="sdt" id="sdt" class="input-infor"
											type="text" placeholder="Số điện thoại" />
									</p>
								<td />

							</tr>

						</table>
						<%
						if (SignUpSucsses != null) {
						%>
						<div class="success-message"><%=SignUpSucsses%></div>
						<%
						}
						%>
						<input style="display: none" name="loai" id="loai"
							class="input-infor" type="text" value="${loai}" required />

						<button class="buttonThem" type="submit" id="submitbut">THÊM
							SINH VIÊN</button>
					</form>
					<button type="button" id="excelsubmitbut" onclick="ClickExcel()">THÊM
						BẰNG EXCEL</button>
				</div>

				<div style="display: none" id="themExcel">
					<form action="<%=request.getContextPath()%>/TTSV/createExcel"
						method="post" enctype="multipart/form-data">
						<div class="form-group">
							<p for="excelFile">Chọn tệp Excel:</p>
							<input style="margin-left: 5% !important; width: 50%" type="file"
								id="excelFile" name="excelFile" accept=".xlsx, .xls">
						</div>
						<div class="form-group">
							<button type="submit">THÊM</button>
						</div>
					</form>
				</div>
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
	function ThemSinhVien() {
		var thoigian = document.getElementById("themsinhvien");
		document.getElementById("submitbut").innerHTML = "THÊM SINH VIÊN";
		thoigian.classList.toggle('show')
		var input = document.getElementById("MSSV");
		input.readOnly = false;
		var editbut = document.getElementById("editbut");
		var deletebut = document.getElementById("deletebut");
		editbut.disabled = true;
		deletebut.disabled = true;
		document.getElementById("name").value = "";
		document.getElementById("gender").value = "";
		document.getElementById("email").value = "";
		document.getElementById("khoa").value = "";
		document.getElementById("address").value = "";
		document.getElementById("sdt").value = "";
		document.getElementById("MSSV").value = "";
		document.getElementById("excelsubmitbut").style.display = "inline-block";
		document.getElementById("loai").value = "them";
	}
	function SuaSinhVien() {
		var thoigian = document.getElementById("themsinhvien");
		document.getElementById("submitbut").innerHTML = "SỬA SINH VIÊN";
		thoigian.classList.toggle('show')
		var input = document.getElementById("MSSV");
		input.readOnly = true;
		document.getElementById("excelsubmitbut").style.display = "none";
		document.getElementById("loai").value = "sua";
	}
	function changeBackgroundColor(row) {
		// Lấy tất cả các hàng trong bảng
		var rows = document.getElementById("myTable")
				.getElementsByTagName("tr");
		var mathoigian = row.cells[0].innerText;
		document.getElementById("mssvlist").value = mathoigian;
		// Đặt màu nền của tất cả các hàng về mặc định (trắng)
		for (var i = 0; i < rows.length; i++) {
			rows[i].style.backgroundColor = "";

			var editbut = document.getElementById("editbut");
			var deletebut = document.getElementById("deletebut");
			editbut.disabled = false;
			deletebut.disabled = false;
		}
		document.getElementById("name").value = row.cells[1].innerText;
		document.getElementById("gender").value = row.cells[2].innerText;
		document.getElementById("email").value = row.cells[5].innerText;
		document.getElementById("khoa").value = row.cells[3].innerText;
		document.getElementById("address").value = row.cells[6].innerText;
		document.getElementById("sdt").value = row.cells[4].innerText;
		document.getElementById("MSSV").value = row.cells[0].innerText;

		// Đặt màu nền của hàng được nhấp vào thành màu tím nhạt
		row.style.backgroundColor = "lavender";
	}
	function ClickExcel() {
		var element = document.getElementById("themExcel");
		element.classList.toggle('show');
	}
	function myFunction() {
		if (document.getElementById("loai").value == "sua"
				|| document.getElementById("loai").value == "them") {
			var thoigian = document.getElementById("themsinhvien");
			document.getElementById("submitbut").innerHTML = "SỬA SINH VIÊN";
			thoigian.classList.toggle('show')
		}
	}
	myFunction();
</script>
</html>