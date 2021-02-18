package rpajdak.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@Entity
@Builder
@AllArgsConstructor
@Table(name = "deleted_note")
public class DeletedNote {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

}
