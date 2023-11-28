package com.departament.controller;

import com.departament.dto.EmployedDto;
import com.departament.dto.MensajeDto;
import com.departament.entity.EmployedEntity;
import com.departament.service.DepartamentService;
import com.departament.service.EmployedService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartamentController {

    @Autowired
    private DepartamentService departamentService;

    @Autowired
    private EmployedService employedService;

    @GetMapping("/getdepartament")
    public ResponseEntity<?> getDepartament() throws JsonProcessingException {
            return departamentService.getDepartament();
    }

    @PostMapping("/addemployed")
    public ResponseEntity<?> addEmployed(@RequestBody EmployedDto employedDto) {
        employedService.save(employedDto);
        return new ResponseEntity(new MensajeDto("El Empleado se Guardo Exitosamente!"), HttpStatus.CREATED);
    }

    @GetMapping("/getemployed")
    public List<EmployedEntity> getEmployed() {
        return employedService.getAll();
    }

}
