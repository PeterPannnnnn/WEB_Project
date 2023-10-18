<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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

</head>
<body>
	<div class="container">

		<form class="form-container" action="ThemSanPham" method="post" enctype="multipart/form-data">
			<h1 class="text-center">Thêm sản phẩm</h1>
			<div class="mb-3">
				<label for="productID" class="form-label">Mã Sản Phẩm</label> <input
					type="text" class="form-control" id="productID" name="productID"
					placeholder="Nhập mã sản phẩm">

			</div>
			<div class="mb-3">
				<label for="productName" class="form-label">Tên Sản Phẩm</label> <input
					type="text" class="form-control" id="productName"
					name="productName" placeholder="Nhập tên sản phẩm">

			</div>

			<div class="mb-3">
				<label for="price" class="form-label">Giá Sản Phẩm</label> <input
					type="number" class="form-control" id="price" name="price"
					placeholder="Nhập giá sản phẩm">

			</div>
			<div class="mb-3">
				<label for="img" class="form-label">Hình Ảnh Sản Phẩm</label> <input
					type="file" class="form-control" id="img" name="img"
					placeholder="Nhập mã sản phẩm">

			</div>
			<div class="mb-3">
				<label for="category" class="form-label">Chọn Thể Loại Sản
					Phẩm</label> <select class="form-select" id="category" name="category">
					<c:forEach var="category" items="${categories}">
						<option value="${category.nameCategory}">${category.nameCategory}</option>
					</c:forEach>
				</select>

			</div>
			<div class="mb-3">
				<label for="description" class="form-label">Mô Tả Sản Phẩm</label>
				<textarea type="text" class="form-control" id="description"
					name="description" placeholder="Nhập mô tả sản phẩm"> </textarea>

			</div>
			<div class="mb-3">
				<button type="submit" class="btn btn-primary">Thêm Sản Phẩm</button>
			</div>
		</form>
</body>
</html>