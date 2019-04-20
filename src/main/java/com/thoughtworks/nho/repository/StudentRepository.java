package com.thoughtworks.nho.repository;

import com.thoughtworks.nho.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository  extends JpaRepository<Student, String> {

    @Query(nativeQuery = true, value = "select student.name, student.email, mapping.studentscore from T_TRAINING_CAMP_STUDENT_MAPPING  mapping left join T_STUDENT student on student.ID = mapping.STUDENTID where mapping.TRAININGCAMPID=:id")
    List<Object[]> findStudentList(@Param("id") String id);

}
