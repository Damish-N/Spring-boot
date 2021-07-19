package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

//@Component
@Service
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getStudent() {
        return studentRepository.findAll();
    }


    public void addNewStudent(Student student) {
        Optional<Student> studentByName =studentRepository.findStudentByName(student.getName());

        if(studentByName.isPresent()){
            throw new IllegalArgumentException("Name is taken");
        }
        studentRepository.save(student);
        System.out.print(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exits =  studentRepository.existsById(studentId);
        if (!exits){
            throw new IllegalStateException("student with id"+studentId+"doesnet exits");
        }

        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(String name,Long studentId) {

//        boolean exits =  studentRepository.existsById(studentId);
//        if (!exits){
//            throw new IllegalStateException("student with id"+studentId+"doesnet exits");
//        }

        Student student = studentRepository.findById(studentId).orElseThrow(()->new IllegalStateException("Not Exits"));

        if (name.length()>0){
            student.setName(name);
        }



    }
}
