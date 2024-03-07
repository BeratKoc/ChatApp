package questapp.abk.business.concrete;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import questapp.abk.business.abstracts.SubCommentService;
import questapp.abk.business.requests.comment.CreateACommentRequest;
import questapp.abk.business.requests.comment.UpdateACommentRequest;
import questapp.abk.business.requests.subcomment.CreateASubCommentRequest;
import questapp.abk.business.requests.subcomment.UpdateASubCommentRequests;
import questapp.abk.business.response.comment.GetACommentResponse;
import questapp.abk.business.response.comment.GetAllCommentsResponses;
import questapp.abk.business.response.comment.GetByCommentsIdResponse;
import questapp.abk.business.response.subcomments.GetASubCommentsResponse;
import questapp.abk.business.response.subcomments.GetAllSubCommentResponses;
import questapp.abk.business.response.subcomments.GetBySubCommentIdResponse;
import questapp.abk.core.utilities.mappers.ModelMapperService;
import questapp.abk.dao.abstracts.CommentRepository;
import questapp.abk.dao.abstracts.SubCommentRepository;
import questapp.abk.entities.Comment;
import questapp.abk.entities.SubComment;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SubCommentServiceImpl implements SubCommentService {
    ModelMapperService modelMapperService;
    SubCommentRepository subCommentRepository;

    @Override
    public List<GetAllSubCommentResponses> getAll() {
        List<SubComment>subComments=this.subCommentRepository.findAll();
       return subComments.stream().map(subComment -> this.modelMapperService.forResponse().map(subComment,GetAllSubCommentResponses.class)).collect(Collectors.toList());
    }

    @Override
    public CreateASubCommentRequest add(CreateASubCommentRequest createASubCommentRequest) {
        SubComment subComment=this.modelMapperService.forRequest().map(createASubCommentRequest,SubComment.class);
        subComment.setId(null);
        subComment.setCreateDate(LocalDate.now());
        return this.modelMapperService.forResponse().map(this.subCommentRepository.save(subComment),CreateASubCommentRequest.class);
    }

    @Override
    public GetASubCommentsResponse update(UpdateASubCommentRequests updateASubCommentRequests) {
        SubComment subComment=this.modelMapperService.forRequest().map(updateASubCommentRequests,SubComment.class);
        subComment.setCreateDate(LocalDate.now());
        return this.modelMapperService.forResponse().map(this.subCommentRepository.save(subComment),GetASubCommentsResponse.class);
    }

    @Override
    public void delete(Long id) {
    this.subCommentRepository.deleteById(id);
    }

    @Override
    public GetBySubCommentIdResponse getById(Long id) {
        SubComment subComment=this.subCommentRepository.findById(id).orElseThrow();

        return this.modelMapperService.forResponse().map(subComment,GetBySubCommentIdResponse.class);
    }

    @Override
    public List<GetBySubCommentIdResponse> getAllSubCommentsByCommentId(Optional<Long> commentId) {
        if(commentId.isPresent()){
            List<SubComment> subComments=this.subCommentRepository.findByCommentId(commentId.get());
            return subComments.stream().map(subComment -> this.modelMapperService.forResponse().map(subComment,GetBySubCommentIdResponse.class)).collect(Collectors.toList());
        }
        throw new IllegalArgumentException();

    }
}
