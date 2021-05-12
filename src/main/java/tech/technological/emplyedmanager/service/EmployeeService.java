package tech.technological.emplyedmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.technological.emplyedmanager.entity.Employee;
import tech.technological.emplyedmanager.repo.EmplyeeRepo;

import java.util.UUID;

@Service
public class EmployeeService {

    private final EmplyeeRepo emplyeeRepo;

    @Autowired
    public EmployeeService(EmplyeeRepo emplyeeRepo) {
        this.emplyeeRepo = emplyeeRepo;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return emplyeeRepo.save(employee);
    }

}
