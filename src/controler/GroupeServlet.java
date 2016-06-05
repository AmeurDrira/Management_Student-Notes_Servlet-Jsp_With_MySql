package controler;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.implementes.GroupeImpl;
import dao.implementes.NiveauImpl;
import model.Groupe;
import model.Niveau;

/**
 * Servlet implementation class EnsignantServlet
 */
@WebServlet("/GroupeServlet")
public class GroupeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Groupe e;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GroupeServlet() {
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
		NiveauImpl niveauImpl = new NiveauImpl();
		String action = request.getParameter("action");

		if ("delete".equals(action)) {
			String id = request.getParameter("id");
			Groupe e = groupeImpl.findByIdGroupe(Integer.parseInt(id));
			groupeImpl.deleteGroupe(e);
		}
		if ("update".equals(action)) {
			String id = request.getParameter("id");
			e = groupeImpl.findByIdGroupe(Integer.parseInt(id));
			request.setAttribute("obj", e);

		}

		List<Groupe> liste = groupeImpl.getAllGroupe();

		request.setAttribute("liste", liste);

		List<Niveau> listeNiveau = niveauImpl.getAllNiveau();

		if (null != e) {
			for (int i = 0; i < listeNiveau.size(); i++) {
				if (listeNiveau.get(i).getId() == e.getId()) {
					Niveau tmpNiveau = listeNiveau.get(0);
					listeNiveau.set(0, listeNiveau.get(i));
					listeNiveau.set(i, tmpNiveau);

				}
			}
		}
		request.setAttribute("listeNiveau", listeNiveau);

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/groupeView.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		GroupeImpl groupeImpl = new GroupeImpl();
		NiveauImpl niveauImpl = new NiveauImpl();

		String libelle = request.getParameter("libelle");
		String abreviation = request.getParameter("abreviation");
		String code = request.getParameter("code");
		String idniveau = request.getParameter("niveaugroupe");
		Niveau niveau = niveauImpl.findByIdNiveau(Integer.parseInt(idniveau));
		String id = request.getParameter("id");

		if ("".equals(id) && !"".equals(libelle) && !"".equals(abreviation) && !"".equals(code)) {
			Groupe g = new Groupe(abreviation, Integer.parseInt(code), libelle, niveau);
			groupeImpl.insertGroupe(g);

		} else {
			Groupe g = new Groupe(Integer.parseInt(id), abreviation, Integer.parseInt(code), libelle, niveau);
			groupeImpl.updateGroupe(g);
		}

		doGet(request, response);
	}

}
