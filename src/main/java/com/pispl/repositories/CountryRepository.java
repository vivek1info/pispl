package com.pispl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pispl.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

}
