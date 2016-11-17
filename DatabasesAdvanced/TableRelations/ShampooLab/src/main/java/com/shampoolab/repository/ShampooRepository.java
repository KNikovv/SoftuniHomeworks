package com.shampoolab.repository;

import com.shampoolab.entities.shampoos.BasicShampoo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ShampooRepository extends JpaRepository<BasicShampoo,Long> {

}
