package questapp.abk.webApiController;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;
import questapp.abk.business.abstracts.CommentService;
import questapp.abk.business.abstracts.SubCommentService;
import questapp.abk.business.requests.comment.CreateACommentRequest;
import questapp.abk.business.requests.subcomment.CreateASubCommentRequest;
import questapp.abk.business.requests.subcomment.UpdateASubCommentRequests;
import questapp.abk.business.requests.user.UpdateUserRequest;
import questapp.abk.business.response.comment.GetByCommentsIdResponse;
import questapp.abk.business.response.like.GetAllLikesResponses;
import questapp.abk.business.response.subcomments.GetAllSubCommentResponses;
import questapp.abk.business.response.subcomments.GetBySubCommentIdResponse;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("subcomments")
@Data
@AllArgsConstructor
public class SubCommentController {
    SubCommentService subCommentService;

    @GetMapping
    public List<GetAllSubCommentResponses> getAllSubCommentResponses(){
        return subCommentService.getAll();
    }
    @PostMapping()
    public CreateASubCommentRequest add(@RequestBody CreateASubCommentRequest createASubCommentRequest){
        return subCommentService.add(createASubCommentRequest);
    }
    //@GetMapping("/{id}")
    //public GetBySubCommentIdResponse getById(@PathVariable Long id){
      //  return subCommentService.getById(id);
    //}
    @PutMapping
    public void update(@RequestBody UpdateASubCommentRequests updateASubCommentRequests) {
        this.subCommentService.update(updateASubCommentRequests);
    }
    @GetMapping(path = "/getsubcomments")
    public List<GetBySubCommentIdResponse> getAllSubComments(@RequestParam Optional<Long> commentId){
        return subCommentService.getAllSubCommentsByCommentId(commentId);
    }
    @DeleteMapping
    public void delete(Long id){
        subCommentService.delete(id);
    }
}
