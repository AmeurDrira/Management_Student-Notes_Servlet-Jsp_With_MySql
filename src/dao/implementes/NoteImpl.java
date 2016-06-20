package dao.implementes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dao.interfaces.NoteInterface;
import model.Etudiant;
import model.Note;

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
	@SuppressWarnings("unchecked")
	@Override
	public List<Note> InsererCompostage(Etudiant etudiant) {
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
}
