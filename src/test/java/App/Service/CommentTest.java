package App.Service;

import App.Model.Comment;
import App.Model.Fact;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CommentTest {
    @Autowired
    CommentsService commentsRepository;
    @Test
    void NewComment() {
        Fact fact = new Fact();
        fact.setId(1);
        Comment comment = new Comment();
        comment.setComment_body("test comment");
        comment.setComment_dislikes(1);
        comment.setComment_likes(2);
        comment.setFact(fact);
        commentsRepository.postNewComment(comment);
    }
}
