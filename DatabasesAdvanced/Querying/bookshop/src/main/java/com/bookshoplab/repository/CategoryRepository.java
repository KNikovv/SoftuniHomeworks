package com.bookshoplab.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.bookshoplab.entities.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

    Category findById(long id);

    Iterable<Category> findAll();
}
