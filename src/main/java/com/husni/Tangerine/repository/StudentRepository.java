package com.husni.Tangerine.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.ListCrudRepository;

import com.husni.Tangerine.model.Student;

public interface StudentRepository extends ListCrudRepository<Student,Integer>{

    List<Student> findAllByNameContains(String name);

    
    
}
