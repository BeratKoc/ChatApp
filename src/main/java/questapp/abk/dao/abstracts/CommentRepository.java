package questapp.abk.dao.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import questapp.abk.core.utilities.mappers.ModelMapperService;
import questapp.abk.entities.Comment;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long>  {
    List<Comment> findByUserIdAndPostId(Long userID, Long PostId);

    List<Comment> findByUserId(Long userId);

    List<Comment> findByPostId(Long postId);


}