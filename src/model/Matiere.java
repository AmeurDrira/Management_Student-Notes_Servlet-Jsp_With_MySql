package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the matiere database table.
 * 
 */
@Entity
@NamedQuery(name="Matiere.findAll", query="SELECT m FROM Matiere m")
public class Matiere implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int code;

	private float coefficient;

	private int credit;

	private String libelle;

	private float volumec;

	private float volumetd;

	private float volumetp;

	//bi-directional many-to-one association to Matiereensignier
	@OneToMany(mappedBy="matiere")
	private List<Matiereensignier> matiereensigniers;

	public Matiere() {
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

	public float getCoefficient() {
		return this.coefficient;
	}

	public void setCoefficient(float coefficient) {
		this.coefficient = coefficient;
	}

	public int getCredit() {
		return this.credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public float getVolumec() {
		return this.volumec;
	}

	public void setVolumec(float volumec) {
		this.volumec = volumec;
	}

	public float getVolumetd() {
		return this.volumetd;
	}

	public void setVolumetd(float volumetd) {
		this.volumetd = volumetd;
	}

	public float getVolumetp() {
		return this.volumetp;
	}

	public void setVolumetp(float volumetp) {
		this.volumetp = volumetp;
	}

	public List<Matiereensignier> getMatiereensigniers() {
		return this.matiereensigniers;
	}

	public void setMatiereensigniers(List<Matiereensignier> matiereensigniers) {
		this.matiereensigniers = matiereensigniers;
	}

	public Matiereensignier addMatiereensignier(Matiereensignier matiereensignier) {
		getMatiereensigniers().add(matiereensignier);
		matiereensignier.setMatiere(this);

		return matiereensignier;
	}

	public Matiereensignier removeMatiereensignier(Matiereensignier matiereensignier) {
		getMatiereensigniers().remove(matiereensignier);
		matiereensignier.setMatiere(null);

		return matiereensignier;
	}

}