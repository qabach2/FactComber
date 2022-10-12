package App.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@ToString
@Table(name = "Comment_Table")

public class Comment {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int comment_id;
        @Column
        private String comment_body;
        @Column
        private int comment_likes;
        @Column
         private int comment_dislikes;
//         @ManyToOne
//        @JoinColumn(name = "id",referencedColumnName = "id")
        @ManyToOne
//        @JsonBackReference
        @JoinColumn(name = "fact_id",referencedColumnName = "id")
//        @JoinColumn(name = "id")
        Fact fact;


}
