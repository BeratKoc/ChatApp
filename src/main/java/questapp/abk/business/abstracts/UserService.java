package questapp.abk.business.abstracts;

import questapp.abk.business.requests.user.CreateAUserRequest;
import questapp.abk.business.requests.user.UpdateUserRequest;
import questapp.abk.business.response.user.GetAllUserResponses;
import questapp.abk.business.response.user.GetByUserIdResponse;

import java.util.List;

public interface UserService {
    List<GetAllUserResponses> getAll();
    void add(CreateAUserRequest createAUserRequest);
    void update(UpdateUserRequest updateUserRequest);
    void delete(Long id);
    GetByUserIdResponse getById(Long id);
}
