package bg.softuni.hibernate.dao;

import bg.softuni.hibernate.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
@Transactional
public interface UserDao extends JpaRepository<User, Long> {

    List<User> findByLastTimeLoggedInAfter(Date date);

    int removeByDeletedTrue();
}
