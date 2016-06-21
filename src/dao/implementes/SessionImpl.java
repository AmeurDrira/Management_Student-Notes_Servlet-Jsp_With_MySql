package dao.implementes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dao.interfaces.SessionInterface;
import model.Session;

public class SessionImpl implements SessionInterface {
	private EntityManagerFactory emfactory;

	public SessionImpl() {
		super();
		emfactory = Persistence.createEntityManagerFactory("Gestion");
	}

	@Override
	public void insertSession(Session session) {
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		entitymanager.persist(session);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();

	}

	@Override
	public void updateSession(Session session) {
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		entitymanager.merge(session);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
	}

	@Override
	public void deleteSession(Session session) {
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		entitymanager.remove(session);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
	}

	@Override
	public Session findByIdSession(int id) {
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		Session session = entitymanager.find(Session.class, id);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
		return session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Session> getAllSession() {
		List<Session> list;
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		Query query = entitymanager.createQuery("SELECT s from Session s");
		list = query.getResultList();
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
		return list;
	}

	@Override
	public Session findSessionPrincipale() {

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		Session session = entitymanager.find(Session.class, 1);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
		return session;
	}

	@Override
	public Session findSessionControle() {
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		Session session = entitymanager.find(Session.class, 2);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
		return session;
	}

}
