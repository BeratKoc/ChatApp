package questapp.abk.dao.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import questapp.abk.entities.User;
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
