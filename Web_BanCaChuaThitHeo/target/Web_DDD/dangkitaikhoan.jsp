<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
	integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"
	integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS"
	crossorigin="anonymous"></script>
<style>
.container {
	display: flex;
	justify-content: center;
	align-items: center;
}

.form-container {
	max-width: 600px;
	width: 100%;
	padding: 20px;
	border: 1px solid #ccc;
	border-radius: 8px;
}

.size {
	width: 15px;
	height: 15px;
}
</style>

<script >
function hienThiMatKhau() {
	var password = document.getElementById("password");
	var hienThi = document.getElementById("hienThi");
	var password2 = document.getElementById("confirm-password");
	var hienThi2 = document.getElementById("hienThi-confirm");
	if(password.type =="password"){
		password.type="text";
		password2.type="text";
		hienThi2.src="img/view.png";
		hienThi.src ="img/view.png";
	}else {
		password.type="password";
		hienThi.src ="img/hidden.png";
		password2.type="password";
		hienThi2.src="img/hidden.png";
	}
}
</script>
</head>
<body>
	<%
	String err_password = request.getAttribute("err_password") + "";
	err_password = (err_password.equals("null")) ? "" : err_password;

	String err_username = request.getAttribute("err_username") + "";
	err_username = (err_username.equals("null")) ? "" : err_username;
	
	String username = request.getAttribute("username")+"";
	username = (username.equals("null"))?"" : username;
	
	String password = request.getAttribute("password")+"";
	password = (password.equals("null"))?"" : password;
	
	String confirmPassword = request.getAttribute("confirm-password")+"";
	confirmPassword = (confirmPassword.equals("null"))?"" : confirmPassword;
	
	String fullName = request.getAttribute("fullName")+"";
	fullName = (fullName.equals("null"))?"" : fullName;
	
	String phone = request.getAttribute("phone")+"";
	phone = (phone.equals("null"))?"" : phone;
	
	String email  = request.getAttribute("email")+"";
	email  = (email.equals("null"))?"" : email;
	
	String address = request.getAttribute("address")+"";
	address = (address.equals("null"))?"" :address;
	%>
	<div class="container">

		<form class="form-container" action="DangKiTaiKhoan" method="post">
			<h1 class="text-center">Đăng ký tài khoản</h1>
			<div class="mb-3">
				<label for="username" class="form-label">Tên đăng nhập</label> <input
					type="text" class="form-control" id="username" name="username"
					placeholder="Nhập tên đăng nhập" value="<%=username %>">
				<div class="text-danger"><%=err_username%></div>
			</div>
			<div class="mb-3">
				<label for="password" class="form-label">Mật khẩu</label>
				<div class="input-group">
					<input type="password" class="form-control" id="password"
						name="password" placeholder="Nhập mật khẩu"
						aria-describedby="button-addon2" value="<%=password %>">
					<button class="btn btn-outline-secondary border border-start-0"
						type="button" id="button-addon2" onclick="hienThiMatKhau()">
						<img class="size" id="hienThi" alt="" src="img/hidden.png">
					</button>
				</div>
			</div>
			<div class="mb-3">
				<label for="confirm-password" class="form-label">Nhập lại
					mật khẩu</label><div class="input-group">
					<input type="password" class="form-control" id="confirm-password"
						name="confirm-password" placeholder="Nhập mật khẩu"
						aria-describedby="button-addon2" value="<%=confirmPassword %>">
					<button class="btn btn-outline-secondary border border-start-0"
						type="button" id="button-addon2" onclick="hienThiMatKhau()" >
						<img class="size" id="hienThi-confirm" alt="" src="img/hidden.png">
					</button>
					
				</div>
				<div class="text-danger"><%=err_password %></div>
			</div>
			<div class="mb-3">
				<label for="full-name" class="form-label">Họ và tên</label> <input
					type="text" class="form-control" id="full-name" name="full-name"
					placeholder="Nhập họ và tên" value="<%=fullName %>">
			</div>
			<div class="mb-3">
				<label for="phone" class="form-label">Số điện thoại</label> <input
					type="tel" class="form-control" id="phone" name="phone"
					placeholder="Nhập số điện thoại" value="<%=phone %>">
			</div>
			<div class="mb-3">
				<label for="email" class="form-label">Email</label> <input
					type="email" class="form-control" id="email" name="email"
					placeholder="Nhập email" value="<%=email %>">
			</div>
			<div class="mb-3">
				<label for="address" class="form-label">Địa chỉ</label>
				<textarea class="form-control" id="address" name="address" rows="3"
					placeholder="Nhập địa chỉ"><%=address %></textarea>
			</div>
			<button type="submit" class="btn btn-primary">Đăng ký</button>
		</form>
	</div>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.0.2/js/bootstrap.bundle.min.js"></script>
</body>
</html>