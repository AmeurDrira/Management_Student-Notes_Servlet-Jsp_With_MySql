package dao.interfaces;

import java.util.List;

import model.Etudiant;
import model.Groupe;
import model.Matiere;
import model.Matiereensignier;
import model.Note;

public interface NoteInterface {
	public void insertNote(Note note);

	public void updateNote(Note note);

	public void deleteNote(Note note);

	public Note findByIdNote(int id);

	public List<Note> getAllNote();

	public void InsererCompostageControle(Etudiant etudiant, Matiereensignier matiereensignier);

	public void InsererCompostagePrincipale(Etudiant etudiant, Matiereensignier matiereensignier);

	public List<Note> getAllNoteByGroup(Groupe groupe);

	public Note getAllNoteByEtudiant(Etudiant etudiant, Matiere matiere);

	public List<Note> getAllNoteByGroupMatiere(Groupe groupe, Matiere matiere);

	public List<Note> getAllNoteByEtudiant(Etudiant etudiant);

	public String compostageCode();

}
