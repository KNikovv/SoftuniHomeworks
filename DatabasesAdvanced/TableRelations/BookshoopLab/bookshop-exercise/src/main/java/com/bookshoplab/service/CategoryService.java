package com.bookshoplab.service;

import com.bookshoplab.entities.Category;

public interface CategoryService {

    void save(Category category);

    void delete(Category category);

    void delete(long id);

    Category findCategory(long id);

    Iterable<Category> findCategories();
}
