package dao.implementes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dao.interfaces.GroupeInterface;
import model.Groupe;

public class GroupeImpl implements GroupeInterface {
	private EntityManagerFactory emfactory;

	public GroupeImpl() {
		super();
		emfactory = Persistence.createEntityManagerFactory("Gestion");

	}

	@Override
	public void insertGroupe(Groupe groupe) {
		emfactory = Persistence.createEntityManagerFactory("Gestion");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		entitymanager.persist(groupe);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
	}

	@Override
	public void updateGroupe(Groupe groupe) {
		emfactory = Persistence.createEntityManagerFactory("Gestion");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		entitymanager.merge(groupe);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();

	}

	@Override
	public void deleteGroupe(Groupe groupe) {
		emfactory = Persistence.createEntityManagerFactory("Gestion");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		entitymanager.remove(entitymanager.merge(groupe));
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();

	}

	@Override
	public Groupe findByIdGroupe(int id) {
		emfactory = Persistence.createEntityManagerFactory("Gestion");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		Groupe groupe = entitymanager.find(Groupe.class, id);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
		return groupe;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Groupe> getAllGroupe() {
		emfactory = Persistence.createEntityManagerFactory("Gestion");
		List<Groupe> list;
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		Query query = entitymanager.createQuery("SELECT g from Groupe g");
		list = query.getResultList();
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
		return list;

	}

}
