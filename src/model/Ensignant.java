package model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
	
	@Transient
	private String sdateNaissance; 

	//bi-directional many-to-one association to Matiereensignier
	@OneToMany(mappedBy="ensignant")
	private List<Matiereensignier> matiereensigniers;

	public Ensignant() {
	}
	

	public Ensignant(int id, int cin, Date dateNaissance, String login, String nom, String password, String prenom,
			int tel) {
		super();
		this.id = id;
		this.cin = cin;
		this.dateNaissance = dateNaissance;
		this.login = login;
		this.nom = nom;
		this.password = password;
		this.prenom = prenom;
		this.tel = tel;
		
	}
	
	public Ensignant(int cin, Date dateNaissance, String login, String nom, String password, String prenom,
			int tel) {
		super();
		this.cin = cin;
		this.dateNaissance = dateNaissance;
		this.login = login;
		this.nom = nom;
		this.password = password;
		this.prenom = prenom;
		this.tel = tel;
		
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
		SimpleDateFormat spd = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		try {
			String stringDate = spd.format(this.dateNaissance);
			 date = spd.parse(stringDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
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

	public String getSdateNaissance() {
		SimpleDateFormat spd = new SimpleDateFormat("yyyy-MM-dd");


			String stringDate = spd.format(this.dateNaissance);
		return stringDate;
	}


	public void setSdateNaissance(String sdateNaissance) {
		this.sdateNaissance = sdateNaissance;
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