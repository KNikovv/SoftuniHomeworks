package app.repository;

import app.entities.Homework;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface HomeworkRepository extends CrudRepository<Homework,Long> {

}
