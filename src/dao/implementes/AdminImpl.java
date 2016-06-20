package dao.implementes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dao.interfaces.AdminInterface;
import model.Admin;
import model.Ensignant;

public class AdminImpl implements AdminInterface {

	private EntityManagerFactory emfactory;

	public AdminImpl() {
		super();
		emfactory = Persistence.createEntityManagerFactory("Gestion");

	}

	@Override
	public void insertAdmin(Admin admin) {
		emfactory = Persistence.createEntityManagerFactory("Gestion");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		entitymanager.persist(admin);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
	}

	@Override
	public void updateAdmin(Admin admin) {
		emfactory = Persistence.createEntityManagerFactory("Gestion");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		entitymanager.merge(admin);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();

	}

	@Override
	public void deleteAdmin(Admin admin) {
		emfactory = Persistence.createEntityManagerFactory("Gestion");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
	
		entitymanager.remove(entitymanager.merge(admin));
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();

	}

	@Override
	public Admin findByIdAdmin(int id) {
		emfactory = Persistence.createEntityManagerFactory("Gestion");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		Admin admin = entitymanager.find(Admin.class, id);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
		return admin;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Admin> getAllAdmin() {
		List<Admin> list;
		emfactory = Persistence.createEntityManagerFactory("Gestion");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		Query query = entitymanager.createQuery("SELECT a from Admin a");
		list = query.getResultList();
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
		return list;
	}

	public Admin findByLoginMotPasse(String login, String pwd) {
		Admin en = new Admin();
		emfactory = Persistence.createEntityManagerFactory("Gestion");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		Query query = entitymanager.createQuery("Select e FROM Admin e WHERE e.login = :login and e.password= :pwd");
		query.setParameter("login", login);
		query.setParameter("pwd", pwd);
		try{
			return en = (Admin) query.getSingleResult();		
	    } catch(NoResultException e) {
	        return en;
	    }
	}

}
