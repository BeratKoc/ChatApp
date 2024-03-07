package questapp.abk.webApiController;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;
import questapp.abk.business.abstracts.PostService;
import questapp.abk.business.requests.post.CreatAPostRequest;
import questapp.abk.business.requests.post.UpdateAPostRequest;
import questapp.abk.business.response.post.GetAllPostResponses;
import questapp.abk.business.response.post.GetByPostIdResponse;
import questapp.abk.business.response.user.GetByUserIdResponse;

import java.util.List;

@RestController
@RequestMapping("/posts")
@AllArgsConstructor
@Data
public class PostController {
    PostService postService;
    @GetMapping()
    public List<GetAllPostResponses> getAllPostResponses(){
        return postService.getAll();
    }
    @PostMapping()
    public void add(@RequestBody CreatAPostRequest creatAPostRequest){
        postService.add(creatAPostRequest);
    }
    @GetMapping("/{id}")
    public GetByPostIdResponse getById(@PathVariable Long id){
        return postService.getById(id);
    }
    @PutMapping
    public void update(@RequestBody UpdateAPostRequest updateAPostRequest){
        postService.update(updateAPostRequest);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        postService.delete(id);
    }

}
