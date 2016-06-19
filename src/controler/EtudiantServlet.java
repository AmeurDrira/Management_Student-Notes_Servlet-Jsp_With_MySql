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

import dao.implementes.EtudiantImpl;
import model.Etudiant;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EtudiantImpl EtudiantImpl = new EtudiantImpl();
		String action = request.getParameter("action");

		if ("delete".equals(action)) {
			String id = request.getParameter("id");
			Etudiant e = EtudiantImpl.findByIdEtudiant(Integer.parseInt(id));
			EtudiantImpl.deleteEtudiant(e);
		}
		if ("update".equals(action)) {
			String id = request.getParameter("id");
			Etudiant e = EtudiantImpl.findByIdEtudiant(Integer.parseInt(id));
			request.setAttribute("obj", e);

		}

		List<Etudiant> liste = EtudiantImpl.getAllEtudiant();
		request.setAttribute("liste", liste);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/EtudiantView.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EtudiantImpl EtudiantImpl = new EtudiantImpl();
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if ("".equals(id) && !"".equals(login) && !"".equals(pwd) && !"".equals(nom) && !"".equals(prenom)
				&& !"".equals(cin)) {
			Etudiant e = new Etudiant(Integer.parseInt(cin), myDate, login, nom, pwd, prenom, Integer.parseInt(tel));

			EtudiantImpl.insertEtudiant(e);

		} else {
			Etudiant e = new Etudiant(Integer.parseInt(id), Integer.parseInt(cin), myDate, login, nom, pwd, prenom,
					Integer.parseInt(tel));
			EtudiantImpl.updateEtudiant(e);
		}
		doGet(request, response);
	}

}
