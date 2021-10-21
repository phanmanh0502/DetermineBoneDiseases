package net.codejava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.codejava.entity.Disease;

public interface DiseseRepository extends JpaRepository<Disease, Integer>{

}
