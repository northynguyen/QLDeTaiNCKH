<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />   
    
    <link rel="stylesheet" href="../Access/Style/Css/Root/Root.css" />    
     <link rel="stylesheet" href="../Access/Style/Css/Login.css" />
     <link rel="stylesheet" href="../Access/Style/Css/formP.css" />
     <link rel="stylesheet" href="../Access/Style/Css/ThongBao.css" />
     <link rel="stylesheet" href="../Access/Style/Css/LeftSideBar.css" />
    <!-- Boxicons CSS -->
    <link flex href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css" rel="stylesheet" />
    <script src="../Access/Style/Js/LeftSideBar.js" defer></script>
  </head>
  <body>
   
    
 <jsp:include page="LeftSideBar.jsp" />
<div class="container-main">
 <jsp:include page="NavBar.jsp" />
   
    
    <!--  IMPORT CODE PHẦN NÀY -->
<div class="main_content">
	<div class="form form-DeTaiCN">
		<h2> Thông báo</h2>
		<div class="table-DeTai">
			<table id="myTable">
				<tr class="columns-title">
					<th>Tiêu đề</th>
					<th>Người gửi</th>
					<th>Thời gian gửi</th>
				</tr>
	
				<tr onclick="changeBackgroundColor(this)">			
					<td onclick=" toggleHideBox() ">
						<a style="text-decoration: underline;color: blue;" data-id='${hobby.iDhobby}'>Thông báo đề tài đã duyệt</a>
					</td>
					<td>
						<p>Phòng QLĐTKH</p>
					</td>
					<td>
						<p>11/11/2023</p>
					</td>
				</tr>
				<tr onclick="changeBackgroundColor(this)">
					<td onclick=" toggleHideBox() ">
						<a style="text-decoration: underline;color: blue;" data-id='${hobby.iDhobby}'>Thông báo đến hạn nộp đề tài</a>
					</td>
					<td>
						<p>Công Thiện</p>
					</td>
					<td>
						<p>15/10/2023</p>
					</td>
				</tr>
	
			</table>
			</div>
		
		<div id ="frame-content" class="frame-content" ">
			<h3> Nội dung thông báo</h3>
			<div class ="info-content"> 
			<p> Đề tài của bạn đã được duyệt </p>
			<p> Nếu có bất cứ thắc mắc nào hãy phản hồi về email sau: hcmute@gmail.com</p>
			</div>		
		</div>
	</div>
</div>
<!--  IMPORT CODE PHẦN NÀY -->
</div>
  </body>
  <script >
  var settingsmenu = document.querySelector(".settings-menu");
  function settingsMenuToggle(){
	    settingsmenu.classList.toggle("settings-menu-height");
	}
  function toggleHideBox() {
		var box = document.getElementById("frame-content");
		if (box.style.display == "none") {
			box.style.display = "block";
		} else {
			box.style.display = "none";
		}
	}
  </script>
</html>