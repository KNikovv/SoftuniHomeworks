package com.hoteldb.repository;

import com.hoteldb.entities.Occupancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OccupancyDao extends JpaRepository<Occupancy,Long>{

}
