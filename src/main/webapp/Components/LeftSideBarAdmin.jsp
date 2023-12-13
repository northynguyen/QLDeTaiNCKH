<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@page import="Models.ThongTinTaiKhoan"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />   
    <link rel="stylesheet" href="../Access/Style/Css/LeftSideBar.css" />
    <link rel="stylesheet" href="../Access/Style/Css/Root/Root.css" />
    <!-- Boxicons CSS -->
    <link flex href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css" rel="stylesheet" />
    <script src="../Access/Style/Js/LeftSideBar.js" defer></script>
     <script src="Access/Style/Js/LeftSideBar.js" defer></script>
  </head>
<body>
<%
	ThongTinTaiKhoan account = (ThongTinTaiKhoan) session.getAttribute("account");
	%>
 <nav class="sidebar locked">
      <div class="logo_items flex">
        <span class="nav_image">
          <img src="https://images.squarespace-cdn.com/content/v1/5930dc9237c5817c00b10842/1557980730821-E0BL40VN22LDSYKQH91O/images.png" alt="logo_img" />
        </span>
        <span class="logo_name">HCMUTE</span>
        <i class="bx bx-lock-alt" id="lock-icon" title="Unlock Sidebar"></i>
        <i class="bx bx-x" id="sidebar-close"></i>
      </div>

      <div class="menu_container">
         <div class="sidebar_profile flex">
          <span class="nav_image">
            <img src="https://cdn.pixabay.com/photo/2017/07/18/23/23/user-2517433_640.png?fbclid=IwAR1r1c6ynegByu0GEhclZBf-LuAwQumotH1wwJxlO5xLYHciVhXABPRZ6Ns" alt="logo_img" />
          </span>
          <div class="data_text">
            <span class="name"><%=account.getHoTen()%></span>
            <span class="email">ADMIN</span>
          </div>
        </div>
        <div class="menu_items">
          <ul class="menu_item">
            <div class="menu_title flex">
              <span class="title">Chức năng</span>
              <span class="line"></span>
            </div>
            <li class="item">
              <a href="#" class="link flex">
                <i class="bx bx-home-alt"></i>
                <span>Trang chủ</span>
              </a>
            </li>
            <li class="item">
              <a href="<%=request.getContextPath() %>/QuanLyDongMoDK.jsp" class="link flex">
                <i class="bx bx-grid-alt"></i>
                <span>Quản lý đóng mở</span>
              </a>
            </li>
          </ul>

          <ul class="menu_item">

            <li class="item">
              <a href="<%=request.getContextPath() %>/TaoTaiKhoan.jsp" class="link flex">
                <i class="bx bxs-magic-wand"></i>
                <span>Tạo tài khoản</span>
              </a>
            </li>
            <li class="item">
              <a href="<%=request.getContextPath() %>/TTSV/show" class="link flex">
                <i class="bx bx-folder"></i>
                <span>Quản lý sinh viên</span>
              </a>
            </li>
            <li class="item">
              <a href="<%=request.getContextPath() %>/DeTai/showkhoa" class="link flex">
                <i class="bx bx-cloud-upload"></i>
                <span>Quản lý khoa</span>
              </a>
            </li>
            <li class="item">
              <a href="<%=request.getContextPath() %>/DeTai/showthoigian" class="link flex">
                <i class="bx bx-cloud-upload"></i>
                <span>Quản lý thời gian</span>
              </a>
            </li>
          </ul>

        </div>

      </div>
    </nav>
</body>
  <script >
  var settingsmenu = document.querySelector(".settings-menu");
  function settingsMenuToggle(){
	    settingsmenu.classList.toggle("settings-menu-height");
	}
  </script>
</html>