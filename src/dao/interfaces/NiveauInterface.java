package dao.interfaces;

import java.util.List;

import model.Niveau;

public interface NiveauInterface {
	public void insertNiveau(Niveau niveau);

	public void updateNiveau(Niveau niveau);

	public void deleteNiveau(Niveau niveau);

	public Niveau findByIdNiveau(int id);

	public List<Niveau> getAllNiveau();

}
