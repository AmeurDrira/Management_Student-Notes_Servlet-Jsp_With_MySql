package dao.implementes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dao.interfaces.EnsignantInterface;
import model.Ensignant;

public class EnsignantImpl implements EnsignantInterface {

	private EntityManagerFactory emfactory;

	public EnsignantImpl() {
		super();
		emfactory = Persistence.createEntityManagerFactory("Gestion");

	}

	@Override
	public void insertEnsignant(Ensignant ensignant) {
		emfactory = Persistence.createEntityManagerFactory("Gestion");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		entitymanager.persist(ensignant);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();

	}

	@Override
	public void updateEnsignant(Ensignant ensignant) {
		emfactory = Persistence.createEntityManagerFactory("Gestion");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		entitymanager.merge(ensignant);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();

	}

	@Override
	public void deleteEnsignant(Ensignant ensignant) {
		emfactory = Persistence.createEntityManagerFactory("Gestion");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		entitymanager.remove(entitymanager.merge(ensignant));
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();

	}

	@Override
	public Ensignant findByIdEnsignant(int id) {
		emfactory = Persistence.createEntityManagerFactory("Gestion");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		Ensignant ensignant = entitymanager.find(Ensignant.class, id);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
		return ensignant;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ensignant> getAllEnsignant() {
		emfactory = Persistence.createEntityManagerFactory("Gestion");
		List<Ensignant> list;
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		Query query = entitymanager.createQuery("SELECT e from Ensignant e");
		list = query.getResultList();
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
		return list;
	}
	

}
