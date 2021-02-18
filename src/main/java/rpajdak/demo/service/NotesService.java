package rpajdak.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rpajdak.demo.model.DeletedNote;
import rpajdak.demo.model.Note;
import rpajdak.demo.repository.DeletedNotesRepository;
import rpajdak.demo.repository.NotesRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class NotesService {

    NotesRepository notesRepository;
    DeletedNotesRepository deletedNotesRepository;

    public NotesService(NotesRepository notesRepository, DeletedNotesRepository deletedNotesRepository) {
        this.notesRepository = notesRepository;
        this.deletedNotesRepository = deletedNotesRepository;
    }

    public void addNote(Note note) {
        setCurrentDateToNewNote(note);
        notesRepository.save(note);
    }

    public Note getNoteById(Long id) {
        return notesRepository.getNoteById(id);
    }

    public List<Note> getAllNotes() {
        return notesRepository.findAll();
    }

    private void setCurrentDateToNewNote(Note note) {
        note.setCreated(LocalDate.now());
    }

    @Transactional
    public void deleteNote(long id) {
        Note note = notesRepository.getNoteById(id);
        moveNoteToDeleted(note);
        notesRepository.deleteById(id);
    }

    private void moveNoteToDeleted(Note note) {
        DeletedNote deletedNote = DeletedNote.builder()
                .OldId(note.getId())
                .title(note.getTitle())
                .content(note.getContent())
                .created(note.getCreated())
                .build();
        deletedNotesRepository.save(deletedNote);
    }

    public void updateNote(Note note) {
        Note existingNote = notesRepository.getNoteById(note.getId());
    }

    public List<DeletedNote> getAllDeletedNotes() {
        return deletedNotesRepository.findAll();
    }

}
