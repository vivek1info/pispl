package com.pispl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pispl.model.Location;
@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {

}
