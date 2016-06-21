package dao.implementes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dao.interfaces.EtudiantInterface;
import model.Etudiant;

public class EtudiantImpl implements EtudiantInterface {

	private EntityManagerFactory emfactory;

	public EtudiantImpl() {
		super();

	}

	@Override
	public void insertEtudiant(Etudiant etudiant) {
		emfactory = Persistence.createEntityManagerFactory("Gestion");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		entitymanager.persist(etudiant);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();

	}

	@Override
	public void updateEtudiant(Etudiant etudiant) {
		emfactory = Persistence.createEntityManagerFactory("Gestion");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		entitymanager.merge(etudiant);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();

	}

	@Override
	public void deleteEtudiant(Etudiant etudiant) {
		emfactory = Persistence.createEntityManagerFactory("Gestion");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		entitymanager.remove(entitymanager.merge(etudiant));
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();

	}

	@Override
	public Etudiant findByIdEtudiant(int id) {
		emfactory = Persistence.createEntityManagerFactory("Gestion");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		Etudiant etudiant = entitymanager.find(Etudiant.class, id);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
		return etudiant;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Etudiant> getAllEtudiant() {

		List<Etudiant> list;
		emfactory = Persistence.createEntityManagerFactory("Gestion");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		Query query = entitymanager.createQuery("SELECT e from Etudiant e");
		list = query.getResultList();
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Etudiant> findEtudiantbyGroupe(int id) {

		List<Etudiant> list;
		emfactory = Persistence.createEntityManagerFactory("Gestion");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		Query query = entitymanager.createQuery("Select e FROM Etudiant e WHERE e.groupe.id = :id");
		query.setParameter("id", id);
		list = query.getResultList();
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
		return list;
	}

	@Override
	public Etudiant findByLoginMotPasse(String login, String pwd) {
		Etudiant en = new Etudiant();
		emfactory = Persistence.createEntityManagerFactory("Gestion");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		Query query = entitymanager.createQuery("Select e FROM Etudiant e WHERE e.login = :login and e.password= :pwd");
		query.setParameter("login", login);
		query.setParameter("pwd", pwd);
		try {
			return en = (Etudiant) query.getSingleResult();
		} catch (NoResultException e) {
			return en;
		}

	}

}
