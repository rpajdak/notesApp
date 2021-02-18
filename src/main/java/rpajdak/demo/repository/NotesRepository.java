package rpajdak.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rpajdak.demo.model.Note;

public interface NotesRepository extends JpaRepository<Long, Note> {
}
