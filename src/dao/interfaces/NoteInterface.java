package dao.interfaces;

import java.util.List;

import model.Note;

public interface NoteInterface {
	public void insertNote(Note note);

	public void updateNote(Note note);

	public void deleteNote(Note note);

	public Note findByIdNote(int id);

	public List<Note> getAllNote();

}
