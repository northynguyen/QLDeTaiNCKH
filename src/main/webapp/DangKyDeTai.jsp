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
<link rel="stylesheet" href="../Access/Style/Css/LeftSideBar.css" />
<link rel="stylesheet" href="../Access/Style/Css/Root/Root.css" />
<link rel="stylesheet" href="../Access/Style/Css/Login.css" />
<link rel="stylesheet" href="../Access/Style/Css/formP.css" />
<!-- Boxicons CSS -->
<link flex href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src=".Access/Style/Js/LeftSideBar.js" defer></script>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>
<body>
<%
	String err = (String) request.getAttribute("err");
%>
	<jsp:include page="Components/LeftSideBar.jsp" />
	<div class="container-main">
		<jsp:include page="Components/NavBar.jsp" />
		<!--  IMPORT CODE PHẦN NÀY -->
		<div class="main_content">
			<div class="form form-DeTaiCN">
				<form class="login-form" action="<%=request.getContextPath()%>/dangkydetai/dangky"
				accept-charset="UTF-8" method="POST">
					<div class="form-title">
						<h1>ĐĂNG KÝ ĐỀ TÀI</h1>
						<i class="fa fa-refresh" aria-hidden="true"></i>
					</div>
					<hr></hr>
<%
 if (err != null) {
 %>
									<div class="error-message"><%=err%></div> <%
 }
 %>
					<div class="table-DeTai">
						<table id="myTable">
							<tr class="columns-title">
								<th>Mã đề tài</th>
								<th>Tên đề tài</th>
								<th>Kinh phí dự kiến</th>
								<th>File mô tả</th>
								<th>Chọn</th>
							</tr>
							<c:forEach var="DeTai" items="${listDeTai}">
								<tr onclick="changeBackgroundColor(this)">
									<input  id="madetaiInput" type="hidden" name="madetai">
									<td><p>
											<c:out value="${DeTai.getMaDeTai()}" />
										</p></td>
									<td><p>
											<c:out value="${DeTai.getTenDeTai()}" />
										</p></td>
									<td><p>
											<c:out value="${DeTai.getKinhPhi()}" />
										</p></td>
									<td><a
										href="<%=request.getContextPath()%>/download/fileMoTa?maDT=${DeTai.getMaDeTai()}">Download</a></td>

									<td>
											<input type="radio" name="chon">
										</td>
								</tr>
							</c:forEach>
						</table>
					</div>

					<button disabled class="btn_disable" id="btn_dk" >ĐĂNG KÝ</button>
				</form>

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
		var madetai = row.cells[0].innerText;
		document.getElementById("madetaiInput").value = madetai;
		// Đặt màu nền của tất cả các hàng về mặc định (trắng)
		for (var i = 0; i < rows.length; i++) {
			rows[i].style.backgroundColor = "";
		}

		// Đặt màu nền của hàng được nhấp vào thành màu tím nhạt
		row.style.backgroundColor = "lavender";
		removedisableButton();
		var radioButtons = row.getElementsByTagName("input");
		  for (var i = 0; i < radioButtons.length; i++) {
		    if (radioButtons[i].type === "radio") {
		      radioButtons[i].checked = false;
		    }
		  }
		  var radio = row.querySelector("input[type='radio']");
		  radio.checked = true;
	}
	function settingsMenuToggle() {
		settingsmenu.classList.toggle("settings-menu-height");
	}
	function removedisableButton()
	{
		var sua = document.getElementById("btn_dk");
		sua.disabled = false;
		sua.classList.remove('btn_disable');
		
	}
</script>
</html>