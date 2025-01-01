package com.znaji.springDataJpa;

import com.znaji.hibernate.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
