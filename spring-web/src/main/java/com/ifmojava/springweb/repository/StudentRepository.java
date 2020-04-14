package com.ifmojava.springweb.repository;

import com.ifmojava.springweb.entity.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StudentRepository
        extends CrudRepository<Student, Integer> {

}
