package com.hoteldb.service;

import com.hoteldb.entities.Customer;
import com.hoteldb.repository.CustomerDao;
import com.hoteldb.service.interfaces.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerDao customerDao;

    @Autowired
    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public void create(Customer customer) {
        this.customerDao.saveAndFlush(customer);
    }
}
