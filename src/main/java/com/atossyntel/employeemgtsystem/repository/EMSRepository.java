/**
 * 
 */
package com.atossyntel.employeemgtsystem.repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.atossyntel.employeemgtsystem.dto.Employee;

import io.swagger.models.properties.EmailProperty;

/**
 * @author Tarun Budhwar
 *
 */
@Service
public class EMSRepository {

	private Map<Long, Employee> employeeMap = new HashMap<>();
	
	@PostConstruct
	public void init() {
		
		Employee employee1 = Employee.builder()
				.employeeId(100L)
				.firstName("Tarun")
				.lastName("Budhwar")
				.salary(15000.00)
				.email("tarun.budhwar@atos.net")
				.mobile("9389202024")
				.doj(new Date())
				.pan("BRQPP8756A").build();
		employeeMap.put(100L, employee1);
		
		Employee employee2 = Employee.builder()
				.employeeId(101L)
				.firstName("Pradeep")
				.lastName("Chinchole")
				.salary(55000.00)
				.email("pradeeep.chinchole@atos.net")
				.mobile("9385638993")
				.doj(new Date())
				.pan("BPQPP5756B").build();
		employeeMap.put(101L, employee2);
		
		Employee employee3 = Employee.builder()
				.employeeId(102L)
				.firstName("Shah Rukh")
				.lastName("Khan")
				.salary(1000000000.00)
				.email("shahrukh.khan@atos.net")
				.mobile("9389252528")
				.doj(new Date())
				.pan("APQOP5776B").build();
		employeeMap.put(102L, employee3);
	}

	public List<Employee> findAll() {
		return employeeMap.values().stream().collect(Collectors.toList());
	}
	
	public Employee findById(long id) {
		return employeeMap.get(id);
	}

}
