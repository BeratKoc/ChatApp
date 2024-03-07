package questapp.abk.business.abstracts;
import questapp.abk.business.requests.like.CreateALikeRequest;
import questapp.abk.business.requests.like.UpdateALikeRequest;
import questapp.abk.business.response.like.GetAllLikesResponses;
import questapp.abk.business.response.like.GetByLikeIdResponse;
import java.util.List;

public interface LikeService {
    List<GetAllLikesResponses> getAll();
    GetAllLikesResponses add(CreateALikeRequest createALikeRequest);
    void update(UpdateALikeRequest updateALikeRequest);
    void delete(Long id);
    GetByLikeIdResponse getbyId(Long id);
}
