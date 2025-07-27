package com.harry.EmpProject;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

//       List<Employee> employees = new ArrayList<>();

	@Autowired
	private EmpService empService;

//	@PostMapping()
//	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
//		Employee saveEmployee = empService.createEmployees(employee);
//		return new ResponseEntity<>(saveEmployee, HttpStatus.CREATED);
//	}
	
	@PostMapping()
	public String createEmployee(@RequestBody Employee employee) {
		Employee saveEmployee = empService.createEmployees(employee);
		return "Employee Created successfully";
	}
	
	

	@GetMapping()
	public List<Employee> getAllEmployees() {

		return empService.getAllEmployees();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		Optional<Employee> employee = empService.getEmployeeById(id);
		return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	//Below code for updating employee

//	@PutMapping("/{id}")
//	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
//		if (!empService.getEmployeeById(id).isPresent()) {
//			return ResponseEntity.notFound().build();
//		}
//		employee.setId(id);
//		Employee updatedEmployee = empService.createEmployees(employee);
//		return ResponseEntity.ok(updatedEmployee);
//	}
	
	@PutMapping("/{id}")
	public String  updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
		if (!empService.getEmployeeById(id).isPresent()) {
			return "Employee not found for this id";
		}
		employee.setId(id);
		Employee updatedEmployee = empService.createEmployees(employee);
		return "Employee Updated secussfully";
	}
	
	
	
	
//	@DeleteMapping("/{id}")
//	public ResponseEntity<Void> deleteEmployee(@PathVariable("id") long id){
//		
//		if (!empService.getEmployeeById(id).isPresent()) {
//			return ResponseEntity.notFound().build();
//		}
//		empService.deleteEmployee(id);
//		return ResponseEntity.noContent().build();
//		
//	}
	
	@DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable("id") long id){
		
		if (!empService.getEmployeeById(id).isPresent()) {
			return "Employee not not found for this id";
		}
		empService.deleteEmployee(id);
		return "Employee delected succssfully ";
		
	}
}
