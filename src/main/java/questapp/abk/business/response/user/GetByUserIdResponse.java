package questapp.abk.business.response.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByUserIdResponse implements Serializable {
    private Long id;
    private String userName;
    private String password;
}
