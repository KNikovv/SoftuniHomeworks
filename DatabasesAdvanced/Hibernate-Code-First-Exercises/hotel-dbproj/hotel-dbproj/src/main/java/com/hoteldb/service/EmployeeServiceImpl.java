package com.hoteldb.service;

import com.hoteldb.entities.Employee;
import com.hoteldb.repository.EmployeeDao;
import com.hoteldb.service.interfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public void create(Employee employee) {
        this.employeeDao.saveAndFlush(employee);
    }
}
