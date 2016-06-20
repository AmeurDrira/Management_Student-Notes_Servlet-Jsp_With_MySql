package controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.implementes.AdminImpl;
import dao.implementes.EnsignantImpl;
import dao.implementes.EtudiantImpl;
import model.Admin;
import model.Ensignant;
import model.Etudiant;

/**
 * Servlet implementation class AuthentificationServlet
 */
@WebServlet("/AuthentificationServlet")
public class AuthentificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AuthentificationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd;
		HttpSession session = request.getSession();
        
		Etudiant etudiant =null;
		EtudiantImpl etudiantImpl = new EtudiantImpl();

		Ensignant ensignant = new Ensignant();
		EnsignantImpl ensignantImpl = new EnsignantImpl();

		Admin admin = new Admin();
		AdminImpl admintImpl = new AdminImpl();

		String login = request.getParameter("login");
		String pwd = request.getParameter("pwd");
		String type = request.getParameter("optionsRadios");
		
		if (null==type) {
			rd = getServletContext().getRequestDispatcher("/indexErreur.jsp");
			rd.forward(request, response);
		}

		if ("etudiant".equals(type)) {
			etudiant = etudiantImpl.findByLoginMotPasse(login.toString(), pwd.toString());
			if( ( login.equals(etudiant.getLogin())) && (pwd.equals(etudiant.getPassword()))) {
				session.setAttribute("etudiant", etudiant);
				
				rd = getServletContext().getRequestDispatcher("/EspaceEtudiantView.jsp");
				rd.forward(request, response);

			}  else {
				rd = getServletContext().getRequestDispatcher("/indexErreur.jsp");
				rd.forward(request, response);
			}
		}
		if ("ensignant".equals(type)) {
			ensignant = ensignantImpl.findByLoginMotPasse(login.toString(), pwd.toString());
			System.out.println(ensignant.getNom());
			if( ( login.equals(ensignant.getLogin())) && (pwd.equals(ensignant.getPassword()))) {
				
				session.setAttribute("ensignant", ensignant);
				rd = getServletContext().getRequestDispatcher("/EspaceEnsignantView.jsp");
				rd.forward(request, response);

			}  else {
				rd = getServletContext().getRequestDispatcher("/indexErreur.jsp");
				rd.forward(request, response);
			}

		}
		if ("admin".equals(type)) {
			admin = admintImpl.findByLoginMotPasse(login.toString(), pwd.toString());
			if( ( login.equals(admin.getLogin())) && (pwd.equals(admin.getPassword()))) {
				session.setAttribute("admin", admin);
				rd = getServletContext().getRequestDispatcher("/adminView.jsp");
				rd.forward(request, response);

			}  else {
				rd = getServletContext().getRequestDispatcher("/indexErreur.jsp");
				rd.forward(request, response);
			}

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
