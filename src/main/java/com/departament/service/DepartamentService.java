package com.departament.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;

public interface DepartamentService {

    ResponseEntity<?> getDepartament() throws JsonProcessingException;
}
