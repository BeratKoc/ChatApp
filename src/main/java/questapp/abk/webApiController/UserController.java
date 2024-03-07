package questapp.abk.webApiController;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import questapp.abk.business.abstracts.UserService;
import questapp.abk.business.requests.user.CreateAUserRequest;
import questapp.abk.business.requests.user.UpdateUserRequest;
import questapp.abk.business.response.user.GetAllUserResponses;
import questapp.abk.business.response.user.GetByUserIdResponse;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@Data
public class UserController {
    UserService userService;
    @GetMapping()
    public List<GetAllUserResponses> getAllUserResponses(){
        return userService.getAll();
    }
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody CreateAUserRequest createAUserRequest) {
        this.userService.add(createAUserRequest);
    }
    @GetMapping("/{id}")
    public GetByUserIdResponse getById(@PathVariable long id) {
        return userService.getById(id);
    }
    @PutMapping
    public void update(@RequestBody UpdateUserRequest updateUserRequest) {
        this.userService.update(updateUserRequest);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long  id) {
        userService.delete(id);

    }
}
