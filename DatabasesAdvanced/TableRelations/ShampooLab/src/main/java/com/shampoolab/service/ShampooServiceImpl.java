package com.shampoolab.service;

import com.shampoolab.entities.shampoos.BasicShampoo;
import com.shampoolab.repository.ShampooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShampooServiceImpl implements ShampooService {

    private final ShampooRepository shampooRepository;

    @Autowired
    public ShampooServiceImpl(ShampooRepository shampooRepository) {
        this.shampooRepository = shampooRepository;
    }

    @Override
    public void create(BasicShampoo shampoo) {
        this.shampooRepository.saveAndFlush(shampoo);
    }
}
