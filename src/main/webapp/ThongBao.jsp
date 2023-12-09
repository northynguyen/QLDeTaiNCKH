<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="Models.ThongTinTaiKhoan"%>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />   
    
    <link rel="stylesheet" href="Access/Style/Css/Root/Root.css" />    
     <link rel="stylesheet" href="Access/Style/Css/Login.css" />
     <link rel="stylesheet" href="Access/Style/Css/formP.css" />
     <link rel="stylesheet" href="Access/Style/Css/ThongBao.css" />
     <link rel="stylesheet" href="Access/Style/Css/LeftSideBar.css" />
    <!-- Boxicons CSS -->
    <link flex href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css" rel="stylesheet" />
    <script src="Access/Style/Js/LeftSideBar.js" defer></script>
  </head>
  <body>
 	<%
	ThongTinTaiKhoan account = (ThongTinTaiKhoan) session.getAttribute("account");
	%>
	<%if (account == null) {response.sendRedirect(request.getContextPath() + "Login.jsp");} %>  
    
 <jsp:include page="Components/LeftSideBar.jsp" />
<div class="container-main">
 <jsp:include page="Components/NavBar.jsp" />
   
    
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
		<c:forEach var="thongbao" items="${ListthongBao}">
				<tr onclick="changeBackgroundColor(this)">			
					<td onclick=" toggleHideBox(${thongbao.getMaThongBao()}) ">
						<a style="text-decoration: underline;color: blue;" data-id='${hobby.iDhobby}'>${thongbao.getTenThongBao()}</a>
					</td>
					<td>
						<p>Phòng QLĐTKH</p>
					</td>
					<td>
						<p>${thongbao.getNgayThongBao()}</p>
					</td>
				</tr>					
			</c:forEach>				
			</table>
			
			</div>
			<c:forEach var="thongbao" items="${ListthongBao}">
				<div id ="${thongbao.getMaThongBao()}" class="frame-content" ">
				<h3> Nội dung thông báo</h3>
				<div class ="info-content"> 
					<p> ${thongbao.getNoiDung()} </p>
				</div>		
				</div>
			</c:forEach>
		
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
  function toggleHideBox(MaThongBao) {
	  	var remove = document.querySelectorAll(".frame-content");
	  	console.log(remove)
	  	for (var i = 0; i < remove.length; i++) {
	  		remove[i].style.display = "none";
	  	}
		var box = document.getElementById(MaThongBao);
		box.style.display = "block";


	}
  </script>
</html>