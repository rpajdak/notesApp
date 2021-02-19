package rpajdak.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rpajdak.demo.model.DeletedNote;
import rpajdak.demo.model.Note;
import rpajdak.demo.model.UpdatedNote;
import rpajdak.demo.service.NotesService;

import java.util.List;

import static org.springframework.http.HttpStatus.*;


@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RestController
@RequestMapping("/notes")
public class NotesController {

    private NotesService notesService;

    public NotesController(NotesService notesService) {
        this.notesService = notesService;
    }

    @PostMapping()
    @ResponseBody
    @ResponseStatus(CREATED)
    public ResponseEntity<Object> addNote(@RequestBody Note note) {
        notesService.addNote(note);
        return ResponseEntity.status(CREATED).body("Note has been created.");
    }


    @GetMapping(params = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(OK)
    public Note getNoteById(@PathVariable("id") Long id) {
        return notesService.getNoteById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(OK)
    public List<Note> getAllNotes() {
        return notesService.getAllNotes();
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    @ResponseStatus(NO_CONTENT)
    public void deleteNote(@PathVariable("id") long id) {
        notesService.deleteNote(id);
    }


    @PutMapping
    @ResponseBody
    @ResponseStatus(OK)
    public void updateNote(@RequestBody Note note) {
        notesService.updateNote(note);
    }

    @GetMapping(value = "/deleted", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(OK)
    public List<DeletedNote> getAllDeletedNotes() {
        return notesService.getAllDeletedNotes();
    }

    @GetMapping(value = "/updated/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(OK)
    public List<UpdatedNote> getAllUpdatesNotesById(@PathVariable("id") Long id) {
        return notesService.getAllUpdatesNotesByCurrentID(id);
    }


}
