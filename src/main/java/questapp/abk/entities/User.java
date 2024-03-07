package questapp.abk.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user")
@Data

public class User extends BaseEntity {

    @Column(name = "user_name", unique = true)
    String userName;
    @Column(name = "password")
    String password;
}
