<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Home</title>
  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css" rel="stylesheet">
  <style>
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
  </style>
</head>
<body>

	<!-- Sidebar -->
	<div class="sidebar">
		<a href="${pageContext.request.contextPath}/manager/home" class="active"> 
			<i class="bi bi-house-door me-2"></i>
			Home
		</a> <a href="${pageContext.request.contextPath}/manager/users"> 
			<i class="bi bi-people me-2"></i> 
			User</a>
	</div>

	<!-- Nội dung chính -->
  <div class="content">
    <h1>Welcome, Manager ${username}</h1>
  </div>

  <!-- Bootstrap JS -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>