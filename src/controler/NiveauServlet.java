package controler;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.implementes.NiveauImpl;
import model.Niveau;

/**
 * Servlet implementation class NiveauServlet
 */
@WebServlet("/NiveauServlet")
public class NiveauServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NiveauServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		NiveauImpl niveauImpl = new NiveauImpl();
		String action = request.getParameter("action");

		if ("delete".equals(action)) {
			String id = request.getParameter("id");
			System.out.println(id);
			Niveau a = niveauImpl.findByIdNiveau(Integer.parseInt(id));
			niveauImpl.deleteNiveau(a);
		}
		if ("update".equals(action)) {
			String id = request.getParameter("id");
			System.out.println(id);
			Niveau a = niveauImpl.findByIdNiveau(Integer.parseInt(id));
			request.setAttribute("obj", a);

		}
		niveauImpl.nombreGroup();
		List<Niveau> liste = niveauImpl.getAllNiveau();
		request.setAttribute("liste", liste);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/niveauView.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		NiveauImpl niveauImpl = new NiveauImpl();
		String libelle = request.getParameter("libelle");
		String code = request.getParameter("code");
		String id = request.getParameter("id");

		if ("".equals(id)  && !"".equals(libelle) && !"".equals(code)) {
			Niveau n = new Niveau( libelle);
			niveauImpl.insertNiveau(n);

		} else {
			Niveau n = new Niveau(Integer.parseInt(id), libelle);
			niveauImpl.updateNiveau(n);
		}

		doGet(request, response);

	}

}
