package com.bridgelabz.employee_payroll.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Getter
@Setter
public class EmployeeDto {
    // hide implementation details of domain objects (JPA entities)/ model class(Entities).
    //takes all the variables other than primary key and generated value

    @NotEmpty(message = "Employee name cannot be null!!!")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message = "Name is Invalid!!")
    public String name;
    @Min(value = 1000,message = "Minimum salary should be greater than 1000")
    public long salary;
    @NotEmpty(message = "This field cannot be empty")
    @Pattern(regexp = "male|female",message = "Enter valid Gender!!")
    public String gender;

    @NotEmpty(message = "Date is mandatory")
    public String startDate;
    @NotEmpty(message = "Please enter a note")
    public String note;
    @NotEmpty(message = "Profile pic is mandatory")
    public String profilePic;

    @NotEmpty(message = "Department can't be NULL")
    public String department;


    //used to transfer data to service class
    public EmployeeDto(String name, long salary, String gender, String startDate, String note, String profilePic,String department) {
        this.name = name;
        this.salary = salary;
        this.gender = gender;
        this.startDate = startDate;
        this.note = note;
        this.profilePic = profilePic;
        this.department=department;

    }
}
