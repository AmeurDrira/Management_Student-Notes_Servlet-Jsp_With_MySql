package dao.interfaces;

import java.util.List;

import model.Matiere;

public interface MatiereInterface {
	public void insertMatiere(Matiere matiere);

	public void updateMatiere(Matiere matiere);

	public void deleteMatiere(Matiere matiere);

	public Matiere findByIdMatiere(int id);

	public List<Matiere> getAllMatiere();

}
