package com.shampoolab.entities.batches;

import com.shampoolab.entities.shampoos.BasicShampoo;

import java.util.Date;
import java.util.Set;

public interface Batch {

    long getId();

    void setId(long id);

    Date getBatchDate();

    void setBatchDate(Date batchDate);

    Set<BasicShampoo> getShampoos();

    void setShampoos(Set<BasicShampoo> shampoos);

}
