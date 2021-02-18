package rpajdak.demo.service;

import org.springframework.stereotype.Service;
import rpajdak.demo.model.Note;
import rpajdak.demo.repository.NotesRepository;

import java.time.LocalDate;

@Service
public class NotesService {

    NotesRepository notesRepository;

    public NotesService(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }

    public void addNote(Note note) {
        setCurrentDateToNewNote(note);
        notesRepository.save(note);
    }

    private void setCurrentDateToNewNote(Note note) {
        note.setCreated(LocalDate.now());
    }
}
