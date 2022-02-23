package com.pispl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pispl.model.Center;
@Repository
public interface CenterRepository extends JpaRepository<Center, Integer> {

}
