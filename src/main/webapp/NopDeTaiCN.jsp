<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

	<jsp:include page="Components/LeftSideBar.jsp" />
	<div class="container-main">
		<jsp:include page="Components/NavBar.jsp" />
		<!--  IMPORT CODE PHẦN NÀY -->
		<div class="main_content">
			<div class="form form-Nop">
				<form class="login-form" action="<%=request.getContextPath()%>/DeTai/submit"
				method="post" accept-charset="UTF-8" enctype="multipart/form-data">
					<div class="form-title">
						<h1>NỘP ĐỀ TÀI</h1>
						<i class="fa fa-refresh" aria-hidden="true"></i>
					</div>
					<hr></hr>

					<h2>${detai.getTenDeTai()}</h2>
					
					<div class="form-time">
						<p>Opened: ${thoigian.getNgayMoDK()}, 00:00 AM</p>
						<p>Due: ${thoigian.getNgayNopDeTai()}, 23:59 PM</p>
					</div>

					<hr></hr>
					<h2>TRẠNG THÁI NỘP</h2>
					<table>
						<tr id = "mauTrangThai">
							<td class="columns-title">
								<p>Trạng thái nộp</p> 
							</td>
							<td><p id ="TrangThai"   >${TrangThai}</p>
							<input style="display: none" type = "text" name = "TrangThai" value = "${TrangThai}">
							</td>
							
						</tr>
					
						
						<tr>
							<td class="columns-title">
								<p>Chỉnh sửa lần cuối</p> 
							</td>
							<td><p>${nopdetai.getThoiGianNop()}</p></td>
						</tr>
						<tr>
							<td class="columns-title">
								<p>Đăng tải các bình luận</p> 
							</td>
							<td><input name = "ghichu" type="text" value="${nopdetai.getGhiChu()}" placeholder="Thêm ghi chú" /></td>
						</tr>
						<tr>
							<td class="columns-title">
								<p>File Báo cáo</p> 
							</td>
							<td> <input name ="file" type="file" /></td>
						</tr>
					</table>
					<input style="display: none" type = "text" name="MaDeTai" value = "${detai.getMaDeTai()}" > 
					<input style="display: none" type = "text" name="MaThoiGian" value = "${dangkydetai.getMaThoiGian()}" > 
					<input style="display: none" type = "text"  name="MaNopDeTai" value = "${nopdetai.getMaNopDeTai()}"> 
					<button id="submit" type="submit" >NỘP BÀI</button>
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
	var MauTrangThai = document.getElementById("mauTrangThai");	
	if (TrangThai == "Đã nộp")
	{
		document.getElementById("submit").innerText = "SỬA";
		MauTrangThai.classList.add("bg-green")
	}
	else
		document.getElementById("submit").innerText = "NỘP BÀI";
	
</script>
</html>