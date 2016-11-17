package com.shampoolab.service;

import com.shampoolab.entities.labels.ClassicLabel;
import com.shampoolab.repository.LabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LabelServiceImpl implements LabelService {

    private final LabelRepository labelRepository;

    @Autowired
    public LabelServiceImpl(LabelRepository labelRepository) {
        this.labelRepository = labelRepository;
    }

    @Override
    public void create(ClassicLabel label) {
        this.labelRepository.saveAndFlush(label);
    }
}
