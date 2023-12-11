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
<script src="../Access/Style/Js/DeTaiCuaToi.js" defer></script>
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
		<div class="main_content">
			<div class="form form-DeTaiCN">
				<div class="form-title">
					<h1>ĐỀ TÀI CỦA TÔI</h1>
					<i class="fa fa-refresh" aria-hidden="true"></i>
				</div>
				<hr></hr>
				<form class="login-form" id="chinhSuaDeXuat" name="madx"
					method="post"
					action="<%=request.getContextPath()%>/DeXuatDeTai/showedit?madx=${madx}">


					<h2>ĐỀ TÀI ĐỀ XUẤT</h2>
					<div class="table-DeTai" id="deTaiDeXuat">
						<table id="myTableDX">
							<tr class="columns-title">
								<th>Mã đơn</th>
								<th>Mã đề tài</th>
								<th>Ngày đề xuất đề tài</th>
								<th>Kinh phí</th>
								<th>File mô tả đề tài</th>
								<th>Ghi Chú</th>
								<th>Trạng thái</th>
							</tr>

							<tr onclick="focusChinhSua(this)">
								<td>
									<p>1</p>
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
								<td>
									<p></p>
								</td>
								<td>
									<p>Chưa duyệt</p>
								</td>
							</tr>
							<tr onclick="focusChinhSua(this)">
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
								<td>
									<p>Đề tài như cưc</p>
								</td>
								<td class="bg-green">
									<p>Từ chối</p>
								</td>
							</tr>

							<tr onclick="focusChinhSua(this)">
								<td>
									<p>30</p>
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
								<td>
									<p></p>
								</td>
								<td>
									<p>Chưa duyệt</p>
								</td>
							</tr>

						</table>
					</div>
					<button type="submit">CHỈNH SỬA ĐỀ XUẤT</button>
				</form>
				
				
				<form class="login-form" id="DK" name="maDK"
					method="post"
					action="<%=request.getContextPath()%>/....?maDK=${maDK}">
					<h2>ĐĂNG KÝ ĐỀ TÀI</h2>
					<div class="table-DeTai" id="dangKy">
						<table id="myTableDK">
							<tr class="columns-title">
								<th>Mã đề tài</th>
								<th>Tên đề tài</th>
								<th>Ngày đề xuất đề tài</th>
								<th>Kinh phí</th>
								<th>File mô tả đề tài</th>
								<th>Thành viên</th>
								<th>Trạng thái</th>
							</tr>

							<tr onclick="focusDangKi(this)">
								<td>
									<p>1</p>
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
								<td><a
									style="text-decoration: underline; color: blue;"
									data-id='${hobby.iDhobby}'>Chi tiết thành viên</a></td>
								<td>
									<p>Chưa duyệt</p>
								</td>
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

							<tr onclick="focusDangKi(this)">
								<td>
									<p>30</p>
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
								<td>
									<p>Chưa duyệt</p>
								</td>
							</tr>

						</table>
					</div>
					<button id="btn-DK" style="display:none; " type="submit">CHỈNH SỬA ĐỀ XUẤT</button>
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
							
							<p style="padding-top:20px">Vai trò</p>
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

</script>
</html>