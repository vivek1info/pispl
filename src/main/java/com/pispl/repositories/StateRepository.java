package com.pispl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pispl.model.State;
@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

}
