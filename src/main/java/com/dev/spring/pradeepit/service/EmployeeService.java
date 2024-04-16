package com.dev.spring.pradeepit.service;


import com.dev.spring.pradeepit.dto.EmployeeDTO;
import com.dev.spring.pradeepit.entity.EmployeeEntity;
import com.dev.spring.pradeepit.mapper.EmployeeMapper;
import com.dev.spring.pradeepit.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public EmployeeDTO createEmployeeEntity(EmployeeDTO request) {
        EmployeeEntity emp = EmployeeMapper.INSTANCE.dtoToEntity(request);
        EmployeeEntity employeeSaved = employeeRepository.save(emp);
        return EmployeeMapper.INSTANCE.entityToDto(employeeSaved);
    }

    public EmployeeDTO getEmployeeEntityById(int eid) {
        Optional<EmployeeEntity> optionalEmployeeEntity = employeeRepository.findById(eid);
        if (optionalEmployeeEntity.isPresent()) {

            EmployeeEntity employeeEntity = optionalEmployeeEntity.get();


            return new EmployeeDTO(employeeEntity.getEid(), employeeEntity.getName(), employeeEntity.getEmail(), employeeEntity.getSalary());
        } else {
            return null;
        }
    }

    public EmployeeDTO updateEmployeeEntity(int eid, EmployeeDTO request) {                        // Check if the employee with the given ID exists
        Optional<EmployeeEntity> optionalEmployeeEntity = employeeRepository.findById(eid);
        if (optionalEmployeeEntity.isPresent()) {                                                  // Retrieve the employee entity
            EmployeeEntity employeeEntity = optionalEmployeeEntity.get();

            employeeEntity.setName(request.getName());
            employeeEntity.setEmail((request.getEmail()));
            employeeEntity.setSalary(request.getSalary());
            EmployeeEntity updatedEmployeeEntity = employeeRepository.save(employeeEntity);

            // Convert the updated employee entity back to DTO and return it

            return new EmployeeDTO(updatedEmployeeEntity.getEid(), updatedEmployeeEntity.getName(), updatedEmployeeEntity.getEmail(), updatedEmployeeEntity.getSalary());


        } else {
            return null;

        }

    }

    public EmployeeDTO deleteEmployeeEntity(int eid) {
        Optional<EmployeeEntity> optionalEmployeeEntity = employeeRepository.findById(eid);
        if (optionalEmployeeEntity.isPresent()) {
            employeeRepository.deleteById(eid);
        }
        return null;
    }

}




