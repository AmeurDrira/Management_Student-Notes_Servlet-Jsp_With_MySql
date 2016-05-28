package dao.interfaces;

import java.util.List;

import model.Etudiant;

public interface EtudiantInterface {
	public void insertEtudiant(Etudiant etudiant);

	public void updateEtudiant(Etudiant etudiant);

	public void deleteEtudiant(Etudiant etudiant);

	public Etudiant findByIdEtudiant(int id);

	public List<Etudiant> getAllEtudiant();

}
