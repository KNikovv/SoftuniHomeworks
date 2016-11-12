package app.dao;

import app.entities.Diagnose;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface DiagnoseDao extends JpaRepository<Diagnose, Long> {

}
