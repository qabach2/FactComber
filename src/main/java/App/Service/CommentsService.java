package App.Service;

import App.DAO.CommentsRepository;
import App.DAO.FactsRepository;
import App.Model.Comment;
import App.Model.Fact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component

public class CommentsService {

    CommentsRepository commentsRepository;

  FactsRepository factsRepository;
    @Autowired
  public CommentsService( CommentsRepository commentsRepository, FactsRepository factsRepository){
       this.commentsRepository = commentsRepository;
       this.factsRepository =factsRepository;
  }
    public Comment postNewComment(Comment comment){
        commentsRepository.save(comment);
        System.out.println(comment);
        return comment;
    }
    public void deleteCommentById(int id){
        commentsRepository.deleteById(id);
    }
    public List<Comment> getAllCommentsByFact(int id){
        Fact fact = factsRepository.findFactById(id).get();
       return commentsRepository.findAllByFact(fact);

    }
    public Comment getCommentById(int id){
        return commentsRepository.findById(id).get();
    }
    public Comment updateLikesById(Comment comment,int id){

        Comment  existingComment= commentsRepository.findById(comment.getComment_id()).get();
        existingComment.setComment_likes(comment.getComment_likes());
        commentsRepository.save(existingComment);
        return existingComment;
    }

    public Comment updateDislikesById(Comment comment,int id){

        Comment  existingComment= commentsRepository.findById(comment.getComment_id()).get();
        existingComment.setComment_dislikes(comment.getComment_dislikes());
        commentsRepository.save(existingComment);
        return existingComment;
    }

}
