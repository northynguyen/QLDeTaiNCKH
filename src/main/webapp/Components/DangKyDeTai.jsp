<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	
	<jsp:include page="LeftSideBar.jsp" />
	<div class="container-main">
		<jsp:include page="NavBar.jsp" />
		<!--  IMPORT CODE PHẦN NÀY -->
		<a 	href="<%= request.getContextPath()%>/dangkydetai/dangky" > Nhan di</a>
		<div class="main_content">
			<div class="form form-DeTaiCN">
				<form class="login-form">
					<div class="form-title">
						<h1>ĐĂNG KÝ ĐỀ TÀI</h1>
						<i class="fa fa-refresh" aria-hidden="true"></i>
					</div>
					<hr></hr>

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
								<tr>

									<td><p>
											<c:out value="${DeTai.getMaDeTai()}" />
										</p></td>
									<td><p>
											<c:out value="${DeTai.getTenDeTai()}" />
										</p></td>
									<td><p>
											<c:out value="${DeTai.getKinhPhi()}" />
										</p></td>
									<td><a href=""> Download</a></td>
									
									<td><c:if test="${DeTai != null}">
											<input type="radio" id="chon_${DeTai.getMaDeTai()}" name="chon"
												value="<c:out value='${DeTai.getMaDeTai()}' />">
										</c:if></td>
								</tr>
							</c:forEach>
						</table>
					</div>
					<button>ĐĂNG KÝ</button>
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
</script>
</html>