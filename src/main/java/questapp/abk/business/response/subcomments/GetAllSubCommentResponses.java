package questapp.abk.business.response.subcomments;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import questapp.abk.entities.Comment;

@Getter
@Setter
public class GetAllSubCommentResponses {
    Long id;
    String text;
    Long commentId;
    CreatedDate createdDate;
}
