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
<style >
.container2 {
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }
</style>
</head>
<body>
<% String error_login = request.getAttribute("error_login")+"";
error_login = (error_login.equals("null"))?"":error_login;
	
%>
	<div class="container2">
	<form action="DangNhap" method="post">
	<h1 class="text-center mb-3">Dang Nhap Tai Khoan</h1>
	<div class="text-danger mb-3"><%=error_login %></div>
	<div class="form-group mb-2">
            <label for="username">Tên đăng nhập:</label>
            <input type="text" class="form-control" id="username"  name="username" placeholder="Nhập tên đăng nhập">
          </div>
          <div class="form-group mb-2">
            <label for="password">Mật khẩu:</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="Nhập mật khẩu">
          </div>
          <button type="submit" class="btn btn-primary mb-2">Đăng Nhập</button>
          <div class=""><p>Neu Ban Chua Co Tai Khoan Hay <a class ="primary-link" href="dangkitaikhoan.jsp">Dang Ki</a></p></div>
	</form>
	</div>
</body>
</html>