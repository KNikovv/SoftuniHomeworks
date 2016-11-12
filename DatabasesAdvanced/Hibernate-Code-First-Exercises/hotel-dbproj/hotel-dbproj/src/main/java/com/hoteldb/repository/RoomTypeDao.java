package com.hoteldb.repository;

import com.hoteldb.entities.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomTypeDao extends JpaRepository<RoomType, Long> {

}
