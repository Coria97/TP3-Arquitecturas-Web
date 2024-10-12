package com.tp3arquitecturasweb.springbootapp.repository;

import com.tp3arquitecturasweb.springbootapp.models.StudentCareer;
import com.tp3arquitecturasweb.springbootapp.models.StudentCareerPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCareerRepository extends JpaRepository<StudentCareer, StudentCareerPK> {

    boolean existsById(StudentCareerPK pk);
}
