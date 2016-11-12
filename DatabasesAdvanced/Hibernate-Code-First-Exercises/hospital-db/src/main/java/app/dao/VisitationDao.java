package app.dao;

import app.entities.Visitation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface VisitationDao extends JpaRepository<Visitation,Long> {

}
