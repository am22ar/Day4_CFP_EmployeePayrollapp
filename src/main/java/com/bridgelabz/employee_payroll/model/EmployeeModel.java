package com.bridgelabz.employee_payroll.model;

import com.bridgelabz.employee_payroll.dto.EmployeeDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Entity
@Getter
@Setter
public class EmployeeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String name;
    private long salary;
    private String gender;
    private String startDate;
    private String note;
    private String profilePic;
    private String department;

    //this constructor takes one parameter i.e DTO class to add/post data in database
    public EmployeeModel(EmployeeDto employeeDto) {
        this.name = employeeDto.name;
        this.salary = employeeDto.salary;
        this.gender = employeeDto.gender;
        this.startDate = employeeDto.startDate;
        this.note = employeeDto.note;
        this.profilePic = employeeDto.profilePic;
        this.department = employeeDto.department;
    }
    //this constructor takes 2 parameters i.e DTO class and primary key to update/put data in database
    public EmployeeModel(int id,EmployeeDto employeeDto) {
        this.id = id;
        this.name = employeeDto.name;
        this.salary = employeeDto.salary;
        this.gender = employeeDto.gender;
        this.startDate = employeeDto.startDate;
        this.note = employeeDto.note;
        this.profilePic = employeeDto.profilePic;
        this.department = employeeDto.department;
    }
    public EmployeeModel() {

    }

}
