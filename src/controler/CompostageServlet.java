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
import dao.implementes.MatiereImpl;
import dao.implementes.MatiereensignierImpl;
import dao.implementes.NoteImpl;
import model.Etudiant;
import model.Groupe;
import model.Matiere;
import model.Matiereensignier;
import model.Note;

/**
 * Servlet implementation class CompostageServlet
 */
@WebServlet("/CompostageServlet")
public class CompostageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CompostageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MatiereensignierImpl matiereensignierImpl = new MatiereensignierImpl();
		GroupeImpl groupeImpl = new GroupeImpl();
		MatiereImpl matiereImpl = new MatiereImpl();
		EtudiantImpl etudiantImpl = new EtudiantImpl();
		NoteImpl noteImpl = new NoteImpl();

		List<Etudiant> listetudiant;
		List<Groupe> listeGroupe;
		List<Matiere> listeMatiere;
		List<Note> listeNote;

		listeGroupe = groupeImpl.getAllGroupe();
		listeMatiere = matiereImpl.getAllMatiere();

		request.setAttribute("listeGroupe", listeGroupe);
		request.setAttribute("listeMatiere", listeMatiere);

		String idgroup = request.getParameter("idgroupe");
		String idmatiere = request.getParameter("idmatiere");

		if (!(null == idgroup) && !(null == idmatiere)) {
			Groupe groupe = groupeImpl.findByIdGroupe(Integer.parseInt(idgroup));
			Matiere matiere = matiereImpl.findByIdMatiere(Integer.parseInt(idmatiere));
			Matiereensignier matiereensignier = matiereensignierImpl.findMatiereensignierParMatGroup(matiere, groupe);
			listetudiant = etudiantImpl.findEtudiantbyGroupe(matiereensignier.getGroupe().getId());
			for (Etudiant etudiant : listetudiant) {
				noteImpl.InsererCompostagePrincipale(etudiant, matiereensignier);
			}
			listeNote = noteImpl.getAllNoteByGroup(groupe);
			request.setAttribute("listeNote", listeNote);

		}

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/CompostageView.jsp");
		rd.forward(request, response);
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
