package com.departament.service;

import com.departament.dto.EmployedDto;
import com.departament.entity.EmployedEntity;

import java.util.List;

public interface EmployedService {


    void save(EmployedDto employedDto);

    List<EmployedEntity> getAll();
}
