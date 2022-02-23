package com.pispl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pispl.model.CenterHire;

@Repository
public interface CenterHireRepository extends JpaRepository<CenterHire, Integer> {

}
