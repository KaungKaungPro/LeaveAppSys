package sg.nus.iss.com.Leaveapp.service;

import java.util.List;

import sg.nus.iss.com.Leaveapp.model.Employee;
import sg.nus.iss.com.Leaveapp.model.Leave;
import sg.nus.iss.com.Leaveapp.model.LeaveType;

public interface ManagerService {
    // Employee methods
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    List<Leave> getLeaveApplicationsForApproval();
    List<Leave> getEmployeeLeaveHistory(Employee employee);


    // LeaveType methods
    List<LeaveType> getAllLeaveTypes();
    LeaveType getLeaveTypeById(Long id);
    void createOrUpdateLeaveType(LeaveType leaveType);
    void deleteLeaveType(Long id);
	
    
    //approve or reject Leave
//    void approveLeaveApplication(Long leavaApplicationId, String comment);
//    void rejectLeaveApplication(Long leavaApplicationId, String comment);

}
