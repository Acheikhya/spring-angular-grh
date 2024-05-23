package codeurteam.td.grhbackend.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import codeurteam.td.grhbackend.model.Employee;
import codeurteam.td.grhbackend.repository.EmployeeRepository;

@Service
public class EmployeeService {
	  @Autowired
	    private EmployeeRepository repository;

	    public List<Employee> findAllEmployees() {
	        return repository.findAll();
	    }

	    public Employee saveEmployee(Employee employee) {
	        return repository.save(employee);
	    }

	    public Employee getEmployeeById(Long id) {
	        return repository.findById(id).orElse(null);
	    }

	    public void deleteEmployee(Long id) {
	        repository.deleteById(id);
	    }
	    
	    public Employee updateEmployee(Long id, Employee employeeDetails) {
	        Employee employee = repository.findById(id)
	                .orElseThrow();

	        employee.setFirstName(employeeDetails.getFirstName());
	        employee.setLastName(employeeDetails.getLastName());
	        employee.setEmail(employeeDetails.getEmail());
	        employee.setPhoneNumber(employeeDetails.getPhoneNumber());
	        employee.setTitre(employeeDetails.getTitre());
	        final Employee updatedEmployee = repository.save(employee);
	        return updatedEmployee;
	    }

}

