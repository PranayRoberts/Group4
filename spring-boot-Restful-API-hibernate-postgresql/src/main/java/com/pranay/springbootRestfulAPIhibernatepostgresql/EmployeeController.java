package com.pranay.springbootRestfulAPIhibernatepostgresql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	
	@Autowired //Injected or Autowired or created the Repository Object in the controller class.
	EmployeeRepository employeeRepository;
	
	@GetMapping("/get-all-employees")
	public List<EmployeeEntity> getAllEmployee(){
		List<EmployeeEntity> allEmployeelist = employeeRepository.findAll();
		return allEmployeelist;
		
	}
	
	@GetMapping("/get-employee/{id}")
	public EmployeeEntity getEmployeebyId(@PathVariable(value = "id") Integer employeeId)
      
	{
		EmployeeEntity employeeEntity = employeeRepository.findById(employeeId).get();
		
		return employeeEntity;	
	}
	
    @PostMapping("/create-employees")
    public EmployeeEntity createEmployee(@RequestBody EmployeeEntity employee) {
       
    	 EmployeeEntity savedEmployee = employeeRepository.save(employee);
    	 
    	 return savedEmployee;
    }
    
    @PutMapping("/update-employees/{id}")
    //@PathVariable- It is used to take the value from URL and assigned or mapped to the class variable or parameter. In our case, we are taking id from /get-employee/{id} and assigned to the employeeId.
    public ResponseEntity<EmployeeEntity> updateEmployee(@PathVariable(value = "id") Integer employeeId,
         @RequestBody EmployeeEntity employeeDetails) {
        EmployeeEntity employee = employeeRepository.findById(employeeId).get();

        employee.setEmailId(employeeDetails.getEmailId());
        employee.setName(employeeDetails.getName());
        employee.setLocation(employeeDetails.getLocation());
        final EmployeeEntity updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }
    
    @DeleteMapping("/delete-employees/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Integer employeeId)
    {
     EmployeeEntity employee = employeeRepository.findById(employeeId).get();

        employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}