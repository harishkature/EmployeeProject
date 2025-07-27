package com.harry.EmpProject;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	//Creating new Emp
	public Employee createEmployees(Employee employee) {

		return employeeRepository.save(employee);

	}

	//Getting all EMP
	public List<Employee> getAllEmployees() {

		return employeeRepository.findAll();

	}
	
	//Getting EMP by ID 
	public Optional<Employee> getEmployeeById(Long id) {
		return employeeRepository.findById(id);
	}

	public void deleteEmployee(long id) {
		employeeRepository.deleteById(id);
		
	}

}
