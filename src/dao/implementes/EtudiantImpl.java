package dao.implementes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dao.interfaces.EtudiantInterface;
import model.Etudiant;

public class EtudiantImpl implements EtudiantInterface {

	private EntityManagerFactory emfactory;

	public EtudiantImpl() {
		super();
		emfactory = Persistence.createEntityManagerFactory("Gestion");

	}
	

	@Override
	public void insertEtudiant(Etudiant etudiant) {
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		entitymanager.persist(etudiant);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();

	}

	@Override
	public void updateEtudiant(Etudiant etudiant) {
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		entitymanager.merge(etudiant);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();

	}

	@Override
	public void deleteEtudiant(Etudiant etudiant) {
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		entitymanager.remove(etudiant);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();

	}

	@Override
	public Etudiant findByIdEtudiant(int id) {
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		Etudiant etudiant = entitymanager.find(Etudiant.class, id);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
		return etudiant;
	}

	@Override
	public List<Etudiant> getAllEtudiant() {

		List<Etudiant> list;
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		Query query = entitymanager.createQuery("SELECT e from Etudiant e");
		list = query.getResultList();
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
		return list;
	}

}
