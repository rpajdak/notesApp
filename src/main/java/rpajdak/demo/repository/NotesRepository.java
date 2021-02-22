package rpajdak.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import rpajdak.demo.model.Note;

@Repository
public interface NotesRepository extends JpaRepository<Note, Long> {

    Note getNoteById(Long id);

    @Query("SELECT n.initialId FROM Note n WHERE n.id= :id")
    Long getInitialId(Long id);
}
