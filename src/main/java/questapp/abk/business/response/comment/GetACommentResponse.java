package questapp.abk.business.response.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import questapp.abk.entities.SubComment;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetACommentResponse {
    Long id;
    Long postId;
    Long userId;
    String text;
    List<SubComment> subComments;
}
