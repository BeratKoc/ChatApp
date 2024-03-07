package questapp.abk.webApiController;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;
import questapp.abk.business.abstracts.LikeService;
import questapp.abk.business.requests.like.CreateALikeRequest;
import questapp.abk.business.requests.like.UpdateALikeRequest;

import questapp.abk.business.response.like.GetAllLikesResponses;
import questapp.abk.business.response.like.GetByLikeIdResponse;


import java.util.List;

@RestController
@RequestMapping("/likes")
@AllArgsConstructor
@Data
public class LikeController {
    LikeService likeService;
    @GetMapping()
    public List<GetAllLikesResponses> getAllLikesResponses(){
        return likeService.getAll();
    }
    @PostMapping()
    public GetAllLikesResponses add(@RequestBody CreateALikeRequest createALikeRequest){
        return likeService.add(createALikeRequest);
    }
    @GetMapping("/{id}")
    public GetByLikeIdResponse getbyId(@PathVariable Long id){
        return likeService.getbyId(id);
    }
    @PutMapping
    public void update(@RequestBody UpdateALikeRequest updateALikeRequest){
        likeService.update(updateALikeRequest);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        likeService.delete(id);
    }

}
