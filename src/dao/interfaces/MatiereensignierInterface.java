package dao.interfaces;

import java.util.List;

import model.Matiereensignier;

public interface MatiereensignierInterface {

	public void insertMatiereensignier(Matiereensignier matiereensignier);

	public void updateMatiereensignier(Matiereensignier matiereensignier);

	public void deleteMatiereensignier(Matiereensignier matiereensignier);

	public Matiereensignier findByIdMatiereensignier(int id);

	public List<Matiereensignier> getAllMatiereensignier();

}
