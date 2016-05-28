package dao.interfaces;

import java.util.List;

import model.Groupe;

public interface GroupeInterface {
	public void insertGroupe(Groupe groupe);

	public void updateGroupe(Groupe groupe);

	public void deleteGroupe(Groupe groupe);

	public Groupe findByIdGroupe(int id);

	public List<Groupe> getAllGroupe();

}
