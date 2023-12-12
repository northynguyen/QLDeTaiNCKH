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
<link flex href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="../Access/Style/Js/LeftSideBar.js" defer></script>
</head>
<body>

	<jsp:include page="LeftSideBar.jsp" />
	<div class="container-main">
		<jsp:include page="NavBar.jsp" />
		<!--  IMPORT CODE PHẦN NÀY -->
		<div class="main_content">
			<div class="form form-Nop">
				<form class="login-form" action="<%=request.getContextPath()%>/DeTai/submit"
				accept-charset="UTF-8" enctype='multipart/form-data' method="POST">
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
						<tr class="bg-green">
							<td class="columns-title">
								<p>Trạng thái nộp</p> 
							</td>
							<td><p>Chưa nộp</p></td>
						</tr>

						<tr>
							<td class="columns-title">
								<p>Thời gian còn lại</p> 
							</td>
							<td><p>Bài tập đã được gửi sớm 3 giờ 39 phút</p></td>
						</tr>
						
						<tr>
							<td class="columns-title">
								<p>Chỉnh sửa lần cuối</p> 
							</td>
							<td><p>Wednesday, 6 September 2023, 8:20 PM</p></td>
						</tr>
						<tr>
							<td class="columns-title">
								<p>Đăng tải các bình luận</p> 
							</td>
							<td><input type="text" placeholder="Thêm ghi chú" /></td>
						</tr>
						<tr>
							<td class="columns-title">
								<p>Đăng tải các bình luận</p> 
							</td>
							<td> <input type="file" /></td>
						</tr>
					</table>
					<button>SUBMIT </button>
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