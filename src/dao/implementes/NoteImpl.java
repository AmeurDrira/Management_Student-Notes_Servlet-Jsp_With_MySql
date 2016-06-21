package dao.implementes;

import java.security.SecureRandom;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dao.interfaces.NoteInterface;
import model.Etudiant;
import model.Groupe;
import model.Matiere;
import model.Matiereensignier;
import model.Note;
import model.Session;

public class NoteImpl implements NoteInterface {
	private EntityManagerFactory emfactory;

	public NoteImpl() {
		super();

	}

	@Override
	public void insertNote(Note note) {
		emfactory = Persistence.createEntityManagerFactory("Gestion");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		entitymanager.persist(note);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();

	}

	@Override
	public void updateNote(Note note) {
		emfactory = Persistence.createEntityManagerFactory("Gestion");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		entitymanager.merge(note);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();

	}

	@Override
	public void deleteNote(Note note) {
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		entitymanager.remove(entitymanager.merge(note));
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();

	}

	@Override
	public Note findByIdNote(int id) {
		emfactory = Persistence.createEntityManagerFactory("Gestion");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		Note note = entitymanager.find(Note.class, id);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
		return note;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Note> getAllNote() {
		List<Note> list;
		emfactory = Persistence.createEntityManagerFactory("Gestion");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		Query query = entitymanager.createQuery("SELECT n from Note n");
		list = query.getResultList();
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
		return list;
	}

	@Override
	public void InsererCompostagePrincipale(Etudiant etudiant, Matiereensignier matiereensignier) {

		SessionImpl sessionImpl = new SessionImpl();
		Session sessionObj = sessionImpl.findSessionPrincipale();
		NoteImpl noteImpl = new NoteImpl();
		Note note = null, noteVerif = null;
		noteVerif = noteImpl.getAllNoteByEtudiant(etudiant, matiereensignier.getMatiere());

		if ((null == noteVerif) || (noteVerif.getEtudiant().getId() != etudiant.getId()
				&& noteVerif.getMatiereensignier().getMatiere().getId() != matiereensignier.getMatiere().getId())) {
			String comp = compostageCode();
			note = new Note(Integer.parseInt(comp), etudiant, sessionObj, matiereensignier);
			noteImpl.insertNote(note);
		}

	}

	@Override
	public String compostageCode() {
		String AB = "0123456789113465752381679765457890796854635421324356789077357556";
		SecureRandom rnd = new SecureRandom();

		StringBuilder sb = new StringBuilder(8);
		for (int i = 0; i < 8; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		return sb.toString();
	}

	@Override
	public void InsererCompostageControle(Etudiant etudiant, Matiereensignier matiereensignier) {
		SessionImpl sessionImpl = new SessionImpl();
		Session sessionObj = sessionImpl.findSessionControle();
		NoteImpl noteImpl = new NoteImpl();
		Note note = null, noteVerif = null;
		noteVerif = noteImpl.getAllNoteByEtudiant(etudiant, matiereensignier.getMatiere());

		if ((null == noteVerif) || (noteVerif.getEtudiant().getId() != etudiant.getId()
				&& noteVerif.getMatiereensignier().getMatiere().getId() != matiereensignier.getMatiere().getId())) {
			String comp = compostageCode();
			note = new Note(Integer.parseInt(comp), etudiant, sessionObj, matiereensignier);
			noteImpl.insertNote(note);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Note> getAllNoteByGroup(Groupe groupe) {
		List<Note> list;
		emfactory = Persistence.createEntityManagerFactory("Gestion");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		Query query = entitymanager.createQuery("SELECT n from Note n WHERE n.matiereensignier.groupe.id = :id");
		query.setParameter("id", groupe.getId());
		list = query.getResultList();
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Note> getAllNoteByGroupMatiere(Groupe groupe, Matiere matiere) {
		List<Note> list;
		emfactory = Persistence.createEntityManagerFactory("Gestion");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		Query query = entitymanager.createQuery(
				"SELECT n from Note n WHERE n.matiereensignier.groupe.id = :idg and n.matiereensignier.matiere.id = :idm ");
		query.setParameter("idg", groupe.getId());
		query.setParameter("idm", matiere.getId());
		list = query.getResultList();
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
		return list;
	}

	@Override
	public Note getAllNoteByEtudiant(Etudiant etudiant, Matiere matiere) {
		Note en = null;
		emfactory = Persistence.createEntityManagerFactory("Gestion");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		Query query = entitymanager
				.createQuery("Select e FROM Note e WHERE e.etudiant.id = :ide and e.matiereensignier.matiere.id= :idm");
		query.setParameter("ide", etudiant.getId());
		query.setParameter("idm", matiere.getId());

		try {
			return en = (Note) query.getSingleResult();
		} catch (NoResultException e) {
			return en;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Note> getAllNoteByEtudiant(Etudiant etudiant) {
		List<Note> list;
		emfactory = Persistence.createEntityManagerFactory("Gestion");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		Query query = entitymanager.createQuery("SELECT n from Note n WHERE n.etudiant.id = :id ");
		query.setParameter("id", etudiant.getId());
		list = query.getResultList();
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
		return list;
	}
}
