package com.shampoolab.repository;

import com.shampoolab.entities.batches.ProductionBatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface BatchRepository extends JpaRepository<ProductionBatch, Long> {

}
