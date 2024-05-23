package codeurteam.td.grhbackend.repository;


import org.springframework.stereotype.Repository;
import codeurteam.td.grhbackend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}