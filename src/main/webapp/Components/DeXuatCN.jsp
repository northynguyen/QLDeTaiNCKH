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
			<div class="form form-DX">
				<form class="login-form"  accept-charset="UTF-8" action="<%=request.getContextPath()%>/DeXuatDeTai/insert" enctype='multipart/form-data' method="POST">
					<div class="form-title">
						<h1>ĐỀ XUẤT ĐỀ TÀI</h1>
						<i class="fa fa-refresh" aria-hidden="true"></i>
					</div>
					<hr></hr>
					<table>
						<tr>
							<td>
								<p>Tên đề tài</p> <input name="tenDeTai" type="text"
								placeholder="Tên đề tài" />
							</td>
							<td><p>Ngày đề xuất</p> <input name="ngayDeXuat" type="date"
								id="ngayhomnay" disabled /></td>
						</tr>

						<tr>
							<td>
								<p>Kinh phí</p> <input name="kinhPhi" type="number"
								placeholder="Kinh phí VNĐ" />
							</td>
							<td><p>Nộp file</p> <input name="file" type="file" /></td>
						</tr>
						<tr>
							<td>
								<button>SUBMIT</button> <!-- 		<input type="submit" text="SUBMIT"/> -->
							</td>
  
						</tr>
					</table>


				</form>
			</div>
		</div>
		<!--  IMPORT CODE PHẦN NÀY -->
	</div>
</body>

<script>
	function setNgayHomNay() {
		var ngayhomnay = new Date();
		var ngayhomnayString = ngayhomnay.toISOString().substring(0, 10);
		document.getElementById("ngayhomnay").value = ngayhomnayString;
		console.log(ngayhomnayString);
	}
	setNgayHomNay();
	var settingsmenu = document.querySelector(".settings-menu");
	function settingsMenuToggle() {
		settingsmenu.classList.toggle("settings-menu-height");
	}
</script>
</html>