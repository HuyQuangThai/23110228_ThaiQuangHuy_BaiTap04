<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>User View</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css" rel="stylesheet">
<style>
/* Optional: Custom CSS to enhance the look */
.table-img {
	max-width: 100px;
	height: auto;
	border-radius: 5px;
}

.table-responsive {
	margin-top: 20px;
}

.table-img {
    max-width: 120px;
    max-height: 120px;
    object-fit: contain; /* giữ tỉ lệ hình */
    display: block;
    margin: 0 auto; /* căn giữa */
}
body {
     margin: 0;
     font-family: Arial, sans-serif;
   }
   .sidebar {
     position: fixed;      /* cố định */
     top: 0;
     left: 0;
     width: 200px;
     height: 100vh;        /* full chiều cao màn hình */
     background-color: #f8f9fa;
     padding-top: 20px;
     border-right: 1px solid #ddd;
   }
   .sidebar a {
     display: block;
     padding: 10px 20px;
     margin: 5px 10px;
     border-radius: 8px;
     text-decoration: none;
     color: #333;
     font-weight: 500;
   }
   .sidebar a:hover,
   .sidebar a.active {
     background-color: #007bff;
     color: white;
   }
   .content {
     margin-left: 200px;   /* chừa chỗ cho sidebar */
     padding: 20px;
   }
   .main-content {
    margin-left: 220px;    /* đẩy nội dung sang phải bằng với chiều rộng sidebar */
    padding: 20px;
    width:80%;
}
	.table-striped > tbody > tr:nth-of-type(odd) {
    background-color: transparent !important;
}
	.action {
		width: 150px;
	}
	
	.btn-success {
		width: 150px;
		margin-left: 7.5px;
	}
</style>
</head>
<body>
	<div class="sidebar">
		<a href="${pageContext.request.contextPath}/manager/home"> 
			<i class="bi bi-house-door me-2"></i>
			Home
		</a> <a href="${pageContext.request.contextPath}/manager/users" class="active"> 
			<i class="bi bi-people me-2"></i> 
			Users</a>
	</div>
	<div class="container mt-5 main-content">
		<div class="d-flex justify-content-between">
		<h2 class="mb-4">Danh Sách User</h2>
		</div>
		<div class="table-responsive">
			<table class="table table-bordered">
				<thead class="table-dark">
					<tr>
						<th scope="col">STT</th>
						<th scope="col">Hình ảnh</th>
						<th scope="col">Username</th>
						<th scope="col">Password</th>
				<!-- 		<th scope="col">Trạng thái</th> -->
						<th scope="col">Hành động</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listuser}" var="user" varStatus="STT">
						<tr>
							<th scope="row">${STT.index+1}</th>
							<td>
							<c:url value="${empty user.images ? 'https://media.istockphoto.com/id/1337144146/vector/default-avatar-profile-icon-vector.jpg?s=612x612&w=0&k=20&c=BIbFwuv7FxTWvh5S3vB6bkT0Qv8Vn8N5Ffseq84ClGI=' : (user.images.substring(0,5) == 'https' ? user.images : '/image?fname=' + user.images)}"
									var="imgUrl" /> <img src="${imgUrl}" class="table-img" alt="User Image" /></td>
							<td>${user.username}</td>
							<td>${user.password}</td>
							<td class = "action" ><a
								href="<c:url value='/manager/users/categories?id=${user.id}'/>"
								class="btn btn-sm btn-success">Xem category</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>