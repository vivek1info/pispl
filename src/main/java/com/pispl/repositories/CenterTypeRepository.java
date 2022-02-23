package com.pispl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pispl.model.CenterType;

@Repository
public interface CenterTypeRepository extends JpaRepository<CenterType, Integer> {

}
