package questapp.abk.business.requests.subcomment;

import lombok.*;
import questapp.abk.entities.Comment;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateASubCommentRequest {
    String text;
    Long commentId;
}
