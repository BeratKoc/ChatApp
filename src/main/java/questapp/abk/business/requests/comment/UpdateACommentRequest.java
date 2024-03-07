package questapp.abk.business.requests.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateACommentRequest {
    Long id;
    Long postId;
    Long userId;
    String text;
}
