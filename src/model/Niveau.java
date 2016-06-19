package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the niveau database table.
 * 
 */
@Entity
@NamedQuery(name = "Niveau.findAll", query = "SELECT n FROM Niveau n")
public class Niveau implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int code;

	private String libelle;

	private int nbgroupe;

	// bi-directional many-to-one association to Groupe
	@OneToMany(mappedBy = "niveau")
	private List<Groupe> groupes;

	public Niveau() {
	}

	public Niveau(int id, String libelle) {
		super();
		this.id = id;
		code = 0;
		this.libelle = libelle;

	}

	public Niveau(String libelle) {
		super();

		code = 0;
		this.libelle = libelle;

	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getNbgroupe() {
		return this.nbgroupe;
	}

	public void setNbgroupe(int nbgroupe) {
		this.nbgroupe = nbgroupe;
	}

	public List<Groupe> getGroupes() {
		return this.groupes;
	}

	public void setGroupes(List<Groupe> groupes) {
		this.groupes = groupes;
	}

	public Groupe addGroupe(Groupe groupe) {
		getGroupes().add(groupe);
		groupe.setNiveau(this);

		return groupe;
	}

	public Groupe removeGroupe(Groupe groupe) {
		getGroupes().remove(groupe);
		groupe.setNiveau(null);

		return groupe;
	}

}