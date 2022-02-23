package com.pispl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pispl.model.CenterCourse;

@Repository
public interface CenterCourseRepository extends JpaRepository<CenterCourse, Integer> {

}
