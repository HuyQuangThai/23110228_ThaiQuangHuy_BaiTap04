package vn.iotstar.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.entities.User;
import vn.iotstar.services.IUserService;
import vn.iotstar.services.impl.UserServiceImpl;

import java.io.IOException;
import java.sql.Date;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    IUserService service = new UserServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("views/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String username = request.getParameter("uname");
		String password = request.getParameter("psw");
		String confirm_password = request.getParameter("confirm_psw");
		String alertMsg = "";
		
		if (username.isEmpty() || password.isEmpty() || confirm_password.isEmpty()) {
			alertMsg = "Vui lòng nhập đầy đủ thông tin";
			request.setAttribute("alert", alertMsg);
			request.getRequestDispatcher("views/register.jsp").forward(request, response);
		}
		
		if (!confirm_password.equals(password)) {
			alertMsg = "Mật khẩu không khớp nhau";
			request.setAttribute("alert", alertMsg);
			request.getRequestDispatcher("views/register.jsp").forward(request, response);
		}
		
		if (service.findByUserName(username) != null) {
			alertMsg = "User này đã tồn tại";
			request.setAttribute("alert", alertMsg);
			request.getRequestDispatcher("views/register.jsp").forward(request, response);
		}
		
		boolean isSuccess = service.register(username, password);
		if (isSuccess) {
			request.setAttribute("alert", alertMsg);
			response.sendRedirect(request.getContextPath() + "/login");
		} else {
			alertMsg = "Hệ thống lỗi";
			request.setAttribute("alert", alertMsg);
			request.getRequestDispatcher("/views/register.jsp").forward(request, response);
		}
	}

}
