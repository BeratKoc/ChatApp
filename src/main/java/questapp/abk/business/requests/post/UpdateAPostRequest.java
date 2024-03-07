package questapp.abk.business.requests.post;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAPostRequest {
    @NotNull
    Long id;
    @NotNull
    Long userId;
    @NotNull
    String title;
    @NotNull
    String text;
}
