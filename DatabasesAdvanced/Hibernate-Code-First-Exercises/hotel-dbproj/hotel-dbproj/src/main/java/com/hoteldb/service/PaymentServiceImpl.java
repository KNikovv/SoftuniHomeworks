package com.hoteldb.service;

import com.hoteldb.entities.Payment;
import com.hoteldb.repository.PaymentDao;
import com.hoteldb.service.interfaces.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentDao paymentDao;

    @Autowired
    public PaymentServiceImpl(PaymentDao paymentDao) {
        this.paymentDao = paymentDao;
    }

    @Override
    public void create(Payment payment) {
        this.paymentDao.saveAndFlush(payment);
    }
}
