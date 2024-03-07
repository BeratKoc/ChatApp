package questapp.abk.dao.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import questapp.abk.entities.SubComment;

import java.util.List;
@Repository
public interface SubCommentRepository extends JpaRepository<SubComment,Long> {

    List<SubComment> findByCommentId(Long commentId);
}
