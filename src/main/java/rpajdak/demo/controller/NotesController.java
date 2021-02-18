package rpajdak.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rpajdak.demo.model.Note;
import rpajdak.demo.service.NotesService;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;


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
    public ResponseEntity<Object> attemptToAddUser(@RequestBody Note note) {
        notesService.addNote(note);
        return ResponseEntity.status(CREATED).body("Note has been created.");
    }


    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
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


}
