<%@page import="model.Customers"%>
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
<!-- Icon Font Stylesheet -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
	rel="stylesheet">


<style>
.size {
	width: 28px;
	height: 30px;
}

.size2 {
	width: 20px;
	height: 20px;
}
</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg bg-body-tertiary">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Navbar</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> Dropdown </a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="#">Action</a></li>
							<li><a class="dropdown-item" href="#">Another action</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="#">Something else
									here</a></li>
						</ul></li>
					<li class="nav-item"><a class="nav-link disabled"
						aria-disabled="true">Disabled</a></li>
				</ul>
				<form class="d-flex" role="search">
					<div class="input-group">
						<input class="form-control" type="search" placeholder="Search"
							aria-label="Search">
						<button class="btn btn-outline-success me-2 border border-start-0"
							type="submit">
							<img class="size2" src="img/search.png">
						</button>
					</div>

					<%
					Object obj = session.getAttribute("customer");
					Customers cus = null;
					if (obj != null) {
						cus = (Customers) obj;
					}
					if (cus == null) {
					%>

					<a class="me-2" href="dangnhap.jsp"><img class="size"
						src="img/user.png"></a>
					<%
					} else {
					%>
					<ul class="navbar-nav me-auto mb-2 mb-lg-0 bg-infor ">
						<li class="nav-item dropdown dropstart"><a
							class="nav-link dropdown-toggle" href="#" role="button"
							data-bs-toggle="dropdown" aria-expanded="false"> <img
								class="size" src="img/user.png">
						</a>
							<ul class="dropdown-menu">

								<li><a class="dropdown-item" href="#">Thong Bao</a></li>
								<li><a class="dropdown-item" href="#">Thay Doi Thong
										Tin</a></li>
								<li><a class="dropdown-item" href="doimatkhau.jsp">Doi
										Mat Khau</a></li>
								<li><a class="dropdown-item" href="ThemSanPham">Them
										San Pham</a></li>
								<li><hr class="dropdown-divider"></li>
								<li><a class="dropdown-item" href="dang-xuat">Thoat Tai
										Khoan</a></li>
							</ul></li>
					</ul>
					<%
					}
					%>

					<a class="me-5" href="#"><img class="size"
						src="img/shopping-cart.png"></a>


				</form>
			</div>
		</div>
	</nav>

	<div class="container mt-4">
		<div class="row">
			<div class="col-lg-3">
				<div class="list-group">
				<a href="TrangChu" class="list-group-item list-group-item-action">
							Toan Bo San Pham </a>
					<c:forEach var="category" items="${categories}">
						<a href="SanPhamTheoDanhMuc?id=${category.categoryID}" class="list-group-item list-group-item-action">
							${category.nameCategory} </a>
					</c:forEach>
				</div>
			</div>
			<div class="col-lg-9">
				<div class="row">
					
				
						<c:forEach var="product" items="${products}">
						<div class="col-lg-4 col-md-6 mb-4">
							<div class="card h-100">
								<a href="#"><img class="card-img-top"
									src="${product.imageURL}" alt=""></a>
								<div class="card-body">
									<h4 class="card-title">
										<a href="#"> ${product.nameProductString} </a>
									</h4>
									<h5>Gia Ban: ${product.price}</h5>
									<p class="card-text">${product.desriptionString}</p>
								</div>
								<div class="card-footer">
									<button class="btn btn-primary">Mua Hang</button>
								</div>
							</div>
							</div>
						</c:forEach>
						
					
				</div>
			</div>

		</div>

	</div>

</body>
</html>