package com.example.internProject.service;

import com.example.internProject.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee findById(int id);

    List<Employee> findAll();

    void saveEmp(Employee employee);

    void deleteById(int id);

}
