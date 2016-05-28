package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ensignant database table.
 * 
 */
@Entity
@NamedQuery(name="Ensignant.findAll", query="SELECT e FROM Ensignant e")
public class Ensignant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int cin;

	@Temporal(TemporalType.DATE)
	private Date dateNaissance;

	private String login;

	private String nom;

	private String password;

	private String prenom;

	private int tel;

	//bi-directional many-to-one association to Matiereensignier
	@OneToMany(mappedBy="ensignant")
	private List<Matiereensignier> matiereensigniers;

	public Ensignant() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCin() {
		return this.cin;
	}

	public void setCin(int cin) {
		this.cin = cin;
	}

	public Date getDateNaissance() {
		return this.dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getTel() {
		return this.tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public List<Matiereensignier> getMatiereensigniers() {
		return this.matiereensigniers;
	}

	public void setMatiereensigniers(List<Matiereensignier> matiereensigniers) {
		this.matiereensigniers = matiereensigniers;
	}

	public Matiereensignier addMatiereensignier(Matiereensignier matiereensignier) {
		getMatiereensigniers().add(matiereensignier);
		matiereensignier.setEnsignant(this);

		return matiereensignier;
	}

	public Matiereensignier removeMatiereensignier(Matiereensignier matiereensignier) {
		getMatiereensigniers().remove(matiereensignier);
		matiereensignier.setEnsignant(null);

		return matiereensignier;
	}

}