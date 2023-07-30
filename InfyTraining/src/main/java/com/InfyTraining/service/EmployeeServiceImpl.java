package com.InfyTraining.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.InfyTraining.entity.Employee;
import com.InfyTraining.repository.EmployeeRepository;

import com.InfyTraining.security.MyEmployee;


public class EmployeeServiceImpl implements UserDetailsService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String employeeName) throws UsernameNotFoundException {
        Employee employee = employeeRepository.getEmployeeByEmployeeName(employeeName);
        if(employee==null) {
            throw new UsernameNotFoundException("Could not find User");
        }
        return new MyEmployee(employee);
    }



}