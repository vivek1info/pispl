package com.pispl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pispl.model.EmployeeType;
@Repository
public interface EmployeeTypeRepository extends JpaRepository<EmployeeType, Integer> {

}
