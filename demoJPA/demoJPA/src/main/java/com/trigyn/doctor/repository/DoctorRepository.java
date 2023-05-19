package com.trigyn.doctor.repository;

import com.trigyn.doctor.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findStudentByName(String name);

    @Query("Select s from Student s where s.name like :sName")
    List<Doctor> findStudentBySname(String sName);

    @Query(value = "Select * from Student where student_name like :sName", nativeQuery = true)
    List<Student> findStudentBySnameNative(String sName);

    @Query("Select s from Student s where s.dept.id = :id")
    List<Student> findStudentByDept(Long id);

}