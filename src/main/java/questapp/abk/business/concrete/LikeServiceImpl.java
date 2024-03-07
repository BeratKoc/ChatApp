package questapp.abk.business.concrete;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import questapp.abk.business.abstracts.LikeService;
import questapp.abk.business.requests.like.CreateALikeRequest;
import questapp.abk.business.requests.like.UpdateALikeRequest;
import questapp.abk.business.response.like.GetAllLikesResponses;
import questapp.abk.business.response.like.GetByLikeIdResponse;
import questapp.abk.core.utilities.mappers.ModelMapperService;
import questapp.abk.dao.abstracts.LikeRepository;
import questapp.abk.entities.Like;
import java.util.List;
@Service
@AllArgsConstructor
public class LikeServiceImpl implements LikeService {
    LikeRepository likeRepository;
    ModelMapperService modelMapperService;
    @Override
    public List<GetAllLikesResponses> getAll() {
        List<Like>likes=this.likeRepository.findAll();
        return likes.stream().map(like -> this.modelMapperService.forResponse().map(like,GetAllLikesResponses.class)).toList();
    }

    @Override
    public GetAllLikesResponses add(CreateALikeRequest createALikeRequest) {
        Like like=this.modelMapperService.forRequest().map(createALikeRequest,Like.class);
        return this.modelMapperService.forResponse().map(this.likeRepository.save(like),GetAllLikesResponses.class);

    }

    @Override
    public void update(UpdateALikeRequest updateALikeRequest) {
        Like like=this.modelMapperService.forRequest().map(updateALikeRequest,Like.class);
        this.likeRepository.save(like);
    }

    @Override
    public void delete(Long id) {
        this.likeRepository.deleteById(id);

    }

    @Override
    public GetByLikeIdResponse getbyId(Long id) {
        Like like= this.likeRepository.findById(id).orElseThrow();
        return this.modelMapperService.forResponse().map(like,GetByLikeIdResponse.class);
    }


}
