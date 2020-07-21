/**
 * 
 */
package com.atossyntel.employeemgtsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atossyntel.employeemgtsystem.dto.Employee;
import com.atossyntel.employeemgtsystem.exception.ResourceNotFoundException;
import com.atossyntel.employeemgtsystem.repository.EMSRepository;

/**
 * @author Tarun Budhwar
 *
 */
@Service
public class EMSService {
	
	@Autowired
	private EMSRepository emsRepository;

	public List<Employee> findAllEmployees() {
		return emsRepository.findAll();
	}
	
	public Employee findById(long id) {
		Employee response = emsRepository.findById(id);
		if(response == null) {
			throw new ResourceNotFoundException("Employee with id [" + id+"]  Not Found");
		}
		return response;
	}
}
