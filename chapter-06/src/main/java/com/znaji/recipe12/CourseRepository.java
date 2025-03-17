package com.znaji.recipe12;

import com.znaji.hibernate.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {
}
