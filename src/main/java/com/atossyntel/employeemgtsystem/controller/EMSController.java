/**
 * 
 */
package com.atossyntel.employeemgtsystem.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atossyntel.employeemgtsystem.dto.Employee;
import com.atossyntel.employeemgtsystem.service.EMSService;

/**
 * @author Tarun Budhwar
 *
 */

@RequestMapping(value="/employees")
@RestController
public class EMSController {
	
	@Autowired
	private EMSService emsService;
	
	@GetMapping(value="/findAllEmployees")
	public ResponseEntity<List<Employee>> findAllEmployees(){
		List<Employee> response = emsService.findAllEmployees();
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value="/findEmployeeById/{id}")
	public EntityModel<Employee> findById(@PathVariable("id") long id){
		Employee response = emsService.findById(id);
		
		EntityModel<Employee> resource = EntityModel.of(response);
		
		WebMvcLinkBuilder linkToAllEmployees = linkTo(methodOn(this.getClass()).findAllEmployees());
		
		resource.add(linkToAllEmployees.withRel("All-Employees"));
		
		return resource;
	}

}
