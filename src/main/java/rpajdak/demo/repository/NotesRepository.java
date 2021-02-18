package rpajdak.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rpajdak.demo.model.Note;

@Repository
public interface NotesRepository extends JpaRepository<Long, Note> {
}
