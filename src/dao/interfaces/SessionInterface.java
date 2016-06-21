package dao.interfaces;

import java.util.List;

import model.Session;

public interface SessionInterface {
	public void insertSession(Session session);

	public void updateSession(Session session);

	public void deleteSession(Session session);

	public Session findByIdSession(int id);

	public List<Session> getAllSession();

	public Session findSessionPrincipale();

	public Session findSessionControle();

}
