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
 <nav class="sidebar locked">
      <div class="logo_items flex">
        <span class="nav_image">
          <img src="https://scontent.fsgn5-8.fna.fbcdn.net/v/t1.15752-9/398212517_358697683311773_2464055266940039865_n.jpg?_nc_cat=109&ccb=1-7&_nc_sid=8cd0a2&_nc_eui2=AeHT2VizBNsGjxQTes0CWJXNlkwAk13JIdKWTACTXckh0sCBsXKyq9nTcnIr1xXccWohGCcqfhgWgI6pD9rJcm-B&_nc_ohc=cTnh5a_Hsu4AX8y7L8o&_nc_ht=scontent.fsgn5-8.fna&oh=03_AdS70Aux-3uIGVnHKEpzvKIbas3Yeh7r9HGXoxFM3z33tQ&oe=658A97A7" alt="logo_img" />
        </span>
        <span class="logo_name">HCMUTE</span>
        <i class="bx bx-lock-alt" id="lock-icon" title="Unlock Sidebar"></i>
        <i class="bx bx-x" id="sidebar-close"></i>
      </div>

      <div class="menu_container">
         <div class="sidebar_profile flex">
          <span class="nav_image">
            <img src="images/profile.jpg" alt="logo_img" />
          </span>
          <div class="data_text">
            <span class="name">David Oliva</span>
            <span class="email">david@gmail.com</span>
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
                <span>Overview</span>
              </a>
            </li>
            <li class="item">
              <a href="#" class="link flex">
                <i class="bx bx-grid-alt"></i>
                <span>All Projects</span>
              </a>
            </li>
          </ul>

          <ul class="menu_item">
            <div class="menu_title flex">
              <span class="title">Editor</span>
              <span class="line"></span>
            </div>
            <li class="item">
              <a href="#" class="link flex">
                <i class="bx bxs-magic-wand"></i>
                <span>Magic Build</span>
              </a>
            </li>
            <li class="item">
              <a href="#" class="link flex">
                <i class="bx bx-folder"></i>
                <span>New Projects</span>
              </a>
            </li>
            <li class="item">
              <a href="#" class="link flex">
                <i class="bx bx-cloud-upload"></i>
                <span>Upload New</span>
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