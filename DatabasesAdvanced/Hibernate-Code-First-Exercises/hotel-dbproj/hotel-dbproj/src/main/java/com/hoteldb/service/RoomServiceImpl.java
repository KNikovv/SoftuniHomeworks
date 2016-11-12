package com.hoteldb.service;

import com.hoteldb.entities.Room;
import com.hoteldb.repository.RoomDao;
import com.hoteldb.service.interfaces.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomDao roomDao;

    @Autowired
    public RoomServiceImpl(RoomDao roomDao) {
        this.roomDao = roomDao;
    }

    @Override
    public void create(Room room) {
        this.roomDao.saveAndFlush(room);
    }
}
