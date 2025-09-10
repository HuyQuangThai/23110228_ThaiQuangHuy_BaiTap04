package vn.iotstar.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import vn.iotstar.entities.Category;
import vn.iotstar.entities.User;
import vn.iotstar.services.impl.CategoryServiceImpl;
import vn.iotstar.services.ICategoryService;

/**
 * Servlet implementation class CategoryController
 */
@WebServlet(urlPatterns = {"/user/categories","/admin/categories"})
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryController() {
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
		ICategoryService cateService = new CategoryServiceImpl();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("account");
		int id = user.getId();
		List<Category> listCategory = cateService.findByUserId(id);
		request.setAttribute("listcate", listCategory);
		if (url.contains("user")) {
			request.setAttribute("home", request.getContextPath() + "/user/home");
			request.setAttribute("category", request.getContextPath() + "/user/categories");
			request.getRequestDispatcher("/views/user/categories.jsp").forward(request, response);
		}
		else if (url.contains("admin")) {
			request.setAttribute("home", request.getContextPath() + "/admin/home");
			request.setAttribute("category", request.getContextPath() + "/admin/categories");
			request.getRequestDispatcher("/views/admin/categories.jsp").forward(request, response);
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
