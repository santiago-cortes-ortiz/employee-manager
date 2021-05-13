package tech.technological.emplyedmanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.technological.emplyedmanager.entity.Employee;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {
    void deleteEmployeeById(Long idEmployee);

    Optional<Employee> findEmployeeById(Long idEmployee);
}
