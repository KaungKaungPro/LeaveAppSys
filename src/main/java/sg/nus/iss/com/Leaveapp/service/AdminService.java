package sg.nus.iss.com.Leaveapp.service;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.nus.iss.com.Leaveapp.model.Employee;
import sg.nus.iss.com.Leaveapp.model.LeaveEntitlement;

import sg.nus.iss.com.Leaveapp.model.Role;
import sg.nus.iss.com.Leaveapp.repository.EmployeeRepository;
import sg.nus.iss.com.Leaveapp.repository.LeaveEntitlementRepository;

import sg.nus.iss.com.Leaveapp.repository.RoleRepository;

@Service
public class AdminService {

    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Autowired
    private LeaveEntitlementRepository leaveEntitlementRepository;
    
    @Autowired
    private RoleRepository roleRepository;

    // Employee methods
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public void createOrUpdateEmployee(Employee employee) {
    	Role role = roleRepository.findRoleByName(employee.getRole().getName());
    	employee.setRole(role);
        employeeRepository.save(employee);
    }

    @Transactional
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
    
    public List<Employee> getManagers() {
        Role managerRole = roleRepository.findRoleByName("manager");
        return employeeRepository.findByRole(managerRole);
    }
    
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
    
    public List<LeaveEntitlement> getAllLeaveEntitlements() {
        return leaveEntitlementRepository.findAll();
    }
    
    public LeaveEntitlement getLeaveEntitlementById(Long id) {
        return leaveEntitlementRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deleteLeaveEntitlement(Long id) {
    	leaveEntitlementRepository.deleteById(id);
    }
    
    @Transactional
    public void createOrUpdateLeaveType(Role role, Map<String, Integer> entitlements, int year) {
    	LeaveEntitlement annualLeaveEntitlement = new LeaveEntitlement("annual", entitlements.get("annual"), role, year);
    	LeaveEntitlement medicalLeaveEntitlement = new LeaveEntitlement("medical", entitlements.get("medical"), role, year);
    	LeaveEntitlement compensationLeaveEntitlement = new LeaveEntitlement("compensation", entitlements.get("compensation"), role, year);
    	leaveEntitlementRepository.save(annualLeaveEntitlement);
    	leaveEntitlementRepository.save(medicalLeaveEntitlement);
    	leaveEntitlementRepository.save(compensationLeaveEntitlement);
    }
}
