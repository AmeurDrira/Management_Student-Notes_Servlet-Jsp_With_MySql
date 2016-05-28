package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the note database table.
 * 
 */
@Entity
@NamedQuery(name="Note.findAll", query="SELECT n FROM Note n")
public class Note implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private float noteexamen;

	private float notepresentielle;

	private float notetd;

	private float notetp;

	private int numcompostage;

	//bi-directional many-to-one association to Etudiant
	@ManyToOne
	@JoinColumn(name="idetudiant")
	private Etudiant etudiant;

	//bi-directional many-to-one association to Session
	@ManyToOne
	@JoinColumn(name="idsession")
	private Session session;

	//bi-directional many-to-one association to Matiereensignier
	@ManyToOne
	@JoinColumn(name="idmatierensignier")
	private Matiereensignier matiereensignier;

	public Note() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getNoteexamen() {
		return this.noteexamen;
	}

	public void setNoteexamen(float noteexamen) {
		this.noteexamen = noteexamen;
	}

	public float getNotepresentielle() {
		return this.notepresentielle;
	}

	public void setNotepresentielle(float notepresentielle) {
		this.notepresentielle = notepresentielle;
	}

	public float getNotetd() {
		return this.notetd;
	}

	public void setNotetd(float notetd) {
		this.notetd = notetd;
	}

	public float getNotetp() {
		return this.notetp;
	}

	public void setNotetp(float notetp) {
		this.notetp = notetp;
	}

	public int getNumcompostage() {
		return this.numcompostage;
	}

	public void setNumcompostage(int numcompostage) {
		this.numcompostage = numcompostage;
	}

	public Etudiant getEtudiant() {
		return this.etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public Session getSession() {
		return this.session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public Matiereensignier getMatiereensignier() {
		return this.matiereensignier;
	}

	public void setMatiereensignier(Matiereensignier matiereensignier) {
		this.matiereensignier = matiereensignier;
	}

}