package shmathes.github.com.SpringBootCrud.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shmathes.github.com.SpringBootCrud.model.Employee;
import shmathes.github.com.SpringBootCrud.repository.EmployeeRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController
{
    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository)
    {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/employee")
    public List<Employee> getAllEmployees()
    {
        return employeeRepository.findAll();
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
    {
        Employee employee = employeeRepository.findById(employeeId).get();
        return ResponseEntity.ok().body(employee);
    }

    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody Employee employee)
    {
        return employeeRepository.save(employee);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
                                                   @RequestBody Employee employeeDetails)
    {
        Employee employee = employeeRepository.findById(employeeId).get();

        employee.setEmailId(employeeDetails.getEmailId());
        employee.setLastName(employeeDetails.getLastName());
        employee.setFirstName(employeeDetails.getFirstName());

        //final Employee updateEmployee = employeeRepository.save(employee);
        employeeRepository.save(employee);
        return ResponseEntity.ok().body(employee);
    }

    @DeleteMapping("/employee/{id}")
    public void removeEmployee(@PathVariable(value = "id") Long employeeId)
    {
        Employee employee = employeeRepository.findById(employeeId).get();
        employeeRepository.delete(employee);
        //return ResponseEntity.ok();
    }
}
