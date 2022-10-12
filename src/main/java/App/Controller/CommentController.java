package App.Controller;


import App.Model.Comment;
import App.Service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/Comment")

public class CommentController {
    private final CommentsService commentService;

    @Autowired
    public  CommentController(CommentsService commentService){
        this.commentService = commentService;
    }
    @PostMapping
    public Comment PostNewComment(@RequestBody Comment comment){
        return commentService.postNewComment(comment);
    }
    @GetMapping("all/{id}")
    public List<Comment> findAllCommentsByFactId(@PathVariable("id")int id){
      return commentService.getAllCommentsByFact(id);
    }
    @PutMapping("dislikes/{id}")
    public Comment updateCommentDislikes (@PathVariable ("id") int id ,@RequestBody Comment comment){
        Comment updatedComment = commentService.updateDislikesById( comment, id);
       return updatedComment;
    }
    @PutMapping("likes/{id}")
    public Comment updateCommentLikes (@PathVariable ("id") int id ,@RequestBody Comment comment){
        Comment updatedComment = commentService.updateLikesById( comment, id);
        return updatedComment;
    }
    @DeleteMapping("/{id}")
    public void  deleteCommentById(@PathVariable ("id") int id ){
        commentService.deleteCommentById(id);

    }
    @GetMapping("/{id}")
    public  Comment getCommentById(@PathVariable("id") int id){
        return commentService.getCommentById(id);
    }
}
