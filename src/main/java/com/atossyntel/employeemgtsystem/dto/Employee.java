/**
 * 
 */
package com.atossyntel.employeemgtsystem.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Tarun Budhwar
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	
	 private Long employeeId;
	 private String firstName;
     private String lastName;
     private Double salary;
     private String email;
     private Date doj;
     private String mobile;
     private String pan;
     
}
