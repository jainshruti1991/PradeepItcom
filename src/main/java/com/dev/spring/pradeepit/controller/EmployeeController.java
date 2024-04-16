package com.dev.spring.pradeepit.controller;


import com.dev.spring.pradeepit.dto.EmployeeDTO;
import com.dev.spring.pradeepit.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/employees")
@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping()
    public EmployeeDTO createEmployeeEntity(@RequestBody EmployeeDTO request) {
        return employeeService.createEmployeeEntity(request);
    }

    @GetMapping("/{eid}")
    public EmployeeDTO getEmployeeEntity(@PathVariable int eid) {
        return employeeService.getEmployeeEntityById(eid);


    }

    @PutMapping("{eid}")

    public EmployeeDTO updateEmployee(@PathVariable int eid, @RequestBody EmployeeDTO employeeDTO) {
        return employeeService.updateEmployeeEntity(eid, employeeDTO);
    }

    @DeleteMapping("/{eid}")
    public void deleteEmployee(@PathVariable int eid) {
        employeeService.deleteEmployeeEntity(eid);
    }

}
