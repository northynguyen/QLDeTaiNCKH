<%@ page language="java" contentType="text/html; charset=UTF-8 "
    pageEncoding="UTF-8"%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../Access/Style/Css/Root/Root.css" />
<link rel="stylesheet" href="../Access/Style/Css/Login.css" />
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
 <link flex href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css" rel="stylesheet" />
</head>
<body>
	<div class="login-page">
  <div class="form">
    <form class="fogetPass-form">
<!--       <input type="password" placeholder="password"/> -->
      <input type="text" placeholder="email address"/>
            <p class="message" style="margin-bottom:10px;"> Dfsdiofjsiof</p>
      <button>Lấy lại mật khẩu</button>
      <p class="message"> <a href="#">Đăng nhập</a></p>
    </form> 

    <form class="login-form">  
     <h1>ĐĂNG KÍ ĐỀ TÀI KHOA HỌC </h1>
    <h5>TRƯỜNG ĐẠI HỌC SƯ PHẠM KỸ THUẬT TP.HỒ CHÍ MINH</h5>
      <input type="text" placeholder="Tài khoản"/>
      <input type="password" placeholder="Mật khẩu"/>
      <button>Đăng nhập</button>
      <p class="message">Quên mật khẩu? <a href="#">Lấy lại mật khẩu</a></p>
    </form>
  </div>
</div>
</body>
<script >

$(document).ready(function(){
    $('.message a').click(function(){
    	console.log("hehe");
      $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
    });
  });
</script>
</html>