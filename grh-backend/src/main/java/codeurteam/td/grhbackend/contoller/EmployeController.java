package codeurteam.td.grhbackend.contoller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import codeurteam.td.grhbackend.model.Employee;
import codeurteam.td.grhbackend.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeController {

		@Autowired
	    private EmployeeService service;

		//Get All Employees
	    @GetMapping
	    public List<Employee> getAllEmployees() {
	        return service.findAllEmployees();
	    }

	  /*  @PutMapping("/{id}")
	    public Employee addEmployee(@RequestBody Employee employee) {
	        return service.saveEmployee(employee);
	    }*/
	    
	    @PutMapping("/{id}")
	    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
	        Employee updatedEmployee = service.updateEmployee(id, employeeDetails);
	        return ResponseEntity.ok(updatedEmployee);
	    }

	    @GetMapping("/{id}")
	    public Employee getEmployeeById(@PathVariable Long id) {
	        return service.getEmployeeById(id);
	    }
	    

	    @DeleteMapping("/{id}")
	    public void deleteEmployee(@PathVariable Long id) {
	        service.deleteEmployee(id);
	    }
}


