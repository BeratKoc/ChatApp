package questapp.abk.dao.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import questapp.abk.entities.Post;
@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

}
