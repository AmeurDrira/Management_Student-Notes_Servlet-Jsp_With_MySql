package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the groupe database table.
 * 
 */
@Entity
@NamedQuery(name="Groupe.findAll", query="SELECT g FROM Groupe g")
public class Groupe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String abreviation;

	private int code;

	private String libelle;

	//bi-directional many-to-one association to Etudiant
	@OneToMany(mappedBy="groupe")
	private List<Etudiant> etudiants;

	//bi-directional many-to-one association to Niveau
	@ManyToOne
	@JoinColumn(name="idniveau")
	private Niveau niveau;

	//bi-directional many-to-one association to Matiereensignier
	@OneToMany(mappedBy="groupe")
	private List<Matiereensignier> matiereensigniers;

	public Groupe() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAbreviation() {
		return this.abreviation;
	}

	public void setAbreviation(String abreviation) {
		this.abreviation = abreviation;
	}

	public int getCode() {
		return this.code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Etudiant> getEtudiants() {
		return this.etudiants;
	}

	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}

	public Etudiant addEtudiant(Etudiant etudiant) {
		getEtudiants().add(etudiant);
		etudiant.setGroupe(this);

		return etudiant;
	}

	public Etudiant removeEtudiant(Etudiant etudiant) {
		getEtudiants().remove(etudiant);
		etudiant.setGroupe(null);

		return etudiant;
	}

	public Niveau getNiveau() {
		return this.niveau;
	}

	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}

	public List<Matiereensignier> getMatiereensigniers() {
		return this.matiereensigniers;
	}

	public void setMatiereensigniers(List<Matiereensignier> matiereensigniers) {
		this.matiereensigniers = matiereensigniers;
	}

	public Matiereensignier addMatiereensignier(Matiereensignier matiereensignier) {
		getMatiereensigniers().add(matiereensignier);
		matiereensignier.setGroupe(this);

		return matiereensignier;
	}

	public Matiereensignier removeMatiereensignier(Matiereensignier matiereensignier) {
		getMatiereensigniers().remove(matiereensignier);
		matiereensignier.setGroupe(null);

		return matiereensignier;
	}

}