<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />   
    <link rel="stylesheet" href="../Access/Style/Css/LeftSideBar.css" />
    <link rel="stylesheet" href="../Access/Style/Css/Root/Root.css" />
    <!-- Boxicons CSS -->
    <link flex href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css" rel="stylesheet" />
    <script src="../Access/Style/Js/LeftSideBar.js" defer></script>
  </head>
<body>

 <!-- Navbar -->
    <nav class="navbar flex">
      <i class="bx bx-menu" id="sidebar-open"></i>
      <h3>ĐẠI HỌC SƯ PHẠM KỸ THUẬT TP.HCM</h3>
      <span class="nav_image" onclick="settingsMenuToggle()">
        <img src="images/profile.jpg" alt="logo_img" />
      </span>
      
   <!--   setting hide -->
    <div class="settings-menu">
        <div id="dark-btn">
          <span></span>
        </div>
        <div class="settings-menu-inner">
          <div class="user-profile">
            <img src="https://i.postimg.cc/cHg22LhR/profile-pic.png" />
            <div style="    padding-left: 10px;">
              <p>Huynh Hong Khanh</p>
              <a href="./InforLogin">See your profile</a>
            </div>
          </div>
          <hr />

          <div class="settings-links">
            <img
              src="https://i.postimg.cc/PJC9GrMb/logout.png"
              class="settings-icon"
            />
            <a href="#"
              >Logout
             </a>
          </div>
        </div>
      </div>
    </nav>
</body>
</html>