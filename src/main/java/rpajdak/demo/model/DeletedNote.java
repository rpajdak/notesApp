package rpajdak.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "deleted_note")
public class DeletedNote {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    @Column(name = "old_id")
    private Long OldId;

    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;

    @Column(name = "created")
    private LocalDate created;
    @Column(name = "modified")
    private LocalDate modified;

    public DeletedNote() {
    }

    public DeletedNote(Long oldId, String title, String content, LocalDate created, LocalDate modified) {
        OldId = oldId;
        this.title = title;
        this.content = content;
        this.created = created;
        this.modified = modified;
    }
}
