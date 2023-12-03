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
					<h1>ĐỀ XUẤT ĐỀ TÀI</h1>
				<i class="fa fa-refresh" aria-hidden="true"></i>
					</div>
					<hr></hr>
					<table>
						<tr>
							<td>
								<p>Tên đề tài</p> <input type="text" placeholder="Tên đề tài" />
							</td>
							<td><p>Ngày nộp đề tài</p> <input type="date" /></td>
						</tr>

						<tr>
							<td>
								<p>Kinh phí</p> <input type="number" placeholder="Kinh phí VNĐ" />
							</td>
							<td><p>Nộp file</p> <input type="file" /></td>
						</tr>
						<tr>
							<td>
								<button>SUBMIT </button>
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