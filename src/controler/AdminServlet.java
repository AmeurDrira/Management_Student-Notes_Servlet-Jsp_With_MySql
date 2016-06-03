package controler;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.implementes.AdminImpl;
import model.Admin;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdminImpl adminImpl = new AdminImpl();
		String action = request.getParameter("action");

		if ("delete".equals(action)) {
			String id = request.getParameter("id");
			System.out.println(id);
			Admin a = adminImpl.findByIdAdmin(Integer.parseInt(id));
			adminImpl.deleteAdmin(a);
		}
		if ("update".equals(action)) {
			String id = request.getParameter("id");
			System.out.println(id);
			Admin a = adminImpl.findByIdAdmin(Integer.parseInt(id));
			request.setAttribute("obj", a);

		}

		List<Admin> liste = adminImpl.getAllAdmin();
		request.setAttribute("liste", liste);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/adminView.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("login");
		String pwd = request.getParameter("pwd");
		String id = request.getParameter("id");

		if (null == id && !"".equals(login) && !"".equals(pwd)) {
			Admin admin = new Admin(login, pwd);
			AdminImpl adminImp = new AdminImpl();
			adminImp.insertAdmin(admin);

		} else {
			Admin admin = new Admin(Integer.parseInt(id), login, pwd);
			AdminImpl adminImp = new AdminImpl();
			adminImp.updateAdmin(admin);
		}

		doGet(request, response);
	}

}
