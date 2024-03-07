package questapp.abk.business.abstracts;

import questapp.abk.business.requests.comment.CreateACommentRequest;
import questapp.abk.business.requests.comment.UpdateACommentRequest;
import questapp.abk.business.requests.like.CreateALikeRequest;
import questapp.abk.business.requests.like.UpdateALikeRequest;
import questapp.abk.business.response.comment.GetACommentResponse;
import questapp.abk.business.response.comment.GetAllCommentsResponses;
import questapp.abk.business.response.comment.GetByCommentsIdResponse;
import questapp.abk.business.response.like.GetAllLikesResponses;
import questapp.abk.business.response.like.GetByLikeIdResponse;
import questapp.abk.entities.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    List<GetAllCommentsResponses> getAll();
    CreateACommentRequest add(CreateACommentRequest createACommentRequest);
    GetACommentResponse update(UpdateACommentRequest updateACommentRequest);
    void delete(Long id);
    public GetByCommentsIdResponse getById(Long id);
    List<GetByCommentsIdResponse> getAllCommentsWithParam(Optional<Long> userId, Optional<Long> postId);

}
