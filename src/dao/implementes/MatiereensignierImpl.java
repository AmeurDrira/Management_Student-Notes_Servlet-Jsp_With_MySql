package dao.implementes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dao.interfaces.MatiereensignierInterface;
import model.Ensignant;
import model.Groupe;
import model.Matiere;
import model.Matiereensignier;

public class MatiereensignierImpl implements MatiereensignierInterface {
	private EntityManagerFactory emfactory;

	public MatiereensignierImpl() {
		super();
	}

	@Override
	public void insertMatiereensignier(Matiereensignier matiereensignier) {
		emfactory = Persistence.createEntityManagerFactory("Gestion");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		entitymanager.persist(matiereensignier);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();

	}

	@Override
	public void updateMatiereensignier(Matiereensignier matiereensignier) {
		emfactory = Persistence.createEntityManagerFactory("Gestion");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		entitymanager.merge(matiereensignier);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();

	}

	@Override
	public void deleteMatiereensignier(Matiereensignier matiereensignier) {
		emfactory = Persistence.createEntityManagerFactory("Gestion");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		entitymanager.remove(entitymanager.merge(matiereensignier));
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();

	}

	@Override
	public Matiereensignier findByIdMatiereensignier(int id) {
		emfactory = Persistence.createEntityManagerFactory("Gestion");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		Matiereensignier matiereensignier = entitymanager.find(Matiereensignier.class, id);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
		return matiereensignier;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Matiereensignier> getAllMatiereensignier() {

		List<Matiereensignier> list;
		emfactory = Persistence.createEntityManagerFactory("Gestion");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		Query query = entitymanager.createQuery("SELECT me from Matiereensignier me");
		list = query.getResultList();
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Matiereensignier> getAllMatiereensignierParEnsignant(Ensignant ensignant) {
		List<Matiereensignier> list;
		emfactory = Persistence.createEntityManagerFactory("Gestion");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		Query query = entitymanager.createQuery("SELECT me from Matiereensignier me WHERE me.ensignant.id = :id");
		query.setParameter("id", (int) ensignant.getId());
		list = query.getResultList();
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
		return list;
	}

	@Override
	public Matiereensignier findMatiereensignierParMatGroupEns(Matiere matiere, Groupe groupe, Ensignant ensignant) {
		Matiereensignier en = new Matiereensignier();
		emfactory = Persistence.createEntityManagerFactory("Gestion");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		Query query = entitymanager.createQuery(
				"Select em FROM Matiereensignier em WHERE em.ensignant.id = :ide and em.groupe.id= :idg and em.matiere.id=:idm");
		query.setParameter("idm",  matiere.getId());
		query.setParameter("idg",  groupe.getId());
		query.setParameter("ide",  ensignant.getId());

		try {
			return en = (Matiereensignier) query.getSingleResult();
		} catch (NoResultException e) {
			return en;
		}

	}
	@Override
	public Matiereensignier findMatiereensignierParMatGroup(Matiere matiere, Groupe groupe) {
		Matiereensignier en = new Matiereensignier();
		emfactory = Persistence.createEntityManagerFactory("Gestion");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		Query query = entitymanager.createQuery(
				"Select em FROM Matiereensignier em WHERE  em.groupe.id= :idg and em.matiere.id=:idm");
		query.setParameter("idm",  matiere.getId());
		query.setParameter("idg",  groupe.getId());
		

		try {
			return en = (Matiereensignier) query.getSingleResult();
		} catch (NoResultException e) {
			return en;
		}

	}

}
