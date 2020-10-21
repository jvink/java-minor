package com.example.assignments._spring_rest.repositories;

import com.example.assignments._spring_rest.models.RekeningDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RekeningRepository extends JpaRepository<RekeningDTO, Long> {
}
