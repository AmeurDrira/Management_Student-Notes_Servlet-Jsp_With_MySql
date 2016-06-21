package controler;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.implementes.EnsignantImpl;
import dao.implementes.GroupeImpl;
import dao.implementes.MatiereImpl;
import dao.implementes.MatiereensignierImpl;
import model.Ensignant;
import model.Groupe;
import model.Matiere;
import model.Matiereensignier;

/**
 * Servlet implementation class MatiereEnsignantGroupServlet
 */
@WebServlet("/MatiereEnsignantGroupServlet")
public class MatiereEnsignantGroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Matiereensignier e;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MatiereEnsignantGroupServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		GroupeImpl groupeImpl = new GroupeImpl();
		MatiereImpl matiereImpl = new MatiereImpl();
		EnsignantImpl ensignantImpl = new EnsignantImpl();
		MatiereensignierImpl matiereensignierImpl = new MatiereensignierImpl();
		String action = request.getParameter("action");

		if ("delete".equals(action)) {
			String id = request.getParameter("id");
			e = matiereensignierImpl.findByIdMatiereensignier(Integer.parseInt(id));
			matiereensignierImpl.deleteMatiereensignier(e);
		}
		if ("update".equals(action)) {
			String id = request.getParameter("id");
			e = matiereensignierImpl.findByIdMatiereensignier(Integer.parseInt(id));
			request.setAttribute("obj", e);

		}

		List<Groupe> listeGroupe = groupeImpl.getAllGroupe();
		List<Matiere> listeMatiere = matiereImpl.getAllMatiere();
		List<Ensignant> listeEnsignant = ensignantImpl.getAllEnsignant();
		List<Matiereensignier> listeMatiereEnsignant = matiereensignierImpl.getAllMatiereensignier();

		if (null != e) {
			for (int i = 0; i < listeMatiere.size(); i++) {
				if (listeMatiere.get(i).getId() == e.getMatiere().getId()) {
					Matiere tmpNiveau = listeMatiere.get(0);
					listeMatiere.set(0, listeMatiere.get(i));
					listeMatiere.set(i, tmpNiveau);

				}
			}
			for (int i = 0; i < listeGroupe.size(); i++) {
				if (listeGroupe.get(i).getId() == e.getGroupe().getId()) {
					Groupe tmpNiveau = listeGroupe.get(0);
					listeGroupe.set(0, listeGroupe.get(i));
					listeGroupe.set(i, tmpNiveau);

				}
			}
			for (int i = 0; i < listeEnsignant.size(); i++) {
				if (listeEnsignant.get(i).getId() == e.getEnsignant().getId()) {
					Ensignant tmpNiveau = listeEnsignant.get(0);
					listeEnsignant.set(0, listeEnsignant.get(i));
					listeEnsignant.set(i, tmpNiveau);

				}
			}
		}

		request.setAttribute("listeMatiere", listeMatiere);
		request.setAttribute("listeGroupe", listeGroupe);
		request.setAttribute("listeEnsignant", listeEnsignant);
		request.setAttribute("listeMatiereEnsignant", listeMatiereEnsignant);

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/matiereensignantgroupView.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		GroupeImpl groupeImpl = new GroupeImpl();
		MatiereImpl matiereImpl = new MatiereImpl();
		EnsignantImpl ensignantImpl = new EnsignantImpl();
		MatiereensignierImpl matiereensignierImpl = new MatiereensignierImpl();

		String idgroupe = request.getParameter("idgroupe");
		String idmatiere = request.getParameter("idmatiere");
		String idensignant = request.getParameter("idensignant");
		String idmatiereEnsignant = request.getParameter("idmatiereEnsignant");
		Matiere m= new Matiere();
		Ensignant en=new Ensignant();
		Groupe g=new Groupe();
		m=matiereImpl.findByIdMatiere(Integer.parseInt(idmatiere));
		en=ensignantImpl.findByIdEnsignant(Integer.parseInt(idensignant));
		g=groupeImpl.findByIdGroupe(Integer.parseInt(idgroupe));
		

		if ("".equals(idmatiereEnsignant)) {
			Matiereensignier matiereensignier= new Matiereensignier(g,m,en);
			matiereensignierImpl.insertMatiereensignier(matiereensignier);	

		} else {
			Matiereensignier matiereensignier= new Matiereensignier(Integer.parseInt(idmatiereEnsignant),g,m,en);
			matiereensignierImpl.updateMatiereensignier(matiereensignier);
		}
		doGet(request, response);
	}

}
