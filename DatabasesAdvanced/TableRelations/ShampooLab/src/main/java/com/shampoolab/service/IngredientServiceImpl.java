package com.shampoolab.service;

import com.shampoolab.entities.ingredients.BasicIngredient;
import com.shampoolab.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public void create(BasicIngredient ingredient) {
        this.ingredientRepository.saveAndFlush(ingredient);
    }
}
