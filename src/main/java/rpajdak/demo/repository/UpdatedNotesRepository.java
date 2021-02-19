package rpajdak.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import rpajdak.demo.model.UpdatedNote;

import java.util.List;

public interface UpdatedNotesRepository extends JpaRepository<UpdatedNote, Long> {

    @Query("SELECT u FROM UpdatedNote u WHERE u.initialId= :id")
    List<UpdatedNote> findAllByInitialId(Long id);
}
