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
import dao.implementes.GroupeImpl;
import dao.implementes.NiveauImpl;
import model.Ensignant;
import model.Groupe;
import model.Niveau;

/**
 * Servlet implementation class EnsignantServlet
 */
@WebServlet("/GroupeServlet")
public class GroupeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		NiveauImpl niveauImpl =new NiveauImpl();
		String action = request.getParameter("action");

		if ("delete".equals(action)) {
			String id = request.getParameter("id");
			Groupe e = groupeImpl.findByIdGroupe(Integer.parseInt(id));
			groupeImpl.deleteGroupe(e);
		}
		if ("update".equals(action)) {
			String id = request.getParameter("id");
			Groupe e = groupeImpl.findByIdGroupe(Integer.parseInt(id));
			request.setAttribute("obj", e);

		}
		
		List<Groupe> liste = groupeImpl.getAllGroupe();
		request.setAttribute("liste", liste);
		
		List<Niveau> listeNiveau = niveauImpl.getAllNiveau();
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
		NiveauImpl niveauImpl =new NiveauImpl();	
		
		String libelle = request.getParameter("libelle");
		String abreviation = request.getParameter("abreviation");
		String code = request.getParameter("code");	
		String idniveau = request.getParameter("niveaugroupe");
		Niveau niveau=niveauImpl.findByIdNiveau(Integer.parseInt(idniveau));
		String id = request.getParameter("id");
		
		
		if (null == id && !"".equals(libelle) && !"".equals(abreviation) && !"".equals(code) ) {
			Groupe g=new Groupe(abreviation,Integer.parseInt(code),libelle,niveau);
			groupeImpl.insertGroupe(g);

		} else {
			Groupe g=new Groupe(Integer.parseInt(id),abreviation,Integer.parseInt(code),libelle,niveau);
			groupeImpl.updateGroupe(g);
		}

		doGet(request, response);
	}

}
