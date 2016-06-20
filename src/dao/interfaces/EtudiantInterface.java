package dao.interfaces;

import java.util.List;

import model.Etudiant;
import model.Groupe;

public interface EtudiantInterface {
	public void insertEtudiant(Etudiant etudiant);

	public void updateEtudiant(Etudiant etudiant);

	public void deleteEtudiant(Etudiant etudiant);

	public Etudiant findByIdEtudiant(int id);

	public List<Etudiant> getAllEtudiant();

	public List<Etudiant> findEtudiantbyGroupe(int id);

	public Etudiant findByLoginMotPasse(String login, String pwd);


}
