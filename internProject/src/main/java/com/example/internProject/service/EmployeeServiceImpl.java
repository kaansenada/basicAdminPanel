package com.example.internProject.service;

import com.example.internProject.entity.Employee;
import com.example.internProject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> temp=employeeRepository.findById(id);
        Employee employee=null;
        if(temp.isPresent()){
            employee=temp.get();
        }else{
            throw new RuntimeException("cant find the id; "+id);
        }
        return employee;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    @Transactional
    public void saveEmp(Employee employee) {
        employeeRepository.save(employee);

    }

    @Override
    @Transactional
    public void deleteById(int id) {
        employeeRepository.deleteById(id);

    }
}
