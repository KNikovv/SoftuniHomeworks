package com.hoteldb.repository;

import com.hoteldb.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentDao extends JpaRepository<Payment,Long> {

}
