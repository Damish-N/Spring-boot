//package com.example.demo.student;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.time.LocalDate;
//import java.time.Month;
//import java.util.List;
//
//@Configuration
//public class StudnetConfig {
//    @Bean
//    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
//        return args -> {
//            Student damish =  new Student(
//                    "Damish",
//                    LocalDate.of(2005, Month.JANUARY,5)
//            );
//            Student Nisal =  new Student(
//                    "Damish",
//                    LocalDate.of(2000, Month.JANUARY,5)
//            );
//            studentRepository.saveAll(List.of(damish,Nisal));
//        };
//    }
//}
