package com.pispl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pispl.model.CenterMovement;



@Repository
public interface CenterMovementRepository extends JpaRepository<CenterMovement, Integer> {

}
