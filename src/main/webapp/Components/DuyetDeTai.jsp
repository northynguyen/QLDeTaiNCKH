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
<link rel="stylesheet" href="../Access/Style/Css/formThoai.css" />
<!-- Boxicons CSS -->
<link flex href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="../Access/Style/Js/LeftSideBar.js" defer></script>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>
<body>

	<jsp:include page="LeftSideBar.jsp" />
	<div class="container-main">
		<jsp:include page="NavBar.jsp" />
		<!--  IMPORT CODE PHẦN NÀY -->
		<div class="main_content">
			<div class="form form-DeTaiCN">
				<form class="login-form">
					<div class="form-title">
						<h1>DUYỆT ĐỀ TÀI</h1>
						<i class="fa fa-refresh" aria-hidden="true"></i>
					</div>
					<hr></hr>


					<div class="table-DeTai">
						<table id="myTable">
							<tr class="columns-title">
								<th>Mã đề tài</th>
								<th>Tên đề tài</th>
								<th>Chủ nhiệm đăng ký</th>
								<th>Chi phí</th>
								<th>File mô tả</th>
								<th>Chọn</th>
							</tr>

							<tr>
								<td>
									<p>Đề tài 1</p>
								</td>
								<td>
									<p>Tên đề tài 1</p>
								</td>
								<td>Chủ nhiệm 1</td>
								<td>
									<p>1000000</p>
								</td>
								<td><a href="">Download</a></td>
								<td><input type="radio" id="" name="chon"></td>
							</tr>
							<tr>
								<td>
									<p>Đề tài 1</p>
								</td>
								<td>
									<p>Tên đề tài 1</p>
								</td>
								<td>Chủ nhiệm 1</td>
								<td>
									<p>1000000</p>
								</td>
								<td><a href="">Download</a></td>
								<td><input type="radio" id="" name="chon"></td>
							</tr>
							<tr>
								<td>
									<p>Đề tài 1</p>
								</td>
								<td>
									<p>Tên đề tài 1</p>
								</td>
								<td>Chủ nhiệm 1</td>
								<td>
									<p>1000000</p>
								</td>
								<td><a href="">Download</a></td>
								<td><input type="radio" id="" name="chon"></td>
							</tr>
							<tr>
								<td>
									<p>Đề tài 1</p>
								</td>
								<td>
									<p>Tên đề tài 1</p>
								</td>
								<td>Chủ nhiệm 1</td>
								<td>
									<p>1000000</p>
								</td>
								<td><a href="">Download</a></td>
								<td><input type="radio" id="" name="chon"></td>
							</tr>
							<tr>
								<td>
									<p>Đề tài 1</p>
								</td>
								<td>
									<p>Tên đề tài 1</p>
								</td>
								<td>Chủ nhiệm 1</td>
								<td>
									<p>1000000</p>
								</td>
								<td><a href="">Download</a></td>
								<td><input type="radio" id="" name="chon"></td>
							</tr>
						</table>
					</div>

				</form>
				<button>DUYỆT</button>
				<button onclick=" toggleHideBox() ">XÓA ĐỀ XUẤT</button>
				<div class="hide-list" id="hide-box" style="display: none;">
					<div class="SV" style="flex: 1;">
						<h2>LÝ DO KHÔNG DUYỆT</h2>
						<form>
							<textarea class="TextArea">Nội dung</textarea><br><br>
							<button>GỬI</button>
						</form>
					</div>
				</div>
				</table>
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

	function toggleHideBox() {
		var box = document.getElementById("hide-box");
		if (box.style.display == "none") {
			box.style.display = "flex";
		} else {
			box.style.display = "none";
		}
	}
</script>


</html>