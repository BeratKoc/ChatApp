package questapp.abk.business.concrete;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import questapp.abk.business.abstracts.CommentService;
import questapp.abk.business.requests.comment.CreateACommentRequest;
import questapp.abk.business.requests.comment.UpdateACommentRequest;
import questapp.abk.business.response.comment.GetACommentResponse;
import questapp.abk.business.response.comment.GetAllCommentsResponses;
import questapp.abk.business.response.comment.GetByCommentsIdResponse;
import questapp.abk.core.utilities.mappers.ModelMapperService;
import questapp.abk.dao.abstracts.CommentRepository;
import questapp.abk.entities.Comment;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {
    ModelMapperService modelMapperService;
    CommentRepository commentRepository;
    @Override
    public List<GetAllCommentsResponses> getAll() {
        List<Comment> comments=this.commentRepository.findAll();

        return comments.stream().map(comment-> this.modelMapperService.forResponse().map(comment,GetAllCommentsResponses.class)).toList();
    }

    @Override
    public CreateACommentRequest add(CreateACommentRequest createACommentRequest) {
      Comment comment=this.modelMapperService.forRequest().map(createACommentRequest,Comment.class);
      comment.setCreateDate(LocalDate.now());
      return this.modelMapperService.forResponse().map(this.commentRepository.save(comment),CreateACommentRequest.class);
    }

    @Override
    public GetACommentResponse update(UpdateACommentRequest updateACommentRequest) {
        Comment comment=this.modelMapperService.forRequest().map(updateACommentRequest,Comment.class);
        comment.setUpdateDate(LocalDate.now());
        return this.modelMapperService.forResponse().map(this.commentRepository.save(comment),GetACommentResponse.class);
    }

    public void delete(Long id){
        this.commentRepository.deleteById(id);
    }
    public GetByCommentsIdResponse getById(Long id){
        Comment comment=this.commentRepository.findById(id).orElseThrow();
        return this.modelMapperService.forResponse().map(comment,GetByCommentsIdResponse.class);
    }

    @Override
    public List<GetByCommentsIdResponse> getAllCommentsWithParam(Optional<Long> userId, Optional<Long> postId) {


            if(userId.isPresent() && postId.isPresent()){
                List<Comment> comments= commentRepository.findByUserIdAndPostId(userId.get(),postId.get());
               return comments.stream().map(comment -> this.modelMapperService.forResponse().map(comment,GetByCommentsIdResponse.class)).collect(Collectors.toList());
            } else if (userId.isPresent()) {
                List<Comment> comments= commentRepository.findByUserId(userId.get());
                return comments.stream().map(comment -> this.modelMapperService.forResponse().map(comment,GetByCommentsIdResponse.class)).collect(Collectors.toList());
            } else if (postId.isPresent()) {
                List<Comment> comments= commentRepository.findByPostId(postId.get());
                return comments.stream().map(comment -> this.modelMapperService.forResponse().map(comment,GetByCommentsIdResponse.class)).collect(Collectors.toList());
            }
            else{
                List<Comment> comments= commentRepository.findAll();
                return comments.stream().map(comment -> this.modelMapperService.forResponse().map(comment,GetByCommentsIdResponse.class)).collect(Collectors.toList());
            }

    }


}
