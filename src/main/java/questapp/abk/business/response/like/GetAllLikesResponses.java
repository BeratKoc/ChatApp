package questapp.abk.business.response.like;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllLikesResponses implements Serializable {
    Long id;
    Long postId;
    Long userId;
}
