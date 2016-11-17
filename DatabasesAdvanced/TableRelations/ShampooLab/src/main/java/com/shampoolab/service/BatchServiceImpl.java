package com.shampoolab.service;

import com.shampoolab.entities.batches.ProductionBatch;
import com.shampoolab.repository.BatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BatchServiceImpl implements BatchService {

    private final BatchRepository batchRepository;

    @Autowired
    public BatchServiceImpl(BatchRepository batchRepository) {
        this.batchRepository = batchRepository;
    }

    @Override
    public void create(ProductionBatch batch) {
        this.batchRepository.saveAndFlush(batch);
    }
}
