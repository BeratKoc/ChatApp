package questapp.abk.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Data
@Table(name = "p_like",uniqueConstraints = {@UniqueConstraint(name = Like.UX_LIKE,columnNames = {Like.COLUMN_POST_ID,Like.COLUMN_USER_ID})})
public class Like extends BaseEntity {

    protected final static String UX_LIKE = "UX_LIKE";
    protected final static String COLUMN_POST_ID = "POST_ID";
    protected final static String COLUMN_USER_ID = "USER_ID";

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = COLUMN_POST_ID,nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Post post;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = COLUMN_USER_ID,nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    User user;

}
