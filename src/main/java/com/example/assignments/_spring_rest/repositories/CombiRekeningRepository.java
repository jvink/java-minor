package com.example.assignments._spring_rest.repositories;

import com.example.assignments._spring_rest.models.CombiRekening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CombiRekeningRepository extends JpaRepository<CombiRekening, Long> {
}
