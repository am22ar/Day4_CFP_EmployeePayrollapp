package com.bridgelabz.employee_payroll.service;

import com.bridgelabz.employee_payroll.dto.EmployeeDto;
import com.bridgelabz.employee_payroll.model.EmployeeModel;

import java.util.List;

public interface IEmployeeService {
//    public String display();
//    public String user(EmployeeDto employeeDto);
    public EmployeeModel saves(EmployeeDto employeeDto);
    public EmployeeModel getById(int id);
    public List<EmployeeModel> getAll();
    public EmployeeModel updateEmployee(EmployeeDto employeeDto, int id);
    public EmployeeModel deleteByID(int id);
    public List<String> findEmployeeByDepartment(String department);
}
