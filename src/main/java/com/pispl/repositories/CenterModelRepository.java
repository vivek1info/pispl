package com.pispl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.pispl.model.CenterModel;

@Repository
public interface CenterModelRepository extends JpaRepository<CenterModel, Integer>{

}
