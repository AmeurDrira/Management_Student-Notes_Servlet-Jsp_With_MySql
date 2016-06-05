package controler;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.implementes.MatiereImpl;
import model.Matiere;

/**
 * Servlet implementation class MatiereServlet
 */
@WebServlet("/MatiereServlet")
public class MatiereServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MatiereServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MatiereImpl matiereImpl = new MatiereImpl();
		String action = request.getParameter("action");

		if ("delete".equals(action)) {
			String id = request.getParameter("id");
			System.out.println(id);
			Matiere a = matiereImpl.findByIdMatiere(Integer.parseInt(id));
			matiereImpl.deleteMatiere(a);
		}
		if ("update".equals(action)) {
			String id = request.getParameter("id");
			System.out.println(id);
			Matiere a = matiereImpl.findByIdMatiere(Integer.parseInt(id));
			request.setAttribute("obj", a);

		}

		List<Matiere> liste = matiereImpl.getAllMatiere();
		request.setAttribute("liste", liste);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/matiereView.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MatiereImpl matiereImpl = new MatiereImpl();
		String libelle = request.getParameter("libelle");
		String coefficient = request.getParameter("coefficient");
		String code = request.getParameter("code");
		String volumec = request.getParameter("volumec");
		String volumetp = request.getParameter("volumetp");
		String volumetd = request.getParameter("volumetd");
		String credit = request.getParameter("credit");
		String id = request.getParameter("id");

		if ("".equals(id)  && !"".equals(libelle) && !"".equals(coefficient) && !"".equals(code) && !"".equals(volumec)
				&& !"".equals(volumetp) && !"".equals(volumetd) && !"".equals(credit)) {
			Matiere m = new Matiere(Integer.parseInt(code), Float.parseFloat(coefficient), Integer.parseInt(credit),
					libelle, Float.parseFloat(volumec), Float.parseFloat(volumetd), Float.parseFloat(volumetp));
			matiereImpl.insertMatiere(m);

		} else {
			Matiere m = new Matiere(Integer.parseInt(id), Integer.parseInt(code), Float.parseFloat(coefficient),
					Integer.parseInt(credit), libelle, Float.parseFloat(volumec), Float.parseFloat(volumetd),
					Float.parseFloat(volumetp));
			matiereImpl.updateMatiere(m);
		}

		doGet(request, response);

	}

}
