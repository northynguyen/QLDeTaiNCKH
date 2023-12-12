<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<link rel="stylesheet" href="Access/Style/Css/LeftSideBar.css" />
<link rel="stylesheet" href="Access/Style/Css/Root/Root.css" />
<link rel="stylesheet" href="Access/Style/Css/Login.css" />
<link rel="stylesheet" href="Access/Style/Css/formP.css" />
<script src="Access/Style/Js/DeTaiCuaToi.js" defer></script>
<link rel="stylesheet" href="../Access/Style/Css/LeftSideBar.css" />
<link rel="stylesheet" href="../Access/Style/Css/Root/Root.css" />
<link rel="stylesheet" href="../Access/Style/Css/Login.css" />
<link rel="stylesheet" href="../Access/Style/Css/formP.css" />
<script src="../Access/Style/Js/DeTaiCuaToi.js" defer></script>
<link flex href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="../Access/Style/Js/LeftSideBar.js" defer></script>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>
<body>

	<jsp:include page="Components/LeftSideBar.jsp" />
	<div class="container-main">
		<jsp:include page="Components/NavBar.jsp" />
		<div class="main_content">
			<div class="form form-DeTaiCN">
				<div class="form-title"></div>
				<hr>
				<div class="hide-list">
					<div class="SVThamGia" style="flex: 1;">
						<div class="deco topdeco"></div>

						<section class="list-wrap">

							<h2>Thành viên nghiên cứu</h2>
							<input type="text" id="search-text" placeholder="search"
								class="search-box"> <span class="list-count"></span>


							<ul id="list">
								<c:forEach var="line" items="${thamgiadetai}">
									<li class="in">
										<p>${line.getTenSinhVien()}</p>
										<p>${line.getVaiTro()}</p> <a>${line.getMSSV()}</a>
									</li>

								</c:forEach>

								<span class="empty-item">no results</span>
							</ul>
						</section>
					</div>
					<div class="SV" style="flex: 1;">
						<form
							action="<%=request.getContextPath()%>/detaicuatoi/add"
							accept-charset="UTF-8" method="POST">
							<h2>Thêm thành viên</h2>
							<table id="myTable">
								<tr class="columns-title">
									<th>MSSV</th>
									<th>Họ và tên</th>
								</tr>
								<c:forEach var="sv" items="${svtrong}">
									<tr onclick="changeBackgroundColor(this);">
							
										<td><p>

												<c:out value="${sv.getMSSV()}" />
											</p></td>
										<td><p>
												<c:out value="${sv.getTenSinhVien()}" />
											</p></td>
									</tr>
								</c:forEach>
								<input name="mssv" type="hidden" id="mssv">
								<input name="madetai" type="hidden" id = "madetai" value="${madetai}">
								<input name="madon" type="hidden" id = "madon" value="${madon}">
							</table>
							<select class="select" name="VaiTro">
								<option value="Coder">Coder</option>
								<option value="Nghiên cứu">Nghiên cứu</option>
								<option value="Thư Ký">Thư ký</option>
							</select>
								<button>THÊM</button>
						</form>
					
					</div>
				</div>
			</div>

		</div>
	</div>
	<!--  IMPORT CODE PHẦN NÀY -->
	</div>
</body>

<script>
	function changeBackgroundColor(row) {
		// Lấy tất cả các hàng trong bảng
		var rows = document.getElementById("myTable")
				.getElementsByTagName("tr");
		var mssv = row.cells[0].innerText;
		document.getElementById("mssv").value = mssv;
		console.log(document.getElementById("mssv").value);
		console.log(document.getElementById("madetai").value);
		// Đặt màu nền của tất cả các hàng về mặc định (trắng)
		for (var i = 0; i < rows.length; i++) {
			rows[i].style.backgroundColor = "";
		}

		// Đặt màu nền của hàng được nhấp vào thành màu tím nhạt
		row.style.backgroundColor = "lavender";
	}
</script>
</html>