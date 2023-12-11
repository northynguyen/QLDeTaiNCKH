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

	<jsp:include page="LeftSideBarPhongQLDTNCKH.jsp" />
	<div class="container-main">
		<jsp:include page="NavBar.jsp" />
		<!--  IMPORT CODE PHẦN NÀY -->
		<div class="main_content">
			<div class="form form-Nop">
				<form class="login-form">
					<div class="form-title">
						<h1>DUYỆT ĐỀ TÀI</h1>
						<i class="fa fa-refresh" aria-hidden="true"></i>
					</div>
					<hr></hr>

					<h2>TRẠNG THÁI ĐỀ TÀI</h2>
					<table>
						<tr >
							<td class="columns-title">
								<p>TÊN ĐỀ TÀI:</p> 
							</td>
							<td><p>Cách để đẹp trai</p></td>
						</tr>
						<tr >
							<td class="columns-title">
								<p>ĐỀ XUẤT BỞI:</p> 
							</td>
							<td><p>Hoàng Công Thiện</p></td>
						</tr>

						<tr>
							<td class="columns-title">
								<p>KINH PHÍ</p> 
							</td>
							<td><p>10000000</p></td>
						</tr>
						<tr >
							<td class="columns-title">
								<p>FILE MÔ TẢ</p> 
							</td>
							<td><a>Tải xuống</a></td>
						</tr>						
						<tr>
							<td class="columns-title">
								<p>THÊM GHI CHÚ:</p> 
							</td>
							<td><input type="text" placeholder="Thêm ghi chú" /></td>
						</tr>
						<tr>
							<td class="columns-title">
								<p>FILE QUYẾT ĐỊNH</p> 
							</td>
							<td> <input type="file" /></td>
						</tr>
					</table>
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