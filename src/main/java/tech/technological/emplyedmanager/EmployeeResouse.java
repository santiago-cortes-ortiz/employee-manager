package tech.technological.emplyedmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.technological.emplyedmanager.entity.Employee;
import tech.technological.emplyedmanager.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeResouse {

    private final EmployeeService employeeService;

    public EmployeeResouse(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        return new ResponseEntity<>(employeeService.getAllEmployee(), HttpStatus.OK);
    }

    @GetMapping("/find/{idEmployee}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("idEmployee") Long idEmployee){
        return new ResponseEntity<>(employeeService.findEmployeeById(idEmployee), HttpStatus.OK);
    }

    @PostMapping("/add")
    public  ResponseEntity<Employee> addEmployee(@RequestBody Employee employeeToAdd){
        Employee newEmployee = employeeService.addEmployee(employeeToAdd);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public  ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee employeeUpdate = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(employeeUpdate, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{idEmployee}")
    public  ResponseEntity<HttpStatus> updateEmployee(@PathVariable("idEmployee") Long idEmployee){
        employeeService.deleteEmployeeById(idEmployee);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
