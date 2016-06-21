package dao.interfaces;

import java.util.List;

import model.Ensignant;
import model.Groupe;
import model.Matiere;
import model.Matiereensignier;

public interface MatiereensignierInterface {

	public void insertMatiereensignier(Matiereensignier matiereensignier);

	public void updateMatiereensignier(Matiereensignier matiereensignier);

	public void deleteMatiereensignier(Matiereensignier matiereensignier);

	public Matiereensignier findByIdMatiereensignier(int id);

	public List<Matiereensignier> getAllMatiereensignier();

	public List<Matiereensignier> getAllMatiereensignierParEnsignant(Ensignant ensignant);

	public Matiereensignier findMatiereensignierParMatGroupEns(Matiere matiere, Groupe groupe, Ensignant e);

	public Matiereensignier findMatiereensignierParMatGroup(Matiere matiere, Groupe groupe);

}
