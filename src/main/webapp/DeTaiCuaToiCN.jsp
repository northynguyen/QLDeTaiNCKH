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
<script src="../Access/Style/Js/DeTaiCuaToi.js" defer></script>
<script src="Access/Style/Js/DeTaiCuaToi.js" defer></script>
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
		<a href="<%=request.getContextPath()%>/detaicuatoi/new"> Nhan di</a>
		<a href="<%=request.getContextPath()%>/detaicuatoi/new2"> Nhan di a</a>
		<div class="main_content">
			<div class="form form-DeTaiCN">
				<div class="form-title">
					<h1>ĐỀ TÀI CỦA TÔI</h1>
					<i class="fa fa-refresh" aria-hidden="true"></i>
				</div>
				<hr></hr>
				<form class="login-form" id="chinhSuaDeXuat" name="madx"
					method="post" action="">
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
											<c:out value="${DeXuat.getNgayDeXuat()}" />
										</p></td>
									<td><p>
											<c:out value="${DeXuat.getKinhPhi()}" />
										</p></td>
									<td><a href=""> Download</a></td>
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
					action="<%=request.getContextPath()%>/....?maDK=${maDK}">
					<h2>ĐĂNG KÝ ĐỀ TÀI</h2>
					<div class="table-DeTai" id="dangKy">
						<table id="myTableDK">
							<tr class="columns-title">
								<th>Mã đề tài</th>
								<th>Tên đề tài</th>
								<th>Ngày duyệt đề xuất</th>
								<th>Kinh phí</th>
								<th>File mô tả đề tài</th>
								<th>Thành viên</th>
								<th>Trạng thái</th>
							</tr>
							<tr onclick="focusDangKi(this)">
								<td>
									<p>5</p>
								</td>
								<td>
									<p>Đăng tải các bình luận</p>
								</td>
								<td>
									<p>Đăng tải các bình luận</p>
								</td>
								<td>
									<p>Đăng tải các bình luận</p>
								</td>
								<td><a href="">Download</a></td>
								<td><a style="text-decoration: underline; color: blue;">Chi
										tiết thành viên</a></td>
								<td class="bg-green">
									<p>Đã duyệt</p>
								</td>
							</tr>
							<c:forEach var="Duyet" items="${listCNDangKy}">
								<tr onclick="focusDangKi(this)">
									<td><p>
											<c:out value="${Duyet.getMaDeXuatDeTai()}" />
										</p></td>
									<td><p>
											<c:out value="${Duyet.getTenDeTai()}" />
										</p></td>
									<td><p>
											<c:out value="${Duyet.getNgayDeXuat()}" />
										</p></td>
									<td><p>
											<c:out value="${Duyet.getKinhPhi()}" />
										</p></td>
									<td><a href=""> Download</a></td>
									<td><a style="text-decoration: underline; color: blue;">Chi
										tiết thành viên</a></td>
									<td><p>
											<c:out value="${Duyet.getGhiChu()}" />
										</p></td>
							</c:forEach>
						</table>
					</div>
					<button id="btn-DK" style="display: none;" type="submit">CHỈNH
						SỬA ĐỀ XUẤT</button>
				</form>


				<div class="hide-list" id="hide-box" style="display: none;">
					<div class="SVThamGia" style="flex: 1;">

						<div class="deco topdeco"></div>


						<section class="list-wrap">

							<h2>Thành viên nghiên cứu</h2>
							<input type="text" id="search-text" placeholder="search"
								class="search-box"> <span class="list-count"></span>


							<ul id="list">
								<li class="in">
									<p>Trịnh Thu Phương</p>
									<p>Coder</p> <a>21110611</a> <i onclick="confirmDelete()"
									class="fa fa-trash" aria-hidden="true"></i>
								</li>
								<li class="in">
									<p>Hoàng Công Thiện</p>
									<p>Coder</p> <a>21110611</a> <i onclick="confirmDelete()"
									class="fa fa-trash" aria-hidden="true"></i>
								</li>
								<li class="in">
									<p>Nguyễn Hữu Thoại</p>
									<p>Coder</p> <a>21110611</a> <i onclick="confirmDelete()"
									class="fa fa-trash" aria-hidden="true"></i>
								</li>
								<li class="in">
									<p>Phạm Bá Thành</p>
									<p>Coder</p> <a>21110611</a> <i onclick="confirmDelete()"
									class="fa fa-trash" aria-hidden="true"></i>
								</li>
								<li class="in">
									<p>Trịnh Thu Phương</p>
									<p>Coder</p> <a>21110611</a> <i onclick="confirmDelete()"
									class="fa fa-trash" aria-hidden="true"></i>
								</li>

								<span class="empty-item">no results</span>
							</ul>
						</section>


					</div>
					<div class="SV" style="flex: 1;">
						<h2>Thêm thành viên</h2>
						<form>
							<p>Chọn sinh viên</p>
							<a href="">Mở danh sách</a>

							<p style="padding-top: 20px">Vai trò</p>
							<select class="select" name="VaiTro">
								<option value="Coder">Coder</option>
								<option value="NghienCuu">Nghiên cứu</option>
								<option value="-">Other</option>
							</select>
							<button type="submit">THÊM</button>
						</form>
					</div>
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
		}
		// Đặt màu nền của hàng được nhấp vào thành màu tím nhạt
		row.style.backgroundColor = "lavender";
		const status =row.querySelectorAll("p")[4].textContent;
		const madx =row.querySelectorAll("p")[0].textContent;
		var btn = document.getElementById("chinhSuaDeXuat");

	 btn.action = '<%=request.getContextPath()%>/DeXuatDeTai/showedit?madx='+ madx;
		btn.value = madx;
		console.log(btn.action);

	}
	function focusDangKi(row) {

		// Lấy tất cả các hàng trong bảng
		var rows = document.getElementById("myTableDK")
				.getElementsByTagName("tr");

		// Đặt màu nền của tất cả các hàng về mặc định (trắng)
		for (var i = 0; i < rows.length; i++) {
			rows[i].style.backgroundColor = "";
		}
		// Đặt màu nền của hàng được nhấp vào thành màu tím nhạt
		row.style.backgroundColor = "lavender";
		const status =row.querySelectorAll("p")[4].textContent;
		const madx =row.querySelectorAll("p")[0].textContent;
		var box = document.getElementById("DK");
		var btn= document.getElementById("btn-DK");
		var box = document.getElementById("hide-box");
		if(status=="Đã duyệt")
		{
			box.action = '<%=request.getContextPath()%>/DeXuatDeTai/showedit?madx='+ madx;
			box.value = madx;
			console.log(btn.value);
			btn.style.display = "block";
			
			box.style.display = "flex";
		}
		else{
			btn.style.display = "none";
			box.style.display = "none";
		}


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
/*  	function toggleHideBox() {
		var box = document.getElementById("hide-box");
		if (box.style.display == "none") {
			box.style.display = "flex";
		} else {
			box.style.display = "none";
		}

	}  */
	
$(document).ready(function() {

    var jobCount = $('#list .in').length;
    $('.list-count').text(jobCount + ' items');
      
    
    $("#search-text").keyup(function () {
       //$(this).addClass('hidden');
    
      var searchTerm = $("#search-text").val();
      var listItem = $('#list').children('li');
    
      
      var searchSplit = searchTerm.replace(/ /g, "'):containsi('")
      
        //extends :contains to be case insensitive
    $.extend($.expr[':'], {
    'containsi': function(elem, i, match, array)
    {
      return (elem.textContent || elem.innerText || '').toLowerCase()
      .indexOf((match[3] || "").toLowerCase()) >= 0;
    }
  });
      
      
      $("#list li").not(":containsi('" + searchSplit + "')").each(function(e)   {
        $(this).addClass('hiding out').removeClass('in');
        setTimeout(function() {
            $('.out').addClass('hidden');
          }, 300);
      });
      
      $("#list li:containsi('" + searchSplit + "')").each(function(e) {
        $(this).removeClass('hidden out').addClass('in');
        setTimeout(function() {
            $('.in').removeClass('hiding');
          }, 1);
      });
      
    
        var jobCount = $('#list .in').length;
      $('.list-count').text(jobCount + ' items');
      
      //shows empty state text when no jobs found
      if(jobCount == '0') {
        $('#list').addClass('empty');
      }
      else {
        $('#list').removeClass('empty');
      }
      
    });
  
    
                    
       /*  
       An extra! This function implements
       jQuery autocomplete in the searchbox.
       Uncomment to use :)
       
       
   function searchList() {                
      //array of list items
      var listArray = [];
    
       $("#list li").each(function() {
      var listText = $(this).text().trim();
        listArray.push(listText);
      });
      
      $('#search-text').autocomplete({
          source: listArray
      });
      
      
    }
                                     
    searchList();
  */
                      
  });

</script>
</html>