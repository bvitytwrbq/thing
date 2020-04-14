package com.ifmojava.springweb.repository;

import com.ifmojava.springweb.entity.University;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UniversityRepository
        extends CrudRepository<University, Integer> {

    @Query("SELECT u FROM University u WHERE u.universityName = :universityName")
    Optional<University> findByName(@Param("universityName") String universityName);
}
