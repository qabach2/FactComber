package App.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@ToString
@Table(name = "Fact_Table")
public class Fact {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String fact_body;
    @Column
    private int fact_likes;
//    @OneToMany
//    @JoinColumn(name = "comment_id",referencedColumnName = "comment_id")
// private ArrayList<Comment> comments;
//    @OneToMany(mappedBy = "fact")
//    @JsonManagedReference
//    Comment comments ;
}
