package questapp.abk.business.requests.post;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import questapp.abk.entities.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatAPostRequest {
    @NotNull
    Long userId;
    @NotNull(message = "Name may not be null")
    String title;
    @NotNull(message = "Name may not be null")
    String text;
}
