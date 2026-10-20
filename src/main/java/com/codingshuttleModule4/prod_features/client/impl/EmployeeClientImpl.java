package com.codingshuttleModule4.prod_features.client.impl;

import com.codingshuttleModule4.prod_features.advice.ApiResponse;
import com.codingshuttleModule4.prod_features.client.EmployeeClient;
import com.codingshuttleModule4.prod_features.dto.EmployeeDTO;
import com.codingshuttleModule4.prod_features.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import org.slf4j.Logger;

@Service
@RequiredArgsConstructor
public class EmployeeClientImpl implements EmployeeClient {

    private final RestClient restClient;
    Logger logger = LoggerFactory.getLogger(EmployeeClientImpl.class);

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        try {
            ApiResponse<List<EmployeeDTO>> employeeDTOList = restClient.get()
                    .uri("employees")
                    .retrieve()
                    .body(new ParameterizedTypeReference<>() {
                    });
            return employeeDTOList.getData();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeeDTO getEmployeeById(Long employeeID) {
         try {
             ApiResponse<EmployeeDTO> employeeDTOApiResponse = restClient.get()
                     .uri("employees/{employeeID}", employeeID)
                     .retrieve()
                     .body(new ParameterizedTypeReference<>(){
                     });
             return employeeDTOApiResponse.getData();
         } catch (Exception e) {
             throw new RuntimeException(e);
         }
    }

    @Override
    public EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO) {

        /*logger.error("ERROR LOG");
        logger.warn("WARN LOG");
        logger.info("INFO LOG");
        logger.debug("DEBUG LOG");
        logger.trace("TRACE LOG");*/

        logger.trace("Trying to create new employee in createNewEmployee");

        try {
            logger.info("Attempting to call the restClient method in createNewEmployee");


            ResponseEntity<ApiResponse<EmployeeDTO>> employeeDTOApiResponse = restClient.post()
                    .uri("employees")
                    .body(employeeDTO)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError, ((request, response) -> {
                        System.out.println(new String(response.getBody().readAllBytes()));
                        throw new ResourceNotFoundException("could not create the employee");
                    }))
                    /*.onStatus(HttpStatusCode::is5xxServerError, ((request, response) -> {
                        throw new RuntimeException("Server error Occurred");
                    }))*/
                    .toEntity(new ParameterizedTypeReference<>() {
                    });

            logger.debug("Successfully create new employee in createNewEmployee");
            logger.trace("Create new employee in createNewEmployee: {}",employeeDTOApiResponse.getBody().getData());
            return employeeDTOApiResponse.getBody().getData();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        }
}
