<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<script src="Access/Style/Js/LeftSideBar.js" defer></script>
</head>
<style>
.form input {
	cursor: pointer;
}

.exist {
	display: block;
}
</style>
<body>

	<jsp:include page="LeftSideBar.jsp" />
	<div class="container-main">
		<jsp:include page="NavBar.jsp" />
		<!--  IMPORT CODE PHẦN NÀY -->
		<div class="main_content">
			<div class="form form-DX">

				<form class="login-form" accept-charset="UTF-8"
					enctype='multipart/form-data' method="POST">
					<div class="form-title">
						<h1>THÔNG TIN CÁ NHÂN</h1>
						<i id="icon-edit" class="fa fa-edit" aria-hidden="true">Edit</i>
					</div>
					<hr></hr>
					<h2>Mã tài khoản: 1 _ Chủ nhiệm _ Khoa CNTT</h2>
					<table>
						<tr>
							<td>
								<p>Họ và tên</p> <input class="change" name="HoTen" type="text"
								value="Trịnh Thu Phương " readonly />
							</td>
							<td>
								<p>Địa chỉ</p> <input class="change" name="DiaChi" type="text"
								value="Long An" readonly />
							</td>
							<td>
								<p>Gioi tính</p> <input class="change" name="GioiTinh"
								type="text" value="Nữ" readonly />
							</td>

						</tr>

						<tr>
							<td>
								<p>Email</p> <input class="change" name="Email" type="email"
								value="anv@gmail.com" readonly />
							</td>
							<td>
								<p>Số điện thoại</p> <input class="change" name="SDT"
								type="number" value="0942523074" readonly />
							</td>

						</tr>
						
					<!-- 	<tr> Dùng cho admin
						
							<td>
						
								<p>Tài khoản </p> <input  name="maTK" type="text"
								value="1" readonly />
							</td>
							<td>
							
								<p>Mật Khẩu</p> <input  name="MatKhau"
								type="password" value="1234" readonly />
							</td>

						</tr>
						<tr>
							<td>
								<button id="hide-button" style="display: none">Xác nhận
									thay đổi</button> 		<input type="submit" text="SUBMIT"/>
							</td>
						</tr> -->
					</table>

				</form>
			</div>
		</div>
		<!--  IMPORT CODE PHẦN NÀY -->
	</div>
</body>

<script>
	var iconEdit = document.getElementById('icon-edit');
	var inputs = document.querySelectorAll('.change');
	var hideButton = document.getElementById('hide-button');
	var input = document.getElementById('.form input');
	// Gắn sự kiện click cho icon-edit
	iconEdit.addEventListener('click', function() {
		// Lặp qua mỗi input và thay đổi thuộc tính readonly
		inputs.forEach(function(input) {
			input.readOnly = !input.readOnly;
		});
		hideButton.style.display = 'block';
		
	});
	var settingsmenu = document.querySelector(".settings-menu");
	function settingsMenuToggle() {
		settingsmenu.classList.toggle("settings-menu-height");
	}
</script>
</html>