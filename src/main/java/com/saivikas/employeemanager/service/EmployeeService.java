package com.saivikas.employeemanager.service;

import com.saivikas.employeemanager.exception.UserNotFoundException;
import com.saivikas.employeemanager.model.Employee;
import com.saivikas.employeemanager.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }
    public Employee findEmployeeById(Long id){
        return employeeRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User by ID "+id+" Not Found"));
    }
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }
    public Employee updateEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }
}
