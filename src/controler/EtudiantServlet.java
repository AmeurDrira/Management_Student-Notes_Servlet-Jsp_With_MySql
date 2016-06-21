package controler;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.implementes.EtudiantImpl;
import dao.implementes.GroupeImpl;
import model.Etudiant;
import model.Groupe;

/**
 * Servlet implementation class EtudiantServlet
 */
@WebServlet("/EtudiantServlet")
public class EtudiantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EtudiantServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		EtudiantImpl etudiantImpl = new EtudiantImpl();
		GroupeImpl groupeImpl = new GroupeImpl();

		List<Groupe> listeGroupe = groupeImpl.getAllGroupe();
		RequestDispatcher rd;

		String action = request.getParameter("action");
		String idgroupe = request.getParameter("idgroupe");
		System.out.println(idgroupe);

		if (!(null == idgroupe)) {
			List<Etudiant> liste = etudiantImpl.findEtudiantbyGroupe(Integer.parseInt(idgroupe));
			for (Etudiant etudiant : liste) {
				System.out.println(etudiant.getNom());
			}
			request.setAttribute("liste", liste);
			request.setAttribute("listeGroupe", listeGroupe);

		} else {
			List<Etudiant> liste = etudiantImpl.getAllEtudiant();
			request.setAttribute("liste", liste);
			request.setAttribute("listeGroupe", listeGroupe);
		}

		if ("delete".equals(action)) {
			String id = request.getParameter("id");
			Etudiant e = etudiantImpl.findByIdEtudiant(Integer.parseInt(id));
			etudiantImpl.deleteEtudiant(e);
		}
		if ("update".equals(action)) {
			String id = request.getParameter("id");
			Etudiant e = etudiantImpl.findByIdEtudiant(Integer.parseInt(id));
			request.setAttribute("obj", e);

		}

		rd = getServletContext().getRequestDispatcher("/EtudiantView.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EtudiantImpl etudiantImpl = new EtudiantImpl();

		GroupeImpl groupeImpl = new GroupeImpl();
		Groupe g = new Groupe();
		String idetudiant = request.getParameter("idetudiant");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String adresse = request.getParameter("adresse");
		String numeroInscri = request.getParameter("numeroInscri");
		String tel = request.getParameter("tel");
		String cin = request.getParameter("cin");

		String idgroupe = request.getParameter("idgroupe");
		g = groupeImpl.findByIdGroupe(Integer.parseInt(idgroupe));

		if ("".equals(idetudiant)) {
			System.out.println("cin" + Integer.parseInt(cin));
			System.out.println("insc" + Integer.parseInt(numeroInscri));
			System.out.println("tel" + Integer.parseInt(tel));

			Etudiant e = new Etudiant(adresse, Integer.parseInt(cin), cin, nom, Integer.parseInt(numeroInscri),
					numeroInscri, prenom, Integer.parseInt(tel), g);

			etudiantImpl.insertEtudiant(e);

		} else {
			Etudiant e = new Etudiant(Integer.parseInt(idetudiant), adresse, Integer.parseInt(cin), cin, nom,
					Integer.parseInt(numeroInscri), numeroInscri, prenom, Integer.parseInt(tel), g);
			etudiantImpl.updateEtudiant(e);
		}
		doGet(request, response);
	}

}
