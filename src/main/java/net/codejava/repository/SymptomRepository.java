package net.codejava.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import net.codejava.entity.Symptom;

public interface SymptomRepository extends JpaRepository<Symptom, Integer> {

	// find by id of Symptom
	public Optional<Symptom> findById(Integer id);
}