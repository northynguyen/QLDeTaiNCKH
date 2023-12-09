<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
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

	<jsp:include page="LeftSideBar.jsp" />
	<div class="container-main">
		<jsp:include page="NavBar.jsp" />
		<div class="main_content">
			<div class="form form-DeTaiCN">
				<div class="form-title">
					<h1>Mã đơn: ${maDon}</h1>
					<i class="fa fa-refresh" aria-hidden="true"></i>
				</div>
				<hr></hr>
				<form class="login-form" id="chinhSuaDeXuat" name="madx"
					method="post"<%-- action="<%=request.getContextPath()%>/DeXuatDeTai/chitiet?madx=${madx}"> --%>>


					<h2>Đề tài</h2>
					<div class="table-DeTai">
						<table id="myTable">
							<tr class="columns-title">
								<th>Mã đề tài</th>
								<th>Tên đề tài</th>
								<th>Kinh phí</th>
								<th>File mô tả</th>

							</tr>

							<tr>
								<td>
									<p>${dt.getMaDeTai()}</p>
								</td>
								<td>
									<p>${dt.getTenDeTai()}</p>
								</td>
								<td>
									<p>${dt.getKinhPhi()}</p>
								</td>
								<td><a href="">Download</a></td>

							</tr>

						</table>
					</div>

				</form>


				<form class="login-form" method="post"<%-- 			action="<%=request.getContextPath()%>/....?maDK=${maDK}"> --%>>
					<h2>CHI TIẾT CHỦ NHIỆM</h2>
					<div class="table-DeTai">
						<table>
							<tr class="columns-title">
								<th>Mã chủ nhiệm</th>
								<th>Họ và tên</th>
								<th>Gioi tính</th>
								<th>Mã khoa</th>
								<th>Số điện thoại</th>
								<th>Email</th>
								<th>Địa chỉ</th>
							</tr>

							<tr>
								<td>
									<p>${cn.getMaTaiKhoan()}</p>
								</td>
								<td>
									<p>${cn.getHoTen()}</p>
								</td>
								<td>
									<p>${cn.getGioiTinh()}</p>
								</td>
								<td>
									<p>${cn.getMaKhoa()}</p>
								</td>
								<td>
									<p>${cn.getSDT()}</p>
								<td>
									<p>${cn.getEmail()}</p>
								</td>
								<td>
									<p>${cn.getDiaChi()}</p>
								</td>
							</tr>

						</table>
					</div>
				</form>


				<div class="hide-list">
					<div class="SVThamGia" style="flex: 1;">

						<div class="deco topdeco"></div>


						<section class="list-wrap">

							<h2>Thành viên nghiên cứu</h2>
							<input type="text" id="search-text" placeholder="search"
								class="search-box"> <span class="list-count"></span>


							<ul id="list">
								<c:forEach var="line" items="${tv}">
									<li class="in">
										<p>${line.getHoTen()}</p>
										<p>${line.getVaiTro()}</p> <a>${line.getMSSV()}</a>
									</li>

									</c:forEach>	

								<span class="empty-item">no results</span>
							</ul>
						</section>


					</div>

				</div>

			</div>
		</div>
		<!--  IMPORT CODE PHẦN NÀY -->
	</div>
</body>

<script>
	
</script>
</html>