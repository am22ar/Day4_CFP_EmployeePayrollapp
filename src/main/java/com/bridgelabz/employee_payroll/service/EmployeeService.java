package com.bridgelabz.employee_payroll.service;

import com.bridgelabz.employee_payroll.dto.EmployeeDto;
import com.bridgelabz.employee_payroll.exception.EmployeePayrollException;
import com.bridgelabz.employee_payroll.model.EmployeeModel;
import com.bridgelabz.employee_payroll.repository.IrepoEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService{
    @Autowired
    IrepoEmployee irepoEmployee;
    private  List<EmployeeModel> employeeModellist =new ArrayList();
    public EmployeeModel saves(EmployeeDto employeeDto) {
        EmployeeModel employeeModel = new EmployeeModel(employeeDto);
        return irepoEmployee.save(employeeModel);

    }
    public EmployeeModel getById(int id)throws EmployeePayrollException{
        //  EmployeeModel employeeModel1= new EmployeeModel(id);
        EmployeeModel employeeModel1=employeeModellist.stream()
                .filter(employeeModel -> employeeModel.getId()==id)
                .findFirst()
                .orElseThrow(() -> new EmployeePayrollException("Employee id not present"));
        return employeeModel1;
    }
    public List<EmployeeModel> getAll(){
        List<EmployeeModel> employeeModels=irepoEmployee.findAll();
        return employeeModels;
    }
    public EmployeeModel updateEmployee(EmployeeDto employeeDto, int id) throws EmployeePayrollException {
        //paassing dto class object to model to get and set data from model class
        EmployeeModel employeeModel1 = employeeModellist.stream()
                .filter(employeeModel -> employeeModel.getId()==id)
                .findFirst()
                .orElseThrow(() -> new EmployeePayrollException("Id Doesn't Exists.."));
        return employeeModel1;

        //instead of writing get set for all varibles just call constructor
        /*
        Optional<EmployeeModel> emp1 = irepoEmployee.findById(id);
        EmployeeModel emp2 = new EmployeeModel(empdto,id);
        return irepoEmployee(emp2);
        * */
    }
    public EmployeeModel deleteByID(int id){
       irepoEmployee.deleteById(id);
        return null;
    }
    //this is custom method to find data of employee based on his/her dept
    public List<String> findEmployeeByDepartment(String department){
        return irepoEmployee.findEmployeeByDepartment(department);
    }
}
