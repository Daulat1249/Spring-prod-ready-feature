package com.codingshuttleModule4.prod_features;

import com.codingshuttleModule4.prod_features.advice.ApiResponse;
import com.codingshuttleModule4.prod_features.client.impl.EmployeeClientImpl;
import com.codingshuttleModule4.prod_features.dto.EmployeeDTO;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProdFeaturesApplicationTests {

	@Autowired
	EmployeeClientImpl employeeClient;

	@Test
	@Order(3)
	void getAllEmployees(){
		List<EmployeeDTO> employeeDTOList =  employeeClient.getAllEmployees();

		System.out.println(employeeDTOList);
	}


	@Test
	@Order(2)
	void getEmployeeById(){
		EmployeeDTO employeeDTOResponse = employeeClient.getEmployeeById(2L);
		System.out.println(employeeDTOResponse);
	}

	@Test
	@Order(1)
	void createNewEmployee(){
		EmployeeDTO employeeDTO = new EmployeeDTO(null, "Anuj", "anuj@gmail.com", 20,"USER", 5000.00,
										LocalDate.of(2026,1,1), true);
		EmployeeDTO savedEmployeeDTO = employeeClient.createNewEmployee(employeeDTO);
		System.out.println(savedEmployeeDTO);
	}
}
