package dao.interfaces;

import java.util.List;

import model.Ensignant;

public interface EnsignantInterface {
	public void insertEnsignant(Ensignant ensignant);

	public void updateEnsignant(Ensignant ensignant);

	public void deleteEnsignant(Ensignant ensignant);

	public Ensignant findByIdEnsignant(int id);

	public List<Ensignant> getAllEnsignant();

	public Ensignant findByLoginMotPasse(String login, String pwd);

}
