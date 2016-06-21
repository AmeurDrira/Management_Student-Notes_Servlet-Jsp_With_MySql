package controler;

import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
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
import dao.implementes.NoteImpl;
import dao.implementes.SessionImpl;
import model.Ensignant;
import model.Etudiant;
import model.Groupe;
import model.Matiere;
import model.Matiereensignier;
import model.Note;
import model.Session;

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
		List<Matiereensignier> list;
		List<Etudiant> listetudiant;
		Ensignant e;
		HttpSession session;

		session = request.getSession();
		e = (Ensignant) session.getAttribute("ensignant");
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MatiereensignierImpl matiereensignierImpl = new MatiereensignierImpl();
		GroupeImpl groupeImpl = new GroupeImpl();
		MatiereImpl matiereImpl = new MatiereImpl();
		EtudiantImpl etudiantImpl = new EtudiantImpl();
		NoteImpl noteImpl = new NoteImpl();
		SessionImpl sessionImpl = new SessionImpl();

		
		List<Note> listeNote;
		Ensignant e;
		HttpSession session = request.getSession();
		Enumeration param = request.getParameterNames();
		List headerValuesList = Collections.list(param);
		
		int idmatiere = Integer.parseInt(request.getParameter("idmatiere"));
		int idgroupe = Integer.parseInt(request.getParameter("idgroupe"));
		
		
		e = (Ensignant) session.getAttribute("ensignant");

		Matiere matiere = matiereImpl.findByIdMatiere(idmatiere);
		
		
		Groupe groupe = groupeImpl.findByIdGroupe(idgroupe);
		listeNote=noteImpl.getAllNoteByGroupMatiere(groupe,matiere);
		
		Session sessionObj = sessionImpl.findSessionPrincipale();
		Matiereensignier matiereensignier;

		matiereensignier = matiereensignierImpl.findMatiereensignierParMatGroupEns(matiere, groupe, e);

		for (Note note : listeNote) {
			Etudiant etudiantObj = etudiantImpl.findByIdEtudiant(note.getEtudiant().getId());
			float notetp = 0;
			float notetd = 0;
			float notepresentielle = 0;
			for (Object headerValueObj : headerValuesList) {
				String fieldName = headerValueObj.toString();

				if (fieldName.contains("TP" + etudiantObj.getId()))
					notetp = Float.parseFloat(request.getParameter(fieldName));
				if (fieldName.contains("TD" + etudiantObj.getId()))
					notetd = Float.parseFloat(request.getParameter(fieldName));
				if (fieldName.contains("TPS" + etudiantObj.getId()))
					notepresentielle = Float.parseFloat(request.getParameter(fieldName));
			}
			if (notepresentielle != 0 && notetd != 0 && notetd != 0) {
				System.out.println("-----------------");
				System.out.println(notetp);
				System.out.println(notetd);
				System.out.println(notepresentielle);
				System.out.println(note.getEtudiant().getNom());
				System.out.println("-----------------");
				note = new Note(note.getId(),notepresentielle, notetd, notetp,note.getNumcompostage(), etudiantObj, sessionObj, matiereensignier);
				noteImpl.updateNote(note);
			}

		}

		doGet(request, response);
	}

}
