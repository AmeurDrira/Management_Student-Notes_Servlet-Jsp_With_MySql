package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the matiereensignier database table.
 * 
 */
@Entity
@NamedQuery(name="Matiereensignier.findAll", query="SELECT m FROM Matiereensignier m")
public class Matiereensignier implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to Groupe
	@ManyToOne
	@JoinColumn(name="idgroupe")
	private Groupe groupe;

	//bi-directional many-to-one association to Matiere
	@ManyToOne
	@JoinColumn(name="idmatiere")
	private Matiere matiere;

	//bi-directional many-to-one association to Ensignant
	@ManyToOne
	@JoinColumn(name="idenseignant")
	private Ensignant ensignant;

	//bi-directional many-to-one association to Note
	@OneToMany(mappedBy="matiereensignier")
	private List<Note> notes;

	public Matiereensignier() {
	}
	

	public Matiereensignier(int id, Groupe groupe, Matiere matiere, Ensignant ensignant) {
		super();
		this.id = id;
		this.groupe = groupe;
		this.matiere = matiere;
		this.ensignant = ensignant;
	}
	public Matiereensignier( Groupe groupe, Matiere matiere, Ensignant ensignant) {
		super();
		
		this.groupe = groupe;
		this.matiere = matiere;
		this.ensignant = ensignant;
	}


	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Groupe getGroupe() {
		return this.groupe;
	}

	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}

	public Matiere getMatiere() {
		return this.matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public Ensignant getEnsignant() {
		return this.ensignant;
	}

	public void setEnsignant(Ensignant ensignant) {
		this.ensignant = ensignant;
	}

	public List<Note> getNotes() {
		return this.notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public Note addNote(Note note) {
		getNotes().add(note);
		note.setMatiereensignier(this);

		return note;
	}

	public Note removeNote(Note note) {
		getNotes().remove(note);
		note.setMatiereensignier(null);

		return note;
	}

}