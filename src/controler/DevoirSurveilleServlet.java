package controler;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.implementes.EtudiantImpl;
import dao.implementes.GroupeImpl;
import dao.implementes.MatiereImpl;
import dao.implementes.MatiereensignierImpl;
import model.Ensignant;
import model.Etudiant;
import model.Groupe;
import model.Matiere;
import model.Matiereensignier;

/**
 * Servlet implementation class DevoirSurveilleServlet
 */
@WebServlet("/DevoirSurveilleServlet")
public class DevoirSurveilleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DevoirSurveilleServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		List<Matiereensignier> list;
		List<Etudiant> listetudiant;
		Ensignant e = (Ensignant) session.getAttribute("ensignant");
		MatiereensignierImpl matiereensignierImpl = new MatiereensignierImpl();
		GroupeImpl groupeImpl = new GroupeImpl();
		MatiereImpl matiereImpl = new MatiereImpl();
		EtudiantImpl etudiantImpl = new EtudiantImpl();
		list = matiereensignierImpl.getAllMatiereensignierParEnsignant(e);
		request.setAttribute("ensignant", e);
		request.setAttribute("list", list);

		String idgroup = request.getParameter("idgroupe");
		String idmatiere = request.getParameter("idmatiere");

		if (!(null == idgroup) && !(null == idmatiere)) {
			listetudiant = etudiantImpl.findEtudiantbyGroupe(Integer.parseInt(idgroup));
			Matiere matiere = matiereImpl.findByIdMatiere(Integer.parseInt(idmatiere));
			Groupe groupe = groupeImpl.findByIdGroupe(Integer.parseInt(idgroup));
			request.setAttribute("listetudiant", listetudiant);
			request.setAttribute("matiere", matiere);
			request.setAttribute("groupe", groupe);
		}

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/EspaceEnsignantView.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Etudiant> listetudiant;
		listetudiant=(List<Etudiant>) request.getAttribute("listetudiant");
		for(Etudiant i:listetudiant)
		{
			System.out.println("-------------------");
			System.out.println(i.getLogin());
			System.out.println("-------------------");
		}

		doGet(request, response);
	}

}
