<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<link rel="stylesheet" href="../Access/Style/Css/LeftSideBar.css" />
<link rel="stylesheet" href="../Access/Style/Css/Root/Root.css" />
<link rel="stylesheet" href="../Access/Style/Css/Login.css" />
<link rel="stylesheet" href="../Access/Style/Css/formP.css" />
<link rel="stylesheet" href="../Access/Style/Css/TaoTaiKhoan.css" />
<link flex href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css"
	rel="stylesheet" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="../Access/Style/Js/LeftSideBar.js" defer></script>
</head>
<body>

	<jsp:include page="LeftSideBar.jsp" />
	<div class="container-main">
		<jsp:include page="NavBar.jsp" />
		<!--  IMPORT CODE PHẦN NÀY -->
		<div class="main_content">
			<div class="form form-DX" style="position: relative;">
				<form class="login-form">
					<div class="form-title">
					<h1>TẠO TÀI KHOẢN</h1>
				<i class="fa fa-refresh" aria-hidden="true"></i>
					</div>
					<hr></hr>
					<table>
						<tr>
							<td>
								<p>Họ và tên:
								<input class="input-infor" type="text" placeholder="Họ và tên" />
								</p> 
							</td>
							<td>
								<p>Tên tài khoản:
								<input class="input-account" type="text" placeholder="Tên tài khoản" />
								</p> 
							</td>
						</tr>
						<tr>
							<td>
								<p>Giới tính:
									<select class="input-select"> 
										<option value="Nam"> Nam</option>
										<option value="Nữ"> Nữ</option>
									</select>
								</p> 
							</td>
						
							<td>
								<p>Mật khẩu:
								<input class="input-account" type="password" placeholder="Mật khẩu" />
								</p> 
							</td>
							
						</tr>
						<tr>
							<td>
								<p>Khoa:
								<select class="input-select"> 
								<option value="CNTT"> Công nghệ thông tin</option>
								<option value="CKCTM"> Cơ khí chế tạo máy</option>
								<option value="DDT"> Điện điện tử</option>
								</select>
								</p> 
							</td>
							<td>
								<p> Nhập lại mật khẩu:
								<input class="input-account" type="password" placeholder="Nhập lại mật khẩu" />
								</p> 
							</td>
						</tr>
						<tr>
							<td>
								<p>Số điện thoại:
								<input class="input-infor" type="number" placeholder="Số điện thoại" />
								</p>
							<td/>
								
							
						</tr>
						<tr>
							<td>
								<p>Email:
								<input class="input-infor"  type="text" placeholder="Địa chỉ Email" />
								</p> 
							<td/>
								
						</tr>
						<tr>
							<td>
							<p>Địa chỉ:
							<input class="input-infor" type="text" placeholder="Địa chỉ" />
							</p> 
							</td>
							<td>
								<p> Role:
									<select class="input-select-role"> 
										<option value="Chủ nhiệm">Chủ nhiệm</option>
										<option value="Phòng quản lý ĐTKH">Phòng quản lý ĐTKH</option>
									</select>
								</p> 
							</td>
						</tr>

							


					</table>
				<button>TẠO TÀI KHOẢN </button>

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