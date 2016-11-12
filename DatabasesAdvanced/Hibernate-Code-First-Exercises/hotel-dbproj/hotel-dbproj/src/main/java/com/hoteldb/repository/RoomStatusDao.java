package com.hoteldb.repository;

import com.hoteldb.entities.RoomStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomStatusDao extends JpaRepository<RoomStatus,Long> {

}
