<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />   
    <link rel="stylesheet" href="../Access/Style/Css/LeftSideBar.css" />
    <link rel="stylesheet" href="../Access/Style/Css/Root/Root.css" />    
     <link rel="stylesheet" href="../Access/Style/Css/Login.css" />
     <link rel="stylesheet" href="../Access/Style/Css/formP.css" />
    <link rel="stylesheet" href="../Access/Style/Css/TaoThongBao.css" />
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
		<h2>Gửi thông báo</h2>
		
		<div class="info-content">
		<h4 padding-bottom-15px> Chọn người nhận: 
			<select name="gender" id="gioi-tinh" class= "infor-reciever">
				<option value="Hoàng Công Thiện">Hoàng Công Thiện</option>
				<option value="Nguyễn Hữu Thoại">Nguyễn Hữu Thoại</option>
				<option value="Trịnh Thu Phương">Trịnh Thu Phương</option>
			</select>
		</h4>
		<h4 padding-bottom-15px> ID người nhận: 
			<Lable class = "IdLable infor-reciever "> ID1 </Lable>
		</h4>
		<h4 padding-bottom-15px>  Tiêu đề thông báo:
			<input type="text">
		</h4>		
		<h4> Nội dung thông báo:</h4>
			<textarea  cols="100" rows="50"></textarea>
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
  </script>
</html>