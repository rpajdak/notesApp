package rpajdak.demo.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@Builder
@AllArgsConstructor
@Entity
@Table(name = "updated_note")
public class UpdatedNote {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "initial_id")
    private Long initialId;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "created")
    private LocalDate created;

    @Column(name = "modified")
    private LocalDate modified;

    public UpdatedNote() {
    }

    public UpdatedNote(Long id, String title, String content, LocalDate created) {
        this.initialId = id;
        this.title = title;
        this.content = content;
        this.created = created;
    }


}
