<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="Models.ThongTinTaiKhoan"%>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<link rel="stylesheet" href="../Access/Style/Css/LeftSideBar.css" />
<link rel="stylesheet" href="../Access/Style/Css/Root/Root.css" />
<link rel="stylesheet" href="../Access/Style/Css/Login.css" />
<link rel="stylesheet" href="../Access/Style/Css/formP.css" />
<link rel="stylesheet" href="Access/Style/Css/LeftSideBar.css" />
<link rel="stylesheet" href="Access/Style/Css/Root/Root.css" />
<link rel="stylesheet" href="Access/Style/Css/Login.css" />
<link rel="stylesheet" href="Access/Style/Css/formP.css" />
<link flex href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="../Access/Style/Js/LeftSideBar.js" defer></script>
</head>
<body>
	<%
	ThongTinTaiKhoan account = (ThongTinTaiKhoan) session.getAttribute("account");
	%>
	<%if (account == null) {response.sendRedirect(request.getContextPath() + "/Login.jsp");} %>

	<jsp:include page="Components/LeftSideBarPhongQLDTNCKH.jsp" />
	<div class="container-main">
		<jsp:include page="Components/NavBar.jsp" />
		<!--  IMPORT CODE PHẦN NÀY -->
		<div class="main_content">
			<div class="form form-Nop">
				<form class="login-form" action="<%=request.getContextPath()%>/DeTai/quyetdinhduyet"
				method="post" accept-charset="UTF-8" enctype="multipart/form-data">
					<div class="form-title">
						<h1>DUYỆT ĐỀ TÀI</h1>
						<i class="fa fa-refresh" aria-hidden="true"></i>
					</div>
					<hr></hr>

					<h2>TRẠNG THÁI ĐỀ TÀI</h2>
			<c:if test="${empty dexuatdetai}">
			<input style ="display: none;" type ="text" name ="LoaiDuyet" value = "DangKy">
			<input style ="display: none;" type ="text" name ="MaChuNhiem" value = "${dangkydetai.getMaChuNhiem()}">
			<input style ="display: none;" type ="text" name ="TenDeTai" value = "${detai.getTenDeTai()}">
			<input style ="display: none;" type ="text" name ="madon" value = "${dangkydetai.getMaDon()}">
			    	<table>
						<tr >
							<td class="columns-title">
								<p>Tên đề tài:</p> 
							</td>
							<td><p>${detai.getTenDeTai()}</p></td>
						</tr>	
						<tr>
							<td class="columns-title">
								<p>Loại:</p> 
							</td>
							<td><p>Đề tài đăng ký sẵn</p></td>
						</tr>				
						<tr>
							<td class="columns-title">
								<p>Kinh phí</p> 
							</td>
							<td><p>${detai.getKinhPhi()}</p></td>
						</tr>
						<tr >
							<td class="columns-title">
								<p>Chủ nhiệm</p> 
							</td>
							<td><p>${thongtintaikhoan.getHoTen()}</p></td>
							<input style ="display: none;" type ="text" name ="LoaiDuyet" value = "${thongtintaikhoan.getMaTaiKhoan()}">
						</tr>						
						<tr>
							<td class="columns-title">
								<p>Thêm ghi chú</p> 
							</td>
							<td><input name = "ghichu" type="text" placeholder="Thêm ghi chú" /></td>
						</tr>
						<tr>
							<td class="columns-title">
								<p>File quyết định</p> 
							</td>
							<td> <input name ="file" type="file" /></td>
						</tr>
					</table>
			</c:if>
			<c:if test="${empty dangkydetai}">
			<input style ="display: none;" type ="text" name ="LoaiDuyet" value = "DeXuat">
			<input style ="display: none;" type ="text" name ="MaChuNhiem" value = "${dexuatdetai.getMaChuNhiem()}">
			<input style ="display: none;" type ="text" name ="madexuat" value = "${dexuatdetai.getMaDeXuatDeTai()}">
			    	<table>
						<tr >
							<td class="columns-title">
								<p>Tên đề tài:</p> 
							</td>
							<td><p>${dexuatdetai.getTenDeTai()}</p></td>
						</tr>
						<tr>
							<td class="columns-title">
								<p>Loại:</p> 
							</td>
							<td><p>Đề tài tự đề xuất</p></td>
						</tr>
						<tr >
							<td class="columns-title">
								<p>Đề xuất bởi:</p> 
							</td>
							<td><p>${thongtintaikhoan.getHoTen()}</p></td>
							<input style ="display: none;" type ="text" name ="MaChuNhiem" value = "${thongtintaikhoan.getMaTaiKhoan()}">
						</tr>

						<tr>
							<td class="columns-title">
								<p>Kinh phí</p> 
							</td>
							<td><p>${dexuatdetai.getKinhPhi()}</p></td>
						</tr>						
						<tr>
							<td class="columns-title">
								<p>Thêm ghi chú:</p> 
							</td>
							<td><input name = "ghichu" type="text" placeholder="Thêm ghi chú" /></td>
						</tr>
						<tr>
							<td class="columns-title">
								<p>File quyết địnhk</p> 
							</td>
							<td> <input name ="file" type="file" /></td>
						</tr>
					</table>
			</c:if>
					
					<button>DUYỆT ĐỀ TÀI </button>
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
</script>
</html>