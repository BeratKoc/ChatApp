package questapp.abk.business.abstracts;

import questapp.abk.business.requests.post.CreatAPostRequest;
import questapp.abk.business.requests.post.UpdateAPostRequest;
import questapp.abk.business.response.post.GetAllPostResponses;
import questapp.abk.business.response.post.GetByPostIdResponse;
import questapp.abk.business.response.user.GetByUserIdResponse;

import java.util.List;

public interface PostService {
    List<GetAllPostResponses> getAll();
    void add(CreatAPostRequest creatAPostRequest);
    void update(UpdateAPostRequest updateAPostRequest);
    void delete(Long id);
    GetByPostIdResponse getById(Long id);
}
