package questapp.abk.webApiController;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;
import questapp.abk.business.abstracts.CommentService;
import questapp.abk.business.abstracts.LikeService;
import questapp.abk.business.requests.comment.CreateACommentRequest;
import questapp.abk.business.requests.comment.UpdateACommentRequest;
import questapp.abk.business.requests.like.CreateALikeRequest;
import questapp.abk.business.requests.like.UpdateALikeRequest;
import questapp.abk.business.response.comment.GetACommentResponse;
import questapp.abk.business.response.comment.GetAllCommentsResponses;
import questapp.abk.business.response.comment.GetByCommentsIdResponse;
import questapp.abk.business.response.like.GetAllLikesResponses;
import questapp.abk.business.response.like.GetByLikeIdResponse;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
@AllArgsConstructor
@Data
public class  CommentController {
    CommentService commentService;

    @PostMapping()
    public CreateACommentRequest add(@RequestBody CreateACommentRequest createACommentRequest){
        return commentService.add(createACommentRequest);
    }
    @GetMapping("/{id}")
    public GetByCommentsIdResponse getById(@PathVariable Long id){
        return commentService.getById(id);
    }

    @GetMapping()
    public List<GetByCommentsIdResponse> getAllComments(@RequestParam Optional<Long> userId,
                                                @RequestParam Optional<Long> postId) {
        return commentService.getAllCommentsWithParam(userId, postId);
    }
    @PutMapping
    public void update(@RequestBody UpdateACommentRequest updateACommentRequest){
       commentService.update(updateACommentRequest);
    };
    @DeleteMapping
    public void delete(Long id){
        commentService.delete(id);
    }

}
