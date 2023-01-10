package com.bridgelabz.employee_payroll.controller;

import com.bridgelabz.employee_payroll.dto.EmployeeDto;
import com.bridgelabz.employee_payroll.dto.ResponseDto;
import com.bridgelabz.employee_payroll.exception.EmployeePayrollException;
import com.bridgelabz.employee_payroll.model.EmployeeModel;
import com.bridgelabz.employee_payroll.repository.IrepoEmployee;
import com.bridgelabz.employee_payroll.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

//to define class as RestController
@RestController
public class EmployeeController {

    //used to add dependency injection by creating objects

    //before we were using EmployeeService class object to execute API's and code was not abstract


    @Autowired //dependency injection
    //Now we are IEmployeeService interface object to execute API's and code is abstract
    IEmployeeService iEmployeeService;

   List<Object> employeeModelList = new ArrayList<>();
    //repository has interface which handles all our CRUD operations related to DB
    @Autowired
    IrepoEmployee irepoEmployee;
    @PostMapping("/addEmp")
    public ResponseEntity<ResponseDto> save(@Valid @RequestBody EmployeeDto employeeDto){
        EmployeeModel employeeModel = iEmployeeService.saves(employeeDto);
        //employeeModelList.add(iEmployeeService.saves(employeeDto));
        ResponseDto responseDto= new ResponseDto("New Employee Added: ",employeeModel);
        ResponseEntity<ResponseDto> response = new ResponseEntity(responseDto, HttpStatus.OK);
        return response;
    }
    @GetMapping("/getting/{id}")
    public ResponseEntity<ResponseDto> gets(@PathVariable int id) throws EmployeePayrollException
    {
        EmployeeModel employeeModel = iEmployeeService.getById(id);
        ResponseDto responseDto = new ResponseDto("Data of Employee With id: ",employeeModel);
        ResponseEntity<ResponseDto> response = new ResponseEntity<>(responseDto,HttpStatus.OK);
        //employeeModelList.add(iEmployeeService.getById(id));
        return response;
    }
    //uc6
    @GetMapping("/getall")
    public ResponseEntity<ResponseDto> greetingModelsFindAll(){
        List<EmployeeModel> employeeModelList1 = iEmployeeService.getAll();
        ResponseDto responseDto = new ResponseDto("Fetching all the data from database: ",employeeModelList1);
        ResponseEntity<ResponseDto> response = new ResponseEntity<>(responseDto,HttpStatus.OK);
        return response;
    }

    //UC7 used to modify or update data into database
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDto> update(@Valid @RequestBody EmployeeDto employeeDto, @PathVariable int id) throws EmployeePayrollException
    {
        EmployeeModel employeeModel= iEmployeeService.updateEmployee(employeeDto,id);
        ResponseDto responseDto= new ResponseDto("Update data of given ID: ",employeeModel);
        ResponseEntity<ResponseDto> response = new ResponseEntity<>(responseDto,HttpStatus.OK);
        //employeeModelList.add(iEmployeeService.updateEmployee(employeeDto,id));
        return  response;
    }

    //used to delete data from database
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDto> del(@PathVariable int id)
    {
        //employeeModelList.add(iEmployeeService.deleteByID(id));
        EmployeeModel employeeModel=iEmployeeService.deleteByID(id);
        ResponseDto responseDto = new ResponseDto("Delete Employee Data: ",employeeModel);
        ResponseEntity<ResponseDto> response = new ResponseEntity<>(responseDto, HttpStatus.OK);
        return response;
    }

    //find employee by department custom api
    @GetMapping("/getDepartment/{department}")
    public ResponseEntity<ResponseDto> findEmployeeByDepartment(@PathVariable("department") String department){
        List<String> employeeModelList1= null;
        employeeModelList1 = iEmployeeService.findEmployeeByDepartment(department);
        ResponseDto responseDto = new ResponseDto("Employee of Specific Department!!!",employeeModelList1);
        ResponseEntity<ResponseDto> response = new ResponseEntity<>(responseDto, HttpStatus.OK);
        return response;
    }

}
