package dao.implementes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dao.interfaces.MatiereensignierInterface;
import model.Matiereensignier;

public class MatiereensignierImpl implements MatiereensignierInterface {
	private EntityManagerFactory emfactory;

	public MatiereensignierImpl() {
		super();
		emfactory = Persistence.createEntityManagerFactory("Gestion");
	}

	@Override
	public void insertMatiereensignier(Matiereensignier matiereensignier) {
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		entitymanager.persist(matiereensignier);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();

	}

	@Override
	public void updateMatiereensignier(Matiereensignier matiereensignier) {
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		entitymanager.merge(matiereensignier);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();

	}

	@Override
	public void deleteMatiereensignier(Matiereensignier matiereensignier) {
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		entitymanager.remove(matiereensignier);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();

	}

	@Override
	public Matiereensignier findByIdMatiereensignier(int id) {
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		Matiereensignier matiereensignier = entitymanager.find(Matiereensignier.class, id);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
		return matiereensignier;
	}

	@Override
	public List<Matiereensignier> getAllMatiereensignier() {
		List<Matiereensignier> list;
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		Query query = entitymanager.createQuery("SELECT me from Matiereensignier me");
		list = query.getResultList();
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
		return list;
	}

}
