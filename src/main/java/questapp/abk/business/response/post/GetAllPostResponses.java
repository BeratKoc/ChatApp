package questapp.abk.business.response.post;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import questapp.abk.entities.User;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllPostResponses implements Serializable {
    Long id;
    @JsonIgnoreProperties("password")
    User user;
    String title;
    String text;
}
