package com.pispl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pispl.model.CenterStatus;
@Repository
public interface CenterStatusRepository extends JpaRepository<CenterStatus, Integer> {

}
