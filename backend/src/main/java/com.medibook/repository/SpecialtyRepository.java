package com.medibook.repository;


import com.medibook.entities.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialtyRepository extends JpaRepository<Specialty, Long> {
}
