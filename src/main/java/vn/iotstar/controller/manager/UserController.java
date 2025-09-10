package vn.iotstar.controller.manager;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.entities.Category;
import vn.iotstar.entities.User;
import vn.iotstar.services.ICategoryService;
import vn.iotstar.services.IUserService;
import vn.iotstar.services.impl.CategoryServiceImpl;
import vn.iotstar.services.impl.UserServiceImpl;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class UserController
 */
@WebServlet(urlPatterns = {"/manager/users", "/manager/users/categories"})
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IUserService userService = new UserServiceImpl();
	ICategoryService cateService = new CategoryServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURI();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		List<User> listUser = userService.findAll();
		request.setAttribute("listuser", listUser);
		if (url.contains("categories")) {
			int id = Integer.parseInt(request.getParameter("id"));
			User user = userService.findById(id);
			List<Category> listCategory = cateService.findByUserId(id);
			request.setAttribute("listcate", listCategory);
			if (user.getRoleid() == 1) request.getRequestDispatcher("/views/user/categories.jsp").forward(request, response);
			else if (user.getRoleid() == 2) request.getRequestDispatcher("/views/manager/users.jsp").forward(request, response);
			request.getRequestDispatcher("/views/admin/categories.jsp").forward(request, response);
		}
		else if (url.contains("users")) {
			request.getRequestDispatcher("/views/manager/users.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
	}

}
