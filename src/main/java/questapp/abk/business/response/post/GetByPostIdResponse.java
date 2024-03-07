package questapp.abk.business.response.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByPostIdResponse implements Serializable {
    Long id;
    Long userId;//degistirmek gerekebilir
    String title;
    String text;
}
