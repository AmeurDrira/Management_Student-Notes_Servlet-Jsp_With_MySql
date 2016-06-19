package dao.implementes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.sun.xml.internal.ws.encoding.soap.SOAP12Constants;

import dao.interfaces.NiveauInterface;
import model.Groupe;
import model.Niveau;

public class NiveauImpl implements NiveauInterface {
	private EntityManagerFactory emfactory;

	public NiveauImpl() {
		super();
		// emfactory = Persistence.createEntityManagerFactory("Gestion");

	}

	@Override
	public void insertNiveau(Niveau niveau) {
		emfactory = Persistence.createEntityManagerFactory("Gestion");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		entitymanager.persist(niveau);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
	}

	@Override
	public void updateNiveau(Niveau niveau) {
		emfactory = Persistence.createEntityManagerFactory("Gestion");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		entitymanager.merge(niveau);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();

	}

	@Override
	public void deleteNiveau(Niveau niveau) {
		emfactory = Persistence.createEntityManagerFactory("Gestion");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		entitymanager.remove(entitymanager.merge(niveau));
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();

	}

	@Override
	public Niveau findByIdNiveau(int id) {
		emfactory = Persistence.createEntityManagerFactory("Gestion");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		Niveau niveau = entitymanager.find(Niveau.class, id);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
		return niveau;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Niveau> getAllNiveau() {
		emfactory = Persistence.createEntityManagerFactory("Gestion");
		List<Niveau> list;
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		Query query = entitymanager.createQuery("SELECT n from Niveau n");
		list = query.getResultList();
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
		return list;
	}

	@Override
	public void nombreGroup() {
		emfactory = Persistence.createEntityManagerFactory("Gestion");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		List<Niveau> niveaux = getAllNiveau();
		Niveau niveau = new Niveau();
		int i = 0;

		for (Niveau group : niveaux) {

			Query query = entitymanager.createQuery("Select COUNT(e) FROM Groupe e WHERE e.niveau.id = :id");
			query.setParameter("id", (int) group.getId());
			i = ((Long) query.getSingleResult()).intValue();
			System.out.println(i);
			niveau = findByIdNiveau((int) group.getId());
			niveau.setNbgroupe(i);
			entitymanager.merge(niveau);
			i = 0;
		}

		entitymanager.getTransaction().commit();
		entitymanager.close();

	}

}
