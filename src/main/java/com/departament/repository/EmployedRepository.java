package com.departament.repository;

import com.departament.entity.EmployedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployedRepository extends JpaRepository<EmployedEntity, Integer> {

}
