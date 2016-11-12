package com.hoteldb.service;

import com.hoteldb.entities.RoomStatus;
import com.hoteldb.repository.RoomStatusDao;
import com.hoteldb.service.interfaces.RoomStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomStatusServiceImpl implements RoomStatusService {

    private final RoomStatusDao roomStatusDao;

    @Autowired
    public RoomStatusServiceImpl(RoomStatusDao roomDao) {
        this.roomStatusDao = roomDao;
    }

    @Override
    public void create(RoomStatus roomStatus) {
        this.roomStatusDao.saveAndFlush(roomStatus);
    }
}
