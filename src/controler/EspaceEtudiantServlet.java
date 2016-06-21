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

import dao.implementes.NoteImpl;
import model.Etudiant;
import model.Note;

/**
 * Servlet implementation class EspaceEtudiantServlet
 */
@WebServlet("/EspaceEtudiantServlet")
public class EspaceEtudiantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EspaceEtudiantServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		NoteImpl noteImpl = new NoteImpl();
		List<Note> listNote;
		Etudiant etudiant;
		HttpSession session;
		session = request.getSession();
		etudiant = (Etudiant) session.getAttribute("etudiant");
		listNote = noteImpl.getAllNoteByEtudiant(etudiant);
		request.setAttribute("listNote", listNote);
		request.setAttribute("etudiant", etudiant);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/EspaceEtudiantView.jsp");
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
