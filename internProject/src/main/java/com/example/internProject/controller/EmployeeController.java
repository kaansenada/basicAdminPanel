package com.example.internProject.controller;

import com.example.internProject.entity.Employee;
import com.example.internProject.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;
    public EmployeeController(EmployeeService theEmployeeService) {employeeService=theEmployeeService; }

    @GetMapping("/list")
    public String listEmployees(Model theModel){
        List<Employee> employees=employeeService.findAll();
        theModel.addAttribute("employees",employees);
        return "employee-list-page";
    }

    @GetMapping("/list/{id}")
    public Employee findById(@PathVariable("id") int id, Model theMOdel){
        Employee temp=employeeService.findById(id);
        return temp;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Employee employee){
        employeeService.saveEmp(employee);

        return "redirect:/employees/list";
    }

    @GetMapping("/deleteById")
    public String deleteEmp(@RequestParam("employeeId")int employeeId){
        Employee temp=employeeService.findById(employeeId);
        employeeService.deleteById(employeeId);
        return "redirect:/employees/list";
    }
    @GetMapping("/showFormForView")
    public String inspectEmployee(@RequestParam("employeeId")int theId, Model theModel) {
        Employee tempEmployee=employeeService.findById(theId);
        return "employees/employee-form";
    }

}
