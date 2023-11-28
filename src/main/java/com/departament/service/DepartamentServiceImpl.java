package com.departament.service;

import com.departament.dto.MensajeDto;
import com.departament.entity.DepartamentEntity;
import com.departament.entity.EmployedEntity;
import com.departament.repository.DepartamentRepository;
import com.departament.repository.EmployedRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DepartamentServiceImpl implements DepartamentService{
    private static final String JSON_URL = "http://localhost:8080/api/v1/departments";

    @Autowired
    DepartamentRepository departamentRepository;


    /**
     * Metodo que realiza validacion que si existe o no algun departamento repetido
     */
    public boolean validateDepartamento(String name){
        DepartamentEntity departamentEntity=departamentRepository.findByNombre(name);
        if(departamentEntity==null){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Metodo principal que ejecuta el consumo del servicio sumistrado de los diferentes departamentos existentes
     * y los guarda en una Base de datos Local,
     */
    @Override
    public ResponseEntity<?> getDepartament() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        String result= restTemplate.getForObject(JSON_URL, String.class);
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(result);
            JsonNode departamentosNode = rootNode.get("departamentos");
            for (JsonNode departamentoNode : departamentosNode) {
                String nombreDepartamento = departamentoNode.asText();
                if(validateDepartamento(nombreDepartamento)) {
                    DepartamentEntity departamentEntity = new DepartamentEntity();
                    departamentEntity.setNombre(nombreDepartamento);
                    departamentRepository.save(departamentEntity);
                }
            }
        return new ResponseEntity(new MensajeDto("Los Departamentos se crearon Exitosamente!"), HttpStatus.CREATED);
    }
}
