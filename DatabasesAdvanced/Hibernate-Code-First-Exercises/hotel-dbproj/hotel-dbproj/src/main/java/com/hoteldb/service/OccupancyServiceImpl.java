package com.hoteldb.service;

import com.hoteldb.entities.Occupancy;
import com.hoteldb.repository.OccupancyDao;
import com.hoteldb.service.interfaces.OccupancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OccupancyServiceImpl implements OccupancyService {

    private final OccupancyDao occupancyDao;

    @Autowired
    public OccupancyServiceImpl(OccupancyDao occupancyDao) {
        this.occupancyDao = occupancyDao;
    }

    @Override
    public void create(Occupancy occupancy) {
        this.occupancyDao.saveAndFlush(occupancy);
    }
}
