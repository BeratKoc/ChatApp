package questapp.abk.business.requests.like;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateALikeRequest {
    Long postId;
    Long userId;
}
