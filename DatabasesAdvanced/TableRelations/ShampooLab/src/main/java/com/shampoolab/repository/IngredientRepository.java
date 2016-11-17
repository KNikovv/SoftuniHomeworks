package com.shampoolab.repository;

import com.shampoolab.entities.ingredients.BasicIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IngredientRepository extends JpaRepository<BasicIngredient, Long> {

}
