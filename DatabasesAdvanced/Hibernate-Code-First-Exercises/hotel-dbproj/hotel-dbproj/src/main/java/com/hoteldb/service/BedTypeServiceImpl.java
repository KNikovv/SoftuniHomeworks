package com.hoteldb.service;

import com.hoteldb.entities.BedType;
import com.hoteldb.repository.BedTypeDao;
import com.hoteldb.service.interfaces.BedTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BedTypeServiceImpl implements BedTypeService {

    private final BedTypeDao bedTypeDao;

    @Autowired
    public BedTypeServiceImpl(BedTypeDao bedTypeDao) {
        this.bedTypeDao = bedTypeDao;
    }

    @Override
    public void create(BedType roomType) {
        this.bedTypeDao.saveAndFlush(roomType);
    }
}
