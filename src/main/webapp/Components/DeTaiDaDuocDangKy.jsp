<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<link rel="stylesheet" href="../Access/Style/Css/LeftSideBar.css" />
<link rel="stylesheet" href="../Access/Style/Css/Root/Root.css" />
<link rel="stylesheet" href="../Access/Style/Css/Login.css" />
<link rel="stylesheet" href="../Access/Style/Css/formP.css" />
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
				<form class="login-form" id="daDK" method="post" enctype='multipart/form-data' action="<%=request.getContextPath()%>/download">
					<div class="form-title">
						<h1>ĐỀ TÀI ĐÃ ĐĂNG KÝ</h1>
						<i class="fa fa-refresh" aria-hidden="true"></i>
					</div>
					<hr></hr>


					<div class="table-DeTai">
						<table id="myTableDaDK">
							<tr class="columns-title">
								<th>Mã đơn</th>
								<th>Mã đề tài</th>
								<th>Mã chủ nhiệm</th>
								<th>Mã người duyệt</th>
								<th>File quyết định</th>	
								<th>Mã thời gian</th>	
								<th>Ghi chú</th>
								<th>Trạng thái</th>	
							</tr>
  					<c:forEach var="line" items="${ddk}">
							<tr  onclick="focusDaDK(this)">
								<td>
									<input style="display:none" name="maDon" value="${line.getMaDon()}">
									<p>${line.getMaDon()}</p>
								</td>
								<td>
									<p>${line.getMaDeTai()}</p>
								</td>
								<td>
									<p>${line.getMaChuNhiem()}</p>
								</td>
								<td>
									<p>${line.getMaChuNhiem()}</p>
								</td>
								<td >
						
									<a href="<%=request.getContextPath()%>/download/fileQuyetDinh?maDon=${line.getMaDon()}" >Download</a>
								</td>
								<td>
									<p>${line.getMaThoiGian()}</p>
								</td>
								<td>
									<p>${line.getGhiChu()}</p>
								</td>
								<td><p>${line.getTrangThai()}</p></td>
							</tr >
							
					</c:forEach>	
						</table>
					</div>
					<button>CHI TIẾT</button>
				</form>


			</div>
			<!--  IMPORT CODE PHẦN NÀY -->
		</div>
		</div>
</body>
<script>
document.addEventListener('DOMContentLoaded', function () {
    var form = document.getElementById('daDK');
    form.addEventListener('submit', function (event) {
        // Lấy tất cả các hàng (tr) trong bảng
        var rows = document.querySelectorAll('#myTableDaDK tr');
        
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
	function focusDaDK(row) {
	    var rows = document.querySelectorAll('#myTableDaDK tr');
	    rows.forEach(function (r) {
	        r.classList.remove('selected');
	    });

	    // Chọn hàng được click
	    row.classList.add('selected');
		// Lấy tất cả các hàng trong bảng
		var rows = document.getElementById("myTableDaDK").getElementsByTagName("tr");

		// Đặt màu nền của tất cả các hàng về mặc định (trắng)
		for (var i = 0; i < rows.length; i++) {
			rows[i].style.backgroundColor = "";
		}
		// Đặt màu nền của hàng được nhấp vào thành màu tím nhạt
		row.style.backgroundColor = "lavender";
		const madx =row.querySelectorAll("p")[0].textContent;
		var btn = document.getElementById("daDK");

	  	btn.action = '<%=request.getContextPath()%>/DeTaiDaDangKy/chitiet?maDon='+ madx;
		btn.value = madx;
		console.log(btn.value); 

	}
	
</script>
</html>