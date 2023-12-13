<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<link rel="stylesheet" href="Access/Style/Css/LeftSideBar.css" />
<link rel="stylesheet" href="Access/Style/Css/Root/Root.css" />
<link rel="stylesheet" href="Access/Style/Css/Login.css" />
<link rel="stylesheet" href="Access/Style/Css/formP.css" />
<link rel="stylesheet" href="../Access/Style/Css/LeftSideBar.css" />
<link rel="stylesheet" href="../Access/Style/Css/Root/Root.css" />
<link rel="stylesheet" href="../Access/Style/Css/Login.css" />
<link rel="stylesheet" href="../Access/Style/Css/formP.css" />
<link flex href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="../Access/Style/Js/LeftSideBar.js" defer></script>
</head>
<body>

	<jsp:include page="Components/LeftSideBarPhongQLDTNCKH.jsp" />
	<div class="container-main">
		<jsp:include page="Components/NavBar.jsp" />
		<!--  IMPORT CODE PHẦN NÀY -->
		<div class="main_content">
			<div class="form form-Nop">
				<form class="login-form"
					action="<%=request.getContextPath()%>/NghiemThu/submit"
					method="post" accept-charset="UTF-8" enctype="multipart/form-data">
					<div class="form-title">
						<h1>THỰC HIỆN NGHIỆM THU</h1>
						<i class="fa fa-refresh" aria-hidden="true"></i>
					</div>
					<hr></hr>

					<h2>${detai.getTenDeTai()}</h2>

					<div class="form-time">
						<p>Opened: ${thoigian.getNgayMoDK()}, 00:00 AM</p>
						<p>Due: ${thoigian.getNgayNopDeTai()}, 23:59 PM</p>
					</div>

					<hr></hr>
					<h2>TRẠNG THÁI THỰC HIỆN</h2>
					<table>
						<tr id="mauTrangThai">
							<td class="columns-title">
								<p>Trạng thái nộp</p>
							</td>
							<td><p id="TrangThai">${nopDeTai.getTrangThai()}</p></td>

						</tr>

						<tr>
							<td class="columns-title">
								<p>Mã người Nghiệm Thu</p>
							</td>
							<td><p>${nghiemthu.getMaNguoiNghiemThu()}</p></td>
						</tr>
						<tr>
							<td class="columns-title">
								<p>Chỉnh sửa lần cuối</p>
							</td>
							<td><p>${nghiemthu.getNgayNghiemThu()}</p></td>
						</tr>
						<tr>
							<td class="columns-title">
								<p>Đăng tải các bình luận</p>
							</td>
							<td><input name="binhluan" type="text"
								value="${nghiemthu.getGhiChu()}" placeholder="Thêm ghi chú" /></td>
						</tr>
						<tr>
							<td class="columns-title">
								<p>Điểm số</p>
							</td>
							<td><input name="diem" type="text"
								value="${nghiemthu.getDiemSo()}" placeholder="Thêm ghi chú" /></td>
						</tr>
						<tr>
							<td class="columns-title">
								<p>Hồ sơ nghiệm thu</p>
							</td>
							<td><input name="file" type="file"
								value="${nghiemthu.getTaiLieuNghiemThu()}" /></td>
						</tr>
					</table>
					
					<input style="display: none" name="MaNghiemThu" value="${nghiemthu.getMaNghiemThu()}"/> 
					<input style="display: none"  name="MaNopDeTai" value="${nopDeTai.getMaNopDeTai()}"/> 
					<input style="display: none"  name="NgayNghiemThu" value="${nghiemthu.getMaNguoiNghiemThu()}"/> 
					<input style="display: none"  name="MaNguoiNghiemThu" value="${nghiemthu.getNgayNghiemThu()}"/>
					<input style="display: none"  name="TrangThai" value="${nopDeTai.getTrangThai()}"/>

					<button id="submit" type="submit">NỘP BÀI</button>
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
	var TrangThai = document.getElementById("TrangThai").innerText;
	console.log(TrangThai);
	var MauTrangThai = document.getElementById("mauTrangThai");
	if (TrangThai == "Đã nghiệm thu") {
		document.getElementById("submit").innerText = "SỬA";
		MauTrangThai.classList.add("bg-green")
	} else {
		document.getElementById("submit").innerText = "SUBMIT";

	}
</script>
</html>