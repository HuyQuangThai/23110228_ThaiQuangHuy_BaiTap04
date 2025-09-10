<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Login Form</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container d-flex justify-content-center align-items-center vh-100">
  <div class="card shadow-lg p-4 rounded-4" style="width: 380px;">
    <h3 class="text-center mb-4">Login</h3>
    
    <form action="/GPAST56/login"  method="post">
      <div class="mb-3">
        <label for="uname" class="form-label"><b>Username</b></label>
        <input type="text" class="form-control" name="uname" placeholder="Enter Username" required>
      </div>
	<div class="mb-3">
        <label for="psw" class="form-label"><b>Password</b></label>
        <input type="password" class="form-control" name="psw" id="psw" placeholder="Enter Password" required>
      </div>
		<div class="mb-3">
		    <c:if test="${alert != null}">
		        <div class="alert alert-danger d-flex align-items-center" role="alert">
		            <div>
		                ${alert}
		            </div>
		        </div>
		    </c:if>
		</div>
      <div class="form-check mb-3">
        <input class="form-check-input" type="checkbox" id="remember" name="remember" checked>
        <label class="form-check-label" for="remember">
          Remember me
        </label>
      </div>

      <!-- Login button -->
      <div class="d-grid mb-2">
        <button type="submit" class="btn btn-primary">Login</button>
      </div>

      <!-- Cancel + Forgot Password -->
      <div class="d-flex justify-content-between">
        <a href="${pageContext.request.contextPath}/register" class="text-decoration-none">Chưa có tài khoản?</a>
        <a href="#" class="text-decoration-none">Quên mật khẩu?</a>
      </div>
    </form>
  </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
