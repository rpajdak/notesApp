package rpajdak.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rpajdak.demo.model.Note;
import rpajdak.demo.service.NotesService;

import static org.springframework.http.HttpStatus.CREATED;


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


}
