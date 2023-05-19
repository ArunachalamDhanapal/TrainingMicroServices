package com.trigyn.doctor.service;

import com.trigyn.demoJPA.entity.Dept;
import com.trigyn.doctor.entity.Student;
import com.trigyn.doctor.model.DoctorVO;
import com.trigyn.demoJPA.repository.DepartmentRepository;
import com.trigyn.doctor.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    DoctorRepository studentRepository;
    @Autowired
    DepartmentRepository departmentRepository;


    private Student convertVO(DoctorVO studentVO) {
        Student student = new Student();
        student.setId(studentVO.getId());
        student.setAge(studentVO.getAge());
        student.setName(studentVO.getName());
        Dept dept = null;
        if(studentVO.getDeptID()!= null){
            dept = departmentRepository.findById(studentVO.getDeptID()).get();
            student.setDept(dept);
        }
        return student;
    }

    public Boolean createStudent(DoctorVO studentVO) {
        Student student = convertVO(studentVO);
        try {
            studentRepository.save(student);
        } catch (Exception exception) {
            return false;
        }
        return true;
    }

    private DoctorVO convertEntity(Student student) {
        DoctorVO studentVO = new DoctorVO();
        studentVO.setId(student.getId());
        studentVO.setAge(student.getAge());
        studentVO.setName(student.getName());
        if(student.getDept()!=null){
            studentVO.setDeptID(student.getDept().getId());
        }
        return studentVO;
    }

    public List<DoctorVO> getAll(){
        List<DoctorVO> studentList = new ArrayList<>();
        for(Student student : studentRepository.findAll()){
            studentList.add(convertEntity(student));
        }
        return studentList;
    }

    public List<DoctorVO> findStudentByName(String name){
        List<DoctorVO> studentList = new ArrayList<>();
        for(Student student : studentRepository.findStudentByName(name)){
            studentList.add(convertEntity(student));
        }
        return studentList;
    }

    public List<DoctorVO> getStudentByName(String name){
        List<DoctorVO> studentList = new ArrayList<>();
        for(Student student : studentRepository.findStudentBySname("%" + name + "%")){
            studentList.add(convertEntity(student));
        }
        return studentList;
    }

    public List<DoctorVO> getStudentByNameNative(String name){
        List<DoctorVO> studentList = new ArrayList<>();
        for(Student student : studentRepository.findStudentBySnameNative("%" + name + "%")){
            studentList.add(convertEntity(student));
        }
        return studentList;
    }

    public List<DoctorVO> getStudentByDept(Long id){
        List<DoctorVO> studentList = new ArrayList<>();
        for(Student student : studentRepository.findStudentByDept(id)){
            studentList.add(convertEntity(student));
        }
        return studentList;
    }
}