<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Category</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
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
</style>
</head>
<body>

	<div class="container mt-5">
		<div class="d-flex justify-content-between">
		<h2 class="mb-4">Danh Sách Danh Mục</h2>
		<a href="${pageContext.request.contextPath}/admin/category/add"
			class="btn btn-primary mb-3">Thêm Danh Mục Mới</a>
		</div>
		<div class="table-responsive">
			<table class="table table-striped table-hover table-bordered">
				<thead class="table-dark">
					<tr>
						<th scope="col">STT</th>
						<th scope="col">Hình ảnh</th>
						<th scope="col">Mã danh mục</th>
						<th scope="col">Tên danh mục</th>
				<!-- 		<th scope="col">Trạng thái</th> -->
						<th scope="col">Hành động</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listcate}" var="cate" varStatus="STT">
						<tr>
							<th scope="row">${STT.index+1}</th>
							<td><c:url
									value="${cate.images.substring(0,5) =='https' ? cate.images : '/image?fname=' += cate.images}"
									var="imgUrl" /> <img src="${imgUrl}"
								class="table-img" alt="Category Image" /></td>
							<td>${cate.id}</td>
							<td>${cate.categoryname}</td>
			<%-- 				<td><c:if test="${cate.status==1}">
									<span class="badge bg-success">Hoạt động</span>
								</c:if> <c:if test="${cate.status!=1}">
									<span class="badge bg-danger">Khóa hoạt động</span>
								</c:if></td> --%>
							<td><a
								href="<c:url value='/admin/category/edit?id=${cate.id }'/>"
								class="btn btn-sm btn-warning">Sửa</a> <a
								href="<c:url value='/admin/category/delete?id=${cate.id}'/>"
								class="btn btn-sm btn-danger"
								onclick="return confirm('Bạn có chắc chắn muốn xóa danh mục này không?');">Xóa</a>
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