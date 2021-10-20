package net.codejava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.codejava.entity.Symptom;

public interface SymptomRepository extends JpaRepository<Symptom, Long>{

}
