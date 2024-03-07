package questapp.abk.business.abstracts;


import org.springframework.web.bind.annotation.RequestParam;

import questapp.abk.business.requests.subcomment.CreateASubCommentRequest;
import questapp.abk.business.requests.subcomment.UpdateASubCommentRequests;

import questapp.abk.business.response.subcomments.GetASubCommentsResponse;
import questapp.abk.business.response.subcomments.GetAllSubCommentResponses;
import questapp.abk.business.response.subcomments.GetBySubCommentIdResponse;

import java.util.List;
import java.util.Optional;

public interface SubCommentService {
    List<GetAllSubCommentResponses> getAll();
    CreateASubCommentRequest add(CreateASubCommentRequest createASubCommentRequest);
    GetASubCommentsResponse update(UpdateASubCommentRequests updateASubCommentRequests);
    void delete(Long id);
    public GetBySubCommentIdResponse getById(Long id);

    public List<GetBySubCommentIdResponse> getAllSubCommentsByCommentId(@RequestParam Optional<Long> commentId);


}
