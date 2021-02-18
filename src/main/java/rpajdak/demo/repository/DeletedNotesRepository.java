package rpajdak.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rpajdak.demo.model.DeletedNote;

public interface DeletedNotesRepository extends JpaRepository<DeletedNote,Long> {
}
