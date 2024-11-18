package com.example.CRUD_application.repository;
import com.example.CRUD_application.model.Student;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findByFirstName(String firstName);
    List<Student> findByYear(int year);

    @Query("SELECT s.department FROM Student s WHERE s.id = :id")String findDepartmentByStudentId(@Param("id") long id);

    @Modifying
    @Transactional
    @Query("DELETE FROM Student s WHERE s.year = :year")
    void deleteByYearOfEnrollment(@Param("year") String year);

}
