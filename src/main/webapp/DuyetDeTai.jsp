<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.time.LocalDate"%>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<link rel="stylesheet" href="Access/Style/Css/LeftSideBar.css" />
<link rel="stylesheet" href="Access/Style/Css/Root/Root.css" />
<link rel="stylesheet" href="Access/Style/Css/Login.css" />
<link rel="stylesheet" href="Access/Style/Css/formP.css" />
<link rel="stylesheet" href="Access/Style/Css/formThoai.css" />
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
<script src=".Access/Style/Js/LeftSideBar.js" defer></script>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>
<body>
	<jsp:include page="LeftSideBar.jsp" />
	<div class="container-main">
		<jsp:include page="NavBar.jsp" />
		<!--  IMPORT CODE PHẦN NÀY -->
		<a href="<%=request.getContextPath()%>/duyetdetai/new"> Nhan
			di</a>
		<div class="main_content">
			<div class="form form-DeTaiCN">
				<form class="login-form" action=""
				accept-charset="UTF-8" method="POST">
					<div class="form-title">
						<h1>DUYỆT ĐỀ TÀI</h1>
						<i class="fa fa-refresh" aria-hidden="true"></i>
					</div>
					<hr></hr>

					<div class="table-DeTai">
						<table id="myTable">
							<tr class="columns-title">
								<th>Mã Đơn </th>
								<th>Tên đề tài</th>
								<th>Chủ Nhiệm</th>
								<th>Kinh phí dự kiến</th>
								<th>File mô tả</th>
								<th>Chọn</th>
							</tr>
							<c:forEach var="Duyet" items="${listDuyet}">
								<tr onclick="changeBackgroundColor(this)">
								 
									<td><p>
											<c:out value="${Duyet.getMaDon()}" />
										</p></td>
									<td><p>
											<c:out value="${Duyet.getTenDeTai()}" />
										</p></td>
									<td><p>
											<c:out value="${Duyet.getTenChuNhiem()}" />
										</p></td>
									<td><p>
											<c:out value="${Duyet.getKinhPhi()}" />
										</p></td>
									<td><a href=""> Download</a></td>

									<td>
											<input type="radio" name="chon">
										</td>
								</tr>
							</c:forEach>
						</table>
					</div>
					
				</form>
				<button disabled class="btn_disable"  id="btn_duyet">DUYỆT</button>
				<button onclick=" toggleHideBox('Không Duyệt');" disabled class="btn_disable" id="btn_xoa">KHÔNG DUYỆT</button>
				<div class="hide-list" id="hide-box" style="display: none;">
					<div class="SV" style="flex: 1;">
						<h2>LÝ DO KHÔNG DUYỆT</h2>
						<form action="<%=request.getContextPath()%>/duyetdetai/xoa"
				accept-charset="UTF-8" method="POST">
							<input id="maDonInput" type="hidden" name ="MaDon">
							<textarea name="GhiChu" class="TextArea" placeholder="Lý do"></textarea><br><br>
							<button>GỬI</button>
						</form>
					</div>
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

	function changeBackgroundColor(row) {
		// Lấy tất cả các hàng trong bảng
		var rows = document.getElementById("myTable")
				.getElementsByTagName("tr");
		var select= document.getElementById("chon");
		var maDon = row.cells[0].innerText;
		document.getElementById("maDonInput").value = maDon
		console.log(maDon);
		// Đặt màu nền của tất cả các hàng về mặc định (trắng)
		for (var i = 0; i < rows.length; i++) {
			rows[i].style.backgroundColor = "";
		}

		// Đặt màu nền của hàng được nhấp vào thành màu tím nhạt
		row.style.backgroundColor = "lavender";
		var radioButtons = row.getElementsByTagName("input");
		  for (var i = 0; i < radioButtons.length; i++) {
		    if (radioButtons[i].type === "radio") {
		      radioButtons[i].checked = false;
		    }
		  }
		  var radio = row.querySelector("input[type='radio']");
		  radio.checked = true;
		  removedisableButton();
	}
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
	function removedisableButton()
	{
		var sua = document.getElementById("btn_duyet");
		sua.disabled = false;
		sua.classList.remove('btn_disable');
		
		var xoa = document.getElementById("btn_xoa");
		xoa.disabled = false;
		xoa.classList.remove('btn_disable');
	}
	function disableButton()
	{
		var sua = document.getElementById("btn_duyet");
		sua.disabled = true;
		sua.classList.add('btn_disable');
		
		var xoa = document.getElementById("btn_xoa");
		xoa.disabled = true;
		xoa.classList.add('btn_disable');
	}
</script>
</html>