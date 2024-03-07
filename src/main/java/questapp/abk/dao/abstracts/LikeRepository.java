package questapp.abk.dao.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import questapp.abk.entities.Like;
@Repository
public interface LikeRepository extends JpaRepository<Like,Long> {

}
