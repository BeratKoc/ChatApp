package questapp.abk.business.concrete;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import questapp.abk.business.abstracts.PostService;
import questapp.abk.business.requests.post.CreatAPostRequest;
import questapp.abk.business.requests.post.UpdateAPostRequest;
import questapp.abk.business.response.post.GetAllPostResponses;
import questapp.abk.business.response.post.GetByPostIdResponse;
import questapp.abk.business.response.user.GetByUserIdResponse;
import questapp.abk.core.utilities.mappers.ModelMapperService;
import questapp.abk.dao.abstracts.PostRepository;
import questapp.abk.entities.Post;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {
    PostRepository postRepository;
    ModelMapperService modelMapperService;
    @Override
    public List<GetAllPostResponses> getAll() {
        List<Post>posts=this.postRepository.findAll();
        return posts.stream().map(post -> this.modelMapperService.forResponse().map(post,GetAllPostResponses.class)).toList();
    }

    @Override
    public void add(CreatAPostRequest creatAPostRequest) {
        Post post=this.modelMapperService.forRequest().map(creatAPostRequest,Post.class);
        post.setId(null);
        post.setCreateDate(LocalDate.now());
        if(creatAPostRequest.getTitle().isBlank()||creatAPostRequest.getText().isBlank()){
            throw new IllegalArgumentException("Text veya title null");
        }
        this.postRepository.save(post);

    }

    @Override
    public void update(UpdateAPostRequest updateAPostRequest) {
        Post post=this.modelMapperService.forRequest().map(updateAPostRequest,Post.class);
        post.setUpdateDate(LocalDate.now());
        this.postRepository.save(post);
    }


    @Override
    public void delete(Long id) {
        this.postRepository.deleteById(id);

    }

    @Override
    public GetByPostIdResponse getById(Long id) {
     Post post= this.postRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Post not found with id: " + id));
     return this.modelMapperService.forResponse().map(post,GetByPostIdResponse.class);
    }
}
