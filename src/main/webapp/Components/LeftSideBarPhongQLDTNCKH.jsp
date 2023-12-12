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
<link flex href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css"
	rel="stylesheet" />
<script src="../Access/Style/Js/LeftSideBar.js" defer></script>
</head>
<body>
	<%
	ThongTinTaiKhoan account = (ThongTinTaiKhoan) session.getAttribute("account");
	%>
	<nav class="sidebar locked">
		<div class="logo_items flex">
			<span class="nav_image"> <img
				src="https://images.squarespace-cdn.com/content/v1/5930dc9237c5817c00b10842/1557980730821-E0BL40VN22LDSYKQH91O/images.png"
				alt="logo_img" />
			</span> <span class="logo_name">HCMUTE</span> <i class="bx bx-lock-alt"
				id="lock-icon" title="Unlock Sidebar"></i> <i class="bx bx-x"
				id="sidebar-close"></i>
		</div>

		<div class="menu_container">
			<div class="sidebar_profile flex">
				<span class="nav_image"> <img
					src="https://vtv1.mediacdn.vn/zoom/640_400/2023/2/9/090223-twice-16759153857492034544526-crop-16759153913131594780654.jpg"
					alt="logo_img" />
				</span>
				<div class="data_text">
					<span class="name"><%=account.getHoTen()%></span> <span
						class="email">PHÒNG QLDTNCKH</span>
				</div>
			</div>
			<div class="menu_items">
				<ul class="menu_item">
					<div class="menu_title flex">
						<span class="title">Chức năng</span> <span class="line"></span>
					</div>
					<li class="item"><a href="#" class="link flex"> <i
							class="bx bx-home-alt"></i> <span>Trang chủ</span>
					</a></li>
					<li class="item"><a
						href="<%=request.getContextPath()%>/quanlydetai/new"
						class="link flex"> <i class="bx bx-grid-alt"></i> <span>Quản
								lý đề tài</span>
					</a></li>
				</ul>

				<ul class="menu_item">

					<li class="item"><a
						href="<%=request.getContextPath()%>/duyetdetai/new"
						class="link flex"> <i class="bx bxs-magic-wand"></i> <span>Duyệt
								đề tài</span>
					</a></li>
					<li class="item"><a
						href="<%=request.getContextPath()%>/duyetdexuat/new"
						class="link flex"> <i class="bx bxs-magic-wand"></i> <span>Duyệt
								đề xuất</span>
					</a></li>
					<li class="item"><a
						href="<%=request.getContextPath()%>/ThongBao/create"
						class="link flex"> <i class="bx bx-folder"></i> <span>Gửi
								thông báo</span>
					</a></li>
					<li class="item"><a
						href="<%=request.getContextPath()%>/NghiemThu/showall"
						class="link flex"> <i class="bx bx-cloud-upload"></i> <span>Nghiệm
								thu đề tài</span>
					</a></li>
				</ul>

			</div>

		</div>
	</nav>
</body>
<script>
	var settingsmenu = document.querySelector(".settings-menu");
	function settingsMenuToggle() {
		settingsmenu.classList.toggle("settings-menu-height");
	}
</script>
</html>