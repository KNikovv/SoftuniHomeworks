package bg.softuni.hibernate.dao;

import bg.softuni.hibernate.entities.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TownDao extends JpaRepository<Town,Long> {

}
