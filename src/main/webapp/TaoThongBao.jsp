<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="Models.ThongTinTaiKhoan"%>
<html lang="en">
<head>

<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<link rel="stylesheet" href="Access/Style/Css/LeftSideBar.css" />
<link rel="stylesheet" href="Access/Style/Css/Root/Root.css" />
<link rel="stylesheet" href="Access/Style/Css/Login.css" />
<link rel="stylesheet" href="Access/Style/Css/formP.css" />
<link rel="stylesheet" href="Access/Style/Css/TaoThongBao.css" />
<link rel="stylesheet" href="../Access/Style/Css/LeftSideBar.css" />
<link rel="stylesheet" href="../Access/Style/Css/Root/Root.css" />
<link rel="stylesheet" href="../Access/Style/Css/Login.css" />
<link rel="stylesheet" href="../Access/Style/Css/formP.css" />
<link rel="stylesheet" href="../Access/Style/Css/TaoThongBao.css" />
<!-- Boxicons CSS -->
<link flex href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css"
	rel="stylesheet" />
<script src="Access/Style/Js/LeftSideBar.js" defer></script>
</head>
<body>
	<%
	String InformSuccess = (String) request.getAttribute("InformSuccess");
	%>
	<%
	ThongTinTaiKhoan account = (ThongTinTaiKhoan) session.getAttribute("account");
	%>
	<%if (account == null) {response.sendRedirect(request.getContextPath() + "Login.jsp");} %>

	<jsp:include page="Components/LeftSideBarPhongQLDTNCKH.jsp" />
	<div class="container-main">
		<jsp:include page="Components/NavBar.jsp" />


		<!--  IMPORT CODE PHẦN NÀY -->
		<div class="main_content">
			<div class="form form-DeTaiCN">
				<form action="<%=request.getContextPath()%>/ThongBao/create"
					method="post" accept-charset="UTF-8">
					<h1>GỬI THÔNG BÁO</h1>

					<div class="info-content">
						<h4 >
							Chọn người nhận: <select name="reciever" id="reciever"
								class="infor-reciever" onchange="changeLableID()">
								<c:forEach var="thongtintaikhoan"
									items="${ListThongTinTaiKhoan}">
									<option value="${thongtintaikhoan.getMaTaiKhoan()}">${thongtintaikhoan.getHoTen()}</option>
								</c:forEach>
							</select>
						</h4>
						<h4 padding-bottom-15px>
							ID người nhận:
							<Lable id="IDReciever" name="IDReciever"
								class="IdLable infor-reciever ">
							${ListThongTinTaiKhoan[0].getMaTaiKhoan()} </Lable>
						</h4>
						<h4 padding-bottom-15px>
							Tiêu đề thông báo: <input name="title" type="text" required>
						</h4>
						<h4>Nội dung thông báo:</h4>
						<textarea name="content" cols="100" rows="50" required></textarea>
					</div>
					<br>
					<%
					if (InformSuccess != null) {
					%>
					<div class="success-message"><%=InformSuccess%></div>
					<%
					}
					%>
					<button type="submit">Gửi thông báo</button>
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

	function changeLableID() {
		var selectElement = document.getElementById("reciever");
		var selectedValue = selectElement.value;
		var lableID = document.getElementById("IDReciever");
		console.log(selectedValue)
		lableID.textContent = selectedValue;
	}
</script>
</html>