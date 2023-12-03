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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="../Access/Style/Js/LeftSideBar.js" defer></script>
</head>
<body>

	<jsp:include page="LeftSideBar.jsp" />
	<div class="container-main">
		<jsp:include page="NavBar.jsp" />
		<!--  IMPORT CODE PHẦN NÀY -->
		<div class="main_content">
			<div class="form form-DX">
				<form class="login-form">
					<div class="form-title">
					<h1>THÊM ĐỀ TÀI</h1>
				<i class="fa fa-refresh" aria-hidden="true"></i>
					</div>
					<hr></hr>
					<table>
							<tr>
								<p>Tên đề tài</p> <input type="text" placeholder="Tên đề tài" />
							</tr>
							<tr>
								<p>Kinh phí</p> <input type="number" placeholder="Kinh phí VNĐ" />
							</tr>
							<tr><p>File mô tả</p> <input type="file" /></tr>
						<tr>
							<td>
								<button>THÊM ĐỀ TÀI </button>
						<!-- 		<input type="submit" text="SUBMIT"/> -->
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
	var settingsmenu = document.querySelector(".settings-menu");
	function settingsMenuToggle() {
		settingsmenu.classList.toggle("settings-menu-height");
	}
</script>
</html>