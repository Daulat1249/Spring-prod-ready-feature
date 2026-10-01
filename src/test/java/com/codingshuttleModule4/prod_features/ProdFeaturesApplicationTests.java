package com.codingshuttleModule4.prod_features;

import com.codingshuttleModule4.prod_features.advice.ApiResponse;
import com.codingshuttleModule4.prod_features.client.impl.EmployeeClientImpl;
import com.codingshuttleModule4.prod_features.dto.EmployeeDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class ProdFeaturesApplicationTests {

	@Autowired
	EmployeeClientImpl employeeClient;

	@Test
	void getAllEmployees(){
		List<EmployeeDTO> employeeDTOList =  employeeClient.getAllEmployees();

		System.out.println(employeeDTOList);
	}


	@Test
	void getEmployeeById(){
		EmployeeDTO employeeDTOResponse = employeeClient.getEmployeeById(2L);
		System.out.println(employeeDTOResponse);
	}

	@Test
	void createNewEmployee(){
		EmployeeDTO employeeDTO = new EmployeeDTO(null, "Anuj", "anuj@gmail.com", 20,"USER", 5000.00,
										LocalDate.of(2026,1,1), true);
		EmployeeDTO savedEmployeeDTO = employeeClient.createNewEmployee(employeeDTO);
		System.out.println(savedEmployeeDTO);
	}
}
