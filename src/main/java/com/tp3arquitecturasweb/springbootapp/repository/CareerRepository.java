package com.tp3arquitecturasweb.springbootapp.repository;

import com.tp3arquitecturasweb.springbootapp.models.Career;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CareerRepository extends JpaRepository<Career, Long> {
}
