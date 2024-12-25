package com.znaji.hibernate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String title;
    private LocalDate beginDate;
    private LocalDate endDate;
    private int fee;
}
//propose sql to create a database course with this table courses in it(using PostgreSQL)
// sql to create a database course:
// CREATE DATABASE course;
// sql to create a table courses in the database course:
// CREATE TABLE courses (
//     id SERIAL PRIMARY KEY,
//     title VARCHAR(100) NOT NULL,
//     begin_date DATE,
//     end_date DATE,
//     fee INT
// );