package rpajdak.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rpajdak.demo.model.DeletedNote;
import rpajdak.demo.model.Note;
import rpajdak.demo.model.UpdatedNote;
import rpajdak.demo.repository.DeletedNotesRepository;
import rpajdak.demo.repository.NotesRepository;
import rpajdak.demo.repository.UpdatedNotesRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class NotesService {

    NotesRepository notesRepository;
    DeletedNotesRepository deletedNotesRepository;
    UpdatedNotesRepository updatedNotesRepository;

    public NotesService(NotesRepository notesRepository, DeletedNotesRepository deletedNotesRepository, UpdatedNotesRepository updatedNotesRepository) {
        this.notesRepository = notesRepository;
        this.deletedNotesRepository = deletedNotesRepository;
        this.updatedNotesRepository = updatedNotesRepository;
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
        Note oldNote = notesRepository.getNoteById(note.getId());

        Long initialId = oldNote.getInitialId();
        if (initialId == null) {
            initialId = note.getId();
        }

        UpdatedNote updatedNote = UpdatedNote.builder()
                .title(oldNote.getTitle())
                .content(oldNote.getContent())
                .created(oldNote.getCreated())
                .modified(LocalDate.now())
                .initialId(initialId)
                .build();

        updatedNotesRepository.save(updatedNote);

        notesRepository.deleteById(note.getId());
        Note newNote = Note.builder()
                .title(note.getTitle())
                .content(note.getTitle())
                .created(oldNote.getCreated())
                .modified(LocalDate.now())
                .initialId(initialId)
                .build();

        addNote(newNote);
    }

    public List<DeletedNote> getAllDeletedNotes() {
        return deletedNotesRepository.findAll();
    }

    public List<UpdatedNote> getAllUpdatesNotesByCurrentID(Long id) {
        long initialId = notesRepository.getInitialId(id);
        return updatedNotesRepository.findAllByInitialId(initialId);
    }
}
