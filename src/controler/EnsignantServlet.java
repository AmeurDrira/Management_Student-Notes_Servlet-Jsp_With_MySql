package controler;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.implementes.EnsignantImpl;
import model.Ensignant;

/**
 * Servlet implementation class EnsignantServlet
 */
@WebServlet("/EnsignantServlet")
public class EnsignantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EnsignantServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EnsignantImpl ensignantImpl = new EnsignantImpl();
		String action = request.getParameter("action");

		if ("delete".equals(action)) {
			String id = request.getParameter("id");
			Ensignant e = ensignantImpl.findByIdEnsignant(Integer.parseInt(id));
			ensignantImpl.deleteEnsignant(e);
		}
		if ("update".equals(action)) {
			String id = request.getParameter("id");
			Ensignant e = ensignantImpl.findByIdEnsignant(Integer.parseInt(id));
			request.setAttribute("obj", e);

		}

		List<Ensignant> liste = ensignantImpl.getAllEnsignant();
		request.setAttribute("liste", liste);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/ensignantView.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EnsignantImpl ensignantImpl = new EnsignantImpl();
		Date myDate = null;
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String datenaissance = request.getParameter("dateNaissance");
		String tel = request.getParameter("tel");
		String cin = request.getParameter("cin");
		String login = request.getParameter("login");
		String pwd = request.getParameter("pwd");
		String id = request.getParameter("id");

		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		if (datenaissance != null) {

			try {
				myDate = (Date) formatter.parse(datenaissance);

			} catch (ParseException e) {

				e.printStackTrace();
			}
		}

		if ("".equals(id)) {
			Ensignant e = new Ensignant(Integer.parseInt(cin), myDate, login, nom, pwd, prenom, Integer.parseInt(tel));

			ensignantImpl.insertEnsignant(e);

		} else {
			Ensignant e = new Ensignant(Integer.parseInt(id), Integer.parseInt(cin), myDate, login, nom, pwd, prenom,
					Integer.parseInt(tel));
			ensignantImpl.updateEnsignant(e);
		}

		doGet(request, response);
	}

}
