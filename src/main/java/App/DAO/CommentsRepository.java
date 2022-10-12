package App.DAO;

import App.Model.Comment;
import App.Model.Fact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findAllByFact(Fact id);
}
