package com.departament.service;

import com.departament.dto.EmployedDto;
import com.departament.entity.EmployedEntity;
import com.departament.repository.EmployedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployedServiceImpl implements EmployedService{

    @Autowired
    EmployedRepository employedRepository;

    /**
     * Guarda un empleado en particular con el Id del departamento especifico
     */
    @Override
    public void save(EmployedDto employedDto) {
        EmployedEntity employedEntity= new EmployedEntity();
        employedEntity.setNombre(employedDto.getNombre());
        employedEntity.setCargo(employedDto.getCargo());
        employedEntity.setDepartamentoId(employedDto.getDepartamentoId());
        employedRepository.save(employedEntity);
    }

    /**
     * Consulta los empleados
     */
    @Override
    public List<EmployedEntity> getAll() {
        return employedRepository.findAll();
    }
}
