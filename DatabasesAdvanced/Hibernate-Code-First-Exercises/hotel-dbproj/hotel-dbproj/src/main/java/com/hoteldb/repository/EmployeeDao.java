package com.hoteldb.repository;

import com.hoteldb.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends JpaRepository<Employee,Long> {

}
