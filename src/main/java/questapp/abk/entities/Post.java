package questapp.abk.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


import java.util.List;

@Entity
@Table(name = "post")
@Data
public class Post extends BaseEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    User user;

    @Column(name = "title",nullable = false)
    @Lob
    @NotNull()
    String title;
    @Lob
    @Column(name = "text",nullable = false)
    @NotNull()
    String text;
    @OneToMany(mappedBy = "post")//Each post can have many comments
    List<Comment> comments;
}
