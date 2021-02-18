package rpajdak.demo.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@Entity
public class Note {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;

    @Column(name = "created")
    private LocalDate created;
    @Column(name = "modified")
    private LocalDate modified;

    public Note() {
    }


    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
