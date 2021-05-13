package tech.technological.emplyedmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.technological.emplyedmanager.entity.Employee;
import tech.technological.emplyedmanager.exception.UserNotFoundException;
import tech.technological.emplyedmanager.repo.EmployeeRepo;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> getAllEmployee(){
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    public Employee findEmployeeById(Long idEmployee){
        return employeeRepo.findEmployeeById(idEmployee)
                .orElseThrow(() -> new UserNotFoundException("User by id: "+idEmployee+ " User not found"));
    }

    public void deleteEmployeeById(Long idEmployee){
        employeeRepo.deleteEmployeeById(idEmployee);
    }
}
