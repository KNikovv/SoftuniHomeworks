package bg.softuni.hibernate.repositories;

import bg.softuni.hibernate.entities.WizzardDeposit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface WizzardDepositRepository extends JpaRepository<WizzardDeposit, Long> {

}
