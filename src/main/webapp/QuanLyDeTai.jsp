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
		<a href="<%=request.getContextPath()%>/quanlydetai/new"> Nhan di</a>
		<div class="main_content">
			<div class="form form-DeTaiCN">
				<form class="login-form">
					<div class="form-title">
						<h1>QUẢN LÝ ĐỀ TÀI</h1>
						<i class="fa fa-refresh" aria-hidden="true"></i>
					</div>
					<hr></hr>


					<div class="table-DeTai">
						<table id="myTable">
							<tr class="columns-title">
								<th>Mã đề tài</th>
								<th>Tên đề tài</th>
								<th>Kinh phí</th>
								<th>File mô tả</th>
								<th>Trạng thái</th>
							</tr>

							<c:forEach var="DeTai" items="${listDeTai}">
								<tr onclick="changeBackgroundColor(this)">
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
									<td><p>
											<c:out value="${DeTai.getTrangThai()}" />
										</p></td>
								</tr>
							</c:forEach>
						</table>

					</div>

				</form>
				
				<button onclick=" toggleHideBox('Thêm đề tài'); disableButton();" >THÊM ĐỀ TÀI</button>
				<button onclick=" toggleHideBox('Sửa đề tài');" disabled class="btn_disable" id="btn_sua">SỬA ĐỀ TÀI</button>
				<form style="width: 300px; display: inline-block;" 
				action="<%=request.getContextPath()%>/quanlydetai/delete"
				accept-charset="UTF-8" method="POST">
				<input type="hidden" id="madetaiInput" name="madetai" />
					<button disabled class="btn_disable" id="btn_xoa">XÓA ĐỀ TÀI</button>
				</form>
				
				<div class="hide-list" id="hide-box" style="display: none;">
					<div class="SV" style="flex: 1;">
						<h2 id="heading"></h2>
						<form  id = "myform"  method="post">
							<input type="hidden" id="madetaiInput1" name="madetai" />
							<p>Tên đề tài</p>
							<input id="tenDeTaiInput" type="text" placeholder="Tên đề tài" name="tendetai" required/>
							<p>Kinh phí</p>
							<input id="kinhPhiInput" type="text" placeholder="Kinh phí" name="kinhphi" required/>
							<p>File mô tả</p>
							<input id="fileMoTaInput" type="file" placeholder="Chọn tệp" name="chontep" />
							<p>Trạng thái</p>
							<select id="trangThaiInput" class="select"  name="trangthai" required>
								<option value="đã đăng ký">đã đăng ký</option>
								<option value="chưa đăng ký">chưa đăng ký</option>
							</select>
							<button id="buttonAdd" type="submit"></button>
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
		var buttonName = document.getElementById("heading").innerText;
		var madetai = row.cells[0].innerText;
		document.getElementById("madetaiInput").value = madetai;
		document.getElementById("madetaiInput1").value = madetai;
		// Đặt màu nền của tất cả các hàng về mặc định (trắng)
		for (var i = 0; i < rows.length; i++) {
			rows[i].style.backgroundColor = "";
		}
		// Đặt màu nền của hàng được nhấp vào thành màu tím nhạt
		row.style.backgroundColor = "lavender";
		 if (buttonName === "Sửa đề tài") {
		        addTextToTextbox(row);
		    }
		 removedisableButton();
	}
	function addTextToTextbox(row) {
		var tenDeTai = row.cells[1].innerText;
		var kinhPhi = row.cells[2].innerText;
		var trangThai = row.cells[4].innerText;
		var fileMoTa = row.cells[3].innerText;
		var heading = document.getElementById("heading");
		var buttonAdd = document.getElementById("buttonAdd");
		// Update the form fields with the captured values
		document.getElementById("tenDeTaiInput").value = tenDeTai;
		document.getElementById("kinhPhiInput").value = kinhPhi;
		var trangThaiInput = document.getElementById("trangThaiInput");
		trangThaiInput.value = trangThai;
	}
	function settingsMenuToggle() {
		settingsmenu.classList.toggle("settings-menu-height");
	}
	function toggleHideBox(buttonName) {
		var box = document.getElementById("hide-box");
		var myForm = document.getElementById("myform"); 
		if (box.style.display == "none") {
			box.style.display = "flex";
			heading.innerText = buttonName;
			if(buttonName=="Sửa đề tài")
			{
				buttonAdd.innerText= "Sửa";
				myForm.action = "http://localhost:8080/QLDeTaiNCKH/quanlydetai/update";
			}			
			else
				{
					buttonAdd.innerText= "Thêm";
					myForm.action = "http://localhost:8080/QLDeTaiNCKH/quanlydetai/add";
				}
		} else {
			box.style.display = "none";
		}
		document.getElementById("tenDeTaiInput").value = "";
	    document.getElementById("kinhPhiInput").value = "";
	    document.getElementById("trangThaiInput").value = "";
	}
	function removedisableButton()
	{
		var sua = document.getElementById("btn_sua");
		sua.disabled = false;
		sua.classList.remove('btn_disable');
		
		var xoa = document.getElementById("btn_xoa");
		xoa.disabled = false;
		xoa.classList.remove('btn_disable');
	}
	function disableButton()
	{
		var sua = document.getElementById("btn_sua");
		sua.disabled = true;
		sua.classList.add('btn_disable');
		
		var xoa = document.getElementById("btn_xoa");
		xoa.disabled = true;
		xoa.classList.add('btn_disable');
	}
</script>
</html>