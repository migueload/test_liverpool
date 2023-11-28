package com.departament.repository;

import com.departament.entity.DepartamentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentRepository extends JpaRepository<DepartamentEntity, Integer> {

    @Query(value = "SELECT ID, NOMBRE FROM DEPARTAMENT_ENTITY WHERE NOMBRE=?", nativeQuery = true)
    DepartamentEntity findByNombre(String name);

}
