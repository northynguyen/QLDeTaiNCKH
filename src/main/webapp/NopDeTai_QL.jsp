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

	<jsp:include page="Components/LeftSideBarPhongQLDTNCKH.jsp" />
	<div class="container-main">
		<jsp:include page="Components/NavBar.jsp" />
		<div class="main_content">
			<div class="form form-DeTaiCN">
				<div class="form-title">
					<h1>NGHIỆM THU</h1>
					<i class="fa fa-refresh" aria-hidden="true"></i>
				</div>
				<hr></hr>

				<form class="login-form" id="DK" name="maDK" method="post"
					action="<%=request.getContextPath()%>/NghiemThu/showSubmit">
					<h2>CÁC FILE ĐÃ NỘP</h2>
					<div class="table-DeTai" id="dangKy">
						<table id="myTableDX">
							<tr class="columns-title">
								<th>Mã nộp đề tài</th>
								<th>Mã đề tài</th>
								<th>Mã người nộp</th>
								<th>File báo cáo</th>
								<th>Thời gian nộp</th>
								<th>Mã đợt NCKH</th>
								<th>Ghi chú</th>
								<th>Trạng thái</th>
							</tr>
							<c:forEach var="Duyet" items="${listNop}">
								<tr onclick="focusDangKy123(this)">
									<td><p>
											<c:out value="${Duyet.getMaNopDeTai()}" />
										</p></td>
									<td><p>
											<c:out value="${Duyet.getMaDeTai()}" />
										</p></td>
									<td><p>
											<c:out value="${Duyet.getMaNguoiNop()}" />
										</p></td>
									<td><a
										href="<%=request.getContextPath()%>/download/fileMoTa?maDT=${Duyet.getMaDeTai()}">Download</a></td>
									<td><p>
											<c:out value="${Duyet.getThoiGianNop()}" />
										</p></td>
									<td><p>
											<c:out value="${Duyet.getMaThoiGian()}" />
										</p></td>
									<td><p>
											<c:out value="${Duyet.getGhiChu()}" />
										</p></td>
									<td><p>
											<c:out value="${Duyet.getTrangThai()}" />
										</p></td>
								</tr>
							</c:forEach>
						</table>
					</div>
					<input type="text" id="madon" name="MaDon" style="display: none" value="2">
					<button id="btn-DK" type="submit">NGHIỆM THU</button>
				</form>
			</div>

		</div>
	</div>
	<!--  IMPORT CODE PHẦN NÀY -->
	</div>
</body>

<script>
	document.addEventListener('DOMContentLoaded', function () {
	    var form = document.getElementById('DK');
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


	function focusDangKy123(row) {
		 var rows = document.querySelectorAll('#myTableDX tr');
		    rows.forEach(function (r) {
		        r.classList.remove('selected');
		    });
		    row.classList.add('selected');
		// Lấy tất cả các hàng trong bảng
		var rows = document.getElementById("myTableDX")
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
		console.log(document.getElementById("madon").value );
		
	}
</script>
</html>