package questapp.abk.business.response.like;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByLikeIdResponse {
    Long id;
    Long postId;
    Long userId;
}
