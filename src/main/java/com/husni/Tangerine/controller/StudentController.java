package com.husni.Tangerine.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.husni.Tangerine.model.Student;
import com.husni.Tangerine.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/student")
public class StudentController {

    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void addStudent(@RequestBody Student student) {
        //TODO: process POST request
        
        repository.save(student);
    }

    @PutMapping("/{id}")
    public void updateStudent(@PathVariable Integer id, @RequestBody Student student) {
        //TODO: process PUT request
        if(!repository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        }
        else{
            repository.deleteById(id);
            repository.save(student);
        }
        
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Integer id){
        if(!repository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Record Not Found");
        }
        else 
            repository.deleteById(id);
    }    
    
    @GetMapping("/{id}")
    public Optional<Student> getMethodName(@PathVariable Integer id) {
        if(!repository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Record Not Found");
        }
        else
            return repository.findById(id);
    }
    

    @GetMapping("/filter/{name}")
    public List<Student> filterStudentByName(@PathVariable String name) {
        return repository.findAllByNameContains(name);
    }
    

    
}
