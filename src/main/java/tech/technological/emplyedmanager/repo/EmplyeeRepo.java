package tech.technological.emplyedmanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.technological.emplyedmanager.entity.Employee;

public interface EmplyeeRepo extends JpaRepository<Employee,Long> {
}
