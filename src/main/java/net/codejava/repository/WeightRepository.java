package net.codejava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.codejava.entity.Weight;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface WeightRepository extends JpaRepository<Weight, Integer>{

    @Query(nativeQuery = true, value = "SELECT DISTINCT id_disease from weight WHERE id_symptom IN :listSymptomId")
    List<Integer> getListDiseaseIdBySymptomIdIn(@Param("listSymptomId") Set<Integer> listSymptomId);

    List<Weight> getAllByIdDiseaseIn(List<Integer> listDiseaseId);
}
