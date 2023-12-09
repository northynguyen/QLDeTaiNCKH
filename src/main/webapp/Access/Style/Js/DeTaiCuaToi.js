document.addEventListener('DOMContentLoaded', function () {
	var form = document.getElementById('chinhSuaDeXuat');
	form.addEventListener('submit', function (event) {
		// Lấy tất cả các hàng (tr) trong bảng
		var rows = document.querySelectorAll('#myTableDX tr');

		// Kiểm tra xem có hàng nào được chọn hay không
		var selectedRow = Array.from(rows).find(row => row.classList.contains('selected'));
		console.log(selectedRow);
		// Nếu không có hàng nào được chọn, chặn việc nộp form và hiện thông báo
		if (!selectedRow) {
			event.preventDefault(); // Chặn việc nộp form
			alert('Vui lòng chọn một hàng trước khi chấp nhận.');
		}
	});
});
var settingsmenu = document.querySelector(".settings-menu");
function settingsMenuToggle() {
	settingsmenu.classList.toggle("settings-menu-height");
}

function focusChinhSua(row) {
	var rows = document.querySelectorAll('#myTableDX tr');
	rows.forEach(function (r) {
		r.classList.remove('selected');
	});

	// Chọn hàng được click
	row.classList.add('selected');
	// Lấy tất cả các hàng trong bảng
	var rows = document.getElementById("myTableDX")
		.getElementsByTagName("tr");

	// Đặt màu nền của tất cả các hàng về mặc định (trắng)
	for (var i = 0; i < rows.length; i++) {
		rows[i].style.backgroundColor = "";
	}
	// Đặt màu nền của hàng được nhấp vào thành màu tím nhạt
	row.style.backgroundColor = "lavender";
	const status = row.querySelectorAll("p")[4].textContent;
	const madx = row.querySelectorAll("p")[0].textContent;
	var btn = document.getElementById("chinhSuaDeXuat");

	btn.action = '<%=request.getContextPath()%>/DeXuatDeTai/showedit?madx=' + madx;
	btn.value = madx;
	console.log(btn.action);
	console.log(btn.value);

}
function focusDangKi(row) {

	// Lấy tất cả các hàng trong bảng
	var rows = document.getElementById("myTableDK")
		.getElementsByTagName("tr");

	// Đặt màu nền của tất cả các hàng về mặc định (trắng)
	for (var i = 0; i < rows.length; i++) {
		rows[i].style.backgroundColor = "";
	}
	// Đặt màu nền của hàng được nhấp vào thành màu tím nhạt
	row.style.backgroundColor = "lavender";
	const status = row.querySelectorAll("p")[4].textContent;
	const madx = row.querySelectorAll("p")[0].textContent;
	var box = document.getElementById("DK");
	var btn = document.getElementById("btn-DK");
	var box = document.getElementById("hide-box");
	if (status == "Đã duyệt") {
		box.action = '<%=request.getContextPath()%>/DeXuatDeTai/showedit?madx=' + madx;
		box.value = madx;
		console.log(btn.value);
		btn.style.display = "block";

		box.style.display = "flex";
	}
	else {
		btn.style.display = "none";
		box.style.display = "none";
	}


}
function confirmDelete() {
	// Kiểm tra xem người dùng có muốn xóa không
	var userConfirmed = confirm("Bạn có muốn xóa không?");

	// Xử lý theo quyết định của người dùng
	if (userConfirmed) {
		alert("Đã xóa!");
		// Thêm mã xóa ở đây nếu cần
	} else {
		alert("Không xóa.");
		// Thêm mã khi không xóa ở đây nếu cần
	}
}
/*  	function toggleHideBox() {
		var box = document.getElementById("hide-box");
		if (box.style.display == "none") {
			box.style.display = "flex";
		} else {
			box.style.display = "none";
		}

	}  */

$(document).ready(function () {

	var jobCount = $('#list .in').length;
	$('.list-count').text(jobCount + ' items');


	$("#search-text").keyup(function () {
		//$(this).addClass('hidden');

		var searchTerm = $("#search-text").val();
		var listItem = $('#list').children('li');


		var searchSplit = searchTerm.replace(/ /g, "'):containsi('")

		//extends :contains to be case insensitive
		$.extend($.expr[':'], {
			'containsi': function (elem, i, match, array) {
				return (elem.textContent || elem.innerText || '').toLowerCase()
					.indexOf((match[3] || "").toLowerCase()) >= 0;
			}
		});


		$("#list li").not(":containsi('" + searchSplit + "')").each(function (e) {
			$(this).addClass('hiding out').removeClass('in');
			setTimeout(function () {
				$('.out').addClass('hidden');
			}, 300);
		});

		$("#list li:containsi('" + searchSplit + "')").each(function (e) {
			$(this).removeClass('hidden out').addClass('in');
			setTimeout(function () {
				$('.in').removeClass('hiding');
			}, 1);
		});


		var jobCount = $('#list .in').length;
		$('.list-count').text(jobCount + ' items');

		//shows empty state text when no jobs found
		if (jobCount == '0') {
			$('#list').addClass('empty');
		}
		else {
			$('#list').removeClass('empty');
		}

	});



	/*  
	An extra! This function implements
	jQuery autocomplete in the searchbox.
	Uncomment to use :)
    
    
function searchList() {                
   //array of list items
   var listArray = [];
 
	$("#list li").each(function() {
   var listText = $(this).text().trim();
	 listArray.push(listText);
   });
   
   $('#search-text').autocomplete({
	   source: listArray
   });
   
   
 }
								  
 searchList();
*/


});







