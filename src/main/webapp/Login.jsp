<%@ page language="java" contentType="text/html; charset=UTF-8 "
    pageEncoding="UTF-8"%>
<%@page import="Models.ThongTinTaiKhoan"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="Access/Style/Css/Root/Root.css" />
<link rel="stylesheet" href="Access/Style/Css/Login.css" />
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<link flex href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css" rel="stylesheet" />
</head>
<body>

	<%
		String err_login = (String) request.getAttribute("errMsg");
	%>
	<%
		ThongTinTaiKhoan account = (ThongTinTaiKhoan) session.getAttribute("account");
	%>
- 	<%if (account != null) {
		if (account.getRole().equals("Chủ nhiệm")) {
			//response.sendRedirect("./Components/ThongBao.jsp");
	
			 RequestDispatcher dispatcher = request.getRequestDispatcher("/ThongBao/show");
			 dispatcher.forward(request, response);
	
		} else if (account.getRole().equals("Quản lý"))
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ThongBao/create");
			dispatcher.forward(request, response);
	
		}
		else if (account.getRole().equals("Admin")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/TTTK/create");
			dispatcher.forward(request, response);
		}
}
	 %> 

	<div class="login-page">
  <div class="form">
    <form class="fogetPass-form">
<!--       <input type="password" placeholder="password"/> -->
      <input type="email" placeholder="email address"/>
            <p class="message" style="margin-bottom:10px;"> Dfsdiofjsiof</p>
      <button>Lấy lại mật khẩu</button>
      <p class="message"> <a href="#">Đăng nhập</a></p>
    </form> 

    <form class="login-form" action="<%=request.getContextPath()%>/Login" method = "post" accept-charset="UTF-8">  
     <h1>ĐĂNG KÍ ĐỀ TÀI KHOA HỌC </h1>
    <h5>TRƯỜNG ĐẠI HỌC SƯ PHẠM KỸ THUẬT TP.HỒ CHÍ MINH</h5>
      <input name = "username" type="text" placeholder="Tài khoản" required/>
      <input name = "password" type="password" placeholder="Mật khẩu" required/>
      
    <% if (err_login != null) { %>
			  <div style="color: red"><%=err_login %></div>
	<% } %>
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