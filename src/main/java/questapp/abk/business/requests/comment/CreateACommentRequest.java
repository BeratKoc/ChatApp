package questapp.abk.business.requests.comment;

import lombok.*;

@Getter
@Setter
public class CreateACommentRequest {

    Long postId;
    Long userId;
    String text;
}
