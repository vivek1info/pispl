package com.pispl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pispl.model.CenterMake;
@Repository
public interface CenterMakeRepository extends JpaRepository<CenterMake, Integer> {

}
