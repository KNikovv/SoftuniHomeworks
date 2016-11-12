package com.hoteldb.repository;

import com.hoteldb.entities.BedType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BedTypeDao extends JpaRepository<BedType, Long> {

}
