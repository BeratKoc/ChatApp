package questapp.abk.business.requests.like;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateALikeRequest {
    Long id;
    Long postId;
    Long userId;
}
