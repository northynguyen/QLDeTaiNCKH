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
<link rel="stylesheet" href="Access/Style/Css/formThoai.css" />
<link rel="stylesheet" href="../Access/Style/Css/LeftSideBar.css" />
<link rel="stylesheet" href="../Access/Style/Css/Root/Root.css" />
<link rel="stylesheet" href="../Access/Style/Css/Login.css" />
<link rel="stylesheet" href="../Access/Style/Css/formP.css" />
<link rel="stylesheet" href="../Access/Style/Css/formThoai.css" />

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
				<div class="form-title">
					<h1>ĐỀ TÀI CỦA TÔI</h1>
					<i class="fa fa-refresh" aria-hidden="true"></i>
				</div>
				<hr></hr>
				<form class="login-form" id="chinhSuaDeXuat" name="madx"
					method="post">
					<h2>ĐỀ TÀI ĐỀ XUẤT</h2>
					<div class="table-DeTai" id="deTaiDeXuat">
						<table id="myTableDX">
							<tr class="columns-title">
								<th>Mã đơn</th>
								<th>Tên đề tài</th>
								<th>Ngày đề xuất đề tài</th>
								<th>Kinh phí</th>
								<th>File mô tả đề tài</th>
								<th>Ghi Chú</th>
								<th>Trạng thái</th>
							</tr>

							<c:forEach var="DeXuat" items="${listDeXuat}">
								<tr onclick="focusChinhSua(this)">
									<td><p>
											<c:out value="${DeXuat.getMaDeXuatDeTai()}" />
										</p></td>
									<td><p>
											<c:out value="${DeXuat.getTenDeTai()}" />
										</p></td>
									<td><p>
											<input style="display: none" name="maDT"
												value="${DeXuat.getMaDeXuatDeTai()}">
											<c:out value="${DeXuat.getNgayDeXuat()}" />
										</p></td>
									<td><p>
											<c:out value="${DeXuat.getKinhPhi()}" />
										</p></td>

									<td><a
										href="<%=request.getContextPath()%>/download/fileMoTaDeXuat?maDT=${DeXuat.getMaDeXuatDeTai()}">Download</a></td>
									<td><p>
											<c:out value="${DeXuat.getTrangThai()}" />
										</p></td>
									<td><p>
											<c:out value="${DeXuat.getGhiChu()}" />
										</p></td>
							</c:forEach>

						</table>
					</div>
					<button type="submit">CHỈNH SỬA ĐỀ XUẤT</button>
				</form>


				<form class="login-form" id="DK" name="maDK" method="post"
					action="<%=request.getContextPath()%>/DeTai/showsubmit"">
					<h2>ĐĂNG KÝ ĐỀ TÀI</h2>
					<div class="table-DeTai" id="dangKy">
						<table id="myTableDK">
							<tr class="columns-title">
								<th>Mã đơn</th>
								<th>Mã đề tài</th>
								<th>Tên đề tài</th>
								<th>Ngày duyệt đề xuất</th>
								<th>Kinh phí</th>
								<th>File mô tả đề tài</th>
								<th>Thành viên</th>
								<th>Trạng thái</th>
							</tr>
							<c:forEach var="Duyet" items="${listCNDangKy}">
								<tr onclick="focusDangKy123(this)">
									<td><p>
											<c:out value="${Duyet.getMaDon()}" />
										</p></td>
									<td><p>
											<c:out value="${Duyet.getMaDeTai()}" />
										</p></td>
									<td><p>
											<c:out value="${Duyet.getTenDeTai()}" />
										</p></td>
									<td><p>
											<c:out value="${Duyet.getNgayduyet()}" />
										</p></td>
									<td><p>
											<c:out value="${Duyet.getKinhPhi()}" />
										</p></td>
									<td><a
										href="<%=request.getContextPath()%>/download/fileMoTa?maDT=${Duyet.getMaDeTai()}">Download</a></td>
									<td><a
										href="<%=request.getContextPath()%>/detaicuatoi/chitiet?madetai=${Duyet.getMaDeTai()}&madon=${Duyet.getMaDon()}"
										style="text-decoration: underline; color: blue;" class="cttv" >Chi
											tiết thành viên</a></td>
									<td><p>
											<c:out value="${Duyet.getTrangThai()}" /> 
										</p></td>
								</tr>
							</c:forEach>
						</table>
					</div>
					<input type="text" id="madon" name="MaDon" style="display: none">
					<button id="btn-DK" style="display: none" type="submit">NỘP
						ĐỀ TÀI</button>
				</form>

				<form class="login-form" id="DK" name="maDK" method="post">
					<h2>ĐỀ TÀI ĐÃ NGHIỆM THU</h2>
					<div class="table-DeTai" id="dangKy">
						<table id="myTableDK">
							<tr class="columns-title">
								<th>Mã nộp</th>
								<th>Mã đề tài</th>
								<th>Điểm số</th>
								<th>Ngày nghiệm thu</th>
								<th>Mã thời gian</th>
								<th>File báo cáo</th>
								<th>Hồ sơ liên quan</th>
								<th>Ghi chú</th>
							</tr>
							<c:forEach var="nop" items="${nopnghiemthu}">
								<tr onclick="focusDangKy123(this)">
									<td><p>
											<c:out value="${nop.getMaNopDeTai()}" />
										</p></td>
									<td><p>
											<c:out value="${nop.getMaDeTai()}" />
										</p></td>
									<td><p>
											<c:out value="${nop.getDiemSo()}" />
										</p></td>
									<td><p>
											<c:out value="${nop.getNgayNghiemThu()}" />
										</p></td>
									<td><p>
											<c:out value="${nop.getMaThoiGian()}" />
										</p></td>
									<td><a
										href="<%=request.getContextPath()%>/download/fileBaoCao?maDT=${nop.getMaNghiemThu()}">Download</a></td>
									<td><a
										href="<%=request.getContextPath()%>/download/fileHoSo?maDT=${nop.getMaNghiemThu()}">Download</a></td>
									<td><p>
											<c:out value="${nop.getGhiChu()}" />
										</p></td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</form>
			</div>

		</div>
	</div>
	<!--  IMPORT CODE PHẦN NÀY -->
	</div>
</body>

<script>
	document.addEventListener('DOMContentLoaded', function () {
	    var form = document.getElementById('chinhSuaDeXuat');
	    form.addEventListener('submit', function (event) {
	        // Lấy tất cả các hàng (tr) trong bảng
	        var rows = document.querySelectorAll('#myTableDX tr');
	        
	        // Kiểm tra xem có hàng nào được chọn hay không
	        var selectedRow = Array.from(rows).find(row => row.classList.contains('selected'));
	        console.log(selectedRow);
	        // Nếu không có hàng nào được chọn, chặn việc nộp form và hiện thông báo
	        if (!selectedRow) {
	            event.preventDefault(); // Chặn việc nộp form
	            alert('Vui lòng chọn một hàng trước khi chấp nhận.');
	        }
	    });
	});
	var settingsmenu = document.querySelector(".settings-menu");
	function settingsMenuToggle() {
		settingsmenu.classList.toggle("settings-menu-height");
	}

	
	function confirmDelete() {
		// Kiểm tra xem người dùng có muốn xóa không
		var userConfirmed = confirm("Bạn có muốn xóa không?");

		// Xử lý theo quyết định của người dùng
		if (userConfirmed) {
			alert("Đã xóa!");
			// Thêm mã xóa ở đây nếu cần
		} else {
			alert("Không xóa.");
			// Thêm mã khi không xóa ở đây nếu cần
		}
	}


	function focusChinhSua(row) {
	    var rows = document.querySelectorAll('#myTableDX tr');
	    rows.forEach(function (r) {
	        r.classList.remove('selected');
	    });

	    // Chọn hàng được click
	    row.classList.add('selected');
		// Lấy tất cả các hàng trong bảng
		var rows = document.getElementById("myTableDX")
				.getElementsByTagName("tr");

		// Đặt màu nền của tất cả các hàng về mặc định (trắng)
		for (var i = 0; i < rows.length; i++) {
			rows[i].style.backgroundColor = "";
			// Đặt màu nền của hàng được nhấp vào thành màu tím nhạt
			row.style.backgroundColor = "lavender";
			const status =row.querySelectorAll("p")[4].textContent;
			const madx =row.querySelectorAll("p")[0].textContent;
			var btn = document.getElementById("chinhSuaDeXuat");
	
		 	btn.action = '<%=request.getContextPath()%>/DeXuatDeTai/showedit?madx='+ madx;
			btn.value = madx;
			console.log(btn.action);
		}
	}
	function focusDangKy123(row) {
		// Lấy tất cả các hàng trong bảng
		var rows = document.getElementById("myTableDK")
			.getElementsByTagName("tr");

		// Đặt màu nền của tất cả các hàng về mặc định (trắng)
		for (var i = 0; i < rows.length; i++) {
			rows[i].style.backgroundColor = "";
		}
		// Đặt màu nền của hàng được nhấp vào thành màu tím nhạt
		row.style.backgroundColor = "lavender";
		const status = row.cells[7].innerText;
		const madx = row.cells[0].innerText;
		document.getElementById("madon").value = madx;
		var btn = document.getElementById("btn-DK");
		var box = document.getElementById("hide-box");
		console.log(status);
		if (status == "Đã duyệt") {		
			btn.style.display = "block";
		}
		else {
			btn.style.display = "none";
		}
		var sua = row.querySelector(".cttv");
		console.log(sua);
		if(status != "Đã duyệt")
			{				
				sua.href="";
			}
			
	}
</script>
</html>