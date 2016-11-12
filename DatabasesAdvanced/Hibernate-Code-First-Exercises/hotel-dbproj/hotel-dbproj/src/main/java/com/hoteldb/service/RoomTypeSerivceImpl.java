package com.hoteldb.service;

import com.hoteldb.entities.RoomType;
import com.hoteldb.repository.RoomTypeDao;
import com.hoteldb.service.interfaces.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomTypeSerivceImpl implements RoomTypeService {


    private final RoomTypeDao roomTypeDao;

    @Autowired
    public RoomTypeSerivceImpl(RoomTypeDao roomTypeDao) {
        this.roomTypeDao = roomTypeDao;
    }

    @Override
    public void create(RoomType roomType) {
        this.roomTypeDao.saveAndFlush(roomType);
    }
}
