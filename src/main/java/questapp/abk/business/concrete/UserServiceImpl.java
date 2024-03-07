package questapp.abk.business.concrete;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import questapp.abk.business.abstracts.UserService;
import questapp.abk.business.requests.user.CreateAUserRequest;
import questapp.abk.business.requests.user.UpdateUserRequest;
import questapp.abk.business.response.user.GetAllUserResponses;
import questapp.abk.business.response.user.GetByUserIdResponse;
import questapp.abk.core.utilities.mappers.ModelMapperService;
import questapp.abk.dao.abstracts.UserRepository;
import questapp.abk.entities.User;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    UserRepository userRepository;
    ModelMapperService modelMapperService;

    @Override
    public List<GetAllUserResponses> getAll() {
        List<User> users=this.userRepository.findAll();
        return users.stream().map(user-> this.modelMapperService.forResponse().map(user,GetAllUserResponses.class)).toList();
    }

    @Override
    public void add(CreateAUserRequest createAUserRequest) {
        User user=this.modelMapperService.forRequest().map(createAUserRequest,User.class);
        this.userRepository.save(user);

    }

    @Override
    public void update(UpdateUserRequest updateUserRequest) {
        User user=this.modelMapperService.forRequest().map(updateUserRequest,User.class);
        this.userRepository.save(user);

    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public GetByUserIdResponse getById(Long id) {
        User user=this.userRepository.findById(id).orElseThrow();
        return this.modelMapperService.forResponse().map(user, GetByUserIdResponse.class);
    }
}

